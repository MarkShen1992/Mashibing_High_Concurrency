package com.basic.chapter1000;/*	�������ƣ�PanelӦ�þ���
 * 	Դ�ļ����ƣ�TestFrameWithPanel.java
 *	Ҫ  �㣺
 *		1. Panel���������
 *		2. ����������ĸ���
 *		3. setSize��setBackground��setLayout��add��setVisible�ȳ��÷���
 */

import java.awt.*;

public class TestFrameWithPanel {
	public static void main(String args[]) {
		Frame f = new Frame("MyTest Frame");
		Panel pan = new Panel();
		f.setSize(200,200);
		f.setBackground(Color.blue);
		f.setLayout(null); // ȡ��Ĭ�ϲ��ֹ�����
		pan.setSize(100,100);
		pan.setBackground(Color.green);
		f.add(pan);
		f.setVisible(true);
	}
}