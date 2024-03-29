package commands;

import managers.CollectionManager;
import utils.Console;
import utils.ExecutionResponse;

/**
 * Выводит элементы, у которых capacity равен заданному.
 * @author trikesh
 */
public class FilterByCapacity extends Command{
    private Console console;
    private CollectionManager collectionManager;

    public FilterByCapacity(Console console, CollectionManager collectionManager) {
        super("filter_by_capacity", "выводит элементы, у которых поле capacity равно заданному");
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
        int capacity;
        try {
            capacity = Integer.parseInt(args[1].trim());
        } catch (NumberFormatException e) {
            return new ExecutionResponse(false, "capacity указан не верно!");
        }
        StringBuilder res = new StringBuilder();
        for (var e : collectionManager.getCollection()){
            if (e.getCapacity() == capacity)
                res.append(e + "\n");
        }
        if (res.isEmpty()){
            res = new StringBuilder("Элементов удовлетворяющим условию не найдено!");
        }
        return new ExecutionResponse(res.toString().trim());
    }
}
