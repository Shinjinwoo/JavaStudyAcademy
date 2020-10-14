
public class MyStudent_Set {
	private String name;
	private int age;
	
	public MyStudent_Set() {
		this("이순신",23);
	}
	public MyStudent_Set(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;		
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;		
	}
	public void setAge(int age) {
		this.age =age;
	}
	public String toString() {
		return "이름은 " + name +" ,나이는 " +age +"살 입니다.";
	}	
}
