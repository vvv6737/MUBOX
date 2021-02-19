package Mubox;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Mubox extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image background;
	
	public Mubox() {
		setTitle("MUBOX");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		background = new ImageIcon(Main.class.getResource("../Images/background.jpg")).getImage();
		
		Music intromusic = new Music("intromusic.mp3", true);
		intromusic.start();
	}
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	private void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		this.repaint();
	}
}