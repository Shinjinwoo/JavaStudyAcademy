
public class MyArrayAlg {
	public static <T> T getLast(T[] a) {
		return a[a.length - 1];
	}

	public static <T> T getSecond(T[] a) {
		return a[a.length - 2];
	}

	public static <T> T getFirst(T[] a) {
		return a[a.length - 3];
	}

	public static <T> void swap(T[] a, int i, int j) {

		T tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

}
