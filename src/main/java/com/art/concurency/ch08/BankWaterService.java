package com.art.concurency.ch08;

import java.util.Map;
import java.util.concurrent.*;

public class BankWaterService implements Runnable {

    /**
     * 创建四个屏障，处理完之后执行当前类的run方法
     */
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(4, this);

    /**
     * 假设只有四个 sheet 页，所以启动 4 个线程
     */
    private Executor executor = Executors.newFixedThreadPool(4);

    /**
     * 保存每个 sheet 计算出的银行流水结果
     */
    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    private void count() {
        for (int i = 0; i < 4; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    // 计算当前 sheet 的银流数据
                    sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                    try {
                        // 计算完成，插入一个屏障
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Override
    public void run() {
        int result = 0;
        // 汇总每个 sheet 计算出来的结果
        for (Map.Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()) {
            result += sheet.getValue();
        }
        // output
        sheetBankWaterCount.put("result", result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }
}
