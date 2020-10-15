import java.util.*;

public class LinkedListTest_List {
	public static void main(String[] args) {
		LinkedList<String> fruitList = new LinkedList<String>();
		fruitList.add("사과");//0번방 사과
		fruitList.add("바나나");//1번방 바나나
		fruitList.add("수박");//2번방 수박(사과,바나나,수박)
		fruitList.add(2,"망고");//2번방에 망고 추가 3번방 수박(사과,바나나,망고,수박)

		int position = fruitList.indexOf("수박");
		System.out.println("수박의 위치: " + position);
		fruitList.set(0, "오렌지");//0번방 오렌지 설정(오렌지,바나나,망고,수박)
		String fruitName = fruitList.get(0);//0번방 오렌지 얻기
		System.out.println("과일이름: " + fruitName);//0번방 오렌지
		fruitList.remove(1);//1번방 삭제(오렌지,망고,수박)
		fruitList.remove("수박");//수박 삭제(오렌지,망고)
		int size = fruitList.size();//size->0,1번방(2개)
		System.out.println("연결리스트 값 출력하기");

		for (int cnt = 0; cnt < size; cnt++) {//(오렌지,망고)
			fruitName = fruitList.get(cnt);
			System.out.println(fruitName);
		}
	}
}
