package Commands;

import java.io.PrintWriter;
import Data.Data;

/**
 * Created by rhoo on 17/11/15.
 */
public class EchoNCommand extends Commands {

    public EchoNCommand(PrintWriter out) {
        super(out);
    }

    @Override
    public boolean execute(String[] input, Data data) {
        if(data.existSurname(input[1]))
            out.println(data.getName(input[1]));
        else
            out.println("SURNAME NOT FOUND");
        return true;
    }
}
