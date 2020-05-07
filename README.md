### 代码目录

- Chapter00_初识Java
  - Hello World
  - 初步认识
  - 程序格式

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
  - 一个类
    - Collections
  - 三个知识点
    - For
    - Generic
    - Auto-boxing / unboxing
  - 六个接口

- [**Chapter07_IO流技术**](https://github.com/MarkShen1992/Mashibing_High_Concurrency/tree/master/src/main/java/com/basic/chapter0700)
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



# 清华人都如此努力，那我们呢？

## 导读：看看清华人是如何学习与生活，再看看自己是如何度过一天的，本来聪明的人就很厉害，而既聪明又努力的人简直无敌了，还在堕落和迷茫的同学，赶快醒醒吧！ 

### 一、永远不要说你已经尽力了

我在高中时体育特别差，跑1000米都很要命，从来都是不及格。到了清华之后，第一节体育课，老师告诉我们每年要测3000米长跑，跑不过不许毕业，取消推研资格。怎么办？于是每天晚上10：30，我们的自习教室关门，操场上的人就多起来了。跑半个小时再回寝室继续学习，练了一个学期，我瘦了40斤，最后考试的时候我仅用了12分56秒就跑下了3000米，我们班最胖的人也在15分钟以内跑完了。清华校训“自强不息”给我的影响非常大。所以永远不要说自己已经尽力了。**什么叫成功？人们死活不相信你能做到的事情，你做到了，这就叫成功。**

### 二、怎样挤时间

大家如果到了清华可以看到，所有的学生骑车都是飞车，走路几乎都是小跑。你很快从校门走进教室就可以比别人多看一会书，多做一道题。时间久了，日积月累，你就会在时间上占有绝对的优势。充分利用课间10分钟，我们一天可以挤出将近两个小时，可以比别人多做一套题。所有人脑子里想的都是利用别人休息的时间来充实自己，使自己在今后的竞争中占据优势地位。同学们不要把清华的学生想得太牛了，清华学生中智商超群的人至多占学生总数的1/4。他们比你们多的东西只是对待自己未来的态度。**清华学生身上有一种非常令人敬畏的精神力量。他们可以为了自己的目标放弃任何诱惑**。就算在大年三十，清华的自习教室也会人满为患。用一位美国教授的话说：“Students of Tsinghua，no Saturday，no Sunday，no holiday！”就是这种精神铸造了清华的神话。不这样就很难考上清华。

### 三、给自己找压力

巨大的压力才会有巨大的动力。清华的学生有的也不是那么喜欢学习的，但是清华的要求极为 严格，四年之间只要一科不及格就取消推研资格，三科不及格就退学了，所以我们都要疯狂地学习。大二的时候，我们有一个夏季小学期共两周。第一周周一上午， 我们在一间教室上了两个小时课，学了计算机的VHDL语言。下课老师要求我们在周五之前编出一个主频30M的CPU来。 所有的人都疯了，因为上午根本就不知道他在说什么。后来我们知道，在其他大学的电子系这门课要学一个学期的。但是老师说得很清楚了，做不出来就不及格。于 是大家就疯狂地跑到图书馆借书，回去废寝忘食地看，第一天看不懂，第二天稍有点明白，第三天白天编了几个简单的程序，晚上开始正式编程，编到凌晨3点，周四编了一天加一个通宵，周五早上8点通过了验收。在此之前，我们没有想到我们还可以在这么短的时间里做这么多事，但是在巨大的压力之下我们完成了。

### 四、情感问题

高中阶段的感情是非常美好的，那种感觉很甜蜜。但我觉得高中时候谈恋爱太麻烦了———你 得偷偷摸摸的，不能被老师和家长知道，但是又一定会被发现，然后一次又一次地被找去谈话，最后只顾着烦了，什么甜蜜的感觉都没有了。就算是上了大学，清华 的情侣们到了大四也是基本都分手了，所以我们好多大学的同学觉得与其费心劳神地找个女朋友还不如安心学习，于是清华就有了“本科僧”“研究僧”的说法。正 是这些过着苦行僧生活的学生使得清华的学风在世界上都有口皆碑。我们这个年龄多学一点安身立命的本事比寻求那些短暂的甜蜜要有意义得多。我给大家的建议 是，我们不妨做四年“本科僧”，千万不要到了最后发现自己浪费了太多的时间和精力而自责和苦恼。

### 五、不要抱怨老师不好

清华的老师做研究都是大牛，但是几乎没有老师好好给本科生上课。没有人教你怎么办，你不会倒是不正常的了。有一次上微机原理课，老师说，今天回去用Protel把课上的电路模拟一下。同学们都说，我们是这辈子第一次听说这个软件。老师说：“这是电子工程人员必备的软件。”转身就走了。没办法，我们回去在图书馆熬了3天终于把这个软件学会了。一次数学课，老师让我们回去用MATLAB画一个三维的图形。同学们都说没学过———这好像是数学系的一门必修课，老师只说了一句：“没学过？回去学呀！”我们又是在图书馆耗了好几天，基本弄明白了。所以，当你觉得有哪一科学得不太好的，一定不要埋怨客观条件，自己的努力才是成功的基石。

### 六、好的身体是一切的本钱

同学们如果真的要为自己的理想拼命的话，必须好好锻炼身体。清华的口号是“为祖国健康工作50年”。所以清华的体育课之所以要求那么高、那么严格，就是逼着大家好好锻炼身体。现在，我们班今年有20个人报名参加北京国际马拉松（全国报名的大学生只有5000人，清华就有3000人）——一是为了体验一下，二是对自己的耐力很有信心。推荐大家多练习长跑，最好每天跑个1000米。相信吧，等你们到了一流大学需要熬夜做研究的时候，你们将会发现自己大学打下的身体健康根基是多么重要。

**Don't count the days, make each day count.**







