package com.mark.concurrent18;

/**
 * 不要以字符串常量作为锁定对象
 * 在下面的例子中，m1和m2其实锁定的是同一对象
 * 这种情况还会发生比较诡异的现象，比如你用到一个类库，在该类库中代码锁定了字符串  "Hello"
 * 但是你都不到源码，所以你在自己源码中也锁定了 "Hello", 这时就会发生非常诡异的死锁阻塞，
 * 因为你的程序和使用到的类库不经意间使用了同一把锁
 * 
 * jetty open source software.
 * 
 * @author MarkShen
 */
public class T {
	
	String s1 = "Hello";
	String s2 = "Hello";
	
	void m1() {
		synchronized (s1) {
			
		}
	}
	
	void m2() {
		synchronized (s2) {
			
		}
	}
}