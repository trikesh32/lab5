package commands;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import console.Asker;
import managers.CollectionManager;
import models.Vehicle;
import utils.Console;
import utils.ExecutionResponse;

public class Add extends Command{
    private final Console console;
    private final CollectionManager collectionManager;
    public Add(Console console, CollectionManager collectionManager){
        super("add {element}", "добавляет новый элемент в коллекцию");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public ExecutionResponse apply(String[] args) {
        try {
            if (!args[1].isEmpty()) return new ExecutionResponse(false, "Команда используется не верно!");
            console.println("Cоздаем новый Vehicle");
            Vehicle o = Asker.askVehicle(console, collectionManager.getNewId());
            if (o.check_validity()){
                   collectionManager.add(o);
                   return new ExecutionResponse("Vehicle успешно добавлен!");
            } return new ExecutionResponse(false,"Данные не валидны!");
        } catch (Asker.AskBreak e){
            return new ExecutionResponse(false, "Отмена команды!");
        }
    }
}
