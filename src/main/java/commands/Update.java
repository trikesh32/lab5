package commands;

import console.Asker;
import managers.CollectionManager;
import utils.Console;
import utils.ExecutionResponse;


/**
 * Обновляет элемент коллекции.
 * @author trikesh
 */
public class Update extends Command {
    private Console console;
    private CollectionManager collectionManager;

    public Update(Console console, CollectionManager collectionManager) {
        super("update id {element}", "обновляет значение элемента");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */
    @Override
    public ExecutionResponse apply(String[] args) {
        try {
            if (args[1].isEmpty()) return new ExecutionResponse(false, "Команда используется не верно!");
            int id;
            try {
                id = Integer.parseInt(args[1].trim());
            } catch (NumberFormatException e) {
                return new ExecutionResponse(false, "ID указан не верно!");
            }
            var old_vehicle = collectionManager.getById(id);
            if (old_vehicle == null || !collectionManager.isContain(old_vehicle)) {
                return new ExecutionResponse(false, "Элемент с заданым ID не найден!");
            }
            console.println("Cоздаем новый Vehicle");
            var new_vehicle = Asker.askVehicle(console, id);
            if (new_vehicle != null && new_vehicle.check_validity()){
                collectionManager.remove(id);
                collectionManager.add(new_vehicle);
                return new ExecutionResponse("Vehicle успешно обновлен!");
            } else {
                return new ExecutionResponse(false, "Данные не валидны!");
            }

        } catch (Asker.AskBreak e) {
            return new ExecutionResponse(false, "Отмена команды!");
        }

    }
}
