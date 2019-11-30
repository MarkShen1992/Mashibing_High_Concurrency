package com.basic.chapter1000;

import java.awt.*;

public class TestMultiFrame {
    public static void main(String args[]) {
        MyFrame4 f1 =
            new MyFrame4(100,100,200,200,Color.BLUE);
        MyFrame4 f2 =
            new MyFrame4(300,100,200,200,Color.YELLOW);
        MyFrame4 f3 =
            new MyFrame4(100,300,200,200,Color.GREEN);
        MyFrame4 f4 =
            new MyFrame4(300,300,200,200,Color.MAGENTA);
    }
}




class MyFrame4 extends Frame{
    static int id = 0;
    MyFrame4(int x,int y,int w,int h,Color color){
        super("MyFrame4 " + (++id));
        setBackground(color);
        setLayout(null);
        setBounds(x,y,w,h);
        setVisible(true);
    }
}
