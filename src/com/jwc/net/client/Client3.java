package com.jwc.net.client;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client3 {
    public static void main(String[] args) throws UnknownHostException, IOException {
        FileInputStream filein = new FileInputStream("E:\\test\\m3.jpg");

        Socket client = new Socket("localhost", 8086);
        OutputStream out = client.getOutputStream();

        int length = 0;
        byte[] buffer = new byte[1024];
        while ((length = filein.read(buffer)) != -1) {
            out.write(buffer);
        }

        out.close();
        client.close();
        filein.close();
    }
}
