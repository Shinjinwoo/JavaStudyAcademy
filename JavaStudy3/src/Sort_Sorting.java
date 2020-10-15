import java.util.*;

import javafx.print.Collation;

public class Sort_Sorting {
	public static void main(String[] args) {
		String[] sample = { "i", "walk", "the", "line" };
		List<String> list = Arrays.asList(sample);

		Collections.sort(list);

		System.out.println(list);
	}

}
