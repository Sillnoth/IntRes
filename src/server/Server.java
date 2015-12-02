package server;


import data.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Server {

	private Data data;
	private Socket client;

	Server(Socket client, Data data) {
		this.data = data;
		this.client = client;
		start();
	}

	public void start() {
			try (
					PrintWriter out =
							new PrintWriter(client.getOutputStream(), true);
					BufferedReader in = new BufferedReader(
							new InputStreamReader(client.getInputStream()));
			)
			{
				String inputLine;
				CommandsInterpretor interpretor = new CommandsInterpretor(out);
				boolean fin = true;
				while (fin && (inputLine = in.readLine()) != null) {
					String[] input = inputLine.split(";");
					fin = interpretor.execute(input, data);
				}
				client.close();
				System.out.println("client: " + Thread.currentThread().getId() + " CONNECTION CLOSED");

			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
}
