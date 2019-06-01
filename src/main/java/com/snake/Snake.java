package com.snake;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Snake {
    Node head, tail;
    Direction dir = Direction.LEFT;

    public Snake() {
        // initialize snake
        head = new Node(20, 20);
        tail = head;
    }

    /**
     * 画出自己(面向对象的思维)
     * @param g
     */
    public void paint(Graphics g) {
        Node n = head;
        while (n != null) {
            n.paint(g);
            n = n.next;
        }

        move();
    }

    private void move() {
        addToHead();
        deleteTail();
        boundaryCheck();
    }

    private void boundaryCheck() {
        if (head.row < 0) head.row = Yard.NODE_COUNT - 1;
        if (head.col < 0) head.col = Yard.NODE_COUNT - 1;
        if (head.row > Yard.NODE_COUNT - 1) head.row = 0;
        if (head.col < Yard.NODE_COUNT - 1) head.col = 0;
    }

    private void addToHead() {
        Node n = null;
        switch (dir) {
            case LEFT:
                n = new Node(head.row, head.col - 1);
                break;
            case RIGHT:
                n = new Node(head.row, head.col + 1);
                break;
            case UP:
                n = new Node(head.row - 1, head.col);
                break;
            case DOWN:
                n = new Node(head.row + 1, head.col);
                break;
        }

        // add new snake head
        n.next = head;
        head.pre = n;
        head = n;
    }

    private void deleteTail() {
        if (tail == null)
            return;
        tail = tail.pre;
        tail.next.pre = null; // 不加这句话，会有内存泄漏的风险
        tail.next = null;
    }

    /**
     * 判断用户按下那个键
     * @param e
     */
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
                dir = Direction.LEFT;
                break;
            case KeyEvent.VK_RIGHT:
                dir = Direction.RIGHT;
                break;
            case KeyEvent.VK_UP:
                dir = Direction.UP;
                break;
            case KeyEvent.VK_DOWN:
                dir = Direction.DOWN;
                break;
        }
    }

    public void eat(Egg e) {
        if (head.row == e.row && head.col == e.col) {
            addToHead();
            e.reAppear();
        }
    }
}
