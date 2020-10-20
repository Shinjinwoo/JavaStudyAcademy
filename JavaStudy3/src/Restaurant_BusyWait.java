
public class Restaurant_BusyWait {
	public static void main(String[] args) {
		Food_BusyWait food = new Food_BusyWait();
		Waiter_BusyWait1 Waiter = new Waiter_BusyWait1("웨이터",food);
		Chef_BusyWait Chef = new Chef_BusyWait("주방장",food);
		Waiter.start();
		Chef.start();
	}
}