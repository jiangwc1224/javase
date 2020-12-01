package com.jwc.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MyBufferedWriter001 {
    public static void main(String[] args) {
        File file = new File("E:\\test\\buffered.txt");
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        char[] cbuf = "江伟晨test".toCharArray();
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(99);
            bufferedWriter.newLine();
            bufferedWriter.append((char) 98);
            bufferedWriter.newLine();
            bufferedWriter.write(cbuf);
            bufferedWriter.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                fileWriter.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


    }
}
