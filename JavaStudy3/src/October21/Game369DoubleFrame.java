package October21;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// 1~100까지 숫자를 증가시키면서 하는 369게임
public class Game369DoubleFrame extends JFrame{
	public Game369DoubleFrame() {
		setTitle("369 게임 둘이 하기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new GamePanel());
		setSize(300,300);
		setVisible(true);
		//System.out.println();
	}
	
	class GamePanel extends JPanel {
		TimerThread th;
		JLabel [] card = new JLabel [2]; // 두 명의 게임자에게 숫자가 출력되는 공간
		JButton startBtn = new JButton("start");
		int n = 1; // 게임 시작 숫자
		char key; // 사용자가 누른 키 문자
		boolean isKeyPressed = false; // 키가 입력되었는지를 나타내는 불린 값. 키가 눌러지면 true로 설정. 초기에는 어떤 키도 눌러지지 않은 상태
		User [] user = new User [2]; // 게임에 참여하는 사용자
		
		GamePanel() {
			user[0] = new User("박지성, 키:AS", 'a', 's'); // 369한 숫자에 입력하는 키는 a, 369중 두 개의 숫자에 대해 입력하는 키는 s
			user[1] = new User("이청룡, 키:KL", 'k', 'l'); // 369한 숫자에 입력하는 키는 k, 369중 두 개의 숫자에 대해 입력하는 키는 l
			
			setLayout(null); // 배치관리자 삭제
			this.addKeyListener(new KeyHandler());

			// name 레이블 생성 및 붙이기
			for(int i=0; i<card.length; i++) {
				JLabel name = new JLabel(user[i].getName());
				name.setFont(new Font("고딕", Font.PLAIN, 15));
				name.setHorizontalAlignment(JLabel.CENTER);
				name.setSize(100, 50);
				name.setLocation(50+110*i,50);
				add(name);
			}
			
			// card 생성 및 붙이기
			for(int i=0; i<card.length; i++) {				
				card[i] = new JLabel();
				card[i].setOpaque(true);
				card[i].setBackground(Color.ORANGE);
				card[i].setFont(new Font("고딕", Font.ITALIC, 30)); // 글자 크기 30 픽셀, 한글을 사용하려면 한글을 지원하는 고딕체 등을 써야 한다.
				card[i].setHorizontalAlignment(JLabel.CENTER); // 숫자를 레이블의 중앙에 배치
				card[i].setSize(100, 50);
				card[i].setLocation(50+110*i,100);
				add(card[i]);
			}
			
			//startBtn
			startBtn.setLocation(100, 200);
			startBtn.setSize(100, 30);
			
			// 시작 버튼이 클릭되면 스레드를 시작 시키도록 이벤트 리스너 달기
			startBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 카드의 텍스트를 모두 지운다.
					card[0].setText("");
					card[1].setText("");
					
					// 초기화
					n = 1;
					isKeyPressed = false;
					card[(n+1)%2].setText(Integer.toString(n)); // 숫자를 문자열로 변환하여 출력
					card[(n+1)%2].requestFocus(); // 키 입력을 받을 수 있도록 포커스를 준다.
					th = new TimerThread();
					th.start(); // 스레드 시작
					
					// 버튼 비활성화
					JButton b = (JButton)e.getSource();
					b.setEnabled(false); // 버튼이 다시 눌러지지 않도록 비활성화 시킴
					
					// 컨텐트 팬이 키 입력을 받을 수 있도록 키 포커스 전환
					b.getParent().requestFocus();
				}
			});
			add(startBtn);
		}
		
		class TimerThread extends Thread {
			public void run() {
				while(true) {
					try {
						sleep(700); // 300 밀리초 후에 번호 갱신

						// 1초 후에도 클릭이 안되면 게임에서 지게됨
						int x = n%10; // 아래 자리 수
						int y = n/10; // 높은 자리 수		
	
						int turn = (n+1)%2; // 이번 차례의 사용자 인덱스
						int next = (turn+1)%2; // 다음 차례의 사용자 인덱스
						
						if((x == 3 || x == 6 || x == 9) && (y == 3 || y == 6 || y == 9)) { // 두 자리수 모두 3, 6, 9 인 경우 판별
							if(isKeyPressed == true && user[turn].isDoubleKey(key)) { // turn 성공
								isKeyPressed = false; 
							}
							else if(isKeyPressed == true && user[(turn+1)%2].isKey(key)){ // turn 옆 사람의 실수, 실패
								msg(next, "Fail");
								break;
							}
							else { 							
								msg(turn, "Fail"); // turn의 실패
								break;
							}
						}
						else if(x == 3 || x == 6 || x == 9 || y == 3 || y == 6 || y == 9) { // 두 자리수 중 한 자리만 3,6,9인 경우 판별
							if(isKeyPressed == true && user[turn].isSingleKey(key)) { // turn 성공
								isKeyPressed = false; 
							}
							else if(isKeyPressed == true && user[next].isKey(key)){ // turn 옆 사람의 실수, 실패
								msg(next, "Fail");
								break;
							}
							else { 							
								msg(turn, "Fail"); // turn의 실패
								break;
							}
						}
						else { // 3,6,9의 어떤 상황도 아닌 경우
							if(isKeyPressed == true && user[turn].isKey(key)) { // turn이 키를 누른 경우
								msg(turn, "Fail"); // turn이 게임에서 짐
								break;
							}
							else if(isKeyPressed == true && user[next].isKey(key)){ // turn 옆 사람이 키를 누른 경우
								msg(next, "Fail"); // turn 옆 사람이 게임에서 짐								
								break;
							}
							isKeyPressed = false; // 키가 눌러지지 않은 것으로 설정							
						}
						n++; // 숫자 증가
						if(n==100) { // 모두 승리함
							msg(0, "Win!!");
							msg(1, "Win!!");
							break; // 게임을 종료하고 다시 시작하도록 한다.
						}
						else
							card[next].setText(Integer.toString(n)); // 증가된 숫자를 문자열로 변환하여 출력
					} catch (InterruptedException e) {
						return;	// 프로그램 종료					
					}
				}
				startBtn.setEnabled(true); // 시작 버튼 활성화
			}
			
			void msg(int id, String s) { // id는 카드의 인덱스
				card[id].setText(s); // 숫자를 문자열로 변환하여 출력		
			}
		}
		
		class KeyHandler extends KeyAdapter {
			public void keyPressed(KeyEvent e) {
				key = e.getKeyChar();
				isKeyPressed = true;
				int turn = (n+1)%2; // 차례인 사용자 인덱스
				card[turn].setBackground(Color.GREEN);				
			}
			public void keyReleased(KeyEvent e) {
				int turn = (n+1)%2; // 차례인 사용자 인덱스
				card[turn].setBackground(Color.ORANGE);				
			}			
			
		}
		
		// 게임에 참여하는 사용자를 구현하는 클래스
		class User {
			String name; // 사용자의 이름
			char singleKey; // 키 맵. 369 중 숫자를 하나 가진 경우 반응하여 입력해야하는 키
			char doubleKey; // 키 맵. 369 중 숫자를 두개 가진 경우 반응하여 입력해야하는 키
			User(String name, char singleKey, char doubleKey) {
				this.name = name;
				this.singleKey = singleKey;
				this.doubleKey = doubleKey;				
			}
			String getName(){return name;}
			boolean isKey(char key) {
				return singleKey == key || doubleKey == key;
			}
			boolean isSingleKey(char key) {
				return singleKey == key;
			}
			boolean isDoubleKey(char key) {
				return doubleKey == key;
			}
		}
	}

	public static void main(String[] args) {
		new Game369DoubleFrame();
	}
}
