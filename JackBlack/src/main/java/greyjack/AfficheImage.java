package greyjack;

import java.awt.Graphics; 
import java.awt.Image; 
import javax.swing.JPanel; 

/*
 * Inutilis�e pour l'instant : pour version affichage graphique fen�tr�
 */

@SuppressWarnings("serial")
public class AfficheImage extends JPanel{
	Image img;
	public AfficheImage(String s){ 
		img = getToolkit().getImage(s); 
	}
	public void paintComponent(Graphics g) 
	{ 
		super.paintComponent(g); 
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this); 
	} 
}