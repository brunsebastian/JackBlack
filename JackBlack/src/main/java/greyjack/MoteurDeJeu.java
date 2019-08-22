package greyjack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MoteurDeJeu {
	public static void main ( String[] args ) {
		Sabot sabot = new Sabot ( 2 ) ;
		sabot.melanger ( ) ;
		
		Croupier croupier = new Croupier ( 300000 ) ;
		Joueur joueur = new Joueur ( 500 ) ;
		joueur.tirerCarte ( sabot ) ;
		croupier.tirerCarte ( sabot ) ;
		joueur.tirerCarte ( sabot ) ;
		
		//Alexia.executerTour ( sabot ) ;
		//sabot.afficherToutesLesCartesNoms ( ) ;

		while ( ! joueur.getServi ( ) )
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
		while ( ! croupier.getServi ( ) )
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