package greyjack;

public class MoteurDeJeu {
	public static void main ( String[] args ) {
		Sabot sabot = new Sabot ( 1 ) ;
		sabot.melanger ( ) ;
		/*
		//paquetDeCartes.afficherToutesLesCartesVerticalement ( ) ;
		Carte cinqDeCarreau = new Carte ( 31 ) ;
		Carte dameDeCoeur = new Carte ( 25 ) ;
		Carte asDeTrefle = new Carte ( 40 ) ;
		Main mainTest = new Main ( 10 ) ;
		mainTest.ajouter ( asDeTrefle ) ;
		mainTest.ajouter ( dameDeCoeur ) ;
		mainTest.ajouter ( cinqDeCarreau ) ;
		mainTest.ajouter ( new Carte ( 2 ) ) ;
		//mainTest.afficherCartes ( ) ;
		mainTest.tirerCarte ( sabot ) ;
		mainTest.afficherCartes ( ) ;
		mainTest.afficherTotal ( ) ;
		
		cinqDeCarreau.afficher ( ) ;
		cinqDeCarreau.afficherNomComplet ( ) ;
		
		sabot.afficherToutesLesCartesNoms ( ) ;
		sabot.afficherCartesEntre ( 1 , 5 ) ;
		System.out.println ( ) ;
		*/
		Croupier Alexia = new Croupier ( 300000 ) ;
		Alexia.executerTour ( sabot ) ;
	}
}

/*
Classes a faire :
- jeu de cartes
- carte
- Croupier
- joueur

*/