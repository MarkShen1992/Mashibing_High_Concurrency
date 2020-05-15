package com.basic.chapter0900.Chat.Chat05;

import java.net.*;
import java.util.*;
import java.io.*;

public class ChatServer {
    ServerSocket server = null;
    Collection cClient = new ArrayList();

    public ChatServer(int port) throws Exception {
        server = new ServerSocket(port);
    }

    public void startServer() throws Exception {
        while (true) {
            Socket s = server.accept();
            cClient.add(new ClientConn(s));
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
                s.close();
                cClient.remove(this);
            } catch (IOException e) {
                System.out.println("client quit");
                try {
                    if (s != null)
                        s.close();
                    cClient.remove(this);
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ChatServer cs = new ChatServer(8888);
        cs.startServer();
    }
}
