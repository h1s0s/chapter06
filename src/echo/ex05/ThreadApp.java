package echo.ex05;

public class ThreadApp {

	public static void main(String[] args) throws InterruptedException {
		// 1.3 TCP 소켓 프로그래밍 - 서버, 서버소켓 만들기-3
		//멀티 스레드 구현하기
		//각각의 스레드가 각자 할일을 함.
		
		// (2). Runnable이라는 인터페이스를 사용하는 방법
		// 자바에서는 부모를 둘이상 둘 수 없음.
		// 그경우 인터페이스를 활용한다.
		//생성자가 조금 다르니 참고
		Thread thread = new Thread(new DigitRunableImpl());
		//↑아래의 코드가 한줄로 요약된 것.
		//Runnable digit = new DigitRunableImp();
		//Thread thread1 = new Thread(digit);
		thread.start();
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.println(ch);
			Thread.sleep(1000);
		}
		

	}

}
