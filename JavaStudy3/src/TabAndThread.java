import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

class MyLabel extends JLabel {
	int barSize = 0; //바 크기
	int maxBarSize;

	MyLabel(int maxBarSize) {
		this.maxBarSize = maxBarSize;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.MAGENTA);
		int width = (int) (((double) (this.getWidth())) / maxBarSize * barSize);
		if (width == 0)//크기가 0이기 때문에 바를 그릴 필요가 없음
			return;
		g.fillRect(0, 0, width, this.getHeight());
	}

	synchronized void fill() {
		if (barSize == maxBarSize) {
			try {
				wait();//바의 크기가 최대이면,ConsumerThread에 의해 바의 크기가 줄어들때 까지 대기
			} catch (InterruptedException e) {
				return;
			}
		}
		barSize++;
		repaint();//바 다시 그리기
		notify();//기다리는 ConsumerThread스레드 꺠우기
	}

	synchronized void consume() {
		if (barSize == 0) {
			try {
				wait();//바의 크기가 0이면 바의크기가 0보다 커질때 까지 대기
			} catch (InterruptedException e) {
				return;
			}
		}
		barSize--;
		repaint();//바 다시 그리기
		notify();//기다리는 이벤트 스레드 깨우기
	}
}

class ConsumerThread extends Thread {
	MyLabel bar;

	ConsumerThread(MyLabel bar) {
		this.bar = bar;
	}

	public void run() {
		while (true) {
			try {
				sleep(200);
				bar.consume();//0.1초마다 바를 1씩 줄인다.
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}

public class TabAndThread extends JFrame {
	MyLabel bar = new MyLabel(100);//바의 최대크기를 100으로 설정

	TabAndThread(String title) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		bar.setBackground(Color.ORANGE);
		bar.setOpaque(true);//그림을 표시하게 설정,투명도 조절
		bar.setLocation(20, 50);
		bar.setSize(300, 200);//300*20크기의 바
		c.add(bar);
		c.addKeyListener(new KeyAdapter() {//컨텐트팬에 키 이벤트 핸들러 등록
			public void keyPressed(KeyEvent e) {
				bar.fill();//키를 누를때 마다 바가 1씩 증가
			}
		});
		setSize(350, 200);
		setVisible(true);
		c.requestFocus();//컨텐트팬에게 키 처리권 부여
		ConsumerThread th = new ConsumerThread(bar);//스레드 생성
		th.start();//스레드 시작
	}

	public static void main(String[] args) {
		new TabAndThread("아무거나 빨리 눌러 바 채우기");
	}
}