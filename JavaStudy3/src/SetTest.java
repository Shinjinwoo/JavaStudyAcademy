import java.util.HashSet;

public class SetTest {
	public static void main (String [] args ) {
		
		HashSet<String> set = new HashSet <String> ();
		set.add("Milk");
		set.add("Bread");
		set.add("Butter");
		set.add("Cheese");
		set.add("Ham");
		
		System.out.println(set);
	}

}
