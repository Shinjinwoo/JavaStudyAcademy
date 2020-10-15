import java.util.*;

public class WordFreq_Map { // Map : 중복된 키를 가질수 없다.
	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		String[] sample = { "to", "be", "or", "not", "to",
				"be", "is", "a", "problem" };

		for (String a : sample) { //문자열에 포함된 단어의 빈도를 계산
			Integer freq = m.get(a);
			m.put(a, (freq == null) ? 1 : freq + 1);
			
			// 삼황연산자 ( 조건a , (freq == null) ? , 참이면 1실행
			// 거짓이면 freq + 1 실행
			// 단어를 꺼내서 빈도를 증가시킴
			
		}

		System.out.println(m.size() + "단어가 있습니다."); //9단어중 3단어 중복으로 7단어
		System.out.println(m.containsKey("to"));
		System.out.println(m.isEmpty());
		System.out.println(m);   //순서가 없기 때문에 마음대로 순서 출력
	}

}
