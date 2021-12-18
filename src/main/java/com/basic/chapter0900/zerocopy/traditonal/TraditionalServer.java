package com.basic.chapter0900.zerocopy.traditonal;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TraditionalServer {
    public static void main(String args[]) {
        int port = 2000;
        ServerSocket server_socket;
        DataInputStream input;

        try {
            server_socket = new ServerSocket(port);
            System.out.println("Server waiting for client on port " + server_socket.getLocalPort());

            // server infinite loop
            while (true) {
                Socket socket = server_socket.accept();
                System.out.println("New connection accepted " + socket.getInetAddress() + ":" + socket.getPort());
                input = new DataInputStream(socket.getInputStream());

                // print received data
                try {
                    byte[] byteArray = new byte[4096];
                    while (true) {
                        int nread = input.read(byteArray, 0, 4096);
                        if (0 == nread)
                            break;
                    }
                } catch (IOException e) {
                    System.out.println(e);
                }

                // connection closed by client
                try {
                    socket.close();
                    System.out.println("Connection closed by client");
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
