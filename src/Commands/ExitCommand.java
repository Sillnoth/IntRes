package Commands;

import java.io.PrintWriter;
import Data.Data;

/**
 * Created by rhoo on 17/11/15.
 */
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
        if(input.length != NUMARG)
            return false;
        return true;
    }
}
