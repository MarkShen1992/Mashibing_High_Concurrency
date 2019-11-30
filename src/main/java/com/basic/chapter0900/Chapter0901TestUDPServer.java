package com.basic.chapter0900;

import java.net.*;

public class Chapter0901TestUDPServer
{
	public static void main(String args[]) throws Exception
	{
		byte buf[] = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		DatagramSocket ds = new DatagramSocket(5678);
		while(true)
		{
			ds.receive(dp);
			System.out.println(new String(buf,0,dp.getLength()));
		}
	}
}