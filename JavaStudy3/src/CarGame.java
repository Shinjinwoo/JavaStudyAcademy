import javax.swing.*;

public class CarGame extends JFrame { // JFream을 상속받는 CarGame 클래스
	class MyThread extends Thread {   // Thread를 상속받는 MyThread 
		private JLabel label; // 라벨 선언
		private int x, y;     // 좌표 X,y 선언

		public MyThread(String fname, int x, int y) {
			this.x = x;
			this.y = y;

			label = new JLabel();
			label.setIcon(new ImageIcon(fname));
			label.setBounds(x, y, 100, 100);
			add(label); 	}
		public void run() {
			for (int i = 0; i < 200; i++) {
				x += 10 * Math.random();
				label.setBounds(x, y, 100, 100);
				repaint();

				try {

					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} } } }

	public CarGame() {
		setTitle("CarRace");
		setSize(600, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		(new MyThread("dog1.png", 100, 0)).start();
		(new MyThread("dog2.png", 100, 50)).start();
		(new MyThread("dog3.png", 100, 100)).start();
		setVisible(true);
	}

	public static void main(String[] args) {
		CarGame t = new CarGame();
	} }
