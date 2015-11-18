package Commands;

import java.io.PrintWriter;
import Data.Data;

public class RemoveSCommand extends Commands {

    private final static int NUMARG = 2;
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

    @Override
    public boolean valid(String[] input) {
        return input.length == NUMARG;
    }
}
