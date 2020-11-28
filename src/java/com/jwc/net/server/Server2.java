package java.com.jwc.net.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(8086);
		Socket socket = serverSocket.accept();
		InputStream in = socket.getInputStream();
		DataInputStream datainput = new DataInputStream(in);
		
		byte[] buf = new byte[1024];

		int length =  datainput.read(buf);
		if(length!=-1) {
			System.out.println(new String(buf,0,length));
			
			OutputStream out = socket.getOutputStream();
			out.write("已收到,谢谢".getBytes());
			out.close();
		}

		datainput.close();
		in.close();
		socket.close();
		serverSocket.close();
	}
}
