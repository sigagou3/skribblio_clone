import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private ServerSocket serverSocket;
	private Socket socket;
	
	public Server() {
		try {
			serverSocket = new ServerSocket(9090, 8, InetAddress.getByName("localhost"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
