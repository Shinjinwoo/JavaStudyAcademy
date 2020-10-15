import java.util.*;

public class ProductTest_ArrayList {
	public void getProductTest_set(List list) {
		ProductArrayList prod = null;
		String code = null;
		String name = null;
		String color = null;
		int qty = 0;

		for (int i = 0; i < list.size(); i++) {
			prod = (ProductArrayList) list.get(i);

			code = prod.getCode();
			name = prod.getName();
			color = prod.getColor();
			qty = prod.getQty();

			System.out.println("제품번호 = " + code);
			System.out.println("제품이름 = " + name);
			System.out.println("제품색상 = " + color);
			System.out.println("제품수량 = " + qty);

		}
		

	}
	
	public static void main(String[] args) {
		ArrayList pList = new ArrayList();
		ProductArrayList p1 = new ProductArrayList();
		ProductArrayList p2 = new ProductArrayList("0002","스마트TV","흰색",200);
		ProductArrayList p3 = new ProductArrayList("0003","노트북","은색",100);
		pList.add(p1);
		pList.add(p2);
		pList.add(p3);
		
		ProductTest_ArrayList p = new ProductTest_ArrayList();
		
		p.getProductTest_set(pList);

	}

}
