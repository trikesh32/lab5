package managers;

import commands.Command;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CommandManager {
    private Map<String, Command> commands = new LinkedHashMap<>();
    public void register(String commandName, Command command){
        commands.put(commandName, command);
    }
    public Map<String, Command> getCommands(){
        return commands;
    }

}
