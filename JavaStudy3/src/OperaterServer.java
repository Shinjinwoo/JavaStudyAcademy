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

			listener = new ServerSocket(9999); // ���� ���� ����

			socket = listener.accept(); // Ŭ���̾�Ʈ�κ��� ���� ��û ���

			System.out.println("�����");

			in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Ŭ���̾�Ʈ�κ����� �Է� ��Ʈ��

			stin = new BufferedReader(new InputStreamReader(System.in)); // Ű����κ����� �Է� ��Ʈ��

			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // Ŭ���̾�Ʈ���� ��� ��Ʈ��

			String inputMessage;

			while (true) {

				inputMessage = in.readLine(); // Ŭ���̾�Ʈ���� �� ���� ���ڿ� ����

				for (int i = 0; i < inputMessage.length(); i++) {
					char ch = inputMessage.charAt(i);

					if (ch == '+' || ch == '-' || ch == '*') {
						numList.add(Integer.parseInt(num));
						operaterList.add(ch); // �����ڸ� �����ڹ迭�� �߰�
						num = ""; // �ӽ÷� ����� ���ڸ� ����ش�
						continue; // ���� ����� ��ɹ����� �̵�
					}
					num += ch; // ������ �ձ����� ���ڸ� �ӽ÷� �־� ����
				}
				numList.add(Integer.parseInt(num)); // ������ ����

				while (!operaterList.isEmpty()) { // �����ڹ迭�� �� ������
					int prevNum = numList.poll(); // poll : �պ��� ������ ����
					int nextNum = numList.poll();
					char op = operaterList.poll();

					if (op == '+') {
						numList.addFirst(prevNum + nextNum); // addFirst �迭 ���� �տ� �ִ´�
					} else if (op == '-') {
						numList.addFirst(prevNum - nextNum);
					} else if (op == '*') {
						numList.addFirst(prevNum * nextNum);
					} else if (op == '/') {
						numList.addFirst(prevNum / nextNum);
					}
				}
				
				System.out.println(numList.poll());

				if (inputMessage.equalsIgnoreCase("bye")) { // Ŭ���̾�Ʈ�� "bye"�� ������ ���� ����

					System.out.println("�ȴ�");

					break;

				}

				System.out.println(inputMessage); // Ŭ���̾�Ʈ�� ���� �޽��� ȭ�鿡 ���

				String outputMessage = stin.readLine(); // Ű���忡�� �� ���� ���ڿ� ����

				out.write("����>" + outputMessage + "\n"); // Ű���忡�� ���� ���ڿ� ����

				out.flush();

			}

		} catch (

		IOException e) {

			System.out.println(e.getMessage());

		} finally {// try���� ���������� �����.

			try {

				socket.close(); // Ŭ���̾�Ʈ�� ��ſ� ���� �ݱ�

				listener.close(); // ���� ���� �ݱ�

			} catch (IOException e) {

				System.out.println("Ŭ���̾�Ʈ�� ä�� �� ������ �߻��߽��ϴ�.");

			}

		}

	}

}
