package October20;

import java.net.Socket;
import java.util.Scanner;
public class ClientExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("연결한 IP ?");
		String ip = sc.nextLine();
		System.out.println("사용한 별명은 ?");
		String name = sc.nextLine();
		try {
			Socket socket = new Socket(ip, 9002);
			ReceiveThread rt = new ReceiveThread(socket);
			SendThread st = new SendThread(socket,name);
			
			rt.start();
			st.start();
			
		} catch(Exception e) { 
			System.out.println(e.getMessage());			
		} 
	}
}