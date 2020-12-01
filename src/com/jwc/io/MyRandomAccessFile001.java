package com.jwc.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class MyRandomAccessFile001 {
    public static void main(String[] args) {
        File file = new File("E:\\test\\doc.txt");
        // 文件长度
        long totalLength = file.length();
        // 分块长度
        int blockLength = 1024;
        // 分块数量
        int blockCount = (int) (Math.ceil(totalLength * 1.0 / blockLength));

        int begin = 0;
        int actualLength = 0;

        for (int i = 0; i < blockCount; i++) {
            begin = i * blockLength;

            if (i == blockCount - 1) {
                actualLength = (int) totalLength - i * blockLength;
            } else {
                actualLength = blockLength;
            }

            System.out.println("当前分块数：" + i + "起始位置：" + begin + "读取长度：" + actualLength);
            readBlock(file, begin, actualLength);
        }

    }

    public static void readBlock(File file, int begin, int actualLength) {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            byte[] buff = new byte[1024];
            randomAccessFile.seek(begin);
            int length = 0;
            while ((length = randomAccessFile.read(buff)) != -1) {
                if (actualLength > length) {
                    System.out.println(new String(buff, 0, length));
                    actualLength -= length;
                } else {
                    System.out.println(new String(buff, 0, actualLength));
                    break;
                }
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                randomAccessFile.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


}
