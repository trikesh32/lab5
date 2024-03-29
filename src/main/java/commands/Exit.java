package commands;

import utils.Console;
import utils.ExecutionResponse;

/**
 * Остановка работы программы.
 * @author trikesh
 */
public class Exit extends Command{
    private final Console console;
    public Exit(Console console){
        super("exit", "завершить программу без сохранений");
        this.console = console;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */
    @Override
    public ExecutionResponse apply(String[] args) {
        if (!args[1].isEmpty()) return new ExecutionResponse(false, "Команда используется не верно!");
        return new ExecutionResponse("special_mark_exit");
    }
}
