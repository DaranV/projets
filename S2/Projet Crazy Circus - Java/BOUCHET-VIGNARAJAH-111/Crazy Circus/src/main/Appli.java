package main;

import java.util.Scanner;

import entit�s.Dompteur;
import entit�s.Border;
import jeu.Jeu;

/**
 * Classe Appli du projet crazyCircus. Elle contient le main.
 * 
 * @author BOUCHET Ulysse & VIGNARAJAH Daran
 * @version 2.2 23/02/2019
 */
public class Appli {

	/**
	 * main du projet crazyCircus
	 * 
	 * @param noms la liste des noms de sc�nes des dompteurs voulant participer au
	 *             jeu
	 */
	public static void main(String[] noms) {
		Scanner sc = new Scanner(System.in);

		// G�n�ration du jeu
		Jeu crazyCircus = new Jeu();
		System.out.print(Border.border);
		System.out.println("Initialisation du jeu en cours...");

		if (noms.length != 0) {

			// Inscription des dompteurs
			System.out.print(Border.border);
			System.out.println("Inscription de tous les dompteurs...");
			for (int i = 0; i < noms.length; ++i) {
				System.out.println(crazyCircus.addDompteur(noms[i]));
			}

			// Potentielle inscription d'autres dompteurs
			System.out.print(Border.border);
			System.out.println("En plus de ceux que vous avez pass� en param�tre,");
			if (continueAdding())
				addDompteurs(crazyCircus);

		} else {
			// Si aucun dompteur n'a �t� pass� en param�tre, inscription de dompteurs
			// manuelle
			System.out.print(Border.border);
			System.out.println("Aucun dompteur n'a �t� pass� en param�tre.");
			System.out.println("Veuillez les entrer manuellement.");
			addDompteurs(crazyCircus);
		}

		chooseDifficulty(crazyCircus);
		// Boucle de jeu
		boolean play = true;
		String nomDeScene;
		String commande;
		while (crazyCircus.continueJeu()) {
			// Affichage de la situation
			System.out.print(Border.border);
			System.out.println(crazyCircus.displayJeu());

			// Scan de la commande:
			System.out.print(Border.border);
			System.out.println("Entrez votre pseudo suivi d'une commande :");
			nomDeScene = sc.next();
			commande = sc.next().toUpperCase();

			// Simulation de la commande et affichage de ses cons�quences
			System.out.print(Border.border);
			System.out.println(crazyCircus.play(nomDeScene, commande));
		}

		// Affichage du classement
		System.out.print(Border.border);
		System.out.println(crazyCircus.displayLeaderboard());
	}

	/**
	 * Permet d'ajouter des dompteurs (joueurs) au jeu pass� en param�tre
	 * 
	 * @param j Jeu auquel on souhaite ajouter des dompteurs
	 * 
	 * @see Jeu
	 * @see Jeu#addDompteur(String)
	 * @see Dompteur
	 */
	public static void addDompteurs(Jeu j) {
		Scanner sc = new Scanner(System.in);

		String nomDeScene = new String();
		boolean addDompteurs = true;
		while (addDompteurs) {
			Dompteur tmp;
			System.out.print(Border.border);
			System.out.println("Entrez le nom de sc�ne d'un dompteur :");
			System.out.println("(uniquement des lettres (sans accents))");

			nomDeScene = sc.next();
			System.out.println(j.addDompteur(nomDeScene));
			addDompteurs = continueAdding();
		}
	}

	/**
	 * Demande � l'utilisateur s'il veut continuer � ajouter de nouveaux dompteurs
	 * au jeu
	 * 
	 * @return true si l'utilisateur veut, false sinon
	 */
	public static boolean continueAdding() {
		Scanner sc = new Scanner(System.in);

		String choix;
		boolean valide = false;
		while (!valide) {
			System.out.println("Avez-vous d'autres dompteurs � ajouter? (OUI/NON)");
			choix = sc.next();
			if (choix.toUpperCase().equals("OUI"))
				return true;
			else if (choix.toUpperCase().equals("NON"))
				return false;
			else {
				System.out.print(Border.border);
				System.out.println("Veuillez entrer une cha�ne valide.");
			}
		}
		return false;
	}

	/**
	 * Permet � l'utilisateur de choisir la difficult� du jeu
	 * 
	 * @param j le jeu
	 * @see Jeu
	 * @see Jeu#setDifficile(boolean)
	 */
	public static void chooseDifficulty(Jeu j) {
		Scanner sc = new Scanner(System.in);

		String choix = " ";
		while (!choix.toUpperCase().equals("FACILE") && !choix.toUpperCase().equals("DIFFICILE")) {
			System.out.print(Border.border);
			System.out.println("Choississez votre difficult� (Facile/Difficile):");
			System.out.println("En mode difficile, la commande SO est interdite.");

			choix = sc.next();

			if (choix.toUpperCase().equals("FACILE"))
				j.setDifficile(false);
			else if (choix.toUpperCase().equals("DIFFICILE"))
				j.setDifficile(true);
			else {
				System.out.print(Border.border);
				System.out.println("Veuillez entrer une cha�ne valide.");
			}

		}
	}

}