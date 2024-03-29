package commands;

import managers.CollectionManager;
import utils.Console;
import utils.ExecutionResponse;

/**
 * Убирает последний элемент коллекции
 * @author trikesh
 */
public class RemoveLast extends Command{
    private Console console;
    private CollectionManager collectionManager;

    public RemoveLast(Console console, CollectionManager collectionManager) {
        super("remove_last", "удаляет последний элемент");
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
        collectionManager.removeLast();
        return new ExecutionResponse("Последний Vehicle удален успешно!");
    }
}
