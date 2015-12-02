package commands;

import java.io.PrintWriter;
import data.Data;

public class RemoveNCommand extends Commands {

    private static final int NUMARG = 2;
    public RemoveNCommand(PrintWriter out) {
        super(out);
    }

    @Override
    public boolean execute(String[] input, Data data) {
        if(!data.existName(input[1]))
            out.println("NAME NOT FOUND");
        else {
            data.removeName(input[1]);
            out.println("REMOVEOK");
        }
        return true;

    }

    @Override
    public boolean valid(String[] input) {
        return input.length == NUMARG;
    }
}
