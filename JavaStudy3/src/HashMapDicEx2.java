import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
public class HashMapDicEx2 {
	public static void main (String[] args ) {
		
		HashMap <String, String> dic = new HashMap< String,String>();
		
		
		dic.put("강수지", "전화번호 : 010 - 1111 - 2222");
		dic.put("배수지", "전화번호 : 010 - 3333 - 4444");
		dic.put("이효리", "전화번호 : 010 - 6666 - 5555");
		
		Set<String> keys = dic.keySet(); 
		Iterator <String > it = keys.iterator();
		
		while(it.hasNext()) {
			String key = it.next();
			String value = dic.get(key);
			
			System.out.println("(" + key + "," + value + ")");
		}
		
		Scanner scan = new Scanner(System.in);
		
		for (int i=0; i<3; i++ ) {
			System.out.print("찾고 싶은 인물의 번호는 ?");
			String eng = scan.next();
			System.out.println(dic.get(eng));
		}
	}

}