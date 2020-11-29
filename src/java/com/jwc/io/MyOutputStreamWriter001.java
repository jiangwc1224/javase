package java.com.jwc.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MyOutputStreamWriter001 {
    public static void main(String[] args) {
        File file = new File("E:\\test\\bbb.txt");
        OutputStream out = null;
        OutputStreamWriter outwriter = null;

        try {
            out = new FileOutputStream(file);
            outwriter = new OutputStreamWriter(out);

            char[] c = new char[1024];
            for (int i = 0; i < c.length; i++) {
                c[i] = (char) i;
            }

            outwriter.write(99);
            outwriter.write("abc");
            outwriter.write("江伟晨");
            outwriter.write(c);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                outwriter.close();
                out.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
