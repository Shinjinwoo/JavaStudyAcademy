
public class Food_BusyWait {
	public void receiveOder(String Waiter) {
		for(int i=0; i<5; i++ ){
			System.out.println(Waiter + "가 주문을 받습니다.");
		}
		System.out.println(Waiter + "가 주문을 주방에 전달 합니다.");
		System.out.println();
	}
	public void makefood (String Chef) {
		for (int i=0; i<5; i++) {
			System.out.println(Chef+"이 음식을 만듭니다.");
		}
		System.out.println(Chef+"이 음식을 다 만들었습니다.");
		System.out.println();
	}	
}
