package greyjack;

public class Scores {
	private int score[] ;
	private String nom[] ;
	private int nombreJoueursAffiches ;
	
	public Scores ( int nombreJoueursInput ) {
		score = new int[nombreJoueursInput] ;
		nom = new String[nombreJoueursInput] ;
		nombreJoueursAffiches = nombreJoueursInput ;

		score[0] = 1000 ;
		score[1] = 200 ;
		score[2] = 50 ;
		nom[0] = "Philippe Le Grand" ;
		nom[1] = "Marion" ;
		nom[2] = "Xena" ;
	}

	public int getScore ( int index ) {
		return this.score[index] ;
	}
	public String getNom ( int index ) {
		return this.nom[index] ;
	}

	
	public void afficherMeilleursScores () {
		System.out.println ("MEILLEURS SCORES") ;
		System.out.println ( "Rang | Nom        | Score" ) ;
		for ( int i = 0 ; i < this.nombreJoueursAffiches ; i ++ )
			System.out.println ( (i+1) + " | " + this.nom[i] + " | " + this.score[i] ) ;
	}

}
