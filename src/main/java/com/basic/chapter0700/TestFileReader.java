package com.basic.chapter0700;

import java.io.*;
public class TestFileReader {
  public static void main(String[] args) {
    FileReader fr = null; 
    int c = 0;
    try {
      fr = new FileReader("d:\\share\\java\\io\\TestFileReader.java");
      int ln = 0;
      while ((c = fr.read()) != -1) {
        //char ch = (char) fr.read();
        System.out.print((char)c);
        //if (++ln >= 100) { System.out.println(); ln = 0;}
      }
      fr.close();
    } catch (FileNotFoundException e) {
      System.out.println("找不到指定文件");
    } catch (IOException e) {
      System.out.println("文件读取错误");
    }

  }
}