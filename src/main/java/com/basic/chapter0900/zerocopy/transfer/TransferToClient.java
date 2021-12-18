package com.basic.chapter0900.zerocopy.transfer;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class TransferToClient {

    public static void main(String[] args) throws IOException {
        TransferToClient sfc = new TransferToClient();
        sfc.testSendfile();
    }

    public void testSendfile() throws IOException {
        String host = "localhost";
        int port = 9026;
        SocketAddress sad = new InetSocketAddress(host, port);
        SocketChannel sc = SocketChannel.open();
        sc.connect(sad);
        sc.configureBlocking(true);

        String fname = "D:\\soft\\julia-1.4.2-win64.exe";
        long fsize = 183678375L, sendzise = 4094;

        // FileProposerExample.stuffFile(fname, fsize);
        FileChannel fc = new FileInputStream(fname).getChannel();
        long start = System.currentTimeMillis();
        long nsent = 0, curnset = 0;
        curnset = fc.transferTo(0, fsize, sc);
        System.out.println(
            "total bytes transferred--" + curnset + " and time taken in MS--" + (System.currentTimeMillis() - start));
        fc.close();
    }

}
