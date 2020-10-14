
public class MyArrayAlgTest {
	public static void main(String[] args) {
		String[] language = { "C++", "C#", "JAVA" };
		String last = MyArrayAlg.getLast(language); // last 는 "JAVA"
		String second = MyArrayAlg.getSecond(language); // second 는 "C#"
		String first = MyArrayAlg.getFirst(language); // first 는 "C++"

		MyArrayAlg.swap(language, 1, 2);

		for (String value : language) {
			System.out.println(value);
		}

		
		System.out.println("-----------------");
		
		System.out.println(first);
		System.out.println(second);
		System.out.println(last);

	}

}
