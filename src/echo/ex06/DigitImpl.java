package echo.ex06;

public class DigitImpl implements Runnable {

	public void run() {
		for (int cnt=0; cnt<10; cnt++) {
			System.out.println(cnt);
		}
	}
	
}
