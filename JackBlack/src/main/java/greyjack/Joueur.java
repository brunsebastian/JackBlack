package greyjack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Joueur extends Main {
	int cave = 0 ;
	boolean servi = false ;

	public Joueur ( int caveinitiale ) {
		super ( 10 ) ; // Le joueur n'a jamais besoin de plus de 15 cartes
		this.cave = caveinitiale ;
	}
	
	public boolean peutTirer ( ) {
		return this.getTotalFinal ( ) < 21 && this.servi == false ;
	}
	
	public boolean decider ( Sabot sabot ) {
		boolean veutContinuer = true ;
		String decision="" ;
		if ( this.servi )
			return false ;
		do {
			System.out.print ( "Taper 'r' pour rester, 't' pour tirer : " ) ;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				decision = br.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if (decision.equalsIgnoreCase("t"))
				this.tirerCarte(sabot);
			else if (decision.equalsIgnoreCase("r")) {
				veutContinuer = false ;
				this.servi = true ;
			}
			else
				decision = "" ;
		} while ( decision == "" ) ;
		return veutContinuer ;
	}
	
}
