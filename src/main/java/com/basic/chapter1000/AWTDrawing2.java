package com.basic.chapter1000;/*	�������ƣ�AWT ��ͼ����
 * 	Դ�ļ����ƣ�AWTDrawing2.java
 *	Ҫ  �㣺
 *		1. AWT�����ͼԭ��
 *		2. Graphics�༰���û�ͼ����
 */

import java.awt.*;

class SubPanel extends Panel{
	public void paint(Graphics g){
		g.drawString("this is a drawing test!",20,20);		
		g.drawLine(30,60,100,120);
		g.draw3DRect(60,50,70,30,false);
	}	
}
	
public class AWTDrawing2 {
    private Frame f = new Frame(" Hello Out There!");
    private SubPanel p = new SubPanel();
	public void launchFrame() {
	    f.add(p);
	    f.setSize(170,170);
	    f.setBackground( new Color(89,145,145));
	    f.setVisible( true); 
	}
	public static void main( String args[]) {
	    AWTDrawing2 guiWindow = new AWTDrawing2();
	    guiWindow.launchFrame();
    }
}