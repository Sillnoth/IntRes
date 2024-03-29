package commands;

import java.io.PrintWriter;
import data.Data;

public class EditSCommand extends Commands {

    private static final int NUMARG = 3;
    public EditSCommand(PrintWriter out) {
        super(out);
    }

    @Override
    public boolean execute(String[] input, Data data) {
        if(!data.existSurname(input[1]))
            out.println("SURNAME NOT FOUND");
        else if(data.existSurname(input[2]))
            out.println("ALRDYEX SURNAME : "+input[2]);
        else {
            data.editSurname(input[1],input[2]);
            out.println("EDITOK");
        }
        return true;
    }

    @Override
    public boolean valid(String[] input) {
        return input.length == NUMARG;
    }


}
