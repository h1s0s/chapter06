package echo.ex05;

public class DigitRunableImpl implements Runnable {

	public void run() {
		for (int cnt=0; cnt<10; cnt++) {
			System.out.println(cnt);
		}
	}
	
}
