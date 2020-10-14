import java.util.*;
public class HashMapDicEx {
	public static void main (String[] args ) {
		
		HashMap <String, String> dic = new HashMap< String,String>();
		
		
		dic.put("baby", "아기");
		dic.put("love", "사랑");
		dic.put("apple", "사과");
		
		Set<String> keys = dic.keySet(); 
		Iterator <String > it = keys.iterator();
		
		while(it.hasNext()) {
			String key = it.next();
			String value = dic.get(key);
			
			System.out.println("(" + key + "," + value + ")");
		}
		
		Scanner scan = new Scanner(System.in);
		
		for (int i=0; i<3; i++ ) {
			System.out.print("찾고 싶은 단어는 ?");
			String eng = scan.next();
			System.out.println(dic.get(eng));
		}
	}

}
