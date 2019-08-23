package greyjack;

public class Main {
	protected Carte[] cartesEnMain = null ;
	protected int nombreMaxCartes = 0 ;
	protected boolean servi = false ;

	public Main ( int nombreMaxCartesInput ) // "nombreMaxCartes" est utilisé en guise de garde-fou
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

	public void afficherTotal ( ) {
		int totalHard = this.getTotalHard ( ) ;
		int total = this.getTotalFinal ( ) ;
		if ( this.estBlackjack() )
			System.out.println ( "Total : 21 - BLACKJACK !" ) ;
		else if ( total > 21 )
			System.out.println ( "Total : " + total + " - SAUTE" ) ;
		else if ( total != totalHard )
			System.out.println ( "Total : " + totalHard + " ou " + total ) ;
		else
			System.out.println ( "Total : " + total ) ;
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

	/*
	 * Fonctions de vérification conditions de victoire défaite
	 */
	public boolean estBlackjack (  ) {
		return this.getTotalFinal() == 21 && this.cartesEnMain[2].getId() == 0 ;
	}
	public boolean estSaute (  ) {
		return this.getTotalFinal() > 21 ;
	}

	/*
	 * Fonction ajouter(Carte carte) : fonction de test pour ajouter à une Main une Carte prédéfinie
	 */
	public void ajouter ( Carte nouvelleCarte )
	{
		for ( int i = 0 ; i < this.nombreMaxCartes ; i ++ )
			if ( this.cartesEnMain[i].getId ( ) == 0 ) {
				this.cartesEnMain[i] = nouvelleCarte ;
				break;
			}
	}

	/*
	 * Fonction de tirage utilisée en jeu, pioche la Carte du dessus dans le Sabot fourni par la Manche
	 */
	public void tirerCarte ( Sabot sabot ) {
		for ( int i = 0 ; i < this.nombreMaxCartes ; i ++ )
			if ( this.cartesEnMain[i].getId ( ) == 0 ) {

				this.cartesEnMain[i] = sabot.fournirCarte ( ) ;
				break;
			}
	}

	/*
	 * Appelée en fin de Manche, vide la Main de la Manche courante avant Manche suivante
	 * reset du tableau cartesEnMain[]
	 */
	public void jeterMain ( ) {
		for ( int i = 0 ; i < this.nombreMaxCartes ; i ++ )
			this.cartesEnMain[i] = new Carte ( 0 ) ;
	}
}