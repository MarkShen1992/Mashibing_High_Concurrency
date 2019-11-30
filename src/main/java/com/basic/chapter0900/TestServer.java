package com.basic.chapter0900;/*	�������ƣ��򵥵�client/server����
 * 	Դ�ļ����ƣ�TestClient.java/TestServer.java
 *	Ҫ  �㣺
 *		1. Java Socket��̲���
 *		2. Socket/ServerSocket���÷�
 *		3. ͨ��Socket������Ի�ȡͨ�ŶԷ�Socket����Ϣ
 */
import java.net.*;
import java.io.*;

public class TestServer {
	public static void main(String args[]) {
		try {		
			ServerSocket s = new ServerSocket(8888);
			while (true) {
				Socket s1 = s.accept();
				OutputStream os = s1.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				dos.writeUTF("Hello," + s1.getInetAddress() + 
						"port#" +s1.getPort() + "  bye-bye!");
				dos.close();
				s1.close();
			}
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println("�������г���:" + e);			
		}
	}
}