import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class ClientMain {

	public static void main(String[] args) throws UnknownHostException {
		String hostName = args[0];
		int portNumber = Integer.parseInt(args[1]);

		try (
		    Socket echoSocket = new Socket(hostName, portNumber);
		    PrintWriter out =
		        new PrintWriter(echoSocket.getOutputStream(), true);
		    BufferedReader in =
		        new BufferedReader(
		            new InputStreamReader(echoSocket.getInputStream()));
		    BufferedReader stdIn =
		        new BufferedReader(
		            new InputStreamReader(System.in))
		){
			String userInput;
			while ((userInput = stdIn.readLine()) != null) {
			    out.println(userInput);
				String response = in.readLine();
			    System.out.println(response);
				if(response.equals("EXITOK"))
					break;
			}

			in.close();
			stdIn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}



	}

}
