package Commands;

import java.io.PrintWriter;
import Data.Data;

/**
 * Created by rhoo on 17/11/15.
 */
public class RemoveNCommand extends Commands {

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
}
