package greyjack;

import java.util.Scanner;

/* La classe manche est l'organisateur de la partie.
 *  Elle communique avec le croupier et le joueur.
 *  (à suivre virtual void ghostPlayer).
 *  Elle gère les phases de jeu. Elle calcule les victoires, gains, pertes.
 */
public class Manche {
	Joueur [] joueurs = null;
	Croupier croupier=null; // à corriger en virtual void ghostPlayer
	Sabot sabot = null;
	// en version 2.0 le nombre de joueurs est limité à 1
	int tempNombreJoueurs = 1;
	int tempNombreDePaquets = 6; // règles françaises
	
// Fonction qui retourne la position d'un objet dans une liste d'objets non primitifs
	public static <T> int indexOf(T[] array, T target) {
		for (int i=0; i< array.length; i++) {
			if (target.equals(array[i])) return i;
		}
		return -1;
	}
	
// Mettre à jour l'affichage de la table en fonction des valeurs actuelles du jeu
	public void afficherManche() {
		System.out.println ( ) ;
		System.out.println ( ) ;
		croupier.afficherCartes ( ) ;
		croupier.afficherTotal ( ) ;
		for (Joueur joueurATable : this.joueurs) {
			System.out.println ( "-------------------------------------------------------" ) ;
			joueurATable.afficherCartes();
			joueurATable.afficherTotal();
		}
	}
	
// Fonction de debuggage : affichage des scores dans la console
	public void afficherScore() {
		/*
		List <Joueur> joueursGagnants = new ArrayList();
		boolean croupierGagnant = false; // à corriger quand on intègre le croupier comme joueur ghostPlayer
		for (Joueur joueurActuel:this.joueurs) {
			if (joueurActuel.estBlackjack()) {
				joueursGagnants.add(joueurActuel);
			};
		}
		if (croupier.estBlackjack()) {
			croupierGagnant = true;
		}
		if (joueursGagnants.isEmpty() && croupierGagnant == false) {
			for (Joueur joueurDeLaPartie : this.joueurs ) {
				if (joueurDeLaPartie == null) System.out.println("Vide.");
					if (!joueurDeLaPartie.estSaute()) {
						if (joueursGagnants.isEmpty() || joueurDeLaPartie.getTotalFinal() == joueursGagnants.get(0).getTotalFinal() ) {
							System.out.println("tu pues");
							joueursGagnants.add(joueurDeLaPartie);
						}
						else if (joueurDeLaPartie.getTotalFinal() > joueursGagnants.get(0).getTotalFinal()) {
						joueursGagnants.clear();
						joueursGagnants.add(joueurDeLaPartie);
					}
				}
			}
		}
		
		if (joueursGagnants.isEmpty()) {
			System.out.println("You loooooooose !"); //tous les joueurs ont sauté ou le donneur seul a un blackjack
		}
		else if (croupierGagnant = true) // croupier a blackjack et il y a au moins un joueur avec blackjack
			
		{
			
		}*/
	}
	
// Fonction de fin de partie : vérifie les scores de chacun et désigne le vainqueur
	
