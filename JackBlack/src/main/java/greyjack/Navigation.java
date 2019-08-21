package greyjack;

import java.util.Scanner;

public class Navigation {
	static boolean start = true;
	static Scanner sc = new Scanner(System.in);
	
	public static void lancerJeu() {
		//	boucle de jeu
		while (start){
			System.out.println("___.   .__                 __         __               __    \r\n" + 
					"\\_ |__ |  | _____    ____ |  | __    |__|____    ____ |  | __\r\n" + 
					" | __ \\|  | \\__  \\ _/ ___\\|  |/ /    |  \\__  \\ _/ ___\\|  |/ /\r\n" + 
					" | \\_\\ \\  |__/ __ \\\\  \\___|    <     |  |/ __ \\\\  \\___|    < \r\n" + 
					" |___  /____(____  /\\___  >__|_ \\/\\__|  (____  /\\___  >__|_ \\\r\n" + 
					"     \\/          \\/     \\/     \\/\\______|    \\/     \\/     \\/\r\n" + 
					"                                    \r\n" + 
					"                        (  (     (  (    \r\n" + 
					"              `  )   (  )\\))(   ))\\ )(   \r\n" + 
					"              /(/(   )\\((_)()\\ /((_|()\\  \r\n" + 
					"             ((_)_\\ ((_)(()((_|_))  ((_) \r\n" + 
					"             | '_ \\) _ \\ V  V / -_)| '_| \r\n" + 
					"             | .__/\\___/\\_/\\_/\\___||_|   \r\n" + 
					"             |_|                         \r\n" + 
					"\r\n" + 
					"");
			System.out.println("Nouvelle Partie (N)");
			System.out.println("Charger la dernière partie (C)");
			System.out.println("Meilleurs Scores (S)");
			System.out.println("Quitter (Q)");
			char prompt = sc.nextLine().charAt(0);
			if(prompt == 'N') {
				System.out.println("Blackjack Power baby !");
				Navigation.jeu();
			} else if(prompt == 'Q') {
				System.out.println("La prochaine fois peut être ...");
				start = false;
			}
		}
	}

	
	public static void jeu() {
		Sabot paquetDeCartes = new Sabot ( 2 ) ;
		paquetDeCartes.melanger ( ) ;
		//paquetDeCartes.afficherToutesLesCartes ( ) ;
		Carte cinqDeCarreau = new Carte ( 31 ) ;
		Carte dameDeCoeur = new Carte ( 25 ) ;
		Carte asDeTrefle = new Carte ( 40 ) ;
		Main mainTest = new Main ( 10 ) ;
		mainTest.ajouter ( asDeTrefle ) ;
		mainTest.ajouter ( dameDeCoeur ) ;
		mainTest.ajouter ( cinqDeCarreau ) ;
		mainTest.ajouter ( new Carte ( 2 ) ) ;
		//mainTest.afficherCartes ( ) ;
		//mainTest.tirerCarte ( paquetDeCartes ) ;
		mainTest.afficherCartes ( ) ;
		mainTest.afficherTotal ( ) ;
		cinqDeCarreau.afficher ( ) ;
		cinqDeCarreau.afficherNomComplet ( ) ;
	}
}