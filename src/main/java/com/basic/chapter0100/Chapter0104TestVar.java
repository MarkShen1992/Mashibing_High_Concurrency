package com.basic.chapter0100;

/**
 * 敲程序方法：在看懂整个程序的意思后，背着把程序敲出来；
 * 或者有自己的理解后，自己组织程序结构完成程序。
 * @author MarkShen1992
 * @since 20191102
 */
public class Chapter0104TestVar {
	
	static int j;
	
	public void m() {
		int i = 0;
		System.out.println(i);
	}
	
	public static void main(String[] args) {
		int i = 0; 
		System.out.println(i);
		System.out.println(j);
		
		boolean b = false;
		if(b) {
			int c = 0;
			System.out.println("b is true");
		}
		
		// System.out.println(c);
		
		long longNum1 = 8888888888888L;
	}
}