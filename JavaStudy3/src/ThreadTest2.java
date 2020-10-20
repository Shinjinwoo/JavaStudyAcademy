
public class ThreadTest2 {
	public static void main(String[] args) {
		A1 a1 = new A1("subA");
		A1 a2 = new A1("subB");
		a1.start();
		a2.start();
		for (int i = 0; i <= 100; i++) {
			System.out.print("main" + i + "\t");

			if (i % 10 == 0)
				System.out.println();
			try {
				Thread.sleep(100);//0.1초마다 실행
			} catch (Exception e) {
			}
		}
	}
}//스레드로 처리된 문장 cpu유효시간에도 실행된다. 빠르다는 장점!
