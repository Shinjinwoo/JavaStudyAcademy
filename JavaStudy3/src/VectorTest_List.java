import java.util.Vector;

public class VectorTest_List {
	public static void main(String[] args) {
		Vector v = new Vector();
		v.add("홍길동");
		v.addElement("이순신");
		v.addElement(new Integer(123));
		v.addElement("홍길동");
		v.addElement(new Integer(123));
		v.addElement(new MyStudent_Set());

		for (int i = 0; i < v.size(); i++) {
			System.out.println(v.get(i));
		}
		System.out.println(v);//toString()호출 출력:은 []안에 출력
	}
}
