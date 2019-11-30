package com.basic.chapter1000;

import java.awt.*;
import java.awt.event.*;

public class TestActionEvent {
    public static void main(String args[]) {
        Frame f = new Frame("Test");
        Button b = new Button("Press Me!");
        Monitor3 bh = new Monitor3();
        b.addActionListener(bh);
        f.add(b, BorderLayout.CENTER);
        f.pack();
        f.setVisible(true);
    }
}

class Monitor3 implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.out.println("a button has been pressed");
    }
}
