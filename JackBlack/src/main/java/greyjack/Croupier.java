package greyjack;

public class Croupier extends Main {
	private int cave = 0 ; // Argent dont la table dispose
	
	public Croupier ( int encaisseInput ) {
		super ( 10 ) ; // Le croupier n'a jamais besoin de plus de 10 cartes
		this.cave = encaisseInput ;
	}
	
	public boolean getServi ( ) {
		return this.getTotalFinal ( ) >= 17 ;
	}
	public void setServi ( boolean input ) {
		this.servi = input ;
	}
	
	public void decider ( Sabot sabot ) {
		if ( ! this.getServi ( ) )
			this.tirerCarte ( sabot ) ;
	}
	
	/*public void executerTour ( Sabot sabot ) {
		this.tirerCarte ( sabot ) ;
		this.afficherCartes ( ) ;
		this.afficherTotal ( ) ;
		try {
			Thread.sleep ( 700 ) ;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if ( this.getTotalFinal ( ) < 17 ) {
			System.out.println ( ) ;
			this.executerTour ( sabot ) ;
		}
	}*/
}