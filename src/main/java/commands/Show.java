package commands;

import managers.CollectionManager;
import utils.Console;
import utils.ExecutionResponse;

/**
 * Выводит элементы коллекции.
 * @author trikesh
 */
public class Show extends Command{
    private Console console;
    private CollectionManager collectionManager;
    public Show(Console console, CollectionManager collectionManager){
        super("show", "выводит информацию о коллекции");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */
    @Override
    public ExecutionResponse apply(String[] args) {
        if(!args[1].isEmpty()) return new ExecutionResponse(false, "Команда используется не верно!");
        if (collectionManager.isEmpty()) return new ExecutionResponse("Коллекция пустая!");
        return new ExecutionResponse(collectionManager.toString());
    }
}
