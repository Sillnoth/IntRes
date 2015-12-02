package commands;

import java.io.PrintWriter;
import data.Data;


public class EchoNCommand extends Commands {

    private static final int NUMARG = 2;
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

    @Override
    public boolean valid(String[] input) {
        return input.length == NUMARG;
    }
}
