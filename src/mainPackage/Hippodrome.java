package mainPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.xml.soap.Text;

public class Hippodrome extends JPanel {

	private static Hippodrome hippo = null;
	private Graphics2D g2D;
	private Insets defInsets= getInsets();
	private String[] rating = new String[4];
	private boolean drawRating = false;
	private int position=1;
	
	private Horse[] horses = new Horse[4];
	private static int  x =50;
	
	private Hippodrome() {
		
		setLayout(null);
		JMenuBar menu = new JMenuBar();
		JMenu opciones = new JMenu("Opciones");
		JMenuItem iniciar = new JMenuItem("Iniciar");
		menu.add(opciones);
		opciones.add(iniciar);
		
		iniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = 0;i<horses.length;i++) {
					System.out.println(i);
				horses[i].getThread(i).start();
				
				}
				
			}
		});
		
		
		
		
		menu.setBounds(defInsets.left,defInsets.top,1300,20);
		add(menu);
		
		
		
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);//Bugea el menu
		
		g2D = (Graphics2D) g;
		
		
	
	//horse = new ImageIcon("src/IMG/idleHorse.png").getImage();

		g2D.drawImage(new ImageIcon("src/IMG/grass.jpg").getImage(), defInsets.left, defInsets.top+20, null);
		if(drawRating) {
			
			g2D.drawImage(new ImageIcon("src/IMG/trophyBG.png").getImage(), defInsets.left, defInsets.top+20, null);
			g2D.setPaint(Color.WHITE);
			g2D.setFont(new Font("TimesRoman", Font.PLAIN, 30));
			for(int i = 0;i <rating.length;i++) {
				g2D.drawString(rating[i],  defInsets.left+220,horses[i].getDimensionY()+80);
			}
		}
		if (horses[0] == null){
		
			for(int i = 0;i <horses.length ;i++) {
				
				horses[i] = new Horse();
				
			}
		}
		for(int i = 0;i <horses.length ;i++) {
			
			horses[i].getLabel().setIcon(new ImageIcon(horses[i].getImage()));
			horses[i].getLabel().setBounds(horses[i].getDimensionX(), horses[i].getDimensionY(),130,140);
			add(horses[i].getLabel());
	
		}

	}
	
	public void rating(String name ,String team) {
		
		rating[position-1]= name + "  from " + team ;
		
		position++;
		if(position == 5){
			drawRating = true;
			position = 0;
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
