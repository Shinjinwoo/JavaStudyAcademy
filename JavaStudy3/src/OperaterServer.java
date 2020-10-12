import java.io.*;

import java.net.*;

public class OperaterServer {
		public static void main(String[] args) {

			BufferedReader in = null;

			BufferedReader stin = null;

			BufferedWriter out = null;

			ServerSocket listener = null;

			Socket socket = null;

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

					if (inputMessage.equalsIgnoreCase("bye")){ // Ŭ���̾�Ʈ�� "bye"�� ������ ���� ����

						System.out.println("�ȴ�");

						break;

					}

					System.out.println(inputMessage); // Ŭ���̾�Ʈ�� ���� �޽��� ȭ�鿡 ���

					String outputMessage = stin.readLine(); // Ű���忡�� �� ���� ���ڿ� ����

					out.write("����>" + outputMessage+"\n"); // Ű���忡�� ���� ���ڿ� ����

					out.flush();

				}

			} catch (IOException e) {

				System.out.println(e.getMessage());

			} finally {//try���� ���������� �����.

				try {

					socket.close(); // Ŭ���̾�Ʈ�� ��ſ� ���� �ݱ�

					listener.close(); // ���� ���� �ݱ�

				} catch (IOException e) {

					System.out.println("Ŭ���̾�Ʈ�� ä�� �� ������ �߻��߽��ϴ�.");

				}

			}

		}

	}
