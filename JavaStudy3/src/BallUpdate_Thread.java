import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

class Ball {
	private int x = 100;
	private int y = 100;
	private int size = 30;
	private int xSpeed = 10;
	private int ySpeed = 10;

	public void draw(Graphics g) {

		g.setColor(Color.RED);
		g.fillOval(x, y, size, size); // 100,100,30,30 원을 그린다.

	}

	public void update() {
		x += xSpeed;
		y += ySpeed;

		if ((x + size) > BallUpdate_Thread.BOARD_WIDTH - size || x < 0) {
			xSpeed = -xSpeed;
		}

		if ((y + size) > BallUpdate_Thread.BOARD_HEIGHT - size || y < 0) {
			ySpeed = -ySpeed;
		}
	}

}

public class BallUpdate_Thread extends JPanel {
	static final int BOARD_WIDTH = 600;
	static final int BOARD_HEIGHT = 300;

	private Ball ball = new Ball();

	public BallUpdate_Thread() {
		this.setBackground(Color.YELLOW);
		Runnable task = () -> {
			while (true) {
				ball.update();
				repaint();

				try {
					Thread.sleep(50);
				} catch (InterruptedException ignore) {

				}

			}
		};
		new Thread(task).start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ball.draw(g);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(BallUpdate_Thread.BOARD_WIDTH, BallUpdate_Thread.BOARD_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(new BallUpdate_Thread());
	}

}
