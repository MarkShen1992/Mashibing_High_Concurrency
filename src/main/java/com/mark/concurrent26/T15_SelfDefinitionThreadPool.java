package com.mark.concurrent26;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 自定义线程池
 *
 * @see https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ThreadPoolExecutor.html
 * @since 2021-11-07
 */
public class T15_SelfDefinitionThreadPool {

    public static void main(String[] args) {
        // Returns the number of processors available to the Java virtual machine.
        int processorCount = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor threadPoolExecutor =
            new ThreadPoolExecutor(processorCount, processorCount * 2, 1, TimeUnit.SECONDS, new ArrayBlockingQueue(10));
        System.out.println(threadPoolExecutor);
        int sum = 0;
        try {
            for (int i = 0; i < 10; i++) {
                int tmpInt = i;
                Future<Integer> result = threadPoolExecutor.submit(() -> sum(tmpInt, tmpInt + 10));
                sum += result.get();
            }
        } catch (RejectedExecutionException e) {
            System.out.println("task completed count=" + threadPoolExecutor.getCompletedTaskCount());
            threadPoolExecutor.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(sum);
        System.out.println("Core Pool Size=" + threadPoolExecutor.getCorePoolSize());
        System.out.println("Maximum Pool Size=" + threadPoolExecutor.getMaximumPoolSize());
        System.out.println("Keepalive Time=" + threadPoolExecutor.getKeepAliveTime(TimeUnit.SECONDS));
        threadPoolExecutor.shutdown();
    }

    static int sum(int start, int end) {
        int sum = 0;
        if (start >= end) {
            return sum;
        }
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }
}
