import javax.swing.JOptionPane;

/**스레드를 한경우 중간에 이름을 쳐도 바로 실행**/
class C1 extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);					
			} catch (Exception e) {
				
			}
		}
	}
}
public class ThreadTest6 {
	public static void main(String[] args) {
		C1 c = new C1();
		c.start();
		String name = JOptionPane.showInputDialog("이건 뭐야");
		System.out.println("이름은 "+name+"입니다");
	}
}
