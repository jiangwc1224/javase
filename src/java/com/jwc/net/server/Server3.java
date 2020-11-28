package java.com.jwc.net.server;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server3 {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(8086);
		Socket server = serverSocket.accept();
		
		InputStream in = server.getInputStream();
		FileOutputStream fileout = new FileOutputStream("E:\\test\\m3server.jpg");
		int length = 0;
		byte[] buffer = new byte[1024];
		
		while((length=in.read(buffer))!=-1) {
			fileout.write(buffer);
		}
		
		fileout.close();
		in.close();
		server.close();
		serverSocket.close();
	}
}
