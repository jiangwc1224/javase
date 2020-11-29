package java.com.jwc.io;

import java.io.*;

public class MyInputStream001 {
    public static void main(String[] args) {
        File file = new File("E:\\test\\aaa.txt");
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            int read = 0;
            while ((read = is.read()) != -1) {
                System.out.println((char) read);
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
