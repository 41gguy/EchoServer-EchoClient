import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerThread extends Thread{
	
	private Socket socket;
	String address; 
	InputStream is; 
	InputStreamReader isr; 
	BufferedReader br = null; 
	OutputStream os; 
	PrintStream out; 
	
	
	public EchoServerThread(Socket socket) {
		super("EchoServerThread");
		
		System.setProperty("http.proxyHost", "127.0.0.1");
        System.setProperty("http.proxyPort", "22222");
		
        
		this.socket = socket;
		
		try {
			address = socket.getInetAddress().getHostAddress();
		}
		catch (Exception b) {
			
		}
	}
	
	public void run() {
	
		if (socket.isClosed()) {
			System.out.println("Socket is closed");
		}
		
		
        
        try {
	            System.out.printf("Client connected: %s%n", address);
	            InputStream is = socket.getInputStream();
	            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
	            BufferedReader br = new BufferedReader(isr);
	            
	            OutputStream os = socket.getOutputStream();
	            PrintStream out = new PrintStream(os, true, "UTF-8");
	            
	            while (!socket.isClosed()) {
		        	out.println(br.readLine());
		        }
        }
        catch (Exception n) {
        	System.out.printf("Client disconnected: %s%n", address);
        }
        
         
	}
	
}
