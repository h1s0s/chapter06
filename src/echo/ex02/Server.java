package echo.ex02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {//예외처리를 위한 경고문을 제거해줌.
		// 1.2 TCP 소켓 프로그래밍 - 서버, 서버소켓 만들기-2
		//소켓을 생성하고 나서도 서버가 꺼지지 않게
		
		//1. ~서버 소켓을 메모리에 올린다~
		//서버소켓:클라이언트의 연결요청을 기다리면서 연결 요청에 대한 수락을 담당한다.
		//소켓 : 클라이언트와 통신을 직접 담당한다.
		//
		//서버소켓 클래스가 이것들을 셋팅해주는 메소드를 가지고 있다.
		//
		//맥 아이피 얻는법 : 터미널에 ipconfig getifaddr en0
		ServerSocket serverSocket = new ServerSocket();
		
		//2. ~포트를 만든다(바인드)
		serverSocket.bind(new InetSocketAddress("172.30.1.51", 10001));
		//자신의 유동아이피번호, 포트번호10001(강사님이 정해주심)
		//bind() : 포트를 생성해줌.
		
		System.out.println("<서버시작>");
		System.out.println("================================");
		System.out.println("[연결을 기다리고 있습니다.]");
		
		//5. ~accept~ : connect가 오면 소켓을 만들어 줌
		Socket socket = serverSocket.accept();
		
		System.out.println("[클라이언트에 연결되었습니다]");
		
		//메세지를 받아주는 스트림
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		//메세지를 보내주는 스트림
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		//메세지 받기
		while(true) {
			String msg = br.readLine();
			if(msg == null) {
				System.out.println("클라이언트 종료키 입력");
				break;
			}
			System.out.println("받은메세지:"+msg);
			//메세지 보내기
			bw.write(msg);
			bw.newLine();
			bw.flush();
		}
		
		System.out.println("====================");
		System.out.println("<서버종료>");
		bw.close();
		socket.close();
		serverSocket.close();	
	}
}