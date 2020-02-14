package mainPackage;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * @author ThePelican18
 */
public class TurfApp {

	public static void main(String[] args) {
		
		new Frame();
		
	}
}
//MARCO PRINCIPAL
	class Frame extends JFrame{

		private static final long serialVersionUID = 1L;
		
		private static Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
		
		public Frame() {
		    setIconImage(new ImageIcon("src/IMG/chessIcon.png").getImage());
			setVisible(true);
			setResizable(false);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setBounds(resWidth() * 400 /1920,resHeight() * 300 / 1080,resWidth() * 1100 /1920, resHeight() * 500/1080);
			Hippodrome hippo = Hippodrome.getInstance();
			add(hippo);//Añade el JPanel
			   
		}
		
		//METODO QUE DEVUELVE EL ANCHO DE LA PANTALLA
		public static int resWidth() {
			
			return (int)resolution.getWidth();
			
		}
		
		//METODO QUE DEVUELVE EL ALTO DE LA PANTALLA
		public static int resHeight() {
			
			return (int)resolution.getHeight();
		}
		public static Image getScaledImage(Image image,int width,int height) {
			
			return image.getScaledInstance(width, height, 0);
			
		}
	}
