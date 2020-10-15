import java.util.*;

public class Search_Searching {
	public static void main(String [] args ) {
		int key = 50;
		List <Integer> list = new ArrayList<Integer>();
		for ( int i = 0; i < 100; i++)
			list.add(i);
		int index = Collections.binarySearch(list,key);
		// Collections 의 이진 탐색 ( binarySerach ) 알고리즘
		
		System.out.println("탐색의 반환값 = " + index);
		
		
	}

}
