package echo.ex03;

public class ThreadApp {

	public static void main(String[] args) {
		// 1.3 TCP 소켓 프로그래밍 - 서버, 서버소켓 만들기-3
		//멀티 스레드 구현하기
		//각각의 스레드가 각자 할일을 함.
		
		// (1). Thread라는 클래스를 사용하는 방법
		//메인 클래스와 별도의 스레드 클래스를 만듬.
		//start();를 하면 클래스의 run()메소드가 같이 작업됨.
		Thread thread = new DigitThread();
		thread.start();// run() 메소드를 별도로 실행 해라.
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.println(ch);			
			try {
				Thread.sleep(1000);//약 1초정도 딜레이
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		// (2). Runnable이라는 인터페이스를 사용하는 방법
		
				

	}

}
