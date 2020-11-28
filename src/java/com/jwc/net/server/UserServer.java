package java.com.jwc.net.server;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import net.client.User;

public class UserServer {
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(8086);

		while (true) {
			Socket server = serverSocket.accept();

			InputStream inputStream = server.getInputStream();

			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

			User user = (User) objectInputStream.readObject();
			String ret = "";
			if ("jiangweichen".equals(user.getUsername()) && "921224".equals(user.getPassword())) {
				System.out.println("欢迎你   " + user.getUsername());
				ret = "登陆成功  ";
			} else {
				ret = "登陆失败，账号密码不对，请重新输入   ";
			}

			server.shutdownInput();

			DataOutputStream dataOutputStream = new DataOutputStream(server.getOutputStream());
			dataOutputStream.writeUTF(ret);
			server.shutdownOutput();

			dataOutputStream.close();
			objectInputStream.close();
			inputStream.close();
			server.close();
		}
//		serverSocket.close();

	}
}
