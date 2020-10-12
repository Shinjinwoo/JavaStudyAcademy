import java.net.*;
import java.io.*;
import java.util.*;



public class TimeClient {
	public static void main (String [] args ) {
		String server_Ip;
		Date date = null;
		int port = 7001;
		
		
		
		try {
			
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in)); //입력받은 IP를 이용하기 위해 버퍼리더 이용
		System.out.println( "타임 서버 시간 받아오기 . . . "); 
		System.out.println(" 타임 서버 아이피 입력 : ");
		server_Ip = read.readLine(); // 라인 하나를 읽는다.
		
		
		Socket client = new Socket ( server_Ip, port ); // IP,PORT 번호를 매개변수로 받는 Socke을 통해 서버에 접속
		InputStream is = client.getInputStream();       // 읽기 연산 
		ObjectInputStream ois = new ObjectInputStream(is);  // 바에서 객체 안에 저장되어 
		//있는 내용을 파일로 저장하거나 네트워크를 통하여 다른 곳으로 
		//전송하려면 객체를 바이트 형태로 일일이 분해해야 한다. 
		//이를 위하여 객체를 직접 입출력 할 수 있도록 해주는 객체 스트림이다.

		
		date = (Date)ois.readObject();  //서버의 시간을 받기위한 date를 Date 클래스를 통해 읽는다.
		System.out.println("현재 시간 : " + date );  // 현재시간 출력
		
		ois.close(); 
		client.close();
		
		
		
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
