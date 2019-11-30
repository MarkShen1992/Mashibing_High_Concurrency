package com.basic.chapter0700;

import java.io.*;

public class TTT {
	public static void main(String[] args) {
		listF(new File("d:/test"), 0);
	}
	
	public static void listF(File f, int level) {
		String preStr = "";
		for(int i=0; i<level; i++) preStr += "    ";
		System.out.println(preStr + f.getName());
		if(f.isDirectory()) {
			File[] files = f.listFiles();
			for(File cf : files) listF(cf, level + 1);
		}
	}
}