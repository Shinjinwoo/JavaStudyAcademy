


class Th3 extends Thread {
	Th3(String str) {
		super(str);
	}

	public void run() {// "대박"20번 출력,한번출력후 0.1초 쉰다.
		for (int i = 0; i < 20; i++) {
			System.out.println(getName() + "대박");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
		}
	}
}

class Th4 extends Thread {
	Th4(String str) {
		super(str);
	}

	public void run() {// "월요일"20번 출력,한번출력후 0.1초 쉰다.
		for (int i = 0; i < 20; i++) {
			System.out.println(getName() + "월요일");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
		}
	}
}

public class ThreadTest4 {
	public static void main(String[] args) {
		Th3 th1 = new Th3("첫번째");
		Th4 th2 = new Th4("th4");
		th1.start();
		th2.start();
	}
}
