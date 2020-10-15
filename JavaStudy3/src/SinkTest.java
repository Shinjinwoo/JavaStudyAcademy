
public class SinkTest {
	public static void main(String[] args) {
		SharedPrinter p = new SharedPrinter();
		String[] engText = { "abc", "def", "ghi", "jkl", "monop" };

		String[] korText = { "동해물과", "백두산이", "마르고닳도록" };

		Thread th1 = new WorkerThread(p, engText);
		Thread th2 = new WorkerThread(p, korText);
		
		th1.start();
		th2.start();

	}
}

class SharedPrinter {
	synchronized void print(String text) {
		for (int i = 0; i < text.length(); i++)
			System.out.print(text.charAt(i));
		System.out.println();
	}
}

class WorkerThread extends Thread {
	SharedPrinter p;
	String[] text;

	WorkerThread(SharedPrinter p, String[] text) {
		this.p = p;
		this.text = text;
	}

	public void run() {
		for (int i = 0; i < text.length; i++)
			p.print(text[i]);
	}
}
