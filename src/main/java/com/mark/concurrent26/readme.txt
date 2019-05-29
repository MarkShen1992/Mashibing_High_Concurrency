Executor
ExecutorService
Callable(exist return value) = Runnable(non-return value)
Executors: 工具类，类似工具类：Arrays, Collections
ThreadPool
Future:未来的结果

如何设置线程数
公式：最佳线程数目 = （（线程等待时间+线程CPU时间）/线程CPU时间 ）* CPU数目

Brian Goetz建议，线程池大小与处理器的利用率之比可以使用下面的公式进行估算：
Nthreads = NCPU * UCPU * (1 + W/C)

其中：
NCPU是处理器的核的数目，可以通过Runtime.getRuntime().availableProcessors()得到
UCPU是期望的CPU利用率（该值应该介于0和1之间）
W/C是等待时间与计算时间的比率

比如4核的处理器NCPU是4，你的程序计算一个方法需要5秒钟，整个程序运行也就需要5秒钟，那么W/C比率
应该是100，

NCPU利用率希望是100%那么也就是1，总体程序最佳的线程数应该是4*1*(1+100）=404个线程数，但实际操
作中，设置404个线程明显不能带来性能的优势，这么多线程数只会增加上下文来回切换带来更严重的性能问
题。

如果你的程序是计算密集型的并且没有IO操作，那么建议线程数设置为cpu核数+1，减少上下文切换。

如果你的程序是IO密集型的（包括网络连接等待），那么可以按照 Nthreads = NCPU * UCPU * (1 + W/C)
计算线程数.