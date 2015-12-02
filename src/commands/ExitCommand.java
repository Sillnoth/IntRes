package commands;

import java.io.PrintWriter;
import data.Data;

public class ExitCommand extends Commands {

    private static final int NUMARG = 1;
    public ExitCommand(PrintWriter out) {
        super(out);
    }

    @Override
    public boolean execute(String[] input, Data data) {
        out.println("EXITOK");
        return false;
    }

    @Override
    public boolean valid(String[] input) {
        return input.length == NUMARG;
    }
}
