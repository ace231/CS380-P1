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
		String msg = "";
		
		try(Socket socket = new Socket("18.221.102.182", 38001)) {
		
			// Checking that connection went through
			String address = socket.getInetAddress().getHostAddress();
			System.out.printf("Connected to %s%n", address);
			
			// Creating client input stream to receive messages from server	
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			
			// Creating client output stream to send messages to server
			OutputStream os = socket.getOutputStream();
			PrintStream out = new PrintStream(os, true, "UTF-8");
			
			// Asking user to input username
			System.out.print("Username: ");
			String uName = kb.readLine();
			out.printf("%s%n", uName);	// Sending name to server
			
			// Loop handles new messages from client to server and from
			// server to client
			while(true) {
				System.out.print("Message: ");
				uName = kb.readLine();
				out.printf("%s%n", uName);
				System.out.println(br.readLine());
			}
		}// End or try
	}// End of main
}