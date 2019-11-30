package com.basic.chapter1000;

import java.awt.*;

public class AWTDrawing {
    private Frame f = new Frame(" Hello Out There!");
    private Panel p = new Panel();
	public void launchFrame() {
	    f.add(p);
	    f.setSize( 170,170);
	    f.setBackground( Color.blue);
	    f.setVisible( true); 
	    p.setForeground(Color.red);
	    Graphics g = p.getGraphics();
	    g.drawArc(30,40,50,60,70,80);
	    g.fillArc(30,40,50,60,70,80);
	}
	public static void main( String args[]) {
	    AWTDrawing guiWindow = new AWTDrawing();
	    guiWindow.launchFrame();
    }
}