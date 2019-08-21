package greyjack;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

/*
 * Classe de fenêtre principale
 * JFrame avec menuBar + zone de tapis
 */

@SuppressWarnings("serial")
public class TapisFrame extends JFrame{
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem jeuMenuItem;
	private JRadioButtonMenuItem rbMenuItem;
	
	public TapisFrame() {
		setSize(1280, 1024); 
		setTitle("BlackJack Power"); 
		menuBar = new JMenuBar();
		menu = new JMenu();
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
		menuBar.add(menu);
		jeuMenuItem = new JMenuItem("Jeu", KeyEvent.VK_T);
		jeuMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		jeuMenuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		rbMenuItem = new JRadioButtonMenuItem();
		menu.add(jeuMenuItem);
		menu.add(rbMenuItem);
		this.setJMenuBar(menuBar);
		//setContentPane(new AfficheImage("C:\\maven\\ressources\\carte.png")); 
		getContentPane().setLayout(new BorderLayout()); 
		this.setVisible(true);}
}
