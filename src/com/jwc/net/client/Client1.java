package com.jwc.net.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1 {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket = new Socket("localhost", 8086);
        OutputStream out = socket.getOutputStream();
        DataOutputStream outStream = new DataOutputStream(out);

        for (int i = 0; i < 100; i++) {

            byte[] buf = "i am client".getBytes();
            outStream.write(buf);
        }

        outStream.close();
        out.close();
        socket.close();
    }
}
