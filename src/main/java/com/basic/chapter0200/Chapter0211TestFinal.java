package com.basic.chapter0200;

public class Chapter0211TestFinal {
	public static void main(String[] args) {
		T t = new T();
		//t.i = 8;
	}
}

final class T {
	final int i = 8;
	public final void m() {
		//j = 9;
	}
}

/**
 * T 是被 final 修饰的类， 不可以被继承
 */
//class TT extends T {
//
//}