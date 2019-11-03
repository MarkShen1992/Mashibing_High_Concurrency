package com.basic.chapter0100;

/**
 * switch
 * @author MarkShen1992
 * @since 20191103
 */
public class Chapter0111TestSwitch {
	public static void main(String[] args) {
		int i = 8;
		switch(i) {
			// 多个case可以合并到一起
			case 8 :
			case 3 :
			case 2 :
				System.out.println("C");
				break;
			case 9 :
				System.out.println("D");
				break;
			default: // default 可以省略，但是不建议
				System.out.println("error");
		}

		// JDK7 new feature 语法
		String condition = "abc";
		switch(condition) {
			case "abcd" :
				System.out.println("abcd");
				break; // 不加break，会产生case穿透问题
			case "abc" :
				System.out.println("abc");
				break;
			default:
				System.out.println("1234");
		}
	}
}