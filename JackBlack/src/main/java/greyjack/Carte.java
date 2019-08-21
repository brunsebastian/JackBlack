package greyjack;

public class Carte {
	private int id = 0 ;
	private int rang = 0 ;
	private int enseigne = 0 ;
	private String nomRang = "" ;
	private String nomEnseigne = "" ;
	

	
	private String[] nomRangDico = { "X" , "As" , "2" , "3" , "4" , "5" , "6", "7" , "8" , "9" , "10" , "Valet" , "Dame" , "Roi" } ;
	private String[] nomEnseigneDico = { "X" , "Pique" , "Coeur" , "Carreau" , "Trefle" } ;

	private String[][] dessinCarteRang =
		{ {"X","   ##   "," ###### ","########","    ####","########"," ###### ","########"," ###### "," ###### ","##  #### ","##    ##","####### ","####### "}
		, {"X","  ####  ","#     ##","#    ## ","   #### ","##      ","##     #","#     ##","##    ##","##    ##","## ##  ##","##    ##"," ##   ##","##    ##"}
		, {"X"," ##  ## ","      ##","    ##  ","  ## ## ","##      ","##      ","     ## ","##    ##","##    ##","## ##  ##","##    ##"," ##   ##","##    ##"}
		, {"X","##    ##","   #### ","   #### "," ##  ## ","####### ","####### ","    ##  "," ###### "," #######","## ##  ##"," ##  ## "," ##   ##","####### "}
		, {"X","########"," ###    ","      ##","########","      ##","##    ##","   ##   ","##    ##","      ##","## ##  ##"," ##  ## "," ##   ##","##  ##  "}
		, {"X","##    ##","##     #","##    ##","     ## ","#     ##","##    ##","  ##    ","##    ##","#     ##","## ##  ##","  ####  "," ##   ##","##   ## "}
		, {"X","##    ##","########"," ###### ","    ####"," ###### "," ###### "," ##     "," ###### "," ###### ","##  #### ","   ##   ","####### ","##    ##"} } ;
	private String[][] dessinCarteEnseigne =
		{ { "X" , "   #   " , " ## ## " , "   #   " , "  ###  " }
		, { "X" , "  ###  " , "#######" , "  ###  " , "  ###  " }
		, { "X" , " ##### " , "#######" , " ##### " , "## # ##" }
		, { "X" , "#######" , "#######" , "#######" , "#######" }
		, { "X" , "## # ##" , " ##### " , " ##### " , "## # ##" }
		, { "X" , "   #   " , "  ###  " , "  ###  " , "   #   " }
		, { "X" , "  ###  " , "   #   " , "   #   " , "  ###  " } } ;
	
	public int getId ( ) {
		return this.id ;
	}
	public int getRang ( ) {
		return this.rang ;
	}
	public int getEnseigne ( ) {
		return this.enseigne ;
	}
	public int getValeur ( ) {
		if ( this.id > 0 ) {
			if ( this.rang > 10 )
				return 10 ;
			else
				return this.rang ;
		}
		else
			return 0 ;
	}
	
	public Carte ( int idInput ) { // l'ID est compris entre 1 et 52 pour le 1er jeu de cartes
		if ( idInput <= 0 ) {
			if ( idInput < 0 )
				System.out.println ( "Carte invalide : ID = " + idInput ) ;
		}
		else {
			this.id = idInput ;
			this.rang = 1 + ( idInput - 1 ) % 13 ;
			this.enseigne = 1 + ( idInput - 1 ) / 13 % 4 ;
			this.nomRang = nomRangDico[this.rang] ;
			this.nomEnseigne = nomEnseigneDico[this.enseigne] ;
			/*if ( this.rang > 10 )
				this.valeur = 10 ;
			else if ( this.rang > 1 )
				this.valeur = this.rang ;
			else
				this.valeur = 1 ;*/
		}
	}
	
	public void detruire ( ) {
		this.id = 0 ;
		this.rang = 0 ;
		this.enseigne = 0 ;
		this.nomRang = "" ;
		this.nomEnseigne = "" ;
	}

	public void afficherNomComplet ( ) {
		System.out.println ( getNomComplet ( ) ) ;
	}
	public String getNomComplet ( ) {
		if ( this.id > 0 )
			return ( this.nomRang + " de " + this.nomEnseigne ) ;
		else
			return "" ;
	}
	public void afficher ( ) {
		if ( this.id > 0 ) {
			for ( int i = 0 ; i < 7 ; i ++ )
				System.out.println ( getLigneASCII ( i ) ) ;
			System.out.println ( ) ;
		}
	}
	public String getLigneASCII ( int ligne ) {
		if ( this.id > 0 )
			return ( (String) this.dessinCarteRang[ligne][this.rang] + " " + this.dessinCarteEnseigne[ligne][this.enseigne] ) ;
		else
			return "" ;
	}
}