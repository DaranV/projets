	package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import tools.Encoder;

public class ClientProgrameur {

	private static int PORT = 2600;
	private static String adresse = "localhost";

	public static void main(String[] args) {
		try {
			Socket socket = new Socket(adresse,PORT);


			BufferedReader sin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter sout = new PrintWriter(socket.getOutputStream(),true);
			Scanner clavier = new Scanner(System.in);
			
			System.out.println("Connect� au serveur " + socket.getInetAddress() + ":"+ socket.getPort());

			String line;

			do {// r�ception et affichage de la question provenant du service

				line = sin.readLine();
				

				if (line == null) break; // fermeture par le service
				
				boolean end = Encoder.isEndCommunication(line);
				String error  = Encoder.getErrors(line);
				//D�code en remplacant les '###' par \n et enl�ve la partie erreur qui est entour� par <error> <error>
				line = Encoder.decode(line);
				
				System.err.print(error != null  ? "\n"+ error + "\n" : "\n");
				System.out.println(line);
				
				if(end) break;

				// prompt d'invite � la saisie
				System.out.print("->");
				
				line = clavier.nextLine();
				if (line.equals("")) break; // fermeture par le client
				// envoie au service de la r�ponse saisie au clavier
				sout.println(Encoder.encode(line));
				
				
			} while (true);


			socket.close();


		} catch (IOException e) {
			e.printStackTrace();
		}


	}


}
