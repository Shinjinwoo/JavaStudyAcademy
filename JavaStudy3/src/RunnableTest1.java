

class Ra1 implements Runnable {// 마치 스레드처럼 사용할수 있다.
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
class Ra2 implements Runnable {// 마치 스레드처럼 사용할수 있다.
	public void run() {//"월요일"20번 출력,한번출력후 0.1초 쉰다.
		for (int i = 0; i < 20; i++) {
			System.out.println("월요일");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
		}
	}
}

public class RunnableTest1 {
	public static void main(String[] args) {
		Ra1 r1 = new Ra1();
		Ra2 r2 = new Ra2();
		Thread th1 = new Thread(r1);
		Thread th2 = new Thread(r2);
		th1.start();
		th2.start();
	}
}
