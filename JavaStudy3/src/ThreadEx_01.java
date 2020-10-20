
public class ThreadEx_01 {
	public static void main(String[] args) {

		class Car {
			String carName;
		} // Car클래스를 만든다. Truck클래스의 슈퍼클래스로 사용할 것이다.

		class Truck extends Car implements Runnable {
			// Car클래스를 상속받아서 Truck클래스를 만든다.
			// 스레드를 사용하기위해 Runnable인터페이스를 구현한다.
			Truck(String carName) {
				this.carName = carName;
			}

			public void run() {
				for (int i = 0; i < 3; i++) { // 자동차가 달리고 있다는 메시지를 3회 반복해서 출력한다.
					try {
						Thread.sleep(100);
						// Thread.sleep(밀리초)는 잠깐 실행을 지정한 밀리초(1/1000초)만큼 멈춘다.
						System.out.println(carName + "~~ 달립니다.");
					} catch (Exception e) {
					}
				}
			}
		}

		Truck car1 = new Truck("$트럭1");
		Thread truck1 = new Thread(car1);
		truck1.start();

		Truck car2 = new Truck("@트럭2");
		Thread truck2 = new Thread(car2);
		truck2.start();

		Truck car3 = new Truck("*트럭3");
		Thread truck3 = new Thread(car3);
		truck3.start();
	}
}
