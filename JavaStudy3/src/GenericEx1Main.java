
public class GenericEx1Main {
	public static void main (String [] args ) {
		GenericEx1<String> t = new GenericEx1<String>();
		
		
		String[] ss = {"Ye~" , "Ah~" , "Seo"};
		
		t.set(ss);
		
		t.print();
		
		GenericEx1 t1 = new GenericEx1(); // 좋은 방법이 아님
		Integer[] s = {1,2,3};
		t1.set(s);
		t1.print();
		
	}

}
