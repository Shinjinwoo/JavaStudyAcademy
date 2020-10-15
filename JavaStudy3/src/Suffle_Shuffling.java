import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Suffle_Shuffling {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i <= 10; i++)
			list.add(i);
		Collections.shuffle(list);
		System.out.println();

	}

}
