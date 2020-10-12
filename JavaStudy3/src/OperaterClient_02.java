
import java.io.*;
import java.net.*;
import java.util.*;

public class OperaterClient_02 {

	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		Socket socket = null;
		Scanner scanner = new Scanner(System.in); // 키보드에서 읽을 스캐너 생성
		try {
			socket = new Socket("localhost", 9999); // 클라이언트 소캣 생성. 서버와 연결
			
			in = new BufferedReader
              (new InputStreamReader(socket.getInputStream())); // 소켓 스트림 생성
			
			out = new BufferedWriter
              (new OutputStreamWriter(socket.getOutputStream())); // 소켓 스트림 생성
			
			while(true) {
				System.out.print("계산식(빈칸으로 띄어 입력, 예 24 + 42)"); // 프롬프트
				String outputMessage = scanner.nextLine(); // 키보드 한행씩 읽기
				if(outputMessage.equalsIgnoreCase("bye")) { //bye 로직
					out.write(outputMessage +"\n"); // bye 문자열 정송
					out.flush();
					break; // bye 로직
				}
				out.write(outputMessage+"\n"); // 키보드에서 읽은 문자열 정송
				out.flush();
				String inputMessage = in.readLine(); // 서버로부터 한행 수신 
				System.out.println("계산결과 : "+inputMessage); // 서버로부터 받은 메시지를 화면에 출력
				
			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				scanner.close();
				if(socket !=null)socket.close();
			}catch(IOException e) {
				System.out.println("오류 발생");
			}
		}
	}
}