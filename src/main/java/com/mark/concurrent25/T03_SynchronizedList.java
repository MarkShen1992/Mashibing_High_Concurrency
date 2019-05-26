package com.mark.concurrent25;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author MarkShen
 *
 */
public class T03_SynchronizedList {
	
	public static void main(String[] args) {
		List<String> strings = new ArrayList<String>();
		// 加锁的容器
		List<String> strsSync = Collections.synchronizedList(strings);
	}
}