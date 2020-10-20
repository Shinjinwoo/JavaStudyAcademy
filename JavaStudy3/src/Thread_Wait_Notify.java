class Buffer {
	private int data;//생산자로부터 소비자로 전해지는 데이터
	private boolean empty = true;//소비자가 기다리고 있으면 true,
									//생산자가 기다리고 있으면 false

	public synchronized int get() {
		while (empty) {
			try {//케익이 생사될떄 까지 기다린다.
				wait();
			} catch (InterruptedException e) {
			}
		}
		empty = true;//상태를 토굴(두상태중 하나선택)한다.소비자가 기다리고 있으면 true,
		notifyAll();//생산자를 깨운다.
		return data;
	}

	public synchronized void put(int data) {
		while (!empty) {//케익이 소비될때 까지 기다린다.
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		empty = false;//생산자가 기다리고 있으면 false
		this.data = data;
		notifyAll();//소비자를 깨운다.
	}
}

class Producer implements Runnable {
	private Buffer buffer;

	public Producer(Buffer buffer) {
		this.buffer = buffer;//버퍼 참조변수를 저장
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			buffer.put(i);//Counter를 정의
			System.out.println("생산자: " + i + "번 케익을 생산하였습니다.");
			try {
				Thread.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {

			}
		}
	}
}

class Consumer implements Runnable {
	private Buffer buffer;//버퍼 참조변수 저장

	public Consumer(Buffer drop) {
		this.buffer = drop;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			int data = buffer.get();//버퍼에서 케익을 가져온다
			System.out.println("@소비자: " + data + "번 케익을 소비하였습니다.");
			try {
				Thread.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {

			}
		}
	}
}

public class Thread_Wait_Notify {
	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		(new Thread(new Producer(buffer))).start();
		(new Thread(new Consumer(buffer))).start();
	}
}
