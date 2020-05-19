package com.basic.chapter1000;

import java.awt.*;
import java.awt.event.*;

public class TestAnonymous {
    Frame f = new Frame("Test Anonymous");
    TextField tf = new TextField(30);

    public TestAnonymous() {
        f.add(new Label("Mouse"), "North");
        f.add(tf, "South");
        f.addMouseMotionListener(
                new MouseMotionAdapter() {
                    public void mouseDragged(MouseEvent e) {
                        String s = "(" + e.getX() + "," + e.getY() + ")";
                        tf.setText(s);
                    }

                    public void mouseMoved(MouseEvent e) {
                    }
                }
        );
        f.setSize(300, 200);
        f.setVisible(true);
    }

    public static void main(String args[]) {
        TestAnonymous t = new TestAnonymous();
    }
}