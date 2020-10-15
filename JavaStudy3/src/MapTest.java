import java.util.HashMap;
import java.util.Map;

class Student {
	int number;
	String name;

	public Student(int number, String name) {
		this.number = number;
		this.name = name;
	}

	public String toString() {//객체를 문자열 형태로 바꿔서 String형태로 반환
		return name;
	}
}

public class MapTest {
	public static void main(String[] args) {
		Map<String, Student> st = new HashMap<String, Student>();
		st.put("20090001", new Student(20090001, "구준표"));
		st.put("20090002", new Student(20090002, "금잔디"));
		st.put("20090003", new Student(20090003, "윤지후"));
		System.out.println(st);//st(키,밸류)모든항목 출력

		st.remove("20090002");//20090002키값 삭제
		st.put("20090003", new Student(20090003, "소이정"));//20090003값의 밸류교체

		System.out.println(st.get("20090003"));//20090003의 밸류값(소이정)출력

		for (Map.Entry<String, Student> s : st.entrySet()) {
			String key = s.getKey();
			Student value = s.getValue();
			System.out.println("key= " + key + " , value= " + value);
		}
	}
}