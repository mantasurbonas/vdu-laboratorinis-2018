package pacman;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class WindowsGame extends JFrame{

	private static final long serialVersionUID = 1L;
	private GameMap gameMap;
	private Pacman pacman;
	private Ghost ghost;
	
	private GameRules rules;
	private InputProcessor inputProcessor;
	private BufferedImage pacmanImg;
	private BufferedImage wallImg;
	private BufferedImage ghostImg;

	public WindowsGame() throws IOException{
		super.setPreferredSize(new Dimension(800,800));
		super.pack();
		super.setVisible(true);

		gameMap = new GameMap();
		pacman = new Pacman(10, 10);
		ghost = new Ghost(10, 7);
		
		rules = new GameRules(gameMap, pacman, ghost);
		inputProcessor = new InputProcessor(pacman);
		
		pacmanImg = ImageIO.read(new File("E:/prj/vdu/pacman/pacman-open.png"));
		wallImg = ImageIO.read(new File("E:/prj/vdu/pacman/wall.png"));
		ghostImg = ImageIO.read(new File("E:/prj/vdu/pacman/ghost.png"));
		
		super.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		super.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e){
				onUserInput(KeyEvent.getKeyText(e.getKeyCode()));
			}
		});
		
		Timer timer = new Timer(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onTimer();
			}
		});
		timer.setRepeats(true);
		timer.start();
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		
		for (int y=0; y< gameMap.getHeight(); y++){
			for(int x = 0; x<gameMap.getWidth(); x++){
				if (gameMap.isWall(y, x))
					g.drawImage(wallImg, x*30, 30+y*30, null);
				else
				if (pacman.isAt(y, x))
					g.drawImage(pacmanImg, x*30, 30+y*30, null);
				else
				if (ghost.isAt(y, x))
					g.drawImage(ghostImg, x*30, 30+y*30, null);
			}
		}
	}
	
	public void onUserInput(String keyText) {
		inputProcessor.processUserInput(keyText);
	}
	
	public void onTimer(){
		repaint();
		
		if (rules.isPacmanEaten())
			rules.gameOver();
		
		rules.movePacman();
		rules.moveGhost();
	}
	
	public static void main(String[] args) throws Exception {
		SwingUtilities.invokeAndWait(new Runnable(){
			public void run(){
				try {
					new WindowsGame();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

}
