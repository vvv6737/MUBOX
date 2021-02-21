package Mubox;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.PaintContext;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Mubox extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic;
	
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../Images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../Images/exitButtonBasic.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../Images/startButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../Images/startButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../Images/quitButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../Images/quitButtonBasic.png"));
	
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../Images/leftButtonEntered.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../Images/leftButtonBasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../Images/rightButtonEntered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../Images/rightButtonBasic.png"));
	
	private Image titleImage = new ImageIcon(Main.class.getResource("../Images/Erase You title image.png")).getImage();
	private Image selectedImage = new ImageIcon(Main.class.getResource("../Images/CHANGMO - Erase You.png")).getImage();
	private Image background = new ImageIcon(Main.class.getResource("../Images/background.jpg")).getImage();
	private JLabel menubar = new JLabel(new ImageIcon(Main.class.getResource("../Images/menuBar.png")));
	
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	
	private int mouseX, mouseY; //메뉴바를 잡고 흔들수있다.
	
	private boolean isMainScreen = false;
	
	public Mubox() {
		setUndecorated(true);
		setTitle("MUBOX");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0)); //paintComponents을 했을때 배경이 하얀색으로 바뀜
		setLayout(null); //버튼이나 JLabel을 넣었을 때 그 위치 그대로 
		
		menubar.setBounds(0, 0, 1240, 30); //메뉴바 위치와 크기을 정해주는것
		menubar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menubar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menubar);
		
		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage); //마우스가 올라갈때 이미지가 entered로 바뀐다
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스를 올리면 커서가 손가락모양이 된다
				Music buttonEnterdMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnterdMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage); //마우스에서 나올때 원래 색으로 돌아간다
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //손가락 모양의 커서를 되돌린다.
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnterdMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnterdMusic.start();
				try {
					Thread.sleep(1000); //소리가 나온다음 정상적으로 
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0); //종료
			}
		});
		add(exitButton);
		
		startButton.setBounds(600, 520, 270, 100); //x축, y축, 가로크기, 세로크기
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage); //마우스가 올라갈때 이미지가 entered로 바뀐다
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스를 올리면 커서가 손가락모양이 된다
				Music buttonEnterdMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnterdMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage); //마우스에서 나올때 원래 색으로 돌아간다
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //손가락 모양의 커서를 되돌린다.
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnterdMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnterdMusic.start();
				// 게임 시작 이벤트
				startButton.setVisible(false);
				quitButton.setVisible(false);
				leftButton.setVisible(true);
				rightButton.setVisible(true);
				background = new ImageIcon(Main.class.getResource("../Images/mainBackground.jpg")).getImage();
				isMainScreen = true;
			}
		});
		add(startButton);
		
		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 64, 64);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnteredImage); //마우스가 올라갈때 이미지가 entered로 바뀐다
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스를 올리면 커서가 손가락모양이 된다
				Music buttonEnterdMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnterdMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage); //마우스에서 나올때 원래 색으로 돌아간다
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //손가락 모양의 커서를 되돌린다.
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnterdMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnterdMusic.start();
				// 왼쪽 버튼 이벤트
			}
		});
		add(leftButton);
		
		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310, 64, 64);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnteredImage); //마우스가 올라갈때 이미지가 entered로 바뀐다
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스를 올리면 커서가 손가락모양이 된다
				Music buttonEnterdMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnterdMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage); //마우스에서 나올때 원래 색으로 돌아간다
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //손가락 모양의 커서를 되돌린다.
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnterdMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnterdMusic.start();
				// 오른쪽 버튼 이벤트
			}
		});
		add(rightButton);
		
		quitButton.setBounds(900, 520, 270, 100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage); //마우스가 올라갈때 이미지가 entered로 바뀐다
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스를 올리면 커서가 손가락모양이 된다
				Music buttonEnterdMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnterdMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage); //마우스에서 나올때 원래 색으로 돌아간다
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //손가락 모양의 커서를 되돌린다.
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnterdMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnterdMusic.start();
				try {
					Thread.sleep(1000); //소리가 나온다음 정상적으로 
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0); //종료
			}
		});
		add(quitButton);
		
		
		Music intromusic = new Music("intromusic.mp3", true);
		intromusic.start(); //인트로 뮤직 스타트
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	
	private void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		if(isMainScreen) {
			g.drawImage(selectedImage, 400, 100, null);
			g.drawImage(titleImage, 340, 70, null);
		}
			
		paintComponents(g);
		this.repaint();
	}
}