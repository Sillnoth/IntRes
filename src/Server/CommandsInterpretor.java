package Server;

import Commands.ExitCommand;

import java.io.PrintWriter;
import java.util.HashMap;
import Commands.*;
import Data.Data;

import java.util.Map;

public class CommandsInterpretor {
    Map<String, Commands> commandMap = new HashMap<>();
    PrintWriter out;

    public CommandsInterpretor(PrintWriter out) {
        this.out = out;
        commandMap.put("EXIT", new ExitCommand(out));
        commandMap.put("ADDN", new AddNCommand(out));
        commandMap.put("ADDS", new AddSCommand(out));
        commandMap.put("ECHON", new EchoNCommand(out));
        commandMap.put("ECHOS", new EchoSCommand(out));
        commandMap.put("REMOVEN", new RemoveNCommand(out));
        commandMap.put("REMOVES", new RemoveSCommand(out));
        commandMap.put("EDITN", new EditNCommand(out));
        commandMap.put("EDITS", new EditSCommand(out));
    }

    public boolean execute(String[] input, Data data) {
        if(commandMap.containsKey(input[0])) {
            if(!commandMap.get(input[0]).valid(input))
                out.println("INVALID PARAM");
            else {
                return commandMap.get(input[0]).execute(input, data);
            }
        }
        else {
            out.println(input[0] +" : Unknown Command");
        }
        return true;
    }
}