
public class OrderedPairTest {
	public static void main(String[] args) {
		OrderedPair<String, Integer> p1 = 
				new OrderedPair<String, Integer>("mykey", 12345678);
		
		
		OrderedPair<String, String> p2 = 
				new OrderedPair<String, String>("java", "a programming laguge");
		
		System.out.println(p1.getKey() + " " + p1.getValue());
		System.out.println(p2.getKey() + " " + p2.getValue());
		
	}

}
