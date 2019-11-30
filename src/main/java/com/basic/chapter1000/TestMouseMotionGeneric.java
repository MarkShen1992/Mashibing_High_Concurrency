package com.basic.chapter1000;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class TestMouseMotionGeneric {
  public static void main(String args[]) {
    new MyFrame888("drawing...");
  }
}

class MyFrame888 extends Frame {
  ArrayList<Point> points = null;
  MyFrame888(String s) {
    super(s);
    points = new ArrayList<Point>(); 
    setLayout(null);
    setBounds(300,300,400,300); 
    this.setBackground(new Color(204,204,255));
    setVisible(true);
    this.addMouseMotionListener(new Monitor4());
  } 
 	public void paint(Graphics g) {
    Iterator<Point> i = points.iterator();
    while(i.hasNext()){
      Point p = i.next();
      g.setColor(Color.BLUE);
      g.fillOval(p.x,p.y,10,10);
    }
  }
  public void addPoint(Point p){
    points.add(p);
  }
}
class Monitor4 extends MouseMotionAdapter {
  private int num = 0;
  public void mouseMoved(MouseEvent e) {
    MyFrame888 f = (MyFrame888)e.getSource();
    f.addPoint(new Point(e.getX(),e.getY()));
    if(num++ >= 5){
      f.repaint();
      num=0;
    }
   }
}
