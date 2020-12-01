package com.jwc.io.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class MyBaiduTest001 {
    public static void main(String[] args) {
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        FileOutputStream fileOutputStream = null;

        File file = new File("E:\\test\\baiduIndexl.html");
        try {
            fileOutputStream = new FileOutputStream(file);

            inputStreamReader = new InputStreamReader(new URL("https://www.baidu.com/").openStream(), "utf-8");
            outputStreamWriter = new OutputStreamWriter(fileOutputStream);

            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            String readline = "";
            while ((readline = bufferedReader.readLine()) != null) {
                bufferedWriter.write(readline);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                bufferedReader.close();
                outputStreamWriter.close();
                inputStreamReader.close();
                fileOutputStream.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
