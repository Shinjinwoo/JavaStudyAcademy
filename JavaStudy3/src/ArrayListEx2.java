import java.util.ArrayList;

public class ArrayListEx2 {
	public static void main(String[] args) {

		ArrayList<String> al = new ArrayList<>();
		al.add("구렁이");
		al.add("팔렁이");
		al.add("칠렁이");
		al.add("구렁이");
		al.add("구렁삼");
		al.add("구렁사");

		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
		
		System.out.println("==============");

		for (String s : al) {
			System.out.println(s);

		}
	}
}
