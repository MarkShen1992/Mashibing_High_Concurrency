package com.basic.chapter0400;

public class Chapter0402TestArgs {
    public static void main(String[] args) {
		/*
		for(int i=0; i<args.length; i++) {
			System.out.println(args[i]);
		}
		
		System.out.println("Usage: java Test \"n1\" \"op\" \"n2\"");
        */
        if (args.length < 3) {
            System.out.println(
                    "Usage: java Test \"n1\" \"op\" \"n2\"");
            System.exit(-1); // 系统非正常退出
        }
        // 基础类型的包装类
        double d1 = Double.parseDouble(args[0]);
        double d2 = Double.parseDouble(args[2]);
        double d = 0;
        if (args[1].equals("+")) d = d1 + d2;
        else if (args[1].equals("-")) d = d1 - d2;
        else if (args[1].equals("x")) d = d1 * d2;
        else if (args[1].equals("/")) d = d1 / d2;
        else {
            System.out.println("Error operator!");
            System.exit(-1);
        }
        System.out.println(d);
    }
}