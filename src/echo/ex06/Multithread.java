package echo.ex06;

public class Multithread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread1 = new Thread(new DigitImpl());
		Thread thread2 = new Thread(new LowerImpl());
		Thread thread3 = new Thread(new UpperImpl());
		
		thread1.start();
		thread2.start();
		thread3.start();
	}

}
