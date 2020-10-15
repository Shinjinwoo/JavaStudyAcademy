import java.util.*;
public class HashMapDicEx {
	public static void main (String[] args ) {
		
		HashMap <String, String> dic = new HashMap< String,String>();
		
		
		dic.put("baby", "아기");
		dic.put("love", "사랑");
		dic.put("apple", "사과");
		
		Set<String> keys = dic.keySet(); 
		Iterator <String > it = keys.iterator();
		
		//dic 해시맵에 들어있는 모든 (key,value) 쌍 출력
		while(it.hasNext()) {
			String key = it.next();
			String value = dic.get(key);
			
			System.out.println("(" + key + "," + value + ")");
		}
		
		System.out.println();
		// 영어단어를 입력 받고 한글단어 검색
		Scanner scan = new Scanner(System.in);
		
		for (int i=0; i<3; i++ ) {
			System.out.print("찾고 싶은 단어는 ?");
			String eng = scan.next();
			System.out.println(dic.get(eng));
		}
	}

}
