package commands;

import managers.CollectionManager;
import utils.Console;
import utils.ExecutionResponse;

/**
 * Сортирует коллекцию
 * @author trikesh
 */
public class Sort extends Command{
    private Console console;
    private CollectionManager collectionManager;

    public Sort(Console console, CollectionManager collectionManager) {
        super("sort", "сортирует коллекцию по именам элементов");
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
        collectionManager.sortCollection();
        return new ExecutionResponse("Коллекция отсортирована успешно!");
    }
}
