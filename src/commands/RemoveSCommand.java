package commands;

import java.io.PrintWriter;
import data.Data;

public class RemoveSCommand extends Commands {

    private static final int NUMARG = 2;
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
