package com.jwc.net.server;

import java.net.ServerSocket;
import java.net.Socket;

public class UserServerThread {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8086);

        while (true) {
            Socket server = serverSocket.accept();
            Thread thread = new Thread(new UserThread(server));
            thread.start();
        }
    }
}
