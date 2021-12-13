package echo.ex06;

public class LowerImpl implements Runnable {
	
	public void run(){
		for (char ch = 'Z'; ch >='A'; ch--) {
			System.out.println(ch);			
			try {
				Thread.sleep(1000);//약 1초정도 딜레이
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
