
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public final class EchoClient2 extends Thread {
	
	
	Socket socket = null;
    	OutputStream os = null;
        PrintStream out = null;
        
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br2 = null;
        BufferedReader br = null;
	
	public static void main(String[] args) {


		try {
			new Thread(new EchoClient2()).start();
		}
		catch (Exception p) {
			System.out.println(p); 
		}

	}
	
    public void run() {

	System.setProperty("http.proxyHost", "127.0.0.1");
	System.setProperty("http.proxyPort", "22222");

	        try (Socket socket = new Socket("localhost", 22222)) {
	            OutputStream os = socket.getOutputStream();
	            PrintStream out = new PrintStream(os, true, "UTF-8");
	            
	            InputStream is = socket.getInputStream();
	            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
	            BufferedReader br2 = new BufferedReader(isr);
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	            
	            while (true) {
	    			 

					System.out.print("<Client> ");
	    				String chat = br.readLine();
	    				out.println(chat);

				

	    			if (chat.equalsIgnoreCase("exit")) {
	    				
	    				System.exit(0);
	    			}
	    	         	
	    	         	out.flush();
	    	         	
	    	         	System.out.print("<Server> ");
	    	         	System.out.println(br2.readLine());
	    	         	
	    	         }
	        }
	        catch (Exception e) {
	        	System.out.println(e); 
	        }
    }
}