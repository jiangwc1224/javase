package com.jwc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MyInputStream002 {
    public static void main(String[] args) {
        File file = new File("E:\\test\\aaa.txt");
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            int length = 0;
            byte[] b = new byte[100];
            while ((length = is.read(b)) != -1) {
                System.out.println(new String(b));
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
