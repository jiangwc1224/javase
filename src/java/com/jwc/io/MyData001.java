package java.com.jwc.io;

import java.io.*;

public class MyData001 {
    public static void main(String[] args) {
        File file = new File("E:\\test\\data.txt");
        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;
        DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = null;

        try {
            // 写入
            fileOutputStream = new FileOutputStream(file);
            dataOutputStream = new DataOutputStream(fileOutputStream);

            dataOutputStream.writeInt(99);
            dataOutputStream.writeBoolean(false);
            dataOutputStream.writeChar(99);
            dataOutputStream.writeUTF("��ΰ��");
            dataOutputStream.writeDouble(3.14);

            // 读取
            fileInputStream = new FileInputStream(file);
            dataInputStream = new DataInputStream(fileInputStream);

            System.out.println(dataInputStream.readInt());
            System.out.println(dataInputStream.readBoolean());
            System.out.println(dataInputStream.readChar());
            System.out.println(dataInputStream.readUTF());
            System.out.println(dataInputStream.readDouble());

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                dataInputStream.close();
                fileInputStream.close();
                dataOutputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
