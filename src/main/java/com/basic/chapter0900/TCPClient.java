package com.basic.chapter0900;

import java.net.*;
import java.io.*;

public class TCPClient {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("127.0.0.1", 6666);
		OutputStream os = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		Thread.sleep(30000);
		dos.writeUTF("hello server!");
		dos.flush();
		dos.close();
		s.close();
	}
}