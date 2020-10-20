class Food_BusyWait1 {
	public synchronized void receiveOder(String Waiter) {
		for (int i = 0; i < 5; i++) {
			System.out.println(Waiter + "가 주문을 받습니다.");
		}
		System.out.println(Waiter + "가 주문을 주방에 전달 합니다.");
		System.out.println();
	}

	public synchronized void makefood(String Chef) {
		for (int i = 0; i < 5; i++) {
			System.out.println(Chef + "이 음식을 만듭니다.");
		}
		System.out.println(Chef + "이 음식을 다 만들었습니다.");
		System.out.println();
	}
}

class Chef_BusyWait1 extends Thread {
	String Chef;
	Food_BusyWait1 food;

	public Chef_BusyWait1(String Chef, Food_BusyWait1 food) {
		this.Chef = Chef;
		this.food = food;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			food.makefood(Chef);
		}
	}
}

class Waiter_BusyWait1 extends Thread {
	String Waiter;
	Food_BusyWait1 food;
	
	public Waiter_BusyWait1(String Waiter, Food_BusyWait1 food) {
		this.Waiter = Waiter;
		this.food = food;
	}


	public Waiter_BusyWait1(String waiter2, Food_BusyWait food2) {
		// TODO Auto-generated constructor stub
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			food.receiveOder(Waiter);
		}
	}
}

public class Restaurant_BusyWait_synchronized {
	public static void main(String[] args) {
		Food_BusyWait1 food = new Food_BusyWait1();
		Waiter_BusyWait1 Waiter =new Waiter_BusyWait1("웨이터",food);
		Chef_BusyWait1 Chef = new Chef_BusyWait1("주방장",food);
		Waiter.start();
		Chef.start();
	}
}
