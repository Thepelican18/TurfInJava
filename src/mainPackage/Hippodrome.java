package mainPackage;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Hippodrome extends JPanel implements Runnable {

	private static Hippodrome hippo = null;
	private Graphics2D g2D;
	private Image horse;
	private Insets defInsets= getInsets();
	private Horse horse1;
	private static int  x =50;
	Thread t1;
	
	private Hippodrome() {
		
		setLayout(null);
		JMenuBar menu = new JMenuBar();
		JMenu opciones = new JMenu("Opciones");
		menu.add(opciones);
		menu.setBounds(defInsets.left,defInsets.top,1300,20);
		add(menu);
		t1= new Thread(this);
		
		t1.start();
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);//Bugea el menu
		
		g2D = (Graphics2D) g;
		
		
	
		//horse = new ImageIcon("src/IMG/idleHorse.png").getImage();
		
		g2D.drawImage(new ImageIcon("src/IMG/grass.jpg").getImage(), defInsets.left, defInsets.top+20, null);
		
		if (horse1 == null){
		horse1 = new Horse();
		}
		horse1.getLabel().setIcon(new ImageIcon(horse1.getImage()));
		horse1.getLabel().setBounds(defInsets.left+x, defInsets.top+350,130,140);
		add(horse1.getLabel());
	
		
		//g2D.drawImage(new ImageIcon(horse1.getImage()).getImage(), defInsets.left+x, defInsets.top+350, null);
		//g2D.drawImage(new ImageIcon(horse).getImage(), defInsets.left+50, defInsets.top+250, null);
		//g2D.drawImage(new ImageIcon(horse).getImage(), defInsets.left+50, defInsets.top+150, null);
		//g2D.drawImage(new ImageIcon(horse).getImage(), defInsets.left+50, defInsets.top+50, null);
		

	}

	
	@Override
	public void run() {
		System.out.println(t1.currentThread());
		try {
			while(x < 500) {
			Thread.sleep(100);
			
			x+= new Random().nextInt(9)+1;
			horse1.setImage();
			repaint();
			
			}
			
		} catch (InterruptedException e) {
			
			System.out.println("not work");
		}
		
		
	}
	
	
	

	
	
	
	// METODO PARA ACCEDER A HIPPODROME SIN INSTANCIAR
	public static Hippodrome getInstance() {

		if (hippo == null) {
			
			hippo = new Hippodrome();
			
		}
		return hippo;
	}

	
}
