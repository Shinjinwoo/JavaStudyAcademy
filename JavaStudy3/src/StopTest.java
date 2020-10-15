public class StopTest {
	static void print(String message) {
		String threadName = Thread.currentThread().getName();
		System.out.format("%s : %s%n", threadName, message);
	}

	private static class MessageLoop implements Runnable {
		public void run() {
			String message[] = { "pride will have a fall", 
					"power is dangerous unless you have humility",
					"Office changes manners",
					"Empty vessels make the most sound." };

			try {
				for (int i = 0; i < message.length; i++) {
					print(message[i]);
					Thread.sleep(2000);
				}
			} catch (InterruptedException e) {
				print(" 아직 끝나지 않았어요");
			}
		}
	}

	public static void main(String args[]) throws InterruptedException {
		int tries = 0;
		print("추가적인 스레드를 시작합니다.");
		Thread t = new Thread(new MessageLoop()); //스레드가 t가 종료하기를 1초동안 기다린다.
		t.start();
		print("추가적인 스레드가 끝나기를 기다립니다.");
		while (t.isAlive()) {  // 해당 스레드의 실행여부 권한
			print("아직 기다립니다.");
			t.join(1000);
			tries++;
			if (tries > 2) {
				print("참을 수 없네요!");
				t.interrupt();
				t.join();
			}
		}
		print("메인 스레드 종료!");
	}
}
