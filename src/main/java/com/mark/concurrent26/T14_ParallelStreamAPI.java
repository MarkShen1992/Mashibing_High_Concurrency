package com.mark.concurrent26;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * ForkJoin非常经典的算法
 * 
 * @author MarkShen
 *
 */
public class T14_ParallelStreamAPI {
	public static void main(String[] args) throws InterruptedException, IOException {
		List<Integer> nums = new ArrayList<Integer>();
		Random r = new Random();
		for (int i=0; i<10000; i++)
			nums.add(1000000 + r.nextInt(1000000));
		
		System.out.println(nums);
		
		long start = System.currentTimeMillis();
		nums.forEach(v->isPrime(v));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		
		start = System.currentTimeMillis();
		nums.forEach(v->isPrime(v));
		end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	static boolean isPrime(int num) {
		for (int i = 2; i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}