package Commands;

import java.io.PrintWriter;
import Data.Data;

/**
 * Created by rhoo on 17/11/15.
 */
public class RemoveSCommand extends Commands {

    public RemoveSCommand(PrintWriter out) {
        super(out);
    }

    @Override
    public boolean execute(String[] input, Data data) {
        if(!data.existSurname(input[1]))
            out.println("SURNAME NOT FOUND");
        else {
            data.removeSurname(input[1]);
            out.println("REMOVEOK");
        }
        return true;
    }
}
