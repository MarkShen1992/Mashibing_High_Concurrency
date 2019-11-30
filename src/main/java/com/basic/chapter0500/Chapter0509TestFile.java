package com.basic.chapter0500;

import java.io.File;
import java.io.IOException;

/**
 * File 测试
 *
 * @author MarkShen
 * @since 20191130
 */
public class Chapter0509TestFile {
    public static void main(String[] args) {
        // File仅仅是内存中的一个对象
        String separator = File.separator;
        String filename = "myfile.txt";
        String directory = "mydir1" + separator + "mydir2";
        //String directory = "mydir1/mydir2";

        // 不推荐这种写法
        //String directory = "mydir1\\mydir2";
        File f = new File(directory, filename);
        if (f.exists()) {
            System.out.println("文件名：" + f.getAbsolutePath());
            System.out.println("文件大小：" + f.length());
        } else {
            f.getParentFile().mkdirs();
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
