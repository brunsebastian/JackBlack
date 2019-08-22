package greyjack;

import java.util.ArrayList;
import java.util.List;

/* La classe manche est l'organisateur de la partie.
 *  Elle communique avec le croupier et le joueur.
 *  (� suivre virtual void ghostPlayer).
 *  Elle g�re les phases de jeu. Elle calcule les victoires, gains, pertes.
 */
public class Manche {
	Joueur [] joueurs = null;
	Croupier croupier=null; // � corriger en virtual void ghostPlayer
	Sabot sabot = null;
	// en version 2.0 le nombre de joueurs est limit� � 1
	int tempNombreJoueurs = 1;
	int tempNombreDePaquets = 6; // r�gles fran�aises
	
// Fonction qui retourne la position d'un objet dans une liste d'objets non primitifs
	public static <T> int indexOf(T[] array, T target) {
		for (int i=0; i< array.length; i++) {
			if (target.equals(array[i])) return i;
		}
		return -1;
	}
	
// Mettre � jour l'affichage de la table en fonction des valeurs actuelles du jeu
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
		boolean croupierGagnant = false; // � corriger quand on int�gre le croupier comme joueur ghostPlayer
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
			System.out.println("You loooooooose�!"); //tous les joueurs ont saut� ou le donneur seul a un blackjack
		}
		else if (croupierGagnant = true) // croupier a blackjack et il y a au moins un joueur avec blackjack
			
		{
			
		}*/
	}
	
// Fonction de fin de partie : v�rifie les scores de chacun et d�signe le vainqueur
	public void designerVainqueur() {			
		for (Joueur joueurDeLaPartie : this.joueurs ) {
			if ( joueurDeLaPartie.estSaute() )
				System.out.println ( "You loooooooose !" ) ;
			else if ( croupier.estBlackjack() ) {
				if ( joueurDeLaPartie.estBlackjack() )
					System.out.println ( "Egalite." ) ;
				else
					System.out.println ( "You loooooooose !" ) ;
			}
			else if (joueurDeLaPartie.estBlackjack()) {
				System.out.println("Blackjack !!! La fete a ton cul");
			}
			else if ( croupier.estSaute() )	
				System.out.println( "Youpi Kai." );
			else if ( joueurDeLaPartie.getTotalFinal() > croupier.getTotalFinal() )
					System.out.println( "Youpi Kai." );
			else if ( joueurDeLaPartie.getTotalFinal() < croupier.getTotalFinal() )
				System.out.println( "You loooooooose !" );
			else
				System.out.println( "Egalite." );			
			System.out.println ( "-------------------------------" ) ;
		}
	}
	
// Verification que la manche a �t� initialis�e
	public boolean estVide() {
		return this==null;
	}
	
// Fonction appel�e par le jeu pour cr�er une nouvelle manche
// Constructeur. A corriger pour les cas multijoueurs
	public Manche() {
		
		//Initialisation de la manche
		this.joueurs = new Joueur[tempNombreJoueurs];
		this.croupier = new Croupier(300000);
		for (int i=0; i< tempNombreJoueurs; i++) this.joueurs[i] = new Joueur (500);
		sabot = new Sabot(tempNombreDePaquets);
		sabot.melanger();
		
		//Premiere donne
		for (Joueur joueurActif: this.joueurs) joueurActif.tirerCarte(sabot);
		croupier.tirerCarte(sabot);
		for (Joueur joueurActif: this.joueurs) joueurActif.tirerCarte(sabot);
		System.out.println("Autant pour moi encore.");
		afficherManche();
		System.out.println("Autant pour moi ou pas.");		
		
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
		// temps d'attente pour la lisibilit� de la donne
			try {
				Thread.sleep ( 50 ) ;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		designerVainqueur();
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
// S'assure de la solvabilit� des joueurs et/ou croupier.
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
