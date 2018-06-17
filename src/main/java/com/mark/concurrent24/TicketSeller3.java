package com.mark.concurrent24;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 有n张火车票，每张票都有一编号
 * 同时有10个窗口在对外售票
 * 写一个模拟程序
 * 
 * 分析下面程序可能产生那些问题?
 * 重复销售， 超量销售
 * @author 18009
 *
 */
public class TicketSeller3 {
	static List<String> tickets = new ArrayList<String>();
	
	static {
		for (int i=0; i<10000; i++) tickets.add("票编号:" + i);
	}
	
	public static void main(String[] args) {
		for (int i=0; i<10; i++) {
			new Thread(() -> {
				while (true) {
					synchronized(tickets) {
						if (tickets.size() < 0) {
							break;
						}
						
						try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("销售了--" + tickets.remove(0));
					}
				}
			}).start();
		}
	}
}