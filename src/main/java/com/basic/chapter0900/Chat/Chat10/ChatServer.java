package com.basic.chapter0900.Chat.Chat10;

import java.net.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class ChatServer extends Frame {
    TextArea ta = new TextArea();

    public void launchFrame() {
        add(ta, BorderLayout.CENTER);
        setBounds(0, 0, 200, 300);
        this.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                }
        );
        setVisible(true);
    }

    ServerSocket server = null;
    Collection cClient = new ArrayList();

    public ChatServer(int port) throws Exception {
        server = new ServerSocket(port);
        launchFrame();
    }

    public void startServer() throws Exception {
        while (true) {
            Socket s = server.accept();
            cClient.add(new ClientConn(s));
            ta.append("NEW-CLIENT " + s.getInetAddress() + ":" + s.getPort());
            ta.append("\n" + "CLIENTS-COUNT: " + cClient.size() + "\n\n");
        }
    }

    class ClientConn implements Runnable {
        Socket s = null;

        public ClientConn(Socket s) {
            this.s = s;
            (new Thread(this)).start();
        }

        public void send(String str) throws IOException {
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF(str);
        }

        public void dispose() {
            try {
                if (s != null) s.close();
                cClient.remove(this);
                ta.append("A client out! \n");
                ta.append("CLIENT-COUNT: " + cClient.size() + "\n\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                DataInputStream dis = new DataInputStream(s.getInputStream());
                String str = dis.readUTF();
                while (str != null && str.length() != 0) {
                    System.out.println(str);
                    for (Iterator it = cClient.iterator(); it.hasNext(); ) {
                        ClientConn cc = (ClientConn) it.next();
                        if (this != cc) {
                            cc.send(str);
                        }
                    }
                    str = dis.readUTF();
                    //send(str);
                }
                this.dispose();
            } catch (Exception e) {
                System.out.println("client quit");
                this.dispose();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ChatServer cs = new ChatServer(8888);
        cs.startServer();
    }
}
