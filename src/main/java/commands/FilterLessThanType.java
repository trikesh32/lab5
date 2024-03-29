package commands;

import managers.CollectionManager;
import models.Vehicle;
import models.VehicleType;
import utils.Console;
import utils.ExecutionResponse;

/**
 * Выводит те элементы, чей VehicleType меньше заданного.
 * @author trikesh
 */
public class FilterLessThanType extends Command{
    private Console console;
    private CollectionManager collectionManager;

    public FilterLessThanType(Console console, CollectionManager collectionManager) {
        super("filter_less_than_type", "выводит элементы, значения поля VehicleType меньше заданного");
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
        VehicleType type;
        try {
            type = VehicleType.valueOf(args[1].trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            return new ExecutionResponse(false, "type указан не верно!");
        }
        StringBuilder res = new StringBuilder();
        for (var e : collectionManager.getCollection()){
            if (e.getVehicleType().compareTo(type) < 0)
                res.append(e + "\n");
        }
        if (res.isEmpty()){
            res = new StringBuilder("Элементов удовлетворяющим условию не найдено!");
        }
        return new ExecutionResponse(res.toString().trim());
    }
}
