
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public final class EchoServer {

    public static void main(String[] args) throws Exception {

	System.setProperty("http.proxyHost", "127.0.0.1");
        System.setProperty("http.proxyPort", "22222");
        
        String address = ""; 

        try (ServerSocket serverSocket = new ServerSocket(22222)) {
            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    address = socket.getInetAddress().getHostAddress();
                    System.out.printf("Client connected: %s%n", address);
                    
                    
                    InputStream is = socket.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is, "UTF-8");
                    BufferedReader br = new BufferedReader(isr);
                    
                    OutputStream os = socket.getOutputStream();
                    PrintStream out = new PrintStream(os, true, "UTF-8");
                   
                     while (socket.isConnected()) {
                    	out.println(br.readLine());
                    }

			
			
                }
                catch (Exception d) {
                	System.out.printf("Client disconnected: %s%n", address);
                }
            }
        }
        catch (Exception e) {
        	
        }
    }
}