package commands;

import java.io.PrintWriter;

import data.Data;


public abstract class Commands {
    protected PrintWriter out;

    Commands(PrintWriter out) {
        this.out = out;
    }

    public abstract boolean execute(String[] input, Data data);

    public abstract boolean valid(String[] input);

}
