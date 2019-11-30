package com.basic.chapter0800;

public class ProducerConsumer {
	public static void main(String[] args) {
		SyncStack ss = new SyncStack();
		Producer p = new Producer(ss);
		Consumer c = new Consumer(ss);
		new Thread(p).start();
		new Thread(p).start();
		new Thread(p).start();
		new Thread(c).start();
	}
}

class WoTou {
	int id; 
	WoTou(int id) {
		this.id = id;
	}
	public String toString() {
		return "WoTou : " + id;
	}
}

class SyncStack {
	int index = 0;
	WoTou[] arrWT = new WoTou[6];
	
	public synchronized void push(WoTou wt) {
		while(index == arrWT.length) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notifyAll();	// ���������ڸö����ϵ��߳�	
		arrWT[index] = wt;
		index ++;
	}
	
	public synchronized WoTou pop() {
		while(index == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notifyAll();
		index--;
		return arrWT[index];
	}
}

class Producer implements Runnable {
	SyncStack ss = null;
	Producer(SyncStack ss) {
		this.ss = ss;
	}
	
	public void run() {
		for(int i=0; i<20; i++) {
			WoTou wt = new WoTou(i);
			ss.push(wt);
System.out.println("�����ˣ�" + wt);
			try {
				Thread.sleep((int)(Math.random() * 200));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}
}

class Consumer implements Runnable {
	SyncStack ss = null;
	Consumer(SyncStack ss) {
		this.ss = ss;
	}
	
	public void run() {
		for(int i=0; i<20; i++) {
			WoTou wt = ss.pop();
System.out.println("������: " + wt);
			try {
				Thread.sleep((int)(Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}
}