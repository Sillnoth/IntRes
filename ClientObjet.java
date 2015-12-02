package main;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;


public class ClientObjet {

	public static void main(String[] args) throws Exception {

		String hostName = args[0];
		int portNumber = Integer.parseInt(args[1]);

		Scanner scanner;
		boolean welcome = true;
		scanner = new Scanner(System.in);
		Socket socket = new Socket(hostName, portNumber);
		ObjectOutputStream out = new ObjectOutputStream(
				socket.getOutputStream());
		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

		while (true) {
			try {
				if(welcome) {
					System.out.println(in.readObject());)
					welcome = false;
				}

				String choix = "";
				Requete requete = null;

				System.out.println("0 - Quit");
				System.out.println("1 - Add");
				System.out.println("2 - List");

				choix = scanner.nextLine();
				switch (choix) {
				case "0":
					requete = null;
					break;
				case "1":
					String nom = "", surnom = "";
					System.out.print("Nom: ");
					nom = scanner.nextLine();
					System.out.print("Surnom: ");
					surnom = scanner.nextLine();
					requete = new AjouterSurnom(nom, surnom);
					break;
				case "2":
					requete = new ListerPersonne();
					break;
				default:
					System.out.println("Choix non disponible");
					return;
				}
				out.writeObject(requete);
				if (requete == null) {
					System.out.println(in.readObject());
					in.close();
					out.close();
					socket.close();
					return;
				}
				Object rep = in.readObject();
				System.out.println(rep);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
