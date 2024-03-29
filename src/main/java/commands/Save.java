package commands;

import managers.CollectionManager;
import managers.DumpManager;
import utils.Console;
import utils.ExecutionResponse;

/**
 * Сохраняет коллекцию.
 * @author trikesh
 */
public class Save extends Command{
    private Console console;
    private CollectionManager collectionManager;
    private DumpManager dumpManager;
    public Save(Console console, CollectionManager collectionManager, DumpManager dumpManager){
        super("save", "сохраняет коллекцию в файл");
        this.console = console;
        this.collectionManager = collectionManager;
        this.dumpManager = dumpManager;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */
    @Override
    public ExecutionResponse apply(String[] args) {
        if(!args[1].isEmpty()) return new ExecutionResponse(false, "Команда используется не верно!");
        collectionManager.saveCollection();
        return new ExecutionResponse("Коллекция сохранена успешно!");
    }
}
