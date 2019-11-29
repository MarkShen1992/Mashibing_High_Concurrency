package com.basic.chapter0500;

import java.util.regex.*;
public class Chapter0504TestString {
	public static void main(String[] args) {
		
		//String s = "AaaaABBBBcc&^%adfsfdCCOOkk99876 _haHA";
		//int lCount = 0, uCount = 0, oCount = 0;
		/*
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c >= 'a' && c <= 'z') {
				lCount ++;
			} else if (c >='A' && c <= 'Z') {
				uCount ++;
			} else {
				oCount ++;
			}
		}
		*/
		/*
		String sL = "abcdefghijklmnopqrstuvwxyz";
		String sU = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(sL.indexOf(c) != -1) {
				lCount ++;
			} else if (sU.indexOf(c) != -1) {
				uCount ++;
			} else {
				oCount ++;
			}
		}
		*/
		
		/*
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(Character.isLowerCase(c)) {
				lCount ++;
			} else if (Character.isUpperCase(c)) {
				uCount ++;
			} else {
				oCount ++;
			}
		}
		
		System.out.println(lCount + " " + uCount + " " + oCount);
		*/
		String s = "sunjavahpjavaokjavajjavahahajavajavagoodjava";
		
		String sToFind = "java";
		int count = 0;
		int index = -1;
		
		while((index = s.indexOf(sToFind)) != -1) {
			s = s.substring(index + sToFind.length());
			count ++;
		}
		
		System.out.println(count);

	}
}