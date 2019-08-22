package greyjack;

/* La classe manche est l'organisateur de la partie.
 *  Elle communique avec le croupier et le joueur.
 *  (� suivre virtual void ghostPlayer).
 *  Elle g�re les phases de jeu. Elle calcule les victoires, gains, pertes.
 */
public class Manche {
	Joueur [] joueurs = null;
	Croupier croupier=null; // � corriger en virtual void ghostPlayer
	int bouton;
	// en version 2.0 le nombre de joueurs est limit� � 1
	int tempNombreJoueurs = 1;
	
// Mettre � jour l'affichage de la table en fonction des valeurs actuelles du jeu
	public void afficherManche() {
		
	}
	
// Fonction de debuggage : affichage des scores dans la console
	public void afficherScore() {
		
	}
	
// Fonction de fin de partie : v�rifie les scores de chacun et d�signe le vainqueur
	public boolean designerVainqueur() {
		return true;
	}
	
// Verification que la manche a �t� initialis�e
	public boolean estVide() {
		return this==null;
	}
	
// Fonction appel�e par le jeu pour cr�er une nouvelle manche
// Constructeur. A corriger pour les cas multijoueurs
	public Manche() {
		joueurs = new Joueur[tempNombreJoueurs];
		while (!designerVainqueur()) {
			//Croupier.tirerCarte();
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
// S'assure de la solvabilit� des joueurs et/ou croupier.
	public void payerEncaisser() {
		/*for (Joueur joueurActif : this.joueurs[]) {
			prendrePertes(j);
			donnerGains(j);
		}*/
	}
	
// get la liste de joueurs dans la manche
	public void getJoueurs( int nombreJoueurs) {
		joueurs = new Joueur[nombreJoueurs];
	}

// set la liste de joueurs dans la manche. En version 2.0 c'est 1.
	public Joueur [] setJoueurs() {
		return this.joueurs;		
	}
	
	public void getBouton(int premierJoueur) {
		
	}
	
	public int setBouton() {
		return this.bouton;
	}
}
