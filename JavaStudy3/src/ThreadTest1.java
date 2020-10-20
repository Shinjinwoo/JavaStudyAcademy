
class A1 extends Thread {
	A1(String str) {
		super(str);
	}

	public void run() {
		for (int i = 0; i <= 100; i++) {
			System.out.print(getName() + i + "\t");
			if (i % 10 == 0)
				System.out.println();
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
		}
	}
}

public class ThreadTest1 {
	public static void main(String[] args) {
		A1 a1 = new A1("subA");
		A1 a2 = new A1("subB");
		a1.run();
		a2.run();
		for (int i = 0; i <= 100; i++) {
			System.out.print("main" + i + "\t");

			if (i % 10 == 0)
				System.out.println();
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
		}
	}
}
