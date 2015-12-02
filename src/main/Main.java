package main;

import server.Receptor;

public class Main {

	private Main(){}
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
