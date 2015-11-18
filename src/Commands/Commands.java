package Commands;

import java.io.PrintWriter;
import Data.Data;

/**
 * Created by rhoo on 17/11/15.
 */
public abstract class Commands {
    protected PrintWriter out;
    protected int numArg;

    Commands(PrintWriter out) {
        this.out = out;
    }

    public abstract boolean execute(String[] input, Data data);

    public abstract boolean valid(String[] input);
}
