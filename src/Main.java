import Server.Receptor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Main {

	public static void main(String[] args){
		int port = -1;
		try{
			if(Integer.parseInt(args[0]) <= 65535 && Integer.parseInt(args[0]) >=0)
				port = Integer.parseInt(args[0]);
		}
		catch (Exception e){}
		Receptor receptor = new Receptor(port);
		receptor.run();
	}

}
