
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public final class EchoServer3 {

    public static void main(String[] args) throws Exception {

	System.setProperty("http.proxyHost", "127.0.0.1");
        System.setProperty("http.proxyPort", "22222");

        try (ServerSocket serverSocket = new ServerSocket(22222)) {
            while (true) {
            	new EchoServerThread(serverSocket.accept()).start();
            }
        }
        catch (Exception e) {
        	System.out.println("2");
        }
    }
}

