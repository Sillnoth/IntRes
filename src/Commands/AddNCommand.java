package Commands;

import java.io.PrintWriter;
import Data.Data;

public class AddNCommand extends Commands {

    private final static int NUMARG = 3;
    public AddNCommand(PrintWriter out) {
        super(out);
    }

    @Override
    public boolean execute(String[] input, Data data) {
        boolean ok = true;
        if(data.existName(input[1])) {
            out.println("ALRDYEX NAME : " + input[1]);
            return true;
        }
        data.addName(input[1]);
        String retour = "ALRDYEX SURNAME : ";
        for(int i = 2; i<input.length; i++) {
            if(data.existSurname(input[i])) {
                retour += input[i] + ";";
                ok = false;
            }
            else {
                data.addSurname(input[1], input[i]);
            }
        }
        if(ok)
            out.println("ADDOK");
        else
            out.println(retour);
        return true;
    }

    @Override
    public boolean valid(String[] input) {
        return input.length >= NUMARG;
    }
}
