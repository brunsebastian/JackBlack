package greyjack;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestMoteur {

	@Test
	public void test () {
		Carte quatreDePique = new Carte(4);
		quatreDePique.afficherNomComplet();
		quatreDePique.afficher();
		assertEquals(quatreDePique.getNomComplet(), "4 de Pique");
		assertEquals(quatreDePique.getId(), 4);
		
		Carte dameDeCarreau = new Carte(12 + 26); // ID = 12 pour la dame + 26 pour le carreau
		dameDeCarreau.afficherNomComplet();
		dameDeCarreau.afficher();
		assertEquals(dameDeCarreau.getNomComplet(), "Dame de Carreau");
		assertEquals(dameDeCarreau.getId(), 38);
		
		Carte carteNulle = new Carte(0);
		carteNulle.afficherNomComplet();
		carteNulle.afficher();
		assertEquals(carteNulle.getNomComplet(), "");
		assertEquals(carteNulle.getId(), 0);
		
		Carte dixDeTrefle = new Carte ( "10" , "trefle" ) ;
		dixDeTrefle.afficherNomComplet();
		dixDeTrefle.afficher();
		assertEquals(dixDeTrefle.getNomComplet(), "10 de Trefle");
		
		int[] idTests = { 1 , 13 , 14 , 26 , 27 , 39 , 40 , 52 , 53 }; // Affiche As-Roi-As-Roi-... à pique, coeur, carreau et trèfle
		Carte carte = null;
		for(int i : idTests){
			carte = new Carte(i);
			carte.afficherNomComplet();
			carte.afficher();
			assertEquals(carte.getId(), i);
		}
		
		Main mainTest = new Main(8);
		mainTest.ajouter(quatreDePique);
		mainTest.ajouter(dameDeCarreau);
		System.out.println("Main test : " + quatreDePique.getNomComplet()+ " et " + dameDeCarreau.getNomComplet());
		mainTest.afficherCartes();
		assertEquals(mainTest.getTotalHard(), 14);
		
		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println();
		
		Main ligneCartes = new Main(13);
		
		// Purement pour afficher les ID
		for(int i = 1; i <= 52; i ++){  // Pour afficher les ID, graphisme à la bourrine
			ligneCartes.ajouter(new Carte(i));
			if(i % 13 == 0){
				ligneCartes.afficherCartes();
				ligneCartes.jeterMain();
				
				for(int j = 13; j > 0; j --){
					if(i - j + 1 >= 10)
						System.out.print("     ID=" +(i - j + 1) + "         ");
					else
						System.out.print("     ID=" +(i - j + 1)+ "          ");
					if(j == 5)
						System.out.print("  ");
				}
				System.out.println();
				System.out.println(); // */
			}	
		}
		
		Sabot sabot = new Sabot(1);
		sabot.afficherToutesLesCartesNoms();
		sabot.melanger();
		
		int cartesNombre[] = new int[53]; // On ajoute 1 case pour éviter de déborder, l'index représentant l'ID de la carte
		for(int i = 0; i < 52; i ++)
			cartesNombre[sabot.getIdCarte(i)] ++;
		assertTrue(cartesNombre[0] == 0);
		for(int i = 1; i <= 52; i ++)// On accède à la case 52 ici
			assertTrue(cartesNombre[i] == 1);
		System.out.println();
		sabot.afficherToutesLesCartesNoms();
		for(int i = 0; i < 52; i += 6)
		{
			sabot.afficherCartesEntre(i , Math.min(i + 5 , 51));
			System.out.println();
		}	
	}
}
