package commands;

import managers.CollectionManager;
import utils.Console;
import utils.ExecutionResponse;

/**
 * Убирает элемент по id.
 * @author trikesh
 */
public class RemoveById extends Command{
    private Console console;
    private CollectionManager collectionManager;

    public RemoveById(Console console, CollectionManager collectionManager) {
        super("remove_by_id id", "удаляет элемент по id");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */
    @Override
    public ExecutionResponse apply(String[] args) {
        if (args[1].isEmpty()) return new ExecutionResponse(false, "Команда используется не верно!");
        int id;
        try {
            id = Integer.parseInt(args[1].trim());
        } catch (NumberFormatException e) {
            return new ExecutionResponse(false, "ID указан не верно!");
        }
        if (collectionManager.getById(id) == null || !collectionManager.isContain(collectionManager.getById(id))) {
            return new ExecutionResponse(false, "Элемент с заданым ID не найден!");
        }
        collectionManager.remove(id);
        return new ExecutionResponse("Vehicle успешно удален!");
    }


}
