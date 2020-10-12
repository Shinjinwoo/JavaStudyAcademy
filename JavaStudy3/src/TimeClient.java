import java.net.*;
import java.io.*;
import java.util.*;



public class TimeClient {
	public static void main (String [] args ) {
		String server_Ip;
		Date date = null;
		int port = 7001;
		
		
		
		try {
			
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in)); //�Է¹��� IP�� �̿��ϱ� ���� ���۸��� �̿�
		System.out.println( "Ÿ�� ���� �ð� �޾ƿ��� . . . "); 
		System.out.println(" Ÿ�� ���� ������ �Է� : ");
		server_Ip = read.readLine(); // ���� �ϳ��� �д´�.
		
		
		Socket client = new Socket ( server_Ip, port ); // IP,PORT ��ȣ�� �Ű������� �޴� Socke�� ���� ������ ����
		InputStream is = client.getInputStream();       // �б� ���� 
		ObjectInputStream ois = new ObjectInputStream(is);  // �ٿ��� ��ü �ȿ� ����Ǿ� 
		//�ִ� ������ ���Ϸ� �����ϰų� ��Ʈ��ũ�� ���Ͽ� �ٸ� ������ 
		//�����Ϸ��� ��ü�� ����Ʈ ���·� ������ �����ؾ� �Ѵ�. 
		//�̸� ���Ͽ� ��ü�� ���� ����� �� �� �ֵ��� ���ִ� ��ü ��Ʈ���̴�.

		
		date = (Date)ois.readObject();  //������ �ð��� �ޱ����� date�� Date Ŭ������ ���� �д´�.
		System.out.println("���� �ð� : " + date );  // ����ð� ���
		
		ois.close(); 
		client.close();
		
		
		
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
