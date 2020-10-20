
/** setPriority()사용 */
class Horse02 implements Runnable {
	private int horse_num;
	public static int num = 0;

	public Horse02(int horse_num) {
		this.horse_num = horse_num;

	}

	@Override // Override 기법은 메서드 내부를 수정
	public void run() {
		for (int i = 0; i <= 10; i++) {
			System.out.println(horse_num + 1 + "번 말이 " + 100 * i + "미터 도착");
		}

	}
}

public class Horse01 {
	public static void main(String[] args) throws InterruptedException {

		int k = 0; //확장된 for문의 INDEX를 활용하기 위한 변수 K이다.


		Thread[] th = new Thread[9];

		for (int i = 0; i < 9; i++) {
			th[i] = new Thread(new Horse02(i));
		}
		

		for (int i = 0; i < 9; i ++) {
			if ( i == 7 )
				th[i].setPriority(Thread.MIN_PRIORITY);
			else
				th[i].setPriority(5);
		}

		for (Thread i : th) {
			th[k].start();
			k++;
			System.out.println(i); // 스레드의 우선순위 확인
		}
		


		System.out.println("main() 종료...");
	}
}