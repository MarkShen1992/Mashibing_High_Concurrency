package com.basic.chapter1000;/*	�������ƣ��ڲ������¼������е�ʹ��
 * 	Դ�ļ����ƣ�TestInner.java
 *	Ҫ  �㣺
 *  	1. �ڲ�������ʺ��÷�
 *		2. ���������ඨ��Ϊ��ͨ�ڲ���ĺô�----
 *		   �ڲ����п�ֱ�ӷ������������Ժͷ���
 */

import java.awt.*;
import java.awt.event.*;

public class TestInner {
	Frame f = new Frame("�ڲ������");
	TextField tf = new TextField(30);
	
	public TestInner(){
		f.add(new Label("�밴�����������϶�"), "North");
		f.add(tf, "South");
		f.setBackground(new Color(120,175,175));
		f.addMouseMotionListener(new InnerMonitor());
		f.addMouseListener(new InnerMonitor());
		f.setSize(300, 200);	    	
		f.setVisible(true);
	}
	
	public static void main(String args[]) {   	
		TestInner t = new TestInner();
	}
	
	private class InnerMonitor implements MouseMotionListener,MouseListener {
		public void mouseDragged(MouseEvent e) {
		    String s = "����϶���λ�ã�" + e.getX() + "," + e.getY() + ")";
		    tf.setText(s);
		}
		
		public void mouseEntered(MouseEvent e) {
		    String s = "����ѽ��봰��";
		    tf.setText(s);
		}
		
		public void mouseExited(MouseEvent e) {
		    String s = "������Ƴ�����";
		    tf.setText(s);
		}
		public void mouseMoved(MouseEvent e) { }
		public void mousePressed(MouseEvent e) { }
		public void mouseClicked(MouseEvent e) { }
		public void mouseReleased(MouseEvent e) { }
	}//end of Inner class
}//end of Outer class