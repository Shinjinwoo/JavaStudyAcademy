import java.io.*;

import java.net.*;
import java.util.LinkedList;

public class OperaterServer {
	public static void main(String[] args) {

		LinkedList<Integer> numList = new LinkedList<Integer>();
		LinkedList<Character> operaterList = new LinkedList<Character>();

		BufferedReader in = null;

		BufferedReader stin = null;

		BufferedWriter out = null;

		ServerSocket listener = null;

		Socket socket = null;

		String num = "";

		try {

			listener = new ServerSocket(9999); // 서버 소켓 생성

			socket = listener.accept(); // 클라이언트로부터 연결 요청 대기

			System.out.println("연결됨");

			in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 클라이언트로부터의 입력 스트림

			stin = new BufferedReader(new InputStreamReader(System.in)); // 키보드로부터의 입력 스트림

			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // 클라이언트로의 출력 스트림

			String inputMessage;

			while (true) {

				inputMessage = in.readLine(); // 클라이언트에서 한 행의 문자열 읽음

				for (int i = 0; i < inputMessage.length(); i++) {
					char ch = inputMessage.charAt(i);

					if (ch == '+' || ch == '-' || ch == '*') {
						numList.add(Integer.parseInt(num));
						operaterList.add(ch); // 연산자를 연산자배열에 추가
						num = ""; // 임시로 저장된 숫자를 비워준다
						continue; // 제일 가까운 명령문으로 이동
					}
					num += ch; // 연산자 앞까지의 숫자를 임시로 넣어 놓음
				}
				numList.add(Integer.parseInt(num)); // 마지막 숫자

				while (!operaterList.isEmpty()) { // 연산자배열이 빌 때까지
					int prevNum = numList.poll(); // poll : 앞부터 완전히 뺀다
					int nextNum = numList.poll();
					char op = operaterList.poll();

					if (op == '+') {
						numList.addFirst(prevNum + nextNum); // addFirst 배열 제일 앞에 넣는다
					} else if (op == '-') {
						numList.addFirst(prevNum - nextNum);
					} else if (op == '*') {
						numList.addFirst(prevNum * nextNum);
					} else if (op == '/') {
						numList.addFirst(prevNum / nextNum);
					}
				}
				
				System.out.println(numList.poll());

				if (inputMessage.equalsIgnoreCase("bye")) { // 클라이언트가 "bye"를 보내면 연결 종료

					System.out.println("안뇽");

					break;

				}

				System.out.println(inputMessage); // 클라이언트가 보낸 메시지 화면에 출력

				String outputMessage = stin.readLine(); // 키보드에서 한 행의 문자열 읽음

				out.write("서버>" + outputMessage + "\n"); // 키보드에서 읽은 문자열 전송

				out.flush();

			}

		} catch (

		IOException e) {

			System.out.println(e.getMessage());

		} finally {// try문을 빠져나가면 실행됨.

			try {

				socket.close(); // 클라이언트와 통신용 소켓 닫기

				listener.close(); // 서버 소켓 닫기

			} catch (IOException e) {

				System.out.println("클라이언트와 채팅 중 오류가 발생했습니다.");

			}

		}

	}

}
