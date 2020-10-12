import java.io.*;
import java.net.*;
import java.util.*;


public class OperaterServer_02 {

	public static String calc(String exp) {//Static 에서 String으로 바뀜
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
			listener = new ServerSocket(9999);//서버 소켓 생성
			System.out.println("연결 대기중");
			socket = listener.accept();//클라이언트로로 부터 연결요청 대기
			System.out.println("연결 되었습니다."); //연결 성공
			in = new BufferedReader
                  (new InputStreamReader(socket.getInputStream()));
			
			// 읽는 과정
			
			out = new BufferedWriter
                  (new OutputStreamWriter(socket.getOutputStream()));
			
			// 쓰는 과정
			
			while(true) { // 무한반복문 
				
				String inputMessage = in.readLine();
				// 클리언트로 부터 한라인씩 읽는다.
				
				if(inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("연결 종료");
					// 연결종료 로직
					break;
				}
				System.out.println("입력값은 : "+inputMessage);//받은 메세지 출력
				String res = calc(inputMessage);//계산 결과는 res
				out.write(res +"\n");
				//콘솔창에 결과값을  \n을 추가 해서 한라인씩 출력
				out.flush();
				
			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}catch(NumberFormatException e) {
			System.out.println("숫자와 기호만 입력 가능");
			
			// 숫자만 입력받는 예외처리
			
		}finally {
			try {
				if(socket != null)socket.close();
				//소켓 총료 
				
				if(listener != null)listener.close();
				//리스너 종료 
			}catch(IOException e) {
				System.out.println("오류발생");
			}
		}
		
	}
}


