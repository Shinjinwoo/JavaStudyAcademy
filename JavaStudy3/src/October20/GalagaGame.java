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

	private boolean running = true;  //구동중인지 boolean형으로 표현

	private ArrayList sprites = new ArrayList(); //어레이리스트로 sprites 선언
	private Sprite starship; // Sprite 객체로 starship 표현 ( 플레이어가 조종할 기체 )
	private BufferedImage bgImage;  // 버퍼 이미지로 배경이미지를 선언
	private BufferedImage alienImage; // 적기체 이미지 선언
	private BufferedImage shotImage; // 투사체의 이미지 선언
	private BufferedImage shipImage; // 조종할 기체의 이미지 선언
	private BufferedImage boomImage; // 폭탄의 이미지 선언

	public GalagaGame() {  
		JFrame frame = new JFrame("Galaga Game"); // 프레임 선언
		frame.setSize(800, 600); // 사이즈 800,600
		frame.add(this); 
		frame.setResizable(false); // 자동 사이징 false
		frame.setVisible(true); // 시각화 true
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종료버튼 클릭시 종료
		try {
			 // IO 익셉션으로 이미지 로드 실패시 에러메시지 출력
			
			bgImage = ImageIO.read(new File("bgImage.png"));    // 이미지를 경로에따라 불러들임 
			shotImage = ImageIO.read(new File("shotImage.png"));
			shipImage = ImageIO.read(new File("shipImage.png"));
			alienImage = ImageIO.read(new File("alienImage.png"));
			boomImage = ImageIO.read(new File("boomImage.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		this.requestFocus(); // 키 이벤트를 받을 컴포넌트를 강제로 설정
		this.initSprites();
		addKeyListener(this);
	}

	private void initSprites() {
		starship = new StarShipSprite(this, shipImage, 382, 460); // 조종할 기체의 객체 선언
		sprites.add(starship); // 어레이리스트의 기체 add
		for (int y = 0; y < 5; y++) { // 좌우로 12개 상하로 5줄의 기체를 생성후 기체칸에 넣음
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
	public void fire() { // 투사체를 2발로 설정하고 좌표와 이미지를 지정하는 메소드
		ShotSprite shot = new ShotSprite(this,shotImage, starship.getX()+10,starship.getY()-30);
		ShotSprite shot2 = new ShotSprite(this,shotImage, starship.getX()+50,starship.getY()-30);
		sprites.add(shot);
		sprites.add(shot2);
	}
	public void boom() { // 폭탄의 좌표와 이미지를 지정하는 메소드
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
				sprite.move(); // 게임이 계속되는 동안 기체들은 move();
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
	//키리스너 입력시 기체의 좌표를 이동시키거나 투사체들을 발사시킨다.
	
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
	// 릴리스때 이동한 좌표의 값을 0으로 세팅 함으로써 한칸이동이 가능하게 설정;
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