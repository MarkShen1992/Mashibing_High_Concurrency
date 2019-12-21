package com.basic.chapter0700;

import java.io.*;

public class TestDataStream {
    public static void main(String[] args) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        try {
            dos.writeDouble(Math.random());
            dos.writeBoolean(true);
            ByteArrayInputStream bais =
                    new ByteArrayInputStream(baos.toByteArray());
            System.out.println(bais.available());
            DataInputStream dis = new DataInputStream(bais);
            System.out.println(dis.readDouble());
            System.out.println(dis.readBoolean());
            dos.close();
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}