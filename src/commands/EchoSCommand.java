package commands;

import java.io.PrintWriter;
import data.Data;


public class EchoSCommand extends Commands {

    private static final int NUMARG = 2;
    public EchoSCommand(PrintWriter out) {
        super(out);
    }

    @Override
    public boolean execute(String[] input, Data data) {
        if(data.existName(input[1])) {
            String retour = "";
            for (String surname : data.getSurname(input[1]))
                retour += surname + " ;";
            if("".equals(retour))
                out.println("NO SURNAME FOR THIS NAME");
            else
                out.println(retour);
        }
        else
            out.println("NAME NOT FOUND");
        return true;
    }

    @Override
    public boolean valid(String[] input) {
        return input.length == NUMARG;
    }
}
