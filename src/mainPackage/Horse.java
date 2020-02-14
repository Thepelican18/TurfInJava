package mainPackage;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Horse {

	
	private String nameHorse;
	private Image imageHorse;
	private JLabel labelHorse;
	private ArrayList <Image> movHorse = new ArrayList<Image>();
	private int count = 0;
	
	
	public Horse(){
		buildImages();
		labelHorse = new JLabel();
	}
	
	
	public void buildImages() {
		
		
		
		movHorse.add(Frame.getScaledImage(new ImageIcon("src/IMG/idleHorse.png").getImage(),120,100));
		movHorse.add(Frame.getScaledImage(new ImageIcon("src/IMG/firstMovHorse.png").getImage(),120,100));
		movHorse.add(Frame.getScaledImage(new ImageIcon("src/IMG/secondMovHorse.png").getImage(),120,100));
		movHorse.add(Frame.getScaledImage(new ImageIcon("src/IMG/thirdMovHorse.png").getImage(),120,100));
		movHorse.add(Frame.getScaledImage(new ImageIcon("src/IMG/fourthMovHorse.png").getImage(),120,100));
		movHorse.add(Frame.getScaledImage(new ImageIcon("src/IMG/fifthMovHorse.png").getImage(),120,100));
		movHorse.add(Frame.getScaledImage(new ImageIcon("src/IMG/sixthMovHorse.png").getImage(),120,100));
		
		setImage();
		
		
		
	}
	
	public void setImage() {
		
		if (count >= 6){
			
			count = 0;
		}
		imageHorse = movHorse.get(count);
		count++;
	}
		
	
	
	public JLabel getLabel() {
		return labelHorse;
	}
	
	public String getName() {
		
		return nameHorse;
	}
	public Image getImage() {
		
		return imageHorse;
	}
	
	
}
