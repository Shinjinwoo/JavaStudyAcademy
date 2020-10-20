package October20;
import java.net.*;
import java.io.*;
public class ReceiveThread extends Thread {
	Socket socket;
	public ReceiveThread(Socket socket) {
		this.socket = socket;
	}
	public void run() {
		try { BufferedReader br = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
			while(true) {
				String str = br.readLine();
				if (str==null) break;
				System.out.println(str);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}