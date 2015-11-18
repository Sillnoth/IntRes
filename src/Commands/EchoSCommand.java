package Commands;

import java.io.PrintWriter;
import Data.Data;

/**
 * Created by rhoo on 17/11/15.
 */
public class EchoSCommand extends Commands {

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
}
