package Commands;

import java.io.PrintWriter;
import Data.Data;

public class ExitCommand extends Commands {

    private final static int NUMARG = 1;
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
        return input.length != NUMARG;
    }
}
