import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ArrayListEx5 {
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

		Iterator<String> it = al.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		System.out.println("==============");

		for (String s : al) {
			System.out.println(s);
		}

		LinkedList<String> kk = new LinkedList<>();
		String[] animal = { "산토끼", "집토끼", "판토끼", "죽은토끼", "알카리토끼" };

		for (int i = 0; i < animal.length; i++) {
			kk.add(animal[i]);
		}
		Iterator<String> it2 = kk.iterator();
		while (it.hasNext()) {
			System.out.println(it2.next());
		}

		System.out.println(al);
		System.out.println(kk);
	}
}