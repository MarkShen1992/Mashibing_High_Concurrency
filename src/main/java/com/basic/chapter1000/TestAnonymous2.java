package com.basic.chapter1000;/*	�������ƣ����������¼������е�ʹ��
 * 	Դ�ļ����ƣ�TestAnonymous2.java
 *	Ҫ  �㣺
 *		1. ������ֻ�����ڲ���
 *		2. ����������ִ�����ʽ----�ȿ��Լ̳и��ࡢҲ���Ե���ʵ�ֽӿ�
 */

import java.awt.*;
import java.awt.event.*;

public class TestAnonymous2 {
	Frame f = new Frame("Test");
	TextField tf = new TextField(10);
	Button b1 = new Button("Start");
	
	public TestAnonymous2(){
		f.add(b1,"North");
		f.add(tf,"South");
		
		b1.addActionListener(new ActionListener(){
			private int i;
			public void actionPerformed(ActionEvent e) {
			 	tf.setText(e.getActionCommand() + ++i);    
			}
		});
		
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);	
			}	
		});
		
		f.pack();        	
		f.setVisible(true);		
	}	
	public static void main(String args[]) {
		new TestAnonymous2();
	}
}
