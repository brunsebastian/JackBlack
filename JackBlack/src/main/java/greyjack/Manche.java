package greyjack;

import java.util.List;

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
	for (int i=0; i<= array.length; i++) {
		if (target.equals(array[i])) return i;
	}
	return -1;
}
	
// Mettre à jour l'affichage de la table en fonction des valeurs actuelles du jeu
	public void afficherManche() {
		Navigation.afficherMenu();
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
		
	}
	
// Fonction de fin de partie : vérifie les scores de chacun et désigne le vainqueur
	public void designerVainqueur() {
		List <Joueur> joueursGagnants = null;
		boolean croupierGagnant==false; // à corriger quand on intègre le croupier comme joueur ghostPlayer
		for (Joueur joueurActuel:this.joueurs) {
			if (joueurActuel.estBlackjack()) {
				joueursGagnants.add(joueurActuel);
			};
		}
		if (croupier.estBlackjack()) {
			croupierGagnant = true;
		}
	}
		
		afficherScore();
		
		Youpi Kai » apparait lorsque le joueur gagne.
		Le message « You loooooooose !» apparait lorsque
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
		for (int i=0; i< tempNombreJoueurs; i++) this.joueurs[i] = new Joueur (500); // corriger avec fonction static length(array of object)
		sabot = new Sabot(tempNombreDePaquets);
		sabot.melanger();
		
		//Premiere donne
		for (Joueur joueurActif: this.joueurs) joueurActif.tirerCarte(sabot);
		croupier.tirerCarte(sabot);
		for (Joueur joueurActif: this.joueurs) joueurActif.tirerCarte(sabot);
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
