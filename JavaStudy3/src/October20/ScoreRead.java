package October20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ScoreRead {
	public static void main(String[] args) {
		int totalScore = 0;
		int count = 0;
		float average = 0.0f;
		File file = new File("scoreData.txt");
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String s;
			s = in.readLine();
			if (s != null) {
				System.out.println("시험점수: " + s);
				StringTokenizer st = new StringTokenizer(s, " , ");
				while (st.hasMoreTokens()) {
					totalScore += Integer.parseInt(st.nextToken());
					count++;
				}
				/**<StringTokenizer클래스>
				 * 문자열을 지정된 구분자(Delimiter) 단위로 끊어주며,
				 * 그렇게 형성된 단위를 순차적으로 출력하는 기능을 제공한다.
				 *  이 기능은 주로 형식을 가진 문서를 파싱(Parsing) 하는 경우에 많은 도움을 준다.
				 *  생성자의 인수로 대상 문자열과 구분자를 전달하게 되는데,
				 *  필요한 경우 여러 종류의 구분자를 전달하는 것도 가능하다.
				 *  <hasMoreTokens 메서드>
				 *  반환할 토큰(문자열을 구분 기준에 따라 분리한 문자 덩어리 각각)이
				 *  남아있는지를 검사하여 boolean 값을 반환하는 메서드로
				 *  while 반복문을 반복시키는 조건으로 삼았다.
				 *  <nextToken 메서드>
				 *  반복 없이 한 번만 호출되는데, 인수로 "()"를 전달하였다. 
				 *  이렇게 인수를 전달하게 되면, 
				 *  지정한 구분 문자 외에 또 다른 구분 문자로 인식되어 토큰 생성의 기준이 되며,
				 *  결과에서 볼 수 있듯이 아무것도 나오지 않는다.*/
				System.out.println("총점: " + totalScore);
				System.out.println("시험 본 사람: " + count + " 명");

				average = (float) totalScore / count;
				System.out.println("시험 평균: "+average);
			}
			in.close();
		} catch (FileNotFoundException e1) {
			System.out.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
