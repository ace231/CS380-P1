/*****************************************
*	Alfredo Ceballos
*	CS 380 - Computer Networks
*	Project 1
*	Professor Nima Davarpanah
*****************************************/
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatClient {
	public static void main(String[] args) throws Exception{
		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try (Socket socket = new Socket("18.221.102.182", 1000)) {
				String address = socket.getInetAddress().getHostAddress();
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				System.out.println(br.readLine());
					
					OutputStream os = socket.getOutputStream();
					PrintStream out = new PrintStream(os, true, "UTF-8");
			} catch(Exception e) {
				System.out.println("Something went wrong...");
				e.printStackTrace();
			}		
		}
	}
}