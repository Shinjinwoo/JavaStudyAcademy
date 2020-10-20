


class Th1 extends Thread{	
	public void run() {// "대박"20번 출력,한번출력후 0.1초 쉰다.
		for (int i = 0; i < 20; i++) {
			System.out.println("대박");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
		}
	}
}

class Th2 extends Thread {
	public void run() {// "월요일"20번 출력,한번출력후 0.1초 쉰다.
		for (int i = 0; i < 20; i++) {
			System.out.println("월요일");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
		}
	}
}

public class ThreadTest3 {
	public static void main(String[] args) {
		Th1 th1 = new Th1();
		Th2 th2 = new Th2();
		th1.start();
		th2.start();
	}

}
