package com.basic.chapter0200;

import java.util.Objects;

public class Chapter0210TestEquals {
    public static void main(String[] args) {
        Cat c1 = new Cat(1, 2, 3);
        Cat c2 = new Cat(1, 2, 3);
        System.out.println(c1 == c2);
        System.out.println(c1.equals(c2));

        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}

class Cat {
    int color;
    int height, weight;

    public Cat(int color, int height, int weight) {
        this.color = color;
        this.height = height;
        this.weight = weight;
    }

    public boolean equals(Object obj) {
        if (obj == null)
        	return false;
        else {
            if (obj instanceof Cat) {
                Cat c = (Cat) obj;
                if (c.color == this.color && c.height == this.height && c.weight == this.weight) {
                    return true;
                }
            }
        }
        return false;
    }

	@Override
	public int hashCode() {
		return Objects.hash(color, height, weight);
	}
}