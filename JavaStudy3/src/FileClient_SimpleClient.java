import java.io.*;
import java.net.Socket;

public class FileClient_SimpleClient {
	public static void main (String[] args ) {
		OutputStream os;
		BufferedReader br_out;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		
		try { 
			String data = null;
			Socket s1 = new Socket("127.0.0.1",5434);
			os = s1.getOutputStream();
			br_out = new BufferedReader(new FileReader ( "input.txt"));
			bw = new BufferedWriter(new OutputStreamWriter(os));
			
			while ((data = br_out.readLine()) != null) {
				pw.println(data);
			}
			
			System.out.println("������ ���� �Ͽ����ϴ�.");
			pw.close();
			s1.close();
			
			
		}catch (IOException e ) {
			e.printStackTrace();
		}
		
	}

}
