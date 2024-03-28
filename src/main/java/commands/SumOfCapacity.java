package commands;

import managers.CollectionManager;
import utils.Console;
import utils.ExecutionResponse;

public class SumOfCapacity extends Command{
    private Console console;
    private CollectionManager collectionManager;

    public SumOfCapacity(Console console, CollectionManager collectionManager) {
        super("sum_of_capacity", "выводит сумму всех полей capacity");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public ExecutionResponse apply(String[] args) {
        if(!args[1].isEmpty()) return new ExecutionResponse(false, "Команда используется не верно!");
        int capacity = 0;
        for (var e:collectionManager.getCollection()){
            capacity += e.getCapacity();
        }
        return new ExecutionResponse("Сумма всех capacity: " + capacity);
    }
}
