package com.art.concurrency.ch04;

import com.art.concurrency.utils.SleepUtils;

public class Daemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(Boolean.TRUE);
        thread.start();
    }

    static class DaemonRunner implements Runnable {

        @Override
        public void run() {
            SleepUtils.second(10);
        }
    }
}
