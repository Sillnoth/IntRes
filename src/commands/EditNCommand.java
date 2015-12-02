package commands;

import java.io.PrintWriter;
import data.Data;


public class EditNCommand extends Commands {

    private static final int NUMARG = 3;
    public EditNCommand(PrintWriter out) {
        super(out);
    }

    @Override
    public boolean execute(String[] input, Data data) {
        if(!data.existName(input[1]))
            out.println("NAME NOT FOUND : " + input[1] );
        else if(data.existName(input[2]))
            out.println("ALRDYEX NAME : " + input[2] );
        else {
            data.editName(input[1], input[2]);
            out.println("EDITOK");
        }
        return true;

    }

    @Override
    public boolean valid(String[] input) {
        return input.length == NUMARG;
    }
}
