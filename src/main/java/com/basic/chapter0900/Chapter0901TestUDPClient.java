package com.basic.chapter0900;

import java.net.*;

public class Chapter0901TestUDPClient
{
	public static void main(String args[]) throws Exception
	{
		byte[] buf = "Hello".getBytes();
		DatagramPacket dp = new DatagramPacket(buf, buf.length, new InetSocketAddress("127.0.0.1", 5678));
		DatagramSocket ds = new DatagramSocket(9999);
		ds.send(dp);
		ds.close();
	}
}