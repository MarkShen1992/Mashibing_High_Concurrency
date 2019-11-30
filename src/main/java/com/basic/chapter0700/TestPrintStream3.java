package com.basic.chapter0700;

import java.util.*;
import java.io.*;
public class TestPrintStream3 {
  public static void main(String[] args) {
    String s = null;
    BufferedReader br = new BufferedReader(
                        new InputStreamReader(System.in));
    try {
      FileWriter fw = new FileWriter
                           ("d:\\bak\\logfile.log", true); //Log4J
      PrintWriter log = new PrintWriter(fw);
      while ((s = br.readLine())!=null) {
        if(s.equalsIgnoreCase("exit")) break;
        System.out.println(s.toUpperCase());
        log.println("-----");
        log.println(s.toUpperCase()); 
        log.flush();
      }
      log.println("==="+new Date()+"==="); 
      log.flush();
      log.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}