
public class GenericType<T> {
	T[] t;

	void setType(T[] t) {
		this.t = t;
	}

	void print() {
		for (T v : t) {
			System.out.println(v);
		}
	}

	public static void main(String[] args) {

		GenericType<CharSequence> gt = new GenericType<>();

		String[] str = { "야호", "신난다", "수요일이니까" }; // 문자형 배열
		gt.setType(str);
		gt.print();
		GenericType<Integer> gt2 = new GenericType<Integer>();
		Integer[] it = { 3, 24, 67, 234 }; // 숫자형 배열
		gt2.setType(it);
		gt2.print();

	}

}
