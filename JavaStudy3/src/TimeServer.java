import java.net.Socket;
import java.io.ObjectOutputStream;
import java.net.*;

public class TimeServer {
	public static void main(String[] args) {

		int port = 7001; // 포트번호 7001

		try { // 트라이 캐치구문
			while (true) {

				ServerSocket ss = new ServerSocket(port); // 소켓서버 생성 포트번호 7001

				Socket client = ss.accept(); // accept 메소드를 통해 서버로 들어오는 클라이언트 대기

				ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());

			}

		} catch (Exception e) { // 예외처리 문구
			System.out.println(e.getMessage());
		}

	}

}
