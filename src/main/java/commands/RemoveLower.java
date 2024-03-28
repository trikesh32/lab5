package commands;

import console.Asker;
import managers.CollectionManager;
import models.Vehicle;
import utils.Console;
import utils.ExecutionResponse;

import java.util.Stack;

public class RemoveLower extends Command{
    private final Console console;
    private final CollectionManager collectionManager;
    public RemoveLower(Console console, CollectionManager collectionManager){
        super("remove_lower {element}", "удаляет все элементы, меньшие чем заданный");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public ExecutionResponse apply(String[] args) {
        try {
            if (!args[1].isEmpty()) return new ExecutionResponse(false, "Команда используется не верно!");
            console.println("Задаем критерий Vehicle");
            Vehicle o = Asker.askVehicle(console, collectionManager.getNewId());
            if (o.check_validity()){
                Stack<Vehicle> tmp = (Stack<Vehicle>) collectionManager.getCollection().clone();
                for (var e : tmp){
                    if (e.compareTo(o) < 0){
                       collectionManager.remove(e.getId());
                    }
                }
                return new ExecutionResponse("Элементы меньше заданного удалены успешно!");
            } return new ExecutionResponse(false,"Данные не валидны!");
        } catch (Asker.AskBreak e){
            return new ExecutionResponse(false, "Отмена команды!");
        }
    }
}
