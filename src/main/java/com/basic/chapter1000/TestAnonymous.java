package com.basic.chapter1000;/*	�������ƣ����������¼������е�ʹ��
 * 	Դ�ļ����ƣ�TestAnonymous.java
 *	Ҫ  �㣺
 *  	1. ����������ʺ��÷�
 *		2. ���������ඨ��Ϊ������ĺô�----
 *		   ���ڲ���Ļ����Ͻ�һ�����˴���
 */

import java.awt.*;
import java.awt.event.*;
public class TestAnonymous {
	Frame f = new Frame("�����ڲ������");
	TextField tf = new TextField(30);
	public TestAnonymous(){
		f.add(new Label("�밴�����������϶�"), "North");
		f.add(tf, "South");
		f.addMouseMotionListener(
			new MouseMotionAdapter(){
				public void mouseDragged(MouseEvent e) {
			    String s = "����϶���λ�ã�" + e.getX() + "," + e.getY() + ")";
			    tf.setText(s);
				}	
				public void mouseMoved(MouseEvent e) { }		
			}
			);
		f.setSize(300, 200);	    	
		f.setVisible(true);
	}
	public static void main(String args[]) {   	
		TestAnonymous t = new TestAnonymous();
	}
}