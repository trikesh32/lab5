package commands;

import managers.CollectionManager;
import managers.CommandManager;
import utils.Console;
import utils.ExecutionResponse;

import java.util.Map;
import java.util.TreeMap;

/**
 * Выводит информацию о командах.
 * @author trikesh
 */
public class Help extends Command{
    private CommandManager commandManager;
    public Help(CommandManager commandManager){
        super("help", "выводит информацию о доступных командах");
        this.commandManager = commandManager;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */
    @Override
    public ExecutionResponse apply(String[] args) {
        if(!args[1].isEmpty()) return new ExecutionResponse(false, "Команда используется не верно!");
        StringBuilder res = new StringBuilder();
        for (String key : new TreeMap<>(commandManager.getCommands()).keySet()){
            var command = commandManager.getCommands();
            res.append(command.get(key).getName() + ": " + command.get(key).getDescription() + "\n");
        }
        return new ExecutionResponse(res.toString().trim());
    }
}
