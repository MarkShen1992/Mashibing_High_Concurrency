package com.basic.chapter0300;

import java.io.*;

/**
 * 异常处理
 *
 * @author MarkShen
 * @since 20191121
 */
public class Chapter0301TestEx {
    public static void main(String[] args) {
        try {
            new Chapter0301TestEx().f2();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		/*
		int[] arr = {1, 2, 3};
		System.out.println(arr[2]);
		try {
			System.out.println(2/0);
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
		*/

        //TestEx te = new TestEx();
        //te.m(0);
		
		/*
		try {
			new TestEx().m(0);
		} catch (ArithmeticException ae) {
			ae.printStackTrace();
		}
		*/

        FileInputStream in = null;
        try {
            in = new FileInputStream("myfile.txt");
            int b;
            b = in.read();
            while (b != -1) {
                System.out.print((char) b);
                b = in.read();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void m(int i) throws ArithmeticException {
        if (i == 0)
            throw new ArithmeticException("参数为0异常...");
    }

    void f() throws FileNotFoundException, IOException {
        FileInputStream in = new FileInputStream("myfile.txt");
        int b;
        b = in.read();
        while (b != -1) {
            System.out.print((char) b);
            b = in.read();
        }
    }

    void f2() throws IOException {
		/*
		try {
			f();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
        f();
    }
}