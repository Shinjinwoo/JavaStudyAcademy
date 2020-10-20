package October20;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GalagaGame extends JPanel implements KeyListener {

	private boolean running = true;

	private ArrayList sprites = new ArrayList();
	private Sprite starship;
	private BufferedImage bgImage;
	private BufferedImage alienImage;
	private BufferedImage shotImage;
	private BufferedImage shipImage;
	private BufferedImage boomImage;

	public GalagaGame() {
		JFrame frame = new JFrame("Galaga Game");
		frame.setSize(800, 600);
		frame.add(this);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			bgImage = ImageIO.read(new File("bgImage.png"));
			shotImage = ImageIO.read(new File("shotImage.png"));
			shipImage = ImageIO.read(new File("shipImage.png"));
			alienImage = ImageIO.read(new File("alienImage.png"));
			boomImage = ImageIO.read(new File("boomImage.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.requestFocus();
		this.initSprites();
		addKeyListener(this);
	}

	private void initSprites() {
		starship = new StarShipSprite(this, shipImage, 382, 460);
		sprites.add(starship);
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 12; x++) {
				Sprite alien = new AlienSprite(this, alienImage, 100 + (x * 50), (50) + y * 30);
				sprites.add(alien);
			}
		}
	}

	private void startGame() {
		sprites.clear();
		initSprites();
	}

	public void endGame() {
		System.exit(0);
	}

	public void removeSprite(Sprite sprite) {
		sprites.remove(sprite);
	}
	public void fire() {
		ShotSprite shot = new ShotSprite(this,shotImage, starship.getX()+10,starship.getY()-30);
		ShotSprite shot2 = new ShotSprite(this,shotImage, starship.getX()+50,starship.getY()-30);
		sprites.add(shot);
		sprites.add(shot2);
	}
	public void boom() {
		Boom boom = new Boom(this, boomImage, starship.getX()+10,starship.getY()-30);
		sprites.add(boom);
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, 800, 600);
		g.drawImage(bgImage, 0,0,null);
		for(int i=0;i<sprites.size();i++) {
			Sprite sprite = (Sprite) sprites.get(i);
			sprite.draw(g);
		}
	}
	public void gameLoop() {
		while(running) {
			for(int i=0;i<sprites.size();i++) {
				Sprite sprite = (Sprite)sprites.get(i);
				sprite.move();
			}
			for(int p=0;p<sprites.size();p++) {
				for(int s=p+1;s<sprites.size();s++) {
					Sprite me = (Sprite)sprites.get(p);
					Sprite other = (Sprite) sprites.get(s);
					
					if(me.checkCollision(other)) {
						me.handleCollision(other);
						other.handleCollision(me);
					}
				}
			}
			repaint();
			try {
				Thread.sleep(10);
			}catch(Exception e) {
		}
	}
}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
			starship.setDx(-3);
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
			starship.setDx(+3);
		if(e.getKeyCode()==KeyEvent.VK_UP)
			starship.setDy(-3);
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
			starship.setDy(+3);
		if(e.getKeyCode()==KeyEvent.VK_SPACE)
			fire();
		if(e.getKeyCode()==KeyEvent.VK_B)
			boom();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
			starship.setDx(0);
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
			starship.setDx(0);
		if(e.getKeyCode()==KeyEvent.VK_UP)
			starship.setDy(0);
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
			starship.setDy(0);
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
	}
	public static void main(String[] args) {
		GalagaGame g = new GalagaGame();
		g.gameLoop();
	}
}