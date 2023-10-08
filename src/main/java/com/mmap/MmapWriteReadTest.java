package com.mmap;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * https://howtodoinjava.com/java/nio/memory-mapped-files-mappedbytebuffer/
 *
 * @author MarkShen
 */
public class MmapWriteReadTest {
    static int length = 0x8FFFFFF;

    static String bigExcelFile = "bigFile.xls";

    static String bigTextFile = "test.txt";

    public static void main(String[] args) throws Exception {
        write();

    }

    private static void write() throws IOException {
        try (RandomAccessFile file = new RandomAccessFile("howtodoinjava.dat", "rw")) {
            MappedByteBuffer out = file.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);

            for (int i = 0; i < length; i++) {
                out.put((byte)'x');
            }
            System.out.println("Finished writing");
        }
    }

    private static void read() throws Exception {
        try (RandomAccessFile file = new RandomAccessFile(new File(bigExcelFile), "r")) {
            // Get file channel in read-only mode
            FileChannel fileChannel = file.getChannel();

            // Get direct byte buffer access using channel.map() operation
            MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());

            // the buffer now reads the file as if it were loaded in memory.
            System.out.println(buffer.isLoaded()); // prints false
            System.out.println(buffer.capacity()); // Get the size based on content size of file

            // You can read the file from this buffer the way you like.
            for (int i = 0; i < buffer.limit(); i++) {
                System.out.print((char)buffer.get()); // Print the content of file
            }
        }
    }

    private static void writeIntoMemoryMappedFile() throws Exception {
        // Create file object
        File file = new File(bigTextFile);

        // Delete the file; we will create a new file
        file.delete();

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw")) {
            // Get file channel in read-write mode
            FileChannel fileChannel = randomAccessFile.getChannel();

            // Get direct byte buffer access using channel.map() operation
            MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 4096 * 8 * 8);

            // Write the content using put methods
            buffer.put("howtodoinjava.com".getBytes());
        }
    }
}
