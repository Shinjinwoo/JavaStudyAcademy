import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
	public static void main(String[] args) {

		Map map = new HashMap();

		map.put(1, new Integer(100));
		map.put("second", "Hello World");
		map.put("third", new MyStudent_Set());
		map.put("forth", null);

		Integer i = (Integer) map.get(1);

		String str = (String) map.get("second");
		System.out.println(i);
		System.out.println(str);

		MyStudent_Set st = (MyStudent_Set) map.get("third");
		System.out.println(st);
		System.out.println("third");
		System.out.println("fourth");

	}

}