	private Scanner sc;
	public void designerVainqueur() {
		double multiplicateur = 0 ;
		for (Joueur joueurDeLaPartie : this.joueurs ) {
			if ( joueurDeLaPartie.estSaute() )
				multiplicateur = -1 ;
			else if ( croupier.estBlackjack() ) {
				if ( joueurDeLaPartie.estBlackjack() )
					multiplicateur = 0 ;
				else
					multiplicateur = -1 ;
			}
			else if (joueurDeLaPartie.estBlackjack()) {
				multiplicateur = 1.5 ;
			}
			else if ( croupier.estSaute() )	
				multiplicateur = 1 ;
			else if ( joueurDeLaPartie.getTotalFinal() > croupier.getTotalFinal() )
				multiplicateur = 1 ;
			else if ( joueurDeLaPartie.getTotalFinal() < croupier.getTotalFinal() )
				multiplicateur = -1 ;
			else
				multiplicateur = 0 ;

			
			if ( multiplicateur == -1 ) {
				Navigation.afficherMessageDefaite();
			}
			else if ( multiplicateur == 0 ) {
				Navigation.afficherMessageEgalite();
			}
			else if ( multiplicateur == 1 ) {
				Navigation.afficherMessageVictoire();
			}
			else if ( multiplicateur == 1.5 ) {
				System.out.println("Blackjack !!! La fete a ton cul");
				Navigation.afficherBlackjack();
				try {
					Navigation.afficherDoigt();
				}
				catch (InterruptedException iE)
				{
					iE.printStackTrace();
				}
			}
			else
				System.out.println ( "ERREUR" ) ; 
			joueurDeLaPartie.gagnerPerdre ( multiplicateur );
		}
	}
	
// Verification que la manche a été initialisée
	public boolean estVide() {
		return this==null;
	}
	
// Fonction appelée par le jeu pour créer une nouvelle manche
// Constructeur. A corriger pour les cas multijoueurs
	public Manche() {
		
		//Initialisation de la manche
		this.joueurs = new Joueur[tempNombreJoueurs];
		this.croupier = new Croupier(300000);
		for (int i=0; i< tempNombreJoueurs; i++) this.joueurs[i] = new Joueur (500);
		sabot = new Sabot(tempNombreDePaquets);
		sabot.melanger();
		
		boolean flagJouer = true ;
		while ( flagJouer ) {
			System.out.println ( "Vous possedez " + joueurs[0].getCave() + " M$." ) ;
			System.out.println ( "Veuillez renseigner votre mise (0 pour quitter la table) : " ) ;
			sc = new Scanner(System.in);
			int miseInput = sc.nextInt();
			if ( miseInput <= 0)
				flagJouer = false ;
			else {
				joueurs[0].setMise(miseInput);
			
				//Premiere donne
				for (Joueur joueurActif: this.joueurs) {
					joueurActif.tirerCarte(sabot);
					joueurActif.setServi(false);
				}
				croupier.tirerCarte(sabot);
				for (Joueur joueurActif: this.joueurs) joueurActif.tirerCarte(sabot);
				
				System.out.print("Sabot : " +sabot.getNombreCartes() + " ");
				for (int i = 0 ; i<sabot.getNombreCartesRestantes() ; i +=4) System.out.print("|");
				for (int i = sabot.getNombreCartes(); i<312 ; i +=4) System.out.print(".");
				afficherManche();
				
				// Cas general de la manche
				for (Joueur joueurActif: this.joueurs) {			
					while (!joueurActif.getServi()) {
						joueurActif.decider(this.sabot);
						afficherManche();
					}
					System.out.println("Joueur "+ Integer.toString(indexOf(this.joueurs, joueurActif)) +" servi.");			
				}
				while (!croupier.getServi()) {
					croupier.decider(this.sabot);
					afficherManche();		
				// temps d'attente pour la lisibilité de la donne
					try {
						Thread.sleep ( 250 ) ;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				try { Thread.sleep ( 1000 ) ; } catch (InterruptedException e) { e.printStackTrace(); }
				designerVainqueur();
				joueurs[0].jeterMain();
				croupier.jeterMain();
				sabot.finDeManche () ;
				try { Thread.sleep ( 1000 ) ; } catch (InterruptedException e) { e.printStackTrace(); }
			}
		}
		
		
	}
// En cas de perte d'un joueur, prend son argent, l'ajoute au croupier
	private int prendrePertes(Joueur joueurActif) {
		return 0;
	}

// En cas de gain d'un joueur, prend son argent, l'ajoute au croupier
	private int donnerGains(Joueur joueurActif) {
		return 0;
	}

// Appel les fonctions prendrePertes() et donnerGain()
// S'assure de la solvabilité des joueurs et/ou croupier.
	public void payerEncaisser() {
		for (Joueur joueurActif : this.joueurs) {
			prendrePertes(joueurActif);
			donnerGains(joueurActif);
		}
	}
	
// set la liste de joueurs dans la manche
	public void setJoueurs( int nombreJoueurs) {
		joueurs = new Joueur[nombreJoueurs];
	}

// get la liste de joueurs dans la manche. En version 2.0 c'est 1.
	public Joueur [] getJoueurs() {
		return this.joueurs;		
	}
}
