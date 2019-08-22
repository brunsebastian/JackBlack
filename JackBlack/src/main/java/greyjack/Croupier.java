package greyjack;

public class Croupier extends Main {
	private int cave = 0 ; // Argent dont la table dispose
	
	public Croupier ( int encaisseInput ) {
		super ( 10 ) ; // Le croupier n'a jamais besoin de plus de 10 cartes
		this.cave = encaisseInput ;
	}

	public boolean getServi ( ) {
		return this.getTotalFinal ( ) >= 17 || this.servi == true || this.cartesEnMain[nombreMaxCartes-1].getId() != 0 ;
	}
	public void setServi ( boolean inputServi ) {
		this.servi = inputServi ;
	}
	
	public boolean blackjackPossible ( ) {
		return this.cartesEnMain[1].getId() == 0 && ( this.cartesEnMain[0].getRang() == 1 || this.cartesEnMain[0].getRang() >= 10 ) ;
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