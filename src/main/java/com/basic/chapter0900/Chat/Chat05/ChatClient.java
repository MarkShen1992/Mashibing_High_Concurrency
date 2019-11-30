package com.basic.chapter0900.Chat.Chat05;

import java.io.*;
import java.net.*;

public class ChatClient
{
	Socket s = null;
	public ChatClient() throws Exception
	{
		s = new Socket("127.0.0.1", 8888);
		(new Thread(new ReceiveThread())).start();
	}
	
	public void send(String str) throws Exception
	{
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		dos.writeUTF(str);
	}
	
	public void disconnect() throws Exception
	{
		s.close();
	}
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader (
								new InputStreamReader(System.in));
		com.basic.chapter0900.Chat.Chat03.ChatClient cc = new com.basic.chapter0900.Chat.Chat03.ChatClient();
		String str = br.readLine();
		while(str != null && str.length() != 0)
		{
			cc.send(str);
			str = br.readLine();
		}
		cc.disconnect();
	}
	
	class ReceiveThread implements Runnable
	{
		public void run()
		{
			if(s == null) return;
			try {
				DataInputStream dis = new DataInputStream(s.getInputStream());
				String str = dis.readUTF();
				while (str != null && str.length() != 0)
				{
					System.out.println(str);
					str = dis.readUTF();
				}
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
		}
	}
}