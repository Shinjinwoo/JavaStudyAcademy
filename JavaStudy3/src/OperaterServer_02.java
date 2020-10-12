import java.io.*;
import java.net.*;
import java.util.*;


public class OperaterServer_02 {

	public static String calc(String exp) {//Static ���� String���� �ٲ�
		StringTokenizer st =new StringTokenizer(exp, " ");
		if(st.countTokens() !=3) return"error";
		
		String res = "";
		int op1 = Integer.parseInt(st.nextToken());
		String opcode = st.nextToken();
		int op2 = Integer.parseInt(st.nextToken());
		switch(opcode) {
		case "+": res = Integer.toString(op1+op2);
		break;
		case "-": res = Integer.toString(op1-op2);
		break;
		case "*": res = Integer.toString(op1*op2);
		break;
		case "/": res = Integer.toString(op1/op2);
		break;
		default : res = "error";
		}
		return res;

	}

	public static void main(String[]args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		ServerSocket listener = null;
		Socket socket = null;
		try {
			listener = new ServerSocket(9999);//���� ���� ����
			System.out.println("���� �����");
			socket = listener.accept();//Ŭ���̾�Ʈ�η� ���� �����û ���
			System.out.println("���� �Ǿ����ϴ�."); //���� ����
			in = new BufferedReader
                  (new InputStreamReader(socket.getInputStream()));
			
			// �д� ����
			
			out = new BufferedWriter
                  (new OutputStreamWriter(socket.getOutputStream()));
			
			// ���� ����
			
			while(true) { // ���ѹݺ��� 
				
				String inputMessage = in.readLine();
				// Ŭ����Ʈ�� ���� �Ѷ��ξ� �д´�.
				
				if(inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("���� ����");
					// �������� ����
					break;
				}
				System.out.println("�Է°��� : "+inputMessage);//���� �޼��� ���
				String res = calc(inputMessage);//��� ����� res
				out.write(res +"\n");
				//�ܼ�â�� �������  \n�� �߰� �ؼ� �Ѷ��ξ� ���
				out.flush();
				
			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}catch(NumberFormatException e) {
			System.out.println("���ڿ� ��ȣ�� �Է� ����");
			
			// ���ڸ� �Է¹޴� ����ó��
			
		}finally {
			try {
				if(socket != null)socket.close();
				//���� �ѷ� 
				
				if(listener != null)listener.close();
				//������ ���� 
			}catch(IOException e) {
				System.out.println("�����߻�");
			}
		}
		
	}
}


