import java.net.*;
import java.io.*;
import java.util.*;



public class TimeClient {
	public static void main (String [] args ) {
		String server_Ip;
		Date date = null;
		int port = 7100;
		
		
		
		try { BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		System.out.println( "Ÿ�� ���� �ð� �޾ƿ��� . . . ");
		System.out.println(" Ÿ�� ���� ������ �Է� : ");
		server_Ip = read.readLine();
		
		
		Socket client = new Socket ( server_Ip, port );
		InputStream is = client.getInputStream();
		ObjectInputStream ois = new ObjectInputStream(is);
		
		date = (Date)ois.readObject();
		System.out.println("���� �ð� : " + date );
		
		ois.close();
		client.close();
		
		
		
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
