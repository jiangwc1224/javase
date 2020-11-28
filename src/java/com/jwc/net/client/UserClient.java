package java.com.jwc.net.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UserClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("localhost",8086);
		OutputStream outputStream  = client.getOutputStream();
		
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String username = sc.nextLine();	
		System.out.println("请输入密码：");
		String password = sc.nextLine();
		
		objectOutputStream.writeObject(new User(username,password));
		
		client.shutdownOutput();
		DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
		String result = dataInputStream.readUTF();
		System.out.println(result);
		
		dataInputStream.close();
		objectOutputStream.close();
		outputStream.close();
		client.close();
		
	}
}
