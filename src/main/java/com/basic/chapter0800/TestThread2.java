package com.basic.chapter0800;

public class TestThread2 {
	public static void main(String args[]) {
		Runner2 r = new Runner2();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t1.start();
		t2.start();
	}
}

class Runner2 implements Runnable {
	public void run() {
		for(int i=0; i<30; i++) {	
			System.out.println("No. " + i);
		}
	}
}
