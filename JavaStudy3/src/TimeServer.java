import java.net.Socket;
import java.io.ObjectOutputStream;
import java.net.*;

public class TimeServer {
	public static void main(String[] args) {

		int port = 7001; // ��Ʈ��ȣ 7001

		try { // Ʈ���� ĳġ���� 
			while (true) {

				ServerSocket ss = new ServerSocket(port); // ���ϼ��� ���� ��Ʈ��ȣ 7001

				Socket client = ss.accept(); // accept �޼ҵ带 ���� ������ ������ Ŭ���̾�Ʈ ��� 

				ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream()); 

			}

		} catch (Exception e) { // ����ó�� ����
			System.out.println(e.getMessage());
		}

	}

}
