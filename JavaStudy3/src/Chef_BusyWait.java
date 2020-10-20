
public class Chef_BusyWait extends Thread {
	String Chef;
	Food_BusyWait food;

	public Chef_BusyWait(String Chef, Food_BusyWait food) {
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
