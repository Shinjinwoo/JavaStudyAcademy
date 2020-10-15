class Counter {//Counter 정의
	private int value = 0;

	public synchronized void increment() {
		value++;
	}//synchronized:공유데이터를 조작하는 메소드앞에 붙여 사용
	//출력에 영향:가끔1이 나오긴 하지만 다시 0이출력
	//가끔1이 나오는 이유는 하나의 스레드가 출력하기 직전에 다른스레드가 1로 증가 시켰기때문
	//즉!!! 증가된값 1이 출력되는것,다시 0으로 감소

	public synchronized void decrement() {
		value--;
	}

	public synchronized void printCounter() {
		System.out.println(value);
	}
}

class MyThre extends Thread {
	Counter shredCounter;//공유된 Counter객체의 참조값을 저장

	public MyThre (Counter c) {
		this.shredCounter = c;
	}

	public void run() {
		int i = 0;
		while (i < 20000) {
			shredCounter.increment();//증가
			shredCounter.decrement();//감소
			//증가했다가 감소시키기 때문에 카운터의 값은 변화가 없다.
			if (i % 40 == 0)
				shredCounter.printCounter();//가끔 카운터의 값을 출력하여 본다
			try {
				sleep((int) (Math.random() * 2));//난수 시간만큼 스레드를 중지
			} catch (InterruptedException e) {
			}
			i++;
		}
	}
}

public class CounterTest_Synchronization {
	public static void main(String[] args) {
		Counter c = new Counter();//공유 카운터 객체 생성
		new MyThre(c).start();//확실하게 잘못된결과를 내기 위해 스레드 4개 생성
		new MyThre(c).start();
		new MyThre(c).start();
		new MyThre(c).start();
	}//실제 싱행결과는 컴퓨터마다 달라진다. 중요한점!!은 잘못된결과가 나온다는점!!
}
/**1. 스레드에 대하여...

* processor는 사용자 눈에 보이지 않는 곳에서 다양한 프로그램들을 실행하고 있다.
* 자바에서도 processor를 통해서 처리한다.
* 메인스레드만 이용하면 대용량 데이터를 처리하는데 부담이 된다.
* 즉, 메인의 일을 별도의 processor로 처리해서 부담을 덜어줄 수 있다.

2. 스레드를 사용하는 이유
  
  1) 대량의 데이터를 분산 처리하기 위해
  2) 고용량 이미지를 가져올 때
  3) 인터넷에서 대용량 데이터를 가져올 때

* 스레드는 클래스가 아니라 메소드다
* public static void main(String[] args) {} -> 기본 스레드 (메인/ 주)

3. 스레드를 호출하는 방법

메서드를 포함하고 있는 클래스(인터페이스)는 Thread와 Runnable이 있다.
* Thread(클래스): Runnable 인터페이스를 구현받은(implements) 클래스
* Runnable (인터페이스) -> public void run(); 와 같이 정의되어 있다.
* Thread 클래스는 runnable 인터페이스를 구현 받았으므로  run 메소드를  구현해야 한다..
* run 메소드가 스레드이다.

    1) 스레드 객체를 만드는 방법
        Thread t = new Thread(); 
        t.start(); // start 메소드에 run 메소드가 포함되어 있음


    2) Thread 클래스를 상속받는 방법
         class T1 extends Thread 
         T1 t = new T1(); 
         t.start();

    3) 러너블을 구현받는 방법
        * 러너블에는 스타트 메소드가 없으므로 Thread 객체를 만들어야 한다.    
           class R implements Runnable
           R r = new R(); 
           Thread rt = new Thread(r);  
           rt.start();

4. Thread.class의 내부 구조 요약

public class Thread implements Runnable { 
           private String name; // thread 이름을 받는 필드명, 스레드 이름은 한글도 받을 수 있다. 
           public Thread(){  }     // 기본 생성자
           public Thread(String n){ 
                      name = n; 
            } 

           // Runnable 객체를 받는 생성자 
           public Thread(Runnable r){ 
           } 
        
           public static String currentThread(){ ~~ }; 

           public String getTname(){ 
                      return name; 
            }; 

           public start(){~~~}; 
}

* static 메소드: Thread.currentThread().getName() // 스레드 이름 반환

**/
/*정리

* start는 실제 스레드인 run스레드를 갖고 있음
* 메인 메소드는 별도로 존재하는 메소드
* 자바는 멀티스레드를 지원한다.
* 각 스레드마다 처리량은 jvm이 할당한다.
* 스레드 안에 스레드를 만들어서 사용할 수 있다.
* 메인스레드는 다른 스레드들을 start하고 잠깐 쉬게할 수 는 있지만 통제할 수는 없다.
    // Thread.sleep(100); // 0.1초 동안 스레드를 일정 시간 동안 대기상태로 둔다.
* Thread는 독립적이기 때문에 반드시 종료(자원해제)시켜야 한다.
* JDK1.6부터는 메인스레드가 종료(해제) 되면  다른 스레드도 다 자원해제 되도록 바뀜

*/
/**멀티 스레드의 특징
* 공유 자원을 접근할 때 동시에 작업을 진행하는 특성이 있다.
* 두 개의 스레드가 동시에 공유자원에 접근하면 문제가 발생한다.
* 예를 들어, 같은 계좌의 금액을 스레드들이 동시에 접근한다면 동기화가 유지되지 않은 입출금의 계산을 한다.

=> 그래서 동기화가 필요한 경우가 있다.

동기화의 정의
 예를 들어,  공항 출입국에 A, B, C 세 사람이 있다. 검색대가 3개 있을 경우에는 문제될 것이 없지만, 
 검색대가 하나 (공유 자원[Shared Resource]) 밖에 없을 경우에는,  한 사람이 사용하면 다른 사람들은  검색대을 밖에서 대기해야 한다.

동기화(Synchronization)란?
=> 줄서기(번갈아 가면서 순서대로 공유자원 사용하는 것) 
* synchronization 블록(자원을 사용할 때 자원에 Lock을 거는 방식) 
   wait()와 notify()

동기화(Synchronization)의 사용법

1) 메서드와 2) 블록 형태로 사용할 수 있다. 
* synchronized 메서드나 블록 내에서 사용되는 공유자원은 무조건 동기화가 보장. 
* synchronized 메서드로 사용될 경우 해당 메서드 내에서 사용되는 모든 멤버 변수들은 락(Lock)이 걸리게 된다. 

*/
