package com.basic.chapter1000;

import java.awt.*;
import java.awt.event.*;

public class TestWindowClose {
    public static void main(String args[]) {
        new MyFrame55("MyFrame");
    }
}

class MyFrame55 extends Frame {
    MyFrame55(String s) {
        super(s);
        setLayout(null);
        setBounds(300, 300, 400, 300);
        this.setBackground(new Color(204, 204, 255));
        setVisible(true);
        //this.addWindowListener(new MyWindowMonitor());

        this.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        setVisible(false);
                        System.exit(-1);
                    }
                });

    }
  /*
  class MyWindowMonitor extends WindowAdapter {
  	public void windowClosing(WindowEvent e) {
  		setVisible(false);
  		System.exit(0);
  	}
  }
  */
}
