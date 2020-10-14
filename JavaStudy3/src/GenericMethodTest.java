
public class GenericMethodTest {
	public static void main(String[] args) {

		Integer[] iArray = { 10, 20, 30, 40, 50 };
		Double[] dArray = { 1.1, 1.2, 1.3, 1.4, 1.5 };
		Character[] cArray = { 'K', 'O', 'R', 'E', 'A' };

		printArray(iArray);
		printArray(dArray);
		printArray(cArray);

	}

	public static <T> void printArray(T[] array) {
		for (T elemnet : array) { // 향상된 for문
			// 배열의 크기만큼 for문을 돌린다.
			System.out.printf("%s ", elemnet);
		} // C 언어의 printf와 동일한 기능 요소들을 출력
		System.out.println();
		// 배열의 모든 요소 출력후 한 라인 넘김
	}

}
