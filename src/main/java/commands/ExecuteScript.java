package commands;
import utils.Console;
import utils.ExecutionResponse;

/**
 * Боль.....
 * @author trikesh
 */
public class ExecuteScript extends Command{
    private final Console console;
    public ExecuteScript(Console console) {
        super("execute_script filename", "выполнить скрипт из указанного файла");
        this.console = console;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */
    @Override
    public ExecutionResponse apply(String[] args) {
        if(args[1].isEmpty()) return new ExecutionResponse(false, "Команда используется не верно!");
        return new ExecutionResponse("Выполняю скрипт из файла " + args[1] + "...");
    }
}
