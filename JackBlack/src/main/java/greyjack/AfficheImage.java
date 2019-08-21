package greyjack;

import java.awt.Graphics; 
import java.awt.Image; 
import javax.swing.JPanel; 

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