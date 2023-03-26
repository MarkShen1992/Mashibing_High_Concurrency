### 小统计：

![Stargazers over time](https://starchart.cc/MarkShen1992/Mashibing_High_Concurrency.svg)

> **Don't count the days, make each day count.**

### 代码目录

- Chapter00_初识Java
  - Hello World
  - 初步认识
  - 代码风格
    - [谷歌代码风格](https://google.github.io/styleguide)
    - [阿里代码风格](https://github.com/alibaba/p3c)

- [Chapter01_Java语言基础](https://github.com/MarkShen1992/Mashibing_High_Concurrency/tree/master/src/main/java/com/basic/chapter0100)
  - **关键字**：if, else, switch, for, while, do while, break, continue, void
  
  - 变量作用域：**出了这个大括号就再也没有人认识这个变量了。**
  
  - 基本数据类型：**四类八种**
    - 整数类型：byte(1 byte), short(2 bytes), int(4 bytes), long(8 bytes)
    - 浮点类型：float(4 bytes), double(8 bytes)
    - 字符类型：char(2 bytes)
    - 布尔类型：boolean
  
    > Instead, expressions in the Java programming language that operate on boolean values are compiled to use values of the Java Virtual Machine **int** data type.
    >
    > ​                                                                                                                                                   -- [*JVMS8*](https://github.com/MarkShen1992/bookstore/tree/master/java/Java%20Virtual%20Machine/jvm8)
    
    ```java
    boolean flag = false;
    ```
    
    >In Oracle’s Java Virtual Machine implementation, boolean arrays in the Java programming language are encoded as Java Virtual Machine byte arrays, using 8 bits per boolean element.
    >
    >​                                                                                                                                                   -- [*JVMS8*](https://github.com/MarkShen1992/bookstore/tree/master/java/Java%20Virtual%20Machine/jvm8)
    
    ```java
    boolean[] flags = {false, true, false, true, true};
    ```
  
  - 形参，实参，返回值，返回值类型
  - 递归调用
  
- [**Chapter02_面向对象编程**](https://github.com/MarkShen1992/Mashibing_High_Concurrency/tree/master/src/main/java/com/basic/chapter0200)
  
  - **内存分析贯穿始终，画图分析**
  - 对象与类的概念
  - **面向对象设计思想**
    - 第一步：考虑问题域中有哪些类，哪些对象
    - 第二步：这些个类，这些个对象有哪些个属性
    - 第三步：考虑类与类之间的关系，定他们之间的方法
  - class
  - new
    - 引用的概念
    - 构造方法的概念
  - 方法重载(编译时多态)
    - 参数个数
    - 参数类型
    - 参数顺序
  - this
  - super
  - static
  - package & import
  - private default protected public
  - extends
  - override
  - final
  - Object
    - equals
    - toString
  - upcasting downcasting
  - polymorphism  / dynamic binding / late
    - 有继承关系存在
    - 存在方法重写 @Override
    - 父类引用指向子类对象
  
- abstract class
  - interface
    - implements
  
- [Chapter03_Java异常处理机制](https://github.com/MarkShen1992/Mashibing_High_Concurrency/tree/master/src/main/java/com/basic/chapter0300)
  - 一个图
  
  ![Exception](https://github.com/MarkShen1992/Mashibing_High_Concurrency/blob/master/materials/Exception.png)
  - 五个关键字
    - try, catch, finally, throw, throws
  - 异常捕获原则
    - 先逮小的，再逮大的
    - 异常和重写的关系: **重写方法需要抛出与原方法所抛出异常类型一致的异常 或者 不抛出异常**
  
- [Chapter04_数组](https://github.com/MarkShen1992/Mashibing_High_Concurrency/tree/master/src/main/java/com/basic/chapter0400)
  - 数组的内存布局
  - 常见算法

- [Chapter05_Java常用类](https://github.com/MarkShen1992/Mashibing_High_Concurrency/tree/master/src/main/java/com/basic/chapter0500)
  - 正则表达式
  - 基础类型包装类
  - Math
  - File
    - 递归
  - 枚举类型

- [**Chapter06_容器类**](https://github.com/MarkShen1992/Mashibing_High_Concurrency/tree/master/src/main/java/com/basic/chapter0600)
  - 一个图
  
  ![Collection Framework](https://github.com/MarkShen1992/Mashibing_High_Concurrency/blob/master/materials/CollectionFramework.png)
  - 一个类
    - Collections
  - 三个知识点
    - For
    - Generic
    - Auto-boxing / unboxing
  - 六个接口
    - Collection
    - Set
    - List
    - Map
    - Iterator
    - Comparable

- [**Chapter07_IO流技术**](https://github.com/MarkShen1992/Mashibing_High_Concurrency/tree/master/src/main/java/com/basic/chapter0700)
  
  ![Java IO](https://github.com/MarkShen1992/Mashibing_High_Concurrency/blob/master/materials/Java%20IO.jpg)
  
  - InputStream / OutputStream
  - Reader / Writer
  - FileInputStream / FileOutputStream
  - FileReader / FileWriter
  - BufferedInputStream / BufferedOutputStream
  - BufferedReader / BufferedWriter
  - ByteArrayInputStream / ByteArrayOutputStream
  - InputStreamReader / OutputStreamWriter
  - DataInputStream / DataOutputStream
  - PrintStream / PrintWriter
  - ObjectInputStream / ObjectOutputStream
  - 分类
    - 方向：输入流，输出流
    - 数据处理单位：字节流，字符流
    - 功能：节点流，处理流
  
- [**Chapter08_多线程**](https://github.com/MarkShen1992/Mashibing_High_Concurrency/tree/master/src/main/java/com/basic/chapter0800)
  - 线程/进程/协程
  - 创建启动线程的方式
  - sleep, join, yield, synchronized, wait, notify, notifyAll

- [Chapter09_网络编程](https://github.com/MarkShen1992/Mashibing_High_Concurrency/tree/master/src/main/java/com/basic/chapter0900)
  - 网络协议分层思想
  - IP概念
  - TCP / UDP概念
  - TCP / UDP程序的写法
    - 知识点融会贯通，+ io 应用

- [Chapter10_GUI](https://github.com/MarkShen1992/Mashibing_High_Concurrency/tree/master/src/main/java/com/basic/chapter1000)
  - 事件模型，**观察者模式**
  - [设计模式的代码](https://github.com/MarkShen1992/DesignPattern), 使用MyEclipse打开更好，有图可以看

- [Chapter11_反射](https://github.com/MarkShen1992/Mashibing_High_Concurrency/tree/master/src/main/java/com/basic/chapter1100)

- [**Chapter12_并发包类讲解代码**](https://github.com/MarkShen1992/Mashibing_High_Concurrency/tree/master/src/main/java/com/mark)

  - [第一讲 concurrent1-19](https://v.qq.com/x/page/x052229kmeq.html)

  - [第二讲 concurrent20-22](https://v.qq.com/x/page/f05224z6ul9.html)

  - [第三讲 concurrent23-25](https://v.qq.com/x/page/z0522fzc1q3.html)

  - [第四讲 concurrent26](https://v.qq.com/x/page/u0522rgqjyk.html)

  - 高并发编程三大块：
    - 同步器(synchronizer)
    - 同步容器
    - 线程池
    - Executor
    - Future
    - Callable

  - 框架
    - [disruptor](https://github.com/LMAX-Exchange/disruptor)
    - [netty](https://netty.io/)

- [Chapter13_利用反射做的小项目](https://github.com/MarkShen1992/Mashibing_High_Concurrency/tree/master/src/main/java/com/annotation)

- 常用工具代码

  - [树形结构遍历](https://github.com/MarkShen1992/Mashibing_High_Concurrency/blob/master/src/main/java/com/program/ConstructTree.java)
  - [Code生成](https://github.com/MarkShen1992/Mashibing_High_Concurrency/blob/master/src/main/java/com/program/CodeGenerator.java)

如果你喜欢这个项目，请我喝杯咖啡吧。

<img src="./like.jpg" alt="drawing" width="300" style="float: left;"/>







