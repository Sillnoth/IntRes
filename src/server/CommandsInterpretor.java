package server;

import commands.ExitCommand;

import java.io.PrintWriter;
import java.util.HashMap;
import commands.*;
import data.Data;

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
        if("HELP".equals(input[0]))
            printCommands();
        else if(commandMap.containsKey(input[0])) {
            if(!commandMap.get(input[0]).valid(input))
                out.println("INVALID PARAM - Type Help for information about commands");
            else {
                return commandMap.get(input[0]).execute(input, data);
            }
        }
        else {
            out.println(input[0] +" : Unknown Command - Type HELP for information about commands");
        }
        return true;
    }

    public void printCommands(){
        String chaine = "";
        for(String s : commandMap.keySet())
            chaine += s+"  ";
        out.println(chaine);
    }
}