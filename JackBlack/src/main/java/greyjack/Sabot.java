package greyjack;

public class Sabot {
	//private String Nationalite = "FR" ou "US" ou "GB"
	private int nombrePaquets = 0 ;
	private int nombreCartes = 0 ;
	private int indexCarteDessus = 0 ;
	private Carte[] cartesPaquet = null ; // 0 pour une carte inexistante
	
	public Sabot ( int nombrePaquetsInput ) { // Le jeu de cartes est cree trie
		this.nombrePaquets = nombrePaquetsInput ;
		this.nombreCartes = 52 * nombrePaquetsInput ;
		indexCarteDessus = this.nombreCartes - 1 ;
		cartesPaquet = new Carte[this.nombreCartes] ;
		for ( int i = 0 ; i < 52 * nombrePaquetsInput ; i ++ ) {
			cartesPaquet[i] = new Carte ( 1 + i ) ;
		}
	}
	
	public int getIdCarte ( int numero ) {
		return this.cartesPaquet[numero].getId ( ) ;
	}

	public void afficherToutesLesCartesVerticalement ( ) {
		for ( Carte carte : this.cartesPaquet ) {
			//this.cartePaquet[i].afficherNomComplet ( ) ;
			carte.afficher ( ) ;
			System.out.println ( ) ;
		}
	}
	public void afficherToutesLesCartesNoms ( ) {
		int i = 0 ;
		System.out.println ( "Nombre de cartes : " + nombreCartes ) ;
		for ( Carte carte : this.cartesPaquet ) {
			//this.cartesPaquet[i].afficherNomComplet ( ) ;
			i ++ ;
			System.out.print ( "Carte " + i + " : " );
			carte.afficherNomComplet ( ) ;
		}
	}
	public void afficherCartesEntre ( int rangDebut , int rangFin ) {
		for ( int i = 0 ; i < 7 ; i ++ ) {
			for ( int j = rangDebut ; j <= rangFin ; j ++ )
				//this.cartePaquet[i].afficherNomComplet ( ) ;
				if ( cartesPaquet[j].getId ( ) > 0 )
						System.out.print ( cartesPaquet[j].getLigneASCII ( i ) + "   " ) ;
			System.out.println ( ) ;
		}
	}
	
/*
	for ( int i = 0 ; i < 7 ; i ++ )
	{
		for ( Carte carte : this.cartesEnMain )
			if ( carte.getId ( ) > 0 )
				System.out.print ( carte.getLigneASCII ( i ) + "   " ) ;
		System.out.println ( ) ;
	}
}*/
	
	public void melanger ( ) {
		int[] nouvelID = new int[nombreCartes] ;
		int idTest = 0 ;
		int i = 0 ;
		while ( i < nombreCartes )
		{
			idTest = 1 + (int) ( Math.random ( ) * nombreCartes ) ;
			for ( int j = 0 ; j < i ; j ++ )
				if ( idTest == nouvelID[j] )
					idTest = 0 ;
			if ( idTest != 0 ) {
				nouvelID[i] = idTest ;
				cartesPaquet[i] = new Carte ( idTest ) ;
				i ++ ;
			}
		}
	}
	
	public Carte fournirCarte ( ) {
		if ( this.indexCarteDessus > 0 ) {
			this.indexCarteDessus -- ;
			//carte = new Carte ( cartesPaquet[this.indexCarteDessus].getId ( ) ) ; // On ne peut pas faire "carte = cartesPaquet[this.indexCarteDessus]" car elles sont liées : détruire l'ancienne carte détruit la copie
			return cartesPaquet[this.indexCarteDessus] ;
		}
		else
			return null ;
	}
}