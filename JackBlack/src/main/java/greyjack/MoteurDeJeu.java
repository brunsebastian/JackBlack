package greyjack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
		Joueur joueur = new Joueur ( 500 ) ;
		joueur.tirerCarte ( sabot ) ;
		croupier.tirerCarte ( sabot ) ;
		joueur.tirerCarte ( sabot ) ;
		
		//Alexia.executerTour ( sabot ) ;
		//sabot.afficherToutesLesCartesNoms ( ) ;

		while ( joueur.peutTirer ( ) )
		{
			System.out.println ( ) ;
			System.out.println ( ) ;
			croupier.afficherCartes ( ) ;
			croupier.afficherTotal ( ) ;
			System.out.println ( "-------------------------------------------------------" ) ;
			joueur.afficherCartes ( ) ;
			joueur.afficherTotal ( ) ;
			joueur.decider ( sabot ) ;
		}
		while ( croupier.peutTirer ( ) )
		{
			try {
				Thread.sleep ( 500 ) ;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			croupier.decider ( sabot ) ;
			System.out.println ( ) ;
			System.out.println ( ) ;
			croupier.afficherCartes ( ) ;
			croupier.afficherTotal ( ) ;
			System.out.println ( "-------------------------------------------------------" ) ;
			joueur.afficherCartes ( ) ;
			joueur.afficherTotal ( ) ;
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