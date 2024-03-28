import commands.*;
import console.StandardConsole;
import managers.CollectionManager;
import managers.CommandManager;
import managers.DumpManager;
import models.Vehicle;
import models.VehicleType;
import utils.Console;
import utils.Runner;

public class Main {
    public static void main(String[] args) {
        String filename = "huy.xml";
        Console console = new StandardConsole();
        console.selectConsoleScanner();
        DumpManager dumpManager = new DumpManager(filename, console);
        CollectionManager collectionManager = new CollectionManager(dumpManager);
        if (!collectionManager.init()){
            console.printError("Не удалось загрузить коллекцию");
            System.exit(1);
        }
        CommandManager commandManager = new CommandManager();
        commandManager.register("add", new Add(console, collectionManager));
        commandManager.register("exit", new Exit(console));
        commandManager.register("show", new Show(console, collectionManager));
        commandManager.register("save", new Save(console, collectionManager, dumpManager));
        commandManager.register("help", new Help(commandManager));
        commandManager.register("info", new Info(console, collectionManager));
        commandManager.register("update", new Update(console, collectionManager));
        commandManager.register("remove_by_id", new RemoveById(console, collectionManager));
        commandManager.register("clear", new Clear(console, collectionManager));
        commandManager.register("remove_last", new RemoveLast(console, collectionManager));
        commandManager.register("sort", new Sort(console, collectionManager));
        commandManager.register("remove_lower", new RemoveLower(console, collectionManager));
        commandManager.register("sum_of_capacity", new SumOfCapacity(console, collectionManager));
        commandManager.register("filter_by_capacity", new FilterByCapacity(console, collectionManager));
        commandManager.register("filter_less_than_type", new FilterLessThanType(console, collectionManager));
        Runner runner = new Runner(console, commandManager);
        runner.interactiveMode();
    }
}