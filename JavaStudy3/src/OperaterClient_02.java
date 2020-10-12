
import java.io.*;
import java.net.*;
import java.util.*;

public class OperaterClient_02 {

	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		Socket socket = null;
		Scanner scanner = new Scanner(System.in); // Ű���忡�� ���� ��ĳ�� ����
		try {
			socket = new Socket("localhost", 9999); // Ŭ���̾�Ʈ ��Ĺ ����. ������ ����
			
			in = new BufferedReader
              (new InputStreamReader(socket.getInputStream())); // ���� ��Ʈ�� ����
			
			out = new BufferedWriter
              (new OutputStreamWriter(socket.getOutputStream())); // ���� ��Ʈ�� ����
			
			while(true) {
				System.out.print("����(��ĭ���� ��� �Է�, �� 24 + 42)"); // ������Ʈ
				String outputMessage = scanner.nextLine(); // Ű���� ���྿ �б�
				if(outputMessage.equalsIgnoreCase("bye")) { //bye ����
					out.write(outputMessage +"\n"); // bye ���ڿ� ����
					out.flush();
					break; // bye ����
				}
				out.write(outputMessage+"\n"); // Ű���忡�� ���� ���ڿ� ����
				out.flush();
				String inputMessage = in.readLine(); // �����κ��� ���� ���� 
				System.out.println("����� : "+inputMessage); // �����κ��� ���� �޽����� ȭ�鿡 ���
				
			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				scanner.close();
				if(socket !=null)socket.close();
			}catch(IOException e) {
				System.out.println("���� �߻�");
			}
		}
	}
}