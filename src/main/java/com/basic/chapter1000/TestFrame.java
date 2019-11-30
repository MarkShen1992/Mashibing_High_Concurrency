package com.basic.chapter1000;/*	�������ƣ�Frame Ӧ�þ���
 * 	Դ�ļ����ƣ�TestFrame.java
 *	Ҫ  �㣺Frame����Ĵ�������ʾ����
 */

import java.awt.*;
public class TestFrame {
	public static void main( String args[]) {
		Frame f = new Frame("My First Test");
		f.setLocation(300, 300);
		f.setSize( 170,100);
		f.setBackground( Color.blue);
		f.setResizable(false);
		f.setVisible( true);
	}
}