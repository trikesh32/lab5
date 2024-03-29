package commands;

import managers.CollectionManager;
import utils.Console;
import utils.ExecutionResponse;

import java.time.LocalDateTime;

/**
 * Выводит информацию о коллекции.
 * @author trikesh
 */
public class Info extends Command{
    private Console console;
    private CollectionManager collectionManager;
    public Info(Console console, CollectionManager collectionManager){
        super("info", "выводит информацию о коллекции");
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

        LocalDateTime lastInitTime = collectionManager.getLastInitTime();
        LocalDateTime lastSaveTime = collectionManager.getLastSaveTime();
        String lastInitTimeString = (lastInitTime == null) ? "коллекция еще не проинициализирована" : lastInitTime.toLocalDate().toString() + " " +
                lastInitTime.toLocalTime().toString();
        String lastSaveTimeString = (lastSaveTime == null) ? "сохранений еще не было" : lastSaveTime.toLocalDate().toString() + " " +
                lastSaveTime.toLocalTime().toString();
        var res = "Информация о колекции: \n" +
                "Тип: " + collectionManager.getCollection().getClass().toString() + "\n" +
                "Количество элементов: " + collectionManager.getCollection().size() + "\n" +
                "Последнее сохранение: " + lastSaveTimeString + "\n" +
                "Последняя инициализация: " + lastInitTimeString;
        return new ExecutionResponse(res);
    }
}
