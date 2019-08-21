package greyjack;

public class Croupier extends Main {
	private int Cave = 0 ; // Argent dont la table dispose
	
	public Croupier ( int encaisseInput ) {
		super ( 10 ) ; // Le croupier n'a jamais besoin de plus de 10 cartes
		this.Cave = encaisseInput ;
	}
	
	public void executerTour ( Sabot sabot ) {
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
	}
}