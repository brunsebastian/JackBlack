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
			afficherMenu();
		}
	}

	/*
	 * Affichage du menu de jeu
	 */
	public static void afficherMenu() {
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
	// un commentaire 2
	public static void afficherMessageVictoire() {
		String messageVictoire = " /$$     /$$                           /$$       /$$   /$$           /$$\r\n" + 
				"|  $$   /$$/                          |__/      | $$  /$$/          |__/\r\n" + 
				" \\  $$ /$$/$$$$$$  /$$   /$$  /$$$$$$  /$$      | $$ /$$/   /$$$$$$  /$$\r\n" + 
				"  \\  $$$$/$$__  $$| $$  | $$ /$$__  $$| $$      | $$$$$/   |____  $$| $$\r\n" + 
				"   \\  $$/ $$  \\ $$| $$  | $$| $$  \\ $$| $$      | $$  $$    /$$$$$$$| $$\r\n" + 
				"    | $$| $$  | $$| $$  | $$| $$  | $$| $$      | $$\\  $$  /$$__  $$| $$\r\n" + 
				"    | $$|  $$$$$$/|  $$$$$$/| $$$$$$$/| $$      | $$ \\  $$|  $$$$$$$| $$\r\n" + 
				"    |__/ \\______/  \\______/ | $$____/ |__/      |__/  \\__/ \\_______/|__/\r\n" + 
				"                            | $$                                        \r\n" + 
				"                            | $$                                        \r\n" + 
				"                            |__/                                        \r\n" + 
				"\r\n" + 
				""; 
		System.out.println(messageVictoire);
	}
	
	public static void afficherMessageDefaite() {
		String messageDefaite = "                                                                                                                              ,---,  \r\n" + 
				"                                                                                                                           ,`--.' |  \r\n" + 
				"                                               ,--,                                                                        |   :  :  \r\n" + 
				"        ,---,                                ,--.'|                                                                        '   '  ;  \r\n" + 
				"       /_ ./|   ,---.           ,--,         |  | :     ,---.     ,---.     ,---.     ,---.                                |   |  |  \r\n" + 
				" ,---, |  ' :  '   ,'\\        ,'_ /|         :  : '    '   ,'\\   '   ,'\\   '   ,'\\   '   ,'\\   .--.--.                     '   :  ;  \r\n" + 
				"/___/ \\.  : | /   /   |  .--. |  | :         |  ' |   /   /   | /   /   | /   /   | /   /   | /  /    '     ,---.          |   |  '  \r\n" + 
				" .  \\  \\ ,' '.   ; ,. :,'_ /| :  . |         '  | |  .   ; ,. :.   ; ,. :.   ; ,. :.   ; ,. :|  :  /`./    /     \\         '   :  |  \r\n" + 
				"  \\  ;  `  ,''   | |: :|  ' | |  . .         |  | :  '   | |: :'   | |: :'   | |: :'   | |: :|  :  ;_     /    /  |        ;   |  ;  \r\n" + 
				"   \\  \\    ' '   | .; :|  | ' |  | |         '  : |__'   | .; :'   | .; :'   | .; :'   | .; : \\  \\    `. .    ' / |        `---'. |  \r\n" + 
				"    '  \\   | |   :    |:  | : ;  ; |         |  | '.'|   :    ||   :    ||   :    ||   :    |  `----.   \\'   ;   /|         `--..`;  \r\n" + 
				"     \\  ;  ;  \\   \\  / '  :  `--'   \\        ;  :    ;\\   \\  /  \\   \\  /  \\   \\  /  \\   \\  /  /  /`--'  /'   |  / |        .--,_     \r\n" + 
				"      :  \\  \\  `----'  :  ,      .-./        |  ,   /  `----'    `----'    `----'    `----'  '--'.     / |   :    |        |    |`.  \r\n" + 
				"       \\  ' ;           `--`----'             ---`-'                                           `--'---'   \\   \\  /         `-- -`, ; \r\n" + 
				"        `--`                                                                                               `----'            '---`\"  \r\n" + 
				"                                                                                                                                     \r\n" + 
				"\r\n" + 
				""; 
		System.out.println(messageDefaite);
	}
	
	public static void afficherMessageEgalite() {
		String messageEgalite = "\r\n" + 
				"\r\n" + 
				"     _                                _\r\n" + 
				"    /_/             .__  .__  __     /_/      \r\n" + 
				"  ____   _________  |  | |__|/  |_  ____  \r\n" + 
				"_/ __ \\ / ___\\__  \\ |  | |  \\   __\\/ __ \\ \r\n" + 
				"\\  ___// /_/  > __ \\|  |_|  ||  | \\  ___/ \r\n" + 
				" \\___  >___  (____  /____/__||__|  \\___  >\r\n" + 
				"     \\/_____/     \\/                   \\/ \r\n" + 
				"\r\n" + 
				""; 
		System.out.println(messageEgalite);
	}
	
	public static void afficherBlackjack() {
		String messageBlackjack = "\r\n" + 
				"\r\n" + 
				"__________.__                 __         __               __     ___.         ___.          ._.\r\n" + 
				"\\______   \\  | _____    ____ |  | __    |__|____    ____ |  | __ \\_ |__ _____ \\_ |__ ___.__.| |\r\n" + 
				" |    |  _/  | \\__  \\ _/ ___\\|  |/ /    |  \\__  \\ _/ ___\\|  |/ /  | __ \\\\__  \\ | __ <   |  || |\r\n" + 
				" |    |   \\  |__/ __ \\\\  \\___|    <     |  |/ __ \\\\  \\___|    <   | \\_\\ \\/ __ \\| \\_\\ \\___  | \\|\r\n" + 
				" |______  /____(____  /\\___  >__|_ \\/\\__|  (____  /\\___  >__|_ \\  |___  (____  /___  / ____| __\r\n" + 
				"        \\/          \\/     \\/     \\/\\______|    \\/     \\/     \\/      \\/     \\/    \\/\\/      \\/\r\n" + 
				"\r\n" + 
				"";
		System.out.println(messageBlackjack);
	}
	
	public static void afficherDoigt()throws InterruptedException {
//		String messageDoigt ="\r\n" + 
//				"\r\n" + 
//				"          __\r\n" + 
//				"         /' ||\r\n" + 
//				"         |_ '|\r\n" + 
//				"         |   |\r\n" + 
//				"         |   |\r\n" + 
//				"         |   |\r\n" + 
//				"      ___|   |__    \r\n" + 
//				"   _ /  /    /  /\r\n" + 
//				"  / |   '   '   |   \r\n" + 
//				" |              |\\\r\n" + 
//				" |              | |\r\n" + 
//				" |                |\r\n" + 
//				"  \\              / \r\n" + 
//				"    \\         '\r\n" + 
//				"    /        /\r\n" + 
//				"\r\n" + 
//				"";
//		System.out.println(messageDoigt);
		
		System.out.print("\r\n" + 
				"\r\n" + 
				"          __\r\n");
		Thread.sleep(200);
		System.out.print("         /' ||\r\n" + 
				"         |_ '|\r\n");
		Thread.sleep(200);
		System.out.print("         |   |\r\n" + 
				"         |   |\r\n");
		Thread.sleep(200);
		System.out.print("         |   |\r\n" + 
				"      ___|   |__    \r\n");
		Thread.sleep(200);
		System.out.print("   _ /  /    /  /\r\n" + 
				"  / |   '   '   |   \r\n");
		Thread.sleep(200);
		System.out.print(" |              |\\\r\n" + 
				" |              | |\r\n");
		Thread.sleep(200);
		System.out.print(" |                |\r\n" + 
				"  \\              / \r\n");
		Thread.sleep(200);
		System.out.print("    \\         '\r\n" + 
				"    /        /\r\n");
		Thread.sleep(200);
		System.out.println("\r\n" + 
				"");
	}

	public static void jeu() {
		Manche manche = new Manche();
	}
}