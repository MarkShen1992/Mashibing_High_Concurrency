package com.basic.chapter0900;

import java.io.*;
import java.net.*;
public class talkclient
{
	public static void main(String args[])
	{
		try
		{
			Socket socket = new Socket("127.0.0.1",4700);
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			BufferedReader is = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
			String readline;
			readline = sin.readLine();
			while (!readline.equals("bye"))	
			{
				os.println(readline);
				os.flush();
				System.out.println("Client:" + readline);
				System.out.println("Server:" + is.readLine());
				readline = sin.readLine();
			}
			os.close();
			is.close();
			socket.close();
		}catch(Exception e)
		{
			System.out.println("Error" + e);
		}
	}
}
			