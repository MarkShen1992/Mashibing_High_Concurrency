package com.mmap;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * https://medium.com/@trunghuynh/java-nio-using-memory-mapped-file-to-load-big-data-into-applications-5058b395cc9d
 *
 * @author MarkShen
 * @since 20231008
 */
public class MemoryBufferTest {
    private static final String BTCUSDT_FILE_PATH = "./BTCUSDT-1m.csv";

    public static void main(String[] args) throws Exception {
        normalMemoryBuffer();
        mappedBuffer();
    }

    private static void normalMemoryBuffer() throws IOException {
        long startTime = System.currentTimeMillis();
        RandomAccessFile file = new RandomAccessFile(BTCUSDT_FILE_PATH, "rw");
        FileChannel channel = file.getChannel();
        // Reading file into normal Memory buffer
        ByteBuffer buffer = ByteBuffer.allocate((int)channel.size());
        channel.read(buffer);
        buffer.flip();

        for (int i = 0; i < channel.size(); i++) {
            System.out.print((char)buffer.get());
        }
        channel.close();
        file.close();
        System.out.println("Total read and print time: " + (System.currentTimeMillis() - startTime));
    }

    private static void mappedBuffer() throws Exception {
        long startTime = System.currentTimeMillis();
        RandomAccessFile file = new RandomAccessFile(BTCUSDT_FILE_PATH, "rw");
        FileChannel channel = file.getChannel();
        // Read file into mapped buffer
        MappedByteBuffer mbb = channel.map(FileChannel.MapMode.READ_WRITE, 0, channel.size());
        System.out.println("Reading content and printing ... ");
        for (int i = 0; i < channel.size(); i++) {
            System.out.print((char)mbb.get());
        }
        channel.close();
        file.close();
        System.out.println("Total read and print time: " + (System.currentTimeMillis() - startTime));
    }
}
