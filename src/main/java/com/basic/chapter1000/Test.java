package com.basic.chapter1000;

import java.awt.*;
public class Test{
    public static void main(String args[]){
		Frame f = new Frame("Java Gui");
		f.setLayout(null);
		Button b = new Button("Button1");
		f.add(b);
		b.setLocation(47,70);
		b.setSize(60,25);
		f.setSize(150,150);
		f.setBackground(new Color(90,145,145,200));
		f.setVisible(true);
	}	
} 

