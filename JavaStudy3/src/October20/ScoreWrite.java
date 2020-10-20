package October20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

//열명의 시험점수를 입력받아 파일에 저장하는 예제
public class ScoreWrite {
	public static void main(String[] args) {
		int count = 1;//몇 번 입력했는지를 카운터 하는 변수
		String scoreData = "";
		String s = null;
		File file = new File("ScoreData.txt");
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter out = new PrintWriter(new FileWriter(file, false));
			//false 는 덮어쓰기,true는 새로 만들기

			do {
				System.out.println(count + "번째 점수를 입력하세요");
				s = in.readLine();
				if (isRealNumber(s)) {//입력한 데이터가 숫자인지를 체크
					if (count != 10) {
						scoreData += s + " , ";
					} else {
						scoreData += s;
					}
					count++;
				} else {
					System.out.println("숫자만 입력 가능합니다.");
				}
			} while (count <= 10);

			out.println(scoreData);
			in.close();
			out.close();
		} catch (IOException e) {
			System.out.println("IOException");
		}
		System.out.println("시험점수를 파일로 출력합니다.");
	}

	//입력 받은 데이터가 숫자인지 체크하는 메소드
	public static boolean isRealNumber(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
