package com.jwc.net.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client2 {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket = new Socket("localhost", 8086);
        OutputStream out = socket.getOutputStream();
        DataOutputStream outStream = new DataOutputStream(out);

        byte[] buf = "已发送".getBytes();
        outStream.write(buf);

        InputStream in = socket.getInputStream();
        byte[] inbuf = new byte[1024];
        int length = 0;
        if ((length = in.read(inbuf)) != -1) {
            System.out.println(new String(inbuf, 0, length));
        }

        in.close();
        outStream.close();
        out.close();
        socket.close();
    }
}
