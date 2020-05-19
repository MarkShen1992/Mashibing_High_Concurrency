package com.basic.chapter1000;

import java.awt.*;
import java.awt.event.*;

public class TestInner {
    Frame f = new Frame("Mouse");
    TextField tf = new TextField(30);

    public TestInner() {
        f.add(new Label("Mouse"), "North");
        f.add(tf, "South");
        f.setBackground(new Color(120, 175, 175));
        f.addMouseMotionListener(new InnerMonitor());
        f.addMouseListener(new InnerMonitor());
        f.setSize(300, 200);
        f.setVisible(true);
    }

    public static void main(String args[]) {
        TestInner t = new TestInner();
    }

    private class InnerMonitor implements MouseMotionListener, MouseListener {
        public void mouseDragged(MouseEvent e) {
            String s = "(" + e.getX() + "," + e.getY() + ")";
            tf.setText(s);
        }

        public void mouseEntered(MouseEvent e) {
            String s = "Start";
            tf.setText(s);
        }

        public void mouseExited(MouseEvent e) {
            String s = "end";
            tf.setText(s);
        }

        public void mouseMoved(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseClicked(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }
    }//end of Inner class
}//end of Outer class