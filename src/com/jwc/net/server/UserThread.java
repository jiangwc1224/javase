package com.jwc.net.server;

import com.jwc.net.client.User;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class UserThread implements Runnable {

    Socket socket;

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public UserThread() {

    }

    public UserThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        ObjectInputStream objectInputStream = null;
        DataOutputStream dataOutputStream = null;
        try {
            inputStream = this.socket.getInputStream();

            objectInputStream = new ObjectInputStream(inputStream);

            User user = (User) objectInputStream.readObject();
            String ret = "";
            if ("jiangweichen".equals(user.getUsername()) && "921224".equals(user.getPassword())) {
                System.out.println("欢迎你   " + user.getUsername());
                ret = "登陆成功  ";
            } else {
                ret = "登陆失败，账号密码不对，请重新输入   ";
            }

            this.socket.shutdownInput();

            dataOutputStream = new DataOutputStream(this.socket.getOutputStream());
            dataOutputStream.writeUTF(ret);
            this.socket.shutdownOutput();


        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            try {
                dataOutputStream.close();
                objectInputStream.close();
                inputStream.close();
                this.socket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


    }

}
