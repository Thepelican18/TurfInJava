package mainPackage;

import java.awt.Dimension;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

// HORSE CLASS
public class Horse extends Thread {

	private String HName, team;// horse name and team
	private static Hippodrome hippo = Hippodrome.getInstance();
	private int x = hippo.getInsets().left;// Horizontal movement
	private int y = yCol; // Vertical movement
	private static int yCol = hippo.getInsets().top;// Horse start position
	private Image HImage;// horse image
	private JLabel HLabel;// horse label
	private Dimension HDimension;// horse dimension
	private ArrayList<Image> movHorse = new ArrayList<Image>();// Horse animation
	private static ArrayList<String> ocupatedNames = new ArrayList<String>();// to not repeat names from the list
	private Thread[] threads = new Thread[4];
	private int count = 0;
	private static int totalHorses = 0;

	// CONSTRUCTOR
	public Horse() {

		chooseTeam();// Choose a team for the horse
		buildImages();// Save all images in a list
		HLabel = new JLabel();

		try {

			setName();// Assign a random name

		} catch (IOException e) {

			System.out.println("names.txt not found");

		}

		threads[totalHorses] = new Thread(this);
		HDimension = new Dimension(x, y);
		totalHorses++;
		yCol += 100;

	}

	@Override
	public void run() {

		try {

			while (x < 1000) {

				Thread.sleep(50);
				x += new Random().nextInt(9) + 1;
				Hmovement();// Update horse position
				setImage();// Change the image of horse
				hippo.repaint();// Repaint the new position

			}
			hippo.rating(HName, team);

		} catch (InterruptedException e) {

			System.out.println("not work");
			
		}
	}
	// ADD ALL IMAGES IN A LIST
	public void buildImages() {

		movHorse.add(Frame.getScaledImage(new ImageIcon("src/IMG/" + team + "/" + "idleHorse.png").getImage(), 120, 100));
		movHorse.add(Frame.getScaledImage(new ImageIcon("src/IMG/" + team + "/" + "firstMovHorse.png").getImage(), 120,	100));
		movHorse.add(Frame.getScaledImage(new ImageIcon("src/IMG/" + team + "/" + "secondMovHorse.png").getImage(), 120, 100));
		movHorse.add(Frame.getScaledImage(new ImageIcon("src/IMG/" + team + "/" + "thirdMovHorse.png").getImage(), 120,	100));
		movHorse.add(Frame.getScaledImage(new ImageIcon("src/IMG/" + team + "/" + "fourthMovHorse.png").getImage(), 120, 100));
		movHorse.add(Frame.getScaledImage(new ImageIcon("src/IMG/" + team + "/" + "fifthMovHorse.png").getImage(), 120,	100));
		movHorse.add(Frame.getScaledImage(new ImageIcon("src/IMG/" + team + "/" + "sixthMovHorse.png").getImage(), 120,	100));
		movHorse.add(Frame.getScaledImage(new ImageIcon("src/IMG/" + team + "/" + "seventhMovHorse.png").getImage(), 120, 100));
		movHorse.add(Frame.getScaledImage(new ImageIcon("src/IMG/" + team + "/" + "eighthMovHorse.png").getImage(), 120, 100));
		movHorse.add(Frame.getScaledImage(new ImageIcon("src/IMG/" + team + "/" + "ninthMovHorse.png").getImage(), 120,	100));
		movHorse.add(Frame.getScaledImage(new ImageIcon("src/IMG/" + team + "/" + "tenthMovHorse.png").getImage(), 120,	100));
		movHorse.add(Frame.getScaledImage(new ImageIcon("src/IMG/" + team + "/" + "eleventhMovHorse.png").getImage(), 120, 100));
		movHorse.add(Frame.getScaledImage(new ImageIcon("src/IMG/" + team + "/" + "twelfthMovHorse.png").getImage(), 120, 100));

		setImage(); //To set the first idle image

	}

	public void setImage() {

		if (count >= 12) {

			count = 1;
		}
		
		HImage = movHorse.get(count);
		count++;
		
	}

	public void Hmovement() {

		HDimension = new Dimension(x, y);

	}

	public void setName() throws IOException {

		ArrayList<String> nameList = new ArrayList<String>();

		BufferedReader bufferName = new BufferedReader(new FileReader("src/names/names.txt"));

		while (bufferName.readLine() != null) {

			nameList.add(bufferName.readLine());

		}
		bufferName.close();
		HName = nameList.get(new Random().nextInt(10));
		while (ocupatedNames.indexOf(HName) != -1) {
			System.out.println("nombre encontrado");
			HName = nameList.get(new Random().nextInt(10));

		}
		ocupatedNames.add(HName);

	}

	public void chooseTeam() {

		if (totalHorses == 0) {
			team = "blueTeam";
		}
		if (totalHorses == 1) {
			team = "redTeam";
		}
		if (totalHorses == 2) {
			team = "yellowTeam";
		}
		if (totalHorses == 3) {
			team = "purpleTeam";
		}
	}
	
	//-----------GETTERS--------------//

	public Thread getThread(int index) {

		return threads[index];
	}

	public JLabel getLabel() {
		return HLabel;
	}

	public String getNameHorse() {

		return HName;
	}

	public Image getImage() {

		return HImage;
	}

	public int getDimensionX() {

		return HDimension.width;
	}

	public int getDimensionY() {

		return HDimension.height;
	}

}
