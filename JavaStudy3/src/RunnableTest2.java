

class Ra3 implements Runnable {// 마치 스레드처럼 사용할수 있다.
	public void run() {// "대박"20번 출력,한번출력후 0.1초 쉰다.
		for (int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName() + "대박");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
		}
	}
}

class Ra4 implements Runnable {// 마치 스레드처럼 사용할수 있다.
	public void run() {// "월요일"20번 출력,한번출력후 0.1초 쉰다.
		for (int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName() + "월요일");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
		}
	}
}

public class RunnableTest2 {
	public static void main(String[] args) {
		Ra3 r1 = new Ra3();
		Ra4 r2 = new Ra4();
		Th3 th3 = new Th3("zz");
		Th4 th4 = new Th4("oo");
		Thread th1 = new Thread(r1, "ㅋㅋ");
		Thread th2 = new Thread(r2, "ㅠㅠ");
		th3.start();
		th4.start();
		th1.start();
		th2.start();
	}
}
