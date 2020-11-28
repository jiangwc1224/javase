package java.com.jwc.net.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(8086);
		Socket socket = serverSocket.accept();
		InputStream in = socket.getInputStream();
		DataInputStream datainput = new DataInputStream(in);
		
		byte[] buf = new byte[1024];
		int length = 0;
		 while((length = datainput.read(buf))!=-1) {
			 System.out.println(new String(buf,0,length));
		 }
		
		datainput.close();
		in.close();
		socket.close();
		serverSocket.close();
	}
}
