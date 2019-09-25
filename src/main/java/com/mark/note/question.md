# 思考题
- A线程正在执行一个对象中的同步方法，B线程是否可以同时执行同一个对象中的非同步方法？
- 同上，B线程是否可以同时执行同一个对象中的另一个同步方法？
- 线程抛出异常会释放吗？
- volatile和synchronized区别
- 写一个程序，证明AtomXXX类比synchronized更高效
- AtomXXX类可以保证可见性吗？写个程序来证明。
- 写一个程序证明AtomXXX类的多个方法并不构成原子性。
- 写一个程序模拟死锁。
- 写一个程序，在main线程中启动100个线程，100个线程完成后，主线程打印完成。使用join和CountDownLatch都可以完成。
- 如何设计高效游戏服务器的架构。
- synchronize和reentrantlock区别。

  - 完成和synchronized一样的功能
  
  - 比synchronize灵活
    
    - tryLock
    - tryLock可指定时间
    - lockInterruptly()
    - 指定锁为公平锁
    
  - 多查Java API
