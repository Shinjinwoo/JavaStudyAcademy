

class DeaMon extends Thread {
	public void run() {
		while (true) { //항상 참이기 때문에 무한으로 찍는다.
			System.out.println("안녕~~~");
			try {
				Thread.sleep(1000);//1초 기다림
			} catch (Exception e) {
			}
		}
	}
}

public class DaeMonTest {
	public static void main(String[] args) throws InterruptedException {
		DeaMon dm = new DeaMon();
		dm.setDaemon(true);
		//  데몬 스레드
		//- 다른 스레드의 작업을 돕는 스레드
		//- 동작중인 스레드가 없으면 자동 종료
		//- 임시저장, 가바지컬렉션이 대표적
		//- 생성법은 start()를 호출하기 전에 setDaemon(true)호출
		dm.start();
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			Thread.sleep(3000);//3초 기다림
		}
	}
}
/**<자바>Thread

1. 프로세스와 스레드
1) Process : CPU와 자원을 할당받아서 자신의 작업이 종료될 때까지
                   다른 프로세스에 제어권을 이동하지 않고
                   자원도 공유하지 않는 실행중인 프로그램
                   (예를 들어, 같은 파일의 PPT를 두번 열게 되면, 두번째 여는 PPT는 읽기 전용)

2) Thread : 프로세스 내에서 수행되는 작업 흐름.
                수행중에 다른 스레드에게 제어권 이동이 가능하고
                자원도 공유할 수 있음.
​**  종료조건이 없는 무한반복 - 스레드 이용

2. java에서 스레드
 1) java.lang 패키지 : Thread 클래스
                               Runnable 인터페이스
                               Thread Group
                               Thread Local
2) java.util.concurrent  패키지
 : 병행성 관련 클래스
 - 세마포어
 - 1.5버전에서 추가

3. Thread 클래스
1) 생성자
Thread()
Thread(String name)  //String name은 Thread이름,없으면 자기가 알아서 이름부여(Thread1, Thread2...) 
Thread(Runnable r)
Thread(Runnable r, String name)  //Runnable r 은  Thread 인터페이스 ,  String name은 Thread이름, 

2) 메소드 
① static void sleep(int msec) : 스레드 대기
② public void run() : 스레드로 수행할 내용   //return값이 없다, 어쩔수 없이 공유변수를 활용해야 한다.
③ public void start() : 스래드 시작
④ public void interrupt : 스레드에게  interrupt 익셉션 발생 시킴

4. Thread 생성
1) Thread클래스로 부터 상속 받아 생성
public class ThreadEx extends Thread{

public void run(){

//0.5초씩 쉬면서 10번 프린트

for(int i=0; i<10; t++){

try{

Thread.Sleep(500);

System.out.println(getName() + ":" + i);

}catch(Exception e){}
}
}
}

Main 실행
class MainEx{

public static void main(String[] args){

ThreadEx t1=new ThreadEx();

ThreadEx t2=new ThreadEx();

// run 일반메소드 바로 호출, 프로세스로 실행
//10초만에 실행 완료(t1객체의 일이 모두 끝나야  t2 객체의 일을 수행, 각 5초씩 걸림)

t1.run();

t2.run();
//start 스레드메소드 호출, 스레드로 실행
//5초만에 실행 완료, t1 객체일과 t2객체일을 번걸아 가면서 수행
//주의, 동시에 수행되는것은 아니다, 더 빨리 수행되는 것은 아니다.

t1.start():

t2.start();
}
}

2) Runnable  인터페이스를 implements 해서 생성
- 기존클래스가 다른 클래스로부터 상속받고 있을때 사용
-  Runnable  인터페이스는 run()메소드만 소유 
-  run() 재정의 해서 사용
-  이때,  Thread클래스  start(), getname()메소드를 사용할수 없다, 그래서
public class ThreadEx implements Runnable extends Calendar{

public void run(){

//0.5초씩 쉬면서 10번 프린트

for(int i=0; i<10; t++){

try{

Thread.Sleep(500);

System.out.println(getName() + ":" + i);

}catch(Exception e){}
}
}
}

Main 실행
class MainEx{

public static void main(String[] args){

ThreadEx t1=new ThreadEx();

ThreadEx t2=new ThreadEx();

//Thread 클래스 객체 생성, 
Thread th1=new Thread(t1);

th1.start();

Thread th2=new Thread(t2);

th2.start();
}
}

5. 스레드 상태 
​Thread 실행(new)  ---> 실행(Runnable) --> 종료(terminate),파기상태로 재시작 안된다.
  - 인터럽트 , 입출력할때 하드와 메모리 사이에서만 이루어지고 다 마치고 나면 cpu에게 결과만 알려준다.
  - 입출력 할때 횟수를 줄이는 것이 속도가 빨라진다.(BufferedReader)

​​6. 데몬 스레드
- 다른 스레드의 작업을 돕는 스레드
- 동작중인 스레드가 없으면 자동 종료
- 임시저장, 가바지컬렉션이 대표적
- 생성법은 start()를 호출하기 전에 setDaemon(true)호출​


데몬스레드(백그라운드 스레드)
public class ThreadEx extends Thread{

public void run(){

for(int i=0; i<10; t++){

try{

Thread.Sleep(1000); //10초

System.out.println("자동저장");

}catch(Exception e){}

}

}

}

Main 실행
class MainEx{

public static void main(String[] args){

ThreadEx t1=new ThreadEx();

​//start시작전에 데몬 먼저 호출

t1.setDemon(true);

t1.start();
try{ Thread.sleep(3000);

System.out.println("메인종료");

}  //데몬이 끝나면 t1도 종료 된다.

catch(Exception e){}


}

}


7. 우선순위(priority)
- 스레드 작업의 우선 순위를 설정하는 것
​- 실제로 우선순위대로 잘 작동을 안해서 사용 빈도는 낮다.
- setPriorty(우선순위) 
- 우선순위는 상수로 쓸것
   Thread.Max_PRIORTY  -->10
              NORMAL   -->5
              MIN     --->1
- 운영체제 마다 우선순위 범위가 다르기 때문에 
   final  상수를 사용한다.
- 윈도우 서버는 리눅스에 의해 안정성이 낮다.


8. 스레드 그룹은 
   운영체제마다 잘 작동이 되지 않는 경우가 있어 잘 사용하지 않는다.(pass)


​9. 스레드 생성시, Exception 처리
스레드 중지 시키고 싶다면 interrupt();메소드 사용하고,
 return 값 주자.
(스레드 종료시키는 다른 메소드는 권장하지 않고 있다.)
​

try{

}

catch(Interrupted Exception e){

---- return;

}


 
**/