package greyjack;

public class MoteurDeJeu {
	public static void main ( String[] args ) {
		Sabot sabot = new Sabot ( 2 ) ;
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
		
		Carte troisDeCoeur = new Carte ( "3" , "coeur" ) ;
		troisDeCoeur.afficher ( ) ;
		*/
		Croupier croupier = new Croupier ( 300000 ) ;
		Joueur Mylene = new Joueur ( 500 ) ;
		//Alexia.executerTour ( sabot ) ;
		//sabot.afficherToutesLesCartesNoms ( ) ;
		
		
		while ( croupier.getTotalFinal ( ) < 17 )
		{
			croupier.tirerCarte ( sabot ) ;
			croupier.afficherCartes ( ) ;
			croupier.afficherTotal ( ) ;
			try {
				Thread.sleep ( 1000 ) ;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if ( croupier.getTotalFinal ( ) > 21 )
				System.out.println ( "SAUTE" ) ;
			System.out.println ( ) ;
		}
	}
}

/*
Classes a faire :
- jeu de cartes
- carte
- Croupier
- joueur

*/