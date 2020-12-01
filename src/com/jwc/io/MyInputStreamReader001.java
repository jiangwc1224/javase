package com.jwc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MyInputStreamReader001 {
    public static void main(String[] args) {
        File file = new File("E:\\test\\aaa.txt");
        InputStream in = null;
        InputStreamReader inreader = null;

        try {
            in = new FileInputStream(file);
            inreader = new InputStreamReader(in);

            char[] cbuffer = new char[1024];

            while ((inreader.read(cbuffer)) != -1) {
                System.out.println(cbuffer);
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
