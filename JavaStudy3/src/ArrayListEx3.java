import java.util.ArrayList;

public class ArrayListEx3 {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<>();

		al.add("watermelon");
		al.add("apple");
		al.add("jujube");
		al.add("banana");

		System.out.println("Count : " + al.size());
		print(al);

		al.add(1, "Kiwi");
		print(al);
		al.add(4, "peach");
		print(al);
		al.remove(0);

		System.out.println("Index 3: " + al.get(3));
		System.out.println("Banana: " + al.contains("banana"));
		System.out.println("Banana: " + al.indexOf("banana"));
		System.out.println("Banana: " + al.lastIndexOf("banana"));

		for (int i = 0; i < al.size(); i++) {
			if (al.get(i).equals("banana")) {
				al.set(i, "strawberry ");
			}
		}

		print(al);

	}

	private static void print(ArrayList<String> al) {
		for (String str : al) {
			System.out.println(str + "\t");
		}
		System.out.println();
	}

}
