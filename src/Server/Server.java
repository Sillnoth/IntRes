package Server;

import Commands.ExitCommand;
import Data.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) {
		int portNumber = Integer.parseInt(args[0]);
		
		try ( 
		    ServerSocket serverSocket = new ServerSocket(portNumber);
		    Socket clientSocket = serverSocket.accept();
		    PrintWriter out =
		        new PrintWriter(clientSocket.getOutputStream(), true);
		    BufferedReader in = new BufferedReader(
		        new InputStreamReader(clientSocket.getInputStream()));
		) {			
			String inputLine;
			CommandsInterpretor interpretor = new CommandsInterpretor(out);
			Data data = new Data();
			boolean fin = true;
            while (fin && (inputLine = in.readLine()) != null) {
				String[] input = inputLine.split(";");
				fin = interpretor.execute(input,data);
            }
            System.out.println("CONNECTION CLOSED");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
}
