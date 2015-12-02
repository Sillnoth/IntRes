package Commands;

import java.io.PrintWriter;
import Data.Data;


public class EchoNCommand extends Commands {

    private final static int NUMARG = 2;
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
