
public class Box<T> {

	private T data;

	public void set(T data) {
		this.data = data;
	}

	public T get() {
		return data;
	}

	public static void main(String[] args) {

		Box<String> a = new Box<String>();

		Box<Integer> b = new Box<Integer>();
	}

}