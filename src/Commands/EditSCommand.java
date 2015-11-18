package Commands;

import java.io.PrintWriter;
import Data.Data;

/**
 * Created by rhoo on 17/11/15.
 */
public class EditSCommand extends Commands {

    private final static int NUMARG = 3;
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
        if(input.length != NUMARG)
            return false;
        return true;
    }


}
