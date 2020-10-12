import java.net.Socket;
import java.io.ObjectOutputStream;
import java.net.*;

public class TimeServer {
	public static void main(String[] args) {

		int port = 7100;

		try {
			while (true) {

				ServerSocket ss = new ServerSocket(port);

				Socket client = ss.accept();

				ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
