import static java.lang.System.out;

class GenericEx1<T> {
	//클래스 옆에<T>로 가상의 자료형 명시 만약<T>를 붙이지 않는다면 변수 선언시에
	 //T와같은 가상의 자료형을 붙이는 것은 불가능하다. 따라서 가상의 자료형을 명시할 경우
	 //클래스명 옆에 <가상자료형명>을 입력해준다.

	T[] v;

	public void set(T[] n) {
		v = n;
	}

	public void print() {
		for (T s : v)
			out.println(s);
	}
	public static void main(String[] args) {
		new GenericEx1();
	}

}
/*<< 제너릭 >> 
 * 클래스에 사용할 타입을 클래스를 디자인할 때 지정하는 것이 아니라
 클래스를 사용할때 지정한 후 사용하는 기술을 말한다.

class Top{
 private Object data = null; //Object형의 Data 생성
 public void setData(Object data){ //setData가 Object Data값을 참조.
  this.data = data;
 }
 public Object getData(){
  return this.data;
 }
}


public class UserGenericMain {
 public static void main(String[] args) {
  String str = "Hello Object 방식";
  Top t = new Top(); //객체 생성
  t.setData(str); //setData는 Object data를 참조한다. 
               	//즉 Hello Object는 저장과 동시에 
               	//Top Class에서 Object형 변수로 선언이 되었기 때문에 
               	//Object형으로 자동적인 형변환을 하게 된다
  String str2 = (String)t.getData(); //하지만 getData로 출력시 Object Data형이 아닌
                                     //메인클래스의 String형으로 출력이 되야 하므로
                                     //다운캐스팅을 위해 강제형변환 
                                     //즉 명시적 형변환을 해줘야먄
                                     //getData해서 str2를 출력 가능하다.
                	          //제너릭 표현은 이런 수고를 조금더 줄여준다.
  System.out.println(str2);
 }
} 
*/
