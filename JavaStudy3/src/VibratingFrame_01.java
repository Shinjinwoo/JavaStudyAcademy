import java.awt.event.MouseAdapter;
import java.util.Random;

import javax.swing.*;

import com.sun.glass.events.MouseEvent;

public class VibratingFrame_01 extends JFrame implements Runnable {
	Thread th;

	public VibratingFrame_01() {
		setTitle("진동하는 프레임 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);

		getContentPane().addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (!th.isAlive())
					return;
				th.interrupt();
			}
		});
		th = new Thread(this);
		th.start();
	}

	@Override
	public void run() {

		Random r = new Random();
		
		while (true) {
			try {
				Thread.sleep(2000);
				
			} catch ( InterruptedException e) {
				return;
			}
			int x = getX() + r.nextInt() % 50;
			int y = getY() + r.nextInt() % 50;
			setLocation(x,y);
		}

	}
	public static void main (String [] args ) {
		new VibratingFrame_01();
	}

}
