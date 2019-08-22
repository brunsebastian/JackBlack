package greyjack;

public class Main {
	protected Carte[] cartesEnMain = null ;
	protected int nombreMaxCartes = 0 ;
	
	public Main ( int nombreMaxCartesInput )
	{
		cartesEnMain = new Carte[nombreMaxCartesInput] ;
		this.nombreMaxCartes = nombreMaxCartesInput ;
		for ( int i = 0 ; i < nombreMaxCartesInput ; i ++ )
			this.cartesEnMain[i] = new Carte ( 0 ) ;
	}
	
	public void afficherCartes ( ) {
		for ( int i = 0 ; i < 7 ; i ++ )
		{
			for ( Carte carte : this.cartesEnMain )
				if ( carte.getId ( ) > 0 )
					System.out.print ( carte.getLigneASCII ( i ) + "   " ) ;
			System.out.println ( ) ;
		}
	}
	
	public void jeterMain ( ) {
		for ( int i = 0 ; i < this.nombreMaxCartes ; i ++ )
			this.cartesEnMain[i] = new Carte ( 0 ) ;
	}
	
	public int getTotalFinal ( ) {
		int total = 0 ;
		total = getTotalHard ( ) ;
		if ( total <= 11 && getSoft ( ) )
			total += 10 ;
		return total ;
	}
	public int getTotalHard ( ) { // l'As est force a 1
		int total = 0 ;
		for ( Carte carte : this.cartesEnMain )
			total += carte.getValeur ( ) ;
		return total ;
	}
	public boolean getSoft ( ) { // Si un As est present, le total peut être augmente de 10
		boolean soft = false ;
		for ( Carte carte : this.cartesEnMain )
			if ( carte.getRang ( ) == 1 )
				soft = true ;
		return soft ;
	}
	
	public void afficherTotal ( ) {
		int totalHard = this.getTotalHard ( ) ;
		int total = this.getTotalFinal ( ) ;
		if ( total == 21 && ( this.cartesEnMain[2].getId() == 0 ) )
			System.out.println ( "Total : BLACKJACK !" ) ;
		else if ( total > 21 )
			System.out.println ( "Total : " + total + " - SAUTE" ) ;
		else if ( total != totalHard )
			System.out.println ( "Total : " + totalHard + " ou " + total ) ;
		else
			System.out.println ( "Total : " + total ) ;
		
	}
	
	public void ajouter ( Carte nouvelleCarte ) // Uniquement pour tests
	{
		for ( int i = 0 ; i < this.nombreMaxCartes ; i ++ )
			if ( this.cartesEnMain[i].getId ( ) == 0 ) {
				this.cartesEnMain[i] = nouvelleCarte ;
				i = this.nombreMaxCartes ; // Rompt le "for"
			}
	}
	
	public void tirerCarte ( Sabot sabot ) {
		for ( int i = 0 ; i < this.nombreMaxCartes ; i ++ )
			if ( this.cartesEnMain[i].getId ( ) == 0 ) {

				this.cartesEnMain[i] = sabot.fournirCarte ( ) ;
				i = this.nombreMaxCartes ; // Rompt le "for"
			}
	}
}