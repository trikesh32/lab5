package commands;

import managers.CollectionManager;
import utils.Console;
import utils.ExecutionResponse;

public class Clear extends Command{
    private Console console;
    private CollectionManager collectionManager;

    public Clear(Console console, CollectionManager collectionManager) {
        super("clear", "очищает коллекцию");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public ExecutionResponse apply(String[] args) {
        if(!args[1].isEmpty()) return new ExecutionResponse(false, "Команда используется не верно!");
        collectionManager.clear();
        return new ExecutionResponse("Коллекция очищена успешно!");
    }
}
