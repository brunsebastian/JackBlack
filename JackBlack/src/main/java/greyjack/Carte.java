package greyjack;

public class Carte {
	private int id = 0 ;
	private int rang = 0 ;
	private int enseigne = 0 ;
	private String nomRang = "" ;
	private String nomEnseigne = "" ;
	

	
	private String[] nomRangDico = { "As" , "2" , "3" , "4" , "5" , "6", "7" , "8" , "9" , "10" , "Valet" , "Dame" , "Roi" } ;
	private String[] nomEnseigneDico = { "Pique" , "Coeur" , "Carreau" , "Trefle" } ;

	private String[][] dessinCarteRang =
		{ {"   ##   "," ###### ","########","    ####","########"," ###### ","########"," ###### "," ###### ","##  #### ","##    ##","####### ","####### "}
		, {"  ####  ","#     ##","#    ## ","   #### ","##      ","##     #","#     ##","##    ##","##    ##","## ##  ##","##    ##"," ##   ##","##    ##"}
		, {" ##  ## ","      ##","    ##  ","  ## ## ","##      ","##      ","     ## ","##    ##","##    ##","## ##  ##","##    ##"," ##   ##","##    ##"}
		, {"##    ##","   #### ","   #### "," ##  ## ","####### ","####### ","    ##  "," ###### "," #######","## ##  ##"," ##  ## "," ##   ##","####### "}
		, {"########"," ###    ","      ##","########","      ##","##    ##","   ##   ","##    ##","      ##","## ##  ##"," ##  ## "," ##   ##","##  ##  "}
		, {"##    ##","##     #","##    ##","     ## ","#     ##","##    ##","  ##    ","##    ##","#     ##","## ##  ##","  ####  "," ##   ##","##   ## "}
		, {"##    ##","########"," ###### ","    ####"," ###### "," ###### "," ##     "," ###### "," ###### ","##  #### ","   ##   ","####### ","##    ##"} } ;
	private String[][] dessinCarteEnseigne =
		{ { "   #   " , " ## ## " , "   #   " , "  ###  " }
		, { "  ###  " , "#######" , "  ###  " , "  ###  " }
		, { " ##### " , "#######" , " ##### " , "## # ##" }
		, { "#######" , "#######" , "#######" , "#######" }
		, { "## # ##" , " ##### " , " ##### " , "## # ##" }
		, { "   #   " , "  ###  " , "  ###  " , "   #   " }
		, { "  ###  " , "   #   " , "   #   " , "  ###  " } } ;
	
	
	public Carte ( String rangInput , String enseigneInput ) {
		for ( int i = 0 ; i < 13 ; i ++ )
			if ( nomRangDico[i].equalsIgnoreCase ( rangInput ) )
				this.rang = 1 + i ;
		for ( int i = 0 ; i < 4 ; i ++ )
			if ( nomEnseigneDico[i].equalsIgnoreCase ( enseigneInput ) )
				this.enseigne = 1 + i ;
		if ( this.rang > 0 && this.enseigne > 0 )
			this.id = this.rang + 13 * ( this.enseigne - 1 ) ;
		else {
			System.out.println ( "Carte invalide : la carte \"" + rangInput + " de " + enseigneInput + "\" n'existe pas." ) ;
			this.id = 0 ;
		}
	}
	
	public Carte ( int idInput ) { // l'ID est compris entre 1 et 52 pour le 1er jeu de cartes, 53-104 pour le 22nd jeu, 105-156 pour le 3e, ...
		if ( idInput <= 0 ) {
			if ( idInput < 0 )
				System.out.println ( "Carte invalide : ID = " + idInput ) ;
		}
		else {
			this.id = idInput ;
			this.rang = 1 + ( idInput - 1 ) % 13 ;
			this.enseigne = 1 + ( idInput - 1 ) / 13 % 4 ;
			this.nomRang = nomRangDico[this.rang-1] ;
			this.nomEnseigne = nomEnseigneDico[this.enseigne-1] ;
		}
	}
	
	
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
			return ( (String) this.dessinCarteRang[ligne][this.rang-1] + " " + this.dessinCarteEnseigne[ligne][this.enseigne-1] ) ;
		else
			return "" ;
	}
}