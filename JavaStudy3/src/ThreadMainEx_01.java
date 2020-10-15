
public class ThreadMainEx_01 {
	public static void mina (String [] args ) {
		
		long id = Thread.currentThread().getId();
		String name = Thread.currentThread().getName();
		int priority = Thread.currentThread().getPriority();
		Thread.State s = Thread.currentThread().getState();
		
		
		System.out.println("현재 스레드의 이름 =" + name);
		System.out.println("현재 스레드의 ID =" + id);
		System.out.println("현재 스레드의 우선순위 값 =" + priority);
		System.out.println("현재 스레드의 상태 =" + s);
	}

}
