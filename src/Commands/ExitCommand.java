package Commands;

import java.io.PrintWriter;
import Data.Data;

/**
 * Created by rhoo on 17/11/15.
 */
public class ExitCommand extends Commands {

    public ExitCommand(PrintWriter out) {
        super(out);
    }

    @Override
    public boolean execute(String[] input, Data data) {
        out.println("EXITOK");
        return false;
    }
}
