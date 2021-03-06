package greyjack;

/*
 * Classe Sabot : repr�sente le sabot dont les cartes de chaque manche vont �tre tir�es.
 */

public class Sabot {
	//private String Nationalite = "FR" ou "US" ou "GB"
	private int nombrePaquets = 0 ; //nombre de paquets dans le sabot
	private int nombreCartes = 0 ; //nombre de cartes restant dans le sabot
	private int indexCarteDessus = 0 ; //avanc�e du tirage dans le sabot
	private Carte[] cartesPaquet = null ; // 0 pour une carte inexistante
	
	/*
	 * Constructeur
	 * @param nombrePaquetsInput : nombre de paquets de cartes � inclure dans le sabot
	 * Le sabot est initialement cr�� tri�, sera m�lang� en d�but de partie
	 */
	public Sabot (int nombrePaquetsInput) { // Le jeu de cartes est cree trie
		this.nombrePaquets = nombrePaquetsInput ;
		this.nombreCartes = 52 * nombrePaquetsInput ;
		this.indexCarteDessus = this.nombreCartes - 1 ;
		this.cartesPaquet = new Carte[this.nombreCartes] ;
		for (int i = 0 ; i < 52 * nombrePaquetsInput ; i ++) {
			cartesPaquet[i] = new Carte (1 + i) ;
		}
	}
	
	public int getNombreCartes ( ) {
		return this.nombreCartes ;
	}
	
	public int getNombreCartesRestantes ( ) {
		return this.indexCarteDessus + 1 ;
	}
	
	/*
	 * r�cup�ration de l'id d'une carte dans le sabot
	 * @param numero : place de la carte dans le sabot
	 * @return : id de la carte r�cup�r�e
	 */
	public int getIdCarte (int numero) {
		return this.cartesPaquet[numero].getId () ;
	}

	/*
	 * Affichage vertical de chaque carte d'un paquet
	 * fonction de test unitaire
	 */
	public void afficherToutesLesCartesVerticalement () {
		for (Carte carte : this.cartesPaquet) {
			//this.cartePaquet[i].afficherNomComplet () ;
			carte.afficher () ;
			System.out.println () ;
		}
	}
	
	/*
	 * Affichage du nom de chaque carte d'un paquet
	 * fonction de test unitaire
	 */
	public void afficherToutesLesCartesNoms () {
		int i = 0 ;
		System.out.println ("Nombre de cartes : " + nombreCartes) ;
		for (Carte carte : this.cartesPaquet) {
			//this.cartesPaquet[i].afficherNomComplet () ;
			i ++ ;
			System.out.print ("Carte " + i + " : ");
			carte.afficherNomComplet () ;
		}
	}
	
	/*
	 * Fonction utilis�e uniquement dans les tests unitaires : affiche toutes les cartes comprises entre 2 rangs
	 * @param rangDebut 
	 * @param rangFin
	 */
	public void afficherCartesEntre (int rangDebut , int rangFin) {
		for (int i = 0 ; i < 7 ; i ++) {
			for (int j = rangDebut ; j <= rangFin ; j ++)
				if ( j < nombreCartes )
					if (cartesPaquet[j].getId () > 0)
						System.out.print (cartesPaquet[j].getLigneASCII (i) + "   ") ;
			System.out.println () ;
		}
	}
	
	/*
	 * fonction de m�lange d'un sabot
	 * appel�e en d�but de partie sur un sabot plein tri�
	 */
	public void melanger () {
		int[] nouvelID = new int[nombreCartes] ;
		int idTest = 0 ;
		int i = 0 ;
		while (i < nombreCartes)
		{
			idTest = 1 + (int) (Math.random () * nombreCartes) ;
			for (int j = 0 ; j < i ; j ++)
				if (idTest == nouvelID[j])
					idTest = 0 ;
			if (idTest != 0) {
				nouvelID[i] = idTest ;
				cartesPaquet[i] = new Carte (idTest) ;
				i ++ ;
			}
		}
		this.indexCarteDessus = this.nombreCartes - 1 ;
	}
	
	public void finDeManche () {
		if ( this.indexCarteDessus <= 52 )
			melanger () ;
	}
	
	/*
	 * Appel�e par Manche pour distribuer une carte � une Main (Croupier ou Joueur)
	 * Modifie l'index dans le sabot symbolisant la prochaine carte � tirer (indexCarteDessus).
	 * @return Carte : la Carte � distribuer 
	 */
	public Carte fournirCarte () {
		if (this.indexCarteDessus > 0) {
			this.indexCarteDessus -- ;
			//carte = new Carte (cartesPaquet[this.indexCarteDessus].getId ()) ; // On ne peut pas faire "carte = cartesPaquet[this.indexCarteDessus]" car elles sont li�es : d�truire l'ancienne carte d�truit la copie
			return cartesPaquet[this.indexCarteDessus] ;
		}
		else
			return null ;
	}
}