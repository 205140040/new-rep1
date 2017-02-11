package com.yfairy.demo.java_concurrent;

import java.util.Date;

public class ThreadDemo {

	public static void main(String[] args) throws Exception {
		/**
		 * Thread类:<br>
		 * http://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html(使用谷歌翻译)<br>
		 * 
		 */

		//
		// 概述包类使用树已弃用指数帮帮我 Java™平台
		// 标准版 7 上一个类下一课框架无框架所有类概要： 嵌套 | 字段 | Constr | 方法详情： 字段 | Constr | 方法
		// java.lang
		// 类线程
		//
		// java.lang.Object
		// java.lang.Thread
		// 所有实现的接口：
		// 可运行
		// 直接已知子类：
		// ForkJoinWorkerThread
		//
		// public class Thread
		// extends Object
		// implements Runnable
		// 一个线程是执行的程序中的一个线程。Java虚拟机允许应用程序具有并发运行的多个执行线程。
		// 每个线程都有一个优先级。具有较高优先级的线程优先于具有较低优先级的线程执行。每个线程可以或也可以不被标记为守护进程。当在一些线程中运行的代码创建一个新Thread对象时，新线程的优先级最初设置为等于创建线程的优先级，并且当且仅当创建线程是守护进程时才是守护线程。
		//
		// 当Java虚拟机启动时，通常有一个非守护进程线程（通常调用名为main某个指定类的方法
		// ）。Java虚拟机继续执行线程，直到发生以下任一情况：
		//
		// exit类的方法Runtime已被调用，并且安全管理器已允许退出操作发生。
		// 不是守护线程的所有线程都已经死亡，通过从调用返回到run方法或通过抛出传播超出run 方法的异常。
		// 有两种方法来创建一个新的执行线程。一个是声明一个类是一个子类Thread。这个子类应该覆盖类的run方法
		// Thread。然后可以分配和启动子类的实例。例如，计算大于规定值的素数的线程可以写成如下：
		//
		// 类PrimeThread extends Thread {
		// long minPrime;
		// PrimeThread（long minPrime）{
		// this.minPrime = minPrime;
		// }}
		//
		// public void run（）{
		// //计算大于minPrime的素数
		// 。。。
		// }}
		// }}
		//
		// 以下代码将创建一个线程并开始运行：
		//
		// PrimeThread p = new PrimeThread（143）;
		// p.start（）;
		//
		// 创建线程的另一种方法是声明一个实现接口的Runnable类。然后该类实现该run方法。然后可以分配类的实例，在创建时作为参数传递
		// Thread，并启动。此其他样式中的相同示例如下所示：
		//
		// 类PrimeRun实现Runnable {
		// long minPrime;
		// PrimeRun（long minPrime）{
		// this.minPrime = minPrime;
		// }}
		//
		// public void run（）{
		// //计算大于minPrime的素数
		// 。。。
		// }}
		// }}
		//
		// 以下代码将创建一个线程并开始运行：
		//
		// PrimeRun p = new PrimeRun（143）;
		// 新线程（p）.start（）;
		//
		// 每个线程都有一个名称用于识别目的。多个线程可以具有相同的名称。如果在创建线程时未指定名称，则会为其生成新名称。
		//
		// 除非另有说明，否则将null参数传递给此类中的构造函数或方法将导致NullPointerException抛出异常。
		//
		// 以来：
		// JDK1.0
		// 也可以看看：
		// Runnable， Runtime.exit(int)， run()， stop()
		// 嵌套类摘要
		//
		// 嵌套类
		// 修饰符和类型 类和说明
		// static class Thread.State
		// 线程状态。
		// static interface Thread.UncaughtExceptionHandler
		// 当线程由于未捕获异常而突然终止时调用的处理程序接口。
		// 字段摘要
		//
		// 字段
		// 修饰符和类型 字段和说明
		// static int MAX_PRIORITY
		// 线程可以拥有的最大优先级。
		// static int MIN_PRIORITY
		// 线程可以拥有的最小优先级。
		// static int NORM_PRIORITY
		// 分配给线程的默认优先级。
		// 构造函数摘要
		//
		// 构造函数
		// 构造函数和说明
		// Thread()
		// 分配一个新Thread对象。
		// Thread(Runnable target)
		// 分配一个新Thread对象。
		// Thread(Runnable target, String name)
		// 分配一个新Thread对象。
		// Thread(String name)
		// 分配一个新Thread对象。
		// Thread(ThreadGroup group, Runnable target)
		// 分配一个新Thread对象。
		// Thread(ThreadGroup group, Runnable target, String name)
		// 分配一个新Thread对象，使其具有target 作为其运行对象，指定name为其名称，并且属于引用的线程组group。
		// Thread(ThreadGroup group, Runnable target, String name, long
		// stackSize)
		// 分配一个新Thread对象，使其具有target
		// 作为其运行对象，指定name为其名称，并且属于由引用的线程组group，并具有指定的堆栈大小。
		// Thread(ThreadGroup group, String name)
		// 分配一个新Thread对象。
		// 方法摘要
		//
		// 方法
		// 修饰符和类型 方法和说明
		// static int activeCount()
		// 返回当前线程的线程组及其子组中的活动线程数的估计值。
		// void checkAccess()
		// 确定当前运行的线程是否有修改此线程的权限。
		// protected Object clone()
		// 抛出CloneNotSupportedException作为线程不能被有意义地克隆。
		// int countStackFrames()
		// 已弃用。
		// 此调用的定义取决于suspend()，不推荐使用。此外，这次电话的结果从来没有明确定义。
		// static Thread currentThread()
		// 返回对当前正在执行的线程对象的引用。
		// void destroy()
		// 已弃用。
		// 这个方法最初被设计为在没有任何清理的情况下销毁这个线程。它持有的任何监视器都将被锁定。但是，该方法从未实现。如果要实施，它将以大多数方式出现死锁倾向suspend()。如果目标线程持有一个锁，保护关键系统资源，当它被销毁时，任何线程都不能再次访问此资源。如果另一个线程尝试锁定此资源，将导致死锁。这种死锁通常表现为“冻结”过程。有关更多信息，请参阅
		// 为什么Thread.stop，Thread.suspend和Thread.resume已弃用？。
		// static void dumpStack()
		// 将当前线程的堆栈跟踪打印到标准错误流。
		// static int enumerate(Thread[] tarray)
		// 将当前线程的线程组及其子组中的每个活动线程复制到指定的数组中。
		// static Map<Thread,StackTraceElement[]> getAllStackTraces()
		// 返回所有活动线程的堆栈跟踪的映射。
		// ClassLoader getContextClassLoader()
		// 返回此Thread的上下文ClassLoader。
		// static Thread.UncaughtExceptionHandler
		// getDefaultUncaughtExceptionHandler()
		// 返回当线程因未捕获异常而突然终止时调用的默认处理程序。
		// long getId()
		// 返回此Thread的标识符。
		// String getName()
		// 返回此线程的名称。
		// int getPriority()
		// 返回此线程的优先级。
		// StackTraceElement[] getStackTrace()
		// 返回表示此线程的堆栈转储的堆栈跟踪元素的数组。
		// Thread.State getState()
		// 返回此线程的状态。
		// ThreadGroup getThreadGroup()
		// 返回此线程所属的线程组。
		// Thread.UncaughtExceptionHandler getUncaughtExceptionHandler()
		// 返回当此线程由于未捕获异常而突然终止时调用的处理程序。
		// static boolean holdsLock(Object obj)
		// 当且仅当当前线程将监视器锁定在指定对象上时，返回true。
		// void interrupt()
		// 中断此线程。
		// static boolean interrupted()
		// 测试当前线程是否已中断。
		// boolean isAlive()
		// 测试此线程是否存活。
		// boolean isDaemon()
		// 测试这个线程是否是守护线程。
		// boolean isInterrupted()
		// 测试此线程是否已中断。
		// void join()
		// 等待这个线程死亡。
		// void join(long millis)
		// 等待最多millis几毫秒这个线程死。
		// void join(long millis, int nanos)
		// 等待最多millis几毫秒加上 nanos这个线程死亡的纳秒。
		// void resume()
		// 已弃用。
		// 此方法仅用于使用suspend()，已被弃用，因为它是死锁容易的。有关更多信息，请参阅
		// 为什么Thread.stop，Thread.suspend和Thread.resume已弃用？。
		// void run()
		// 如果这个线程是使用单独的 Runnable运行对象构造的，那么该 Runnable对象的run方法被调用;
		// 否则，此方法不执行任何操作并返回。
		// void setContextClassLoader(ClassLoader cl)
		// 设置此线程的上下文ClassLoader。
		// void setDaemon(boolean on)
		// 将此线程标记为守护线程或用户线程。
		// static void
		// setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler
		// eh)
		// 设置当线程由于未捕获异常而突然终止时调用的默认处理程序，并且没有为该线程定义任何其他处理程序。
		// void setName(String name)
		// 将此线程的名称更改为等于参数 name。
		// void setPriority(int newPriority)
		// 更改此线程的优先级。
		// void setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler eh)
		// 设置当此线程由于未捕获异常而突然终止时调用的处理程序。
		// static void sleep(long millis)
		// 导致当前执行的线程睡眠（临时停止执行）指定的毫秒数，服从系统计时器和调度程序的精度和准确性。
		// static void sleep(long millis, int nanos)
		// 使当前执行的线程睡眠（临时停止执行）指定的毫秒数加上指定的纳秒数，服从系统计时器和调度程序的精度和准确性。
		// void start()
		// 导致此线程开始执行; Java虚拟机调用run此线程的方法。
		// void stop()
		// 已弃用。
		// 这种方法本质上是不安全的。使用Thread.stop停止线程会导致它解锁所有已锁定的监视器（作为未ThreadDeath检查异常向上传播到堆栈的自然结果
		// ）。如果先前由这些监视器保护的任何对象处于不一致状态，则损坏的对象变得对其他线程可见，可能导致任意行为。许多应用程序stop应该被替换为简单地修改一些变量以指示目标线程应该停止运行的代码。目标线程应该定期检查此变量，并且如果变量指示它要停止运行，则以有序的方式从其run方法返回。如果目标线程等待很长时间（例如，在条件变量上），则interrupt应该使用该方法来中断等待。有关更多信息，请参阅
		// 为什么Thread.stop，Thread.suspend和Thread.resume已弃用？。
		// void stop(Throwable obj)
		// 已弃用。
		// 这种方法本质上是不安全的。详情请参阅stop()
		// 。这种方法的另一个危险是它可以用于生成目标线程未准备处理的异常（包括线程不可能抛出的检查异常，如果不是这种方法）。有关更多信息，请参阅
		// 为什么Thread.stop，Thread.suspend和Thread.resume已弃用？。
		// void suspend()
		// 已弃用。
		// 此方法已被弃用，因为它本质上是死锁容易的。如果目标线程在挂起时保留关键系统资源的监视器上的锁定，则在目标线程恢复之前，任何线程都不能访问此资源。如果恢复目标线程的线程尝试在调用之前锁定此监视器resume，则死锁结果。这种死锁通常表现为“冻结”过程。有关更多信息，请参阅
		// 为什么Thread.stop，Thread.suspend和Thread.resume已弃用？。
		// String toString()
		// 返回此线程的字符串表示形式，包括线程的名称，优先级和线程组。
		// static void yield()
		// 对调度程序提示当前线程愿意产生其当前使用的处理器。
		// 从类java.lang继承的方法。目的
		// equals, finalize, getClass, hashCode, notify, notifyAll, wait, wait,
		// wait
		// 字段详细信息
		//
		// MIN_PRIORITY
		// public static final int MIN_PRIORITY
		// 线程可以拥有的最小优先级。
		// 也可以看看：
		// 常数字段值
		// NORM_PRIORITY
		// public static final int NORM_PRIORITY
		// 分配给线程的默认优先级。
		// 也可以看看：
		// 常数字段值
		// MAX_PRIORITY
		// public static final int MAX_PRIORITY
		// 线程可以拥有的最大优先级。
		// 也可以看看：
		// 常数字段值
		// 构造函数详细信息
		//
		// 线
		// public Thread（）
		// 分配一个新Thread对象。此构造函数与Thread 具有相同的效果(null, null,
		// gname)，其中gname是新生成的名称。自动生成的名称的格式为 "Thread-"+n，其中n是整数。
		// 线
		// 公共线程（Runnable target）
		// 分配一个新Thread对象。此构造函数与Thread 具有相同的效果(null, target,
		// gname)，其中gname是新生成的名称。自动生成的名称的格式为 "Thread-"+n，其中n是整数。
		// 参数：
		// target- run当此线程启动时调用方法的对象。如果null，这个类run方法什么也不做。
		// 线
		// 公共线程（ThreadGroup 组，
		// Runnable 目标）
		// 分配一个新Thread对象。此构造函数与Thread 具有相同的效果(group, target,
		// gname)，其中gname是新生成的名称。自动生成的名称的格式为 "Thread-"+n，其中n是整数。
		// 参数：
		// group -
		// 螺纹组。如果null有安全管理器，则该组由SecurityManager.getThreadGroup（）确定。如果没有安全管理器或SecurityManager.getThreadGroup()返回null，则该组将设置为当前线程的线程组。
		// target- run当此线程启动时调用方法的对象。如果null，这个线程的run方法被调用。
		// 投掷：
		// SecurityException - 如果当前线程无法在指定的线程组中创建线程
		// 线
		// public Thread（String name）
		// 分配一个新Thread对象。这个构造函数具有与Thread 相同的效果(null, null, name)。
		// 参数：
		// name - 新线程的名称
		// 线
		// public Thread（ThreadGroup group，
		// String name）
		// 分配一个新Thread对象。这个构造函数具有与Thread 相同的效果(group, null, name)。
		// 参数：
		// group -
		// 螺纹组。如果null有安全管理器，则该组由SecurityManager.getThreadGroup（）确定。如果没有安全管理器或SecurityManager.getThreadGroup()返回null，则该组将设置为当前线程的线程组。
		// name - 新线程的名称
		// 投掷：
		// SecurityException - 如果当前线程无法在指定的线程组中创建线程
		// 线
		// public Thread（Runnable target，
		// String name）
		// 分配一个新Thread对象。这个构造函数具有与Thread 相同的效果(null, target, name)。
		// 参数：
		// target- run当此线程启动时调用方法的对象。如果null，这个线程的run方法被调用。
		// name - 新线程的名称
		// 线
		// 公共线程（ThreadGroup 组，
		// Runnable 目标，
		// 字符串 名称）
		// 分配一个新Thread对象，使其具有target 作为其运行对象，指定name为其名称，并且属于引用的线程组group。
		// 如果有安全管理器，checkAccess 则以ThreadGroup作为其参数来调用其 方法。
		//
		// 此外， 当直接或间接通过覆盖
		// 或方法的子类checkPermission的RuntimePermission("enableContextClassLoaderOverride")构造函数调用时，它的方法被调用权限。
		// getContextClassLoadersetContextClassLoader
		//
		// 新创建的线程的优先级设置为创建它的线程的优先级，即当前正在运行的线程。方法setPriority可以用于将优先级改变为新值。
		//
		// 当且仅当创建它的线程当前被标记为守护线程时，新创建的线程才被初始标记为守护线程。方法setDaemon 可用于更改线程是否是守护程序。
		//
		// 参数：
		// group -
		// 螺纹组。如果null有安全管理器，则该组由SecurityManager.getThreadGroup（）确定。如果没有安全管理器或SecurityManager.getThreadGroup()返回null，则该组将设置为当前线程的线程组。
		// target- run当此线程启动时调用方法的对象。如果null，这个线程的run方法被调用。
		// name - 新线程的名称
		// 投掷：
		// SecurityException - 如果当前线程无法在指定的线程组中创建线程或无法覆盖上下文类加载器方法。
		// 线
		// 公共线程（ThreadGroup 组，
		// Runnable 目标，
		// 字符串 名称，
		// long stackSize）
		// 分配一个新Thread对象，使其具有target
		// 作为其运行对象，指定name为其名称，并且属于由引用的线程组group，并具有指定的堆栈大小。
		// 这个构造函数Thread(ThreadGroup,Runnable,String)与除了允许指定线程堆栈大小的事实相同。堆栈大小是虚拟机要为此线程的堆栈分配的地址空间的大致字节数。
		// 参数的效果（ stackSize如果有的话）高度依赖于平台。
		//
		// 在某些平台上，指定更高的参数值
		// stackSize可能允许线程在抛出之前达到更大的递归深度StackOverflowError。类似地，指定较低的值可允许更多数量的线程同时存在而不引发OutOfMemoryError（或其他内部错误）。该值之间的关系的细节的stackSize参数和最大递归深度和并发级别是依赖于平台的。
		// 在某些平台上，参数的值 stackSize可能没有任何影响。
		//
		// 虚拟机可以将该stackSize 参数视为建议。如果平台的指定值不合理地低，则虚拟机可以改为使用一些平台特定的最小值;
		// 如果指定的值不合理地高，则虚拟机可以改为使用一些平台特定的最大值。同样，虚拟机可以自由地向上或向下舍入指定值，因为它认为合适（或完全忽略它）。
		//
		// 为参数指定零值stackSize将使此构造函数的行为与 Thread(ThreadGroup, Runnable,
		// String)构造函数完全相同。
		//
		// 由于此构造函数的行为的平台相关性质，在其使用中应该非常小心。执行给定计算所需的线程堆栈大小可能从一个JRE实现到另一个JRE实现。鉴于这种变化，可能需要仔细调整堆栈大小参数，并且可能需要对应用程序在其上运行的每个JRE实现重复调整。
		//
		// 实现注意事项：鼓励Java平台实现者记录其实现相对于参数的行为 stackSize。
		//
		// 参数：
		// group -
		// 螺纹组。如果null有安全管理器，则该组由SecurityManager.getThreadGroup（）确定。如果没有安全管理器或SecurityManager.getThreadGroup()返回null，则该组将设置为当前线程的线程组。
		// target- run当此线程启动时调用方法的对象。如果null，这个线程的run方法被调用。
		// name - 新线程的名称
		// stackSize - 新线程的所需堆栈大小，或零，表示要忽略此参数。
		// 投掷：
		// SecurityException - 如果当前线程无法在指定的线程组中创建线程
		// 以来：
		// 1.4
		// 方法详细信息
		//
		// currentThread
		// public static Thread currentThread（）
		// 返回对当前正在执行的线程对象的引用。
		// 返回：
		// 当前正在执行的线程。
		// 产量
		// public static void yield（）
		// 对调度程序提示当前线程愿意产生其当前使用的处理器。调度程序可以随意忽略此提示。
		// 产量是一种启发式尝试来改善线程之间的相对进展，否则会过度利用CPU。它的使用应结合详细的剖析和基准测试，以确保它实际上具有预期的效果。
		//
		// 使用此方法很少适合。它可能有用于调试或测试目的，它可能有助于重现由于竞争条件的错误。在设计诸如java.util.concurrent.locks包中的并发控制结构的并发控制结构时，它也可能是有用的
		// 。
		//
		// 睡觉
		// public static void sleep（long millis）
		// throws InterruptedException
		// 导致当前执行的线程睡眠（临时停止执行）指定的毫秒数，服从系统计时器和调度程序的精度和准确性。线程不会丢失任何监视器的所有权。
		// 参数：
		// millis - 睡眠时间长度（以毫秒为单位）
		// 投掷：
		// IllegalArgumentException- 如果值为millis负
		// InterruptedException - 如果任何线程已中断当前线程。抛出此异常时，将清除当前线程的 中断状态。
		// 睡觉
		// public static void sleep（long millis，
		// int nanos）
		// throws InterruptedException
		// 使当前执行的线程睡眠（临时停止执行）指定的毫秒数加上指定的纳秒数，服从系统计时器和调度程序的精度和准确性。线程不会丢失任何监视器的所有权。
		// 参数：
		// millis - 睡眠时间长度（以毫秒为单位）
		// nanos- 0-999999额外纳秒睡眠
		// 投掷：
		// IllegalArgumentException- 如果值为millis负，或值 nanos不在范围内0-999999
		// InterruptedException - 如果任何线程已中断当前线程。抛出此异常时，将清除当前线程的 中断状态。
		// 克隆
		// protected Object clone（）
		// throws CloneNotSupportedException
		// 抛出CloneNotSupportedException作为线程不能被有意义地克隆。构造一个新的线程。
		// 覆盖：
		// clone 在班上 Object
		// 返回：
		// 这个实例的克隆。
		// 投掷：
		// CloneNotSupportedException - 总是
		// 也可以看看：
		// Cloneable
		// 开始
		// public void start（）
		// 导致此线程开始执行; Java虚拟机调用run此线程的方法。
		// 结果是两个线程并发运行：当前线程（从调用返回到 start方法）和另一个线程（执行它的 run方法）。
		//
		// 多次启动线程是不合法的。特别地，一旦线程已经完成执行就不会重新启动。
		//
		// 投掷：
		// IllegalThreadStateException - 如果线程已经启动。
		// 也可以看看：
		// run()， stop()
		// 跑
		// public void run（）
		// 如果这个线程是使用单独的 Runnable运行对象构造的，那么该 Runnable对象的run方法被调用;
		// 否则，此方法不执行任何操作并返回。
		// 的子类Thread应该重写此方法。
		//
		// 指定者：
		// run 在界面 Runnable
		// 也可以看看：
		// start()， stop()， Thread(ThreadGroup, Runnable, String)
		// 停止
		// @Deprecated
		// public final void stop（）
		// 已弃用。
		// 这种方法本质上是不安全的。使用Thread.stop停止线程会导致它解锁所有已锁定的监视器（作为未ThreadDeath检查异常向上传播到堆栈的自然结果
		// ）。如果先前由这些监视器保护的任何对象处于不一致状态，则损坏的对象变得对其他线程可见，可能导致任意行为。许多应用程序stop应该被替换为简单地修改一些变量以指示目标线程应该停止运行的代码。目标线程应该定期检查此变量，并且如果变量指示它要停止运行，则以有序的方式从其run方法返回。如果目标线程等待很长时间（例如，在条件变量上），则interrupt应该使用该方法来中断等待。有关更多信息，请参阅
		// 为什么Thread.stop，Thread.suspend和Thread.resume已弃用？。
		// 强制线程停止执行。
		// 如果安装了安全管理器，checkAccess 则会调用其方法this 作为其参数。这可能导致
		// SecurityException升高（在当前线程中）。
		//
		// 如果这个线程与当前线程不同（也就是说，当前线程试图停止除自身之外的线程），那么还会调用安全管理器的checkPermission方法（带有
		// RuntimePermission("stopThread")参数）。再次，这可能导致抛出
		// SecurityException（在当前线程中）。
		//
		// 由该线程表示的线程被强制停止，无论它正在做什么异常，并抛出一个新创建的 ThreadDeath对象作为异常。
		//
		// 允许停止尚未启动的线程。如果线程最终启动，它立即终止。
		//
		// 应用程序通常不应该尝试捕获 ThreadDeath，除非它必须做一些非凡的清理操作（注意，
		// 在线程正式死亡之前执行语句的ThreadDeath原因finally子句的 try抛出）。如果一个catch子句捕获一个
		// ThreadDeath对象，重要的是重新抛出该对象，以使线程实际上死掉。
		//
		// 对其他未捕获的异常作出反应的顶层错误处理程序不打印出消息，或者如果未捕获的异常是实例，则通知应用程序 ThreadDeath。
		//
		// 投掷：
		// SecurityException - 如果当前线程不能修改此线程。
		// 也可以看看：
		// interrupt()， checkAccess()， run()， start()， ThreadDeath，
		// ThreadGroup.uncaughtException(Thread,Throwable)，
		// SecurityManager.checkAccess(Thread)，
		// SecurityManager.checkPermission(java.security.Permission)
		// 停止
		// @Deprecated
		// public final void stop（Throwable obj）
		// 已弃用。 这种方法本质上是不安全的。详情请参阅stop()
		// 。这种方法的另一个危险是它可以用于生成目标线程未准备处理的异常（包括线程不可能抛出的检查异常，如果不是这种方法）。有关更多信息，请参阅
		// 为什么Thread.stop，Thread.suspend和Thread.resume已弃用？。
		// 强制线程停止执行。
		// 如果安装了安全管理器，则checkAccess 调用此线程的方法，这可能导致 SecurityException（在当前线程中）引发。
		//
		// 如果这个线程与当前线程不同（也就是说，当前线程试图停止除自身以外的线程）或
		// obj不是其实例ThreadDeath，那么还会调用安全管理器的checkPermission方法（带
		// RuntimePermission("stopThread")参数）。再次，这可能导致抛出
		// SecurityException（在当前线程中）。
		//
		// 如果参数obj为null， NullPointerException则抛出（在当前线程中）。
		//
		// 由该线程表示的线程被强制停止，无论它正在做什么异常，并抛出该 Throwable对象obj作为异常。这是一个不寻常的行动;
		// 通常，stop应该使用不带参数的方法。
		//
		// 允许停止尚未启动的线程。如果线程最终启动，它立即终止。
		//
		// 参数：
		// obj - 要抛出的Throwable对象。
		// 投掷：
		// SecurityException - 如果当前线程不能修改此线程。
		// NullPointerException- 如果obj为null。
		// 也可以看看：
		// interrupt()， checkAccess()， run()， start()， stop()，
		// SecurityManager.checkAccess(Thread)，
		// SecurityManager.checkPermission(java.security.Permission)
		// 打断
		// public void interrupt（）
		// 中断此线程。
		// 除非当前线程正在中断它自己，这总是允许的，checkAccess调用这个线程的方法，这可能导致SecurityException抛出。
		//
		// 如果该线程阻塞的调用wait()，wait(long)或wait(long, int)该方法的Object
		// 类或的join()，join(long)，join(long, int)，sleep(long)，或者sleep(long,
		// int)，这种类，方法则其中断状态将被清除，它还将收到一个InterruptedException。
		//
		// 如果该线程在可中断通道的I /
		// O操作中被阻塞，则通道将被关闭，线程的中断状态将被设置，并且线程将接收到ClosedByInterruptException。
		//
		// 如果这个线程被阻塞在一个Selector
		// 线程的中断状态将被设置，它将立即从选择操作返回，可能有一个非零的值，就像选择器的wakeup方法被调用。
		//
		// 如果前面的条件没有保持，则该线程的中断状态将被设置。
		//
		// 中断不活动的线程不需要有任何效果。
		//
		// 投掷：
		// SecurityException - 如果当前线程不能修改此线程
		// 中断
		// public static boolean interrupted（）
		// 测试当前线程是否已中断。线程的
		// 中断状态由此方法清除。换句话说，如果这个方法被连续调用两次，第二次调用将返回假（除非当前线程在第一次调用清除其中断状态之后，第二次调用检查它之前再次中断）。
		// 线程中断被忽略，因为在中断时线程不存活，这个方法将返回false。
		//
		// 返回：
		// true如果当前线程已经中断; false除此以外。
		// 也可以看看：
		// isInterrupted()
		// isInterrupted
		// public boolean isInterrupted（）
		// 测试此线程是否已中断。线程的中断状态不受此方法的影响。
		// 线程中断被忽略，因为在中断时线程不存活，这个方法将返回false。
		//
		// 返回：
		// true如果这个线程已经中断了; false除此以外。
		// 也可以看看：
		// interrupted()
		// 破坏
		// @Deprecated
		// public void destroy（）
		// 已弃用。
		// 这个方法最初被设计为在没有任何清理的情况下销毁这个线程。它持有的任何监视器都将被锁定。但是，该方法从未实现。如果要实施，它将以大多数方式出现死锁倾向suspend()。如果目标线程持有一个锁，保护关键系统资源，当它被销毁时，任何线程都不能再次访问此资源。如果另一个线程尝试锁定此资源，将导致死锁。这种死锁通常表现为“冻结”过程。有关更多信息，请参阅
		// 为什么Thread.stop，Thread.suspend和Thread.resume已弃用？。
		// 投掷NoSuchMethodError。
		// 投掷：
		// NoSuchMethodError - 总是
		// 活着
		// public final boolean isAlive（）
		// 测试此线程是否存活。如果线程已经启动并且尚未死亡，则该线程仍然存在。
		// 返回：
		// true如果这个线程活着; false除此以外。
		// 暂停
		// @Deprecated
		// public final void suspend（）
		// 已弃用。
		// 此方法已被弃用，因为它本质上是死锁容易的。如果目标线程在挂起时保留关键系统资源的监视器上的锁定，则在目标线程恢复之前，任何线程都不能访问此资源。如果恢复目标线程的线程尝试在调用之前锁定此监视器resume，则死锁结果。这种死锁通常表现为“冻结”过程。有关更多信息，请参阅
		// 为什么Thread.stop，Thread.suspend和Thread.resume已弃用？。
		// 暂停此主题。
		// 首先，checkAccess这个线程的方法被调用没有参数。这可能导致抛出一个 SecurityException （在当前线程中）。
		//
		// 如果线程是活的，它被挂起并且不再进一步进行，除非和直到它被恢复。
		//
		// 投掷：
		// SecurityException - 如果当前线程不能修改此线程。
		// 也可以看看：
		// checkAccess()
		// 恢复
		// @Deprecated
		// public final void resume（）
		// 已弃用。 此方法仅用于使用suspend()，已被弃用，因为它是死锁容易的。有关更多信息，请参阅
		// 为什么Thread.stop，Thread.suspend和Thread.resume已弃用？。
		// 恢复悬挂线程。
		// 首先，checkAccess这个线程的方法被调用没有参数。这可能导致抛出一个 SecurityException（在当前线程中）。
		//
		// 如果线程仍然活动但是被挂起，则它被恢复并且被允许在其执行中取得进展。
		//
		// 投掷：
		// SecurityException - 如果当前线程不能修改此线程。
		// 也可以看看：
		// checkAccess()， suspend()
		// setPriority
		// public final void setPriority（int newPriority）
		// 更改此线程的优先级。
		// 首先checkAccess，这个线程的方法被调用没有参数。这可能会导致投掷 SecurityException。
		//
		// 否则，此线程的优先级设置为指定newPriority线程组的最小允许优先级和最大允许优先级。
		//
		// 参数：
		// newPriority - 优先级设置此线程
		// 投掷：
		// IllegalArgumentException-如果优先级是不在范围MIN_PRIORITY到 MAX_PRIORITY。
		// SecurityException - 如果当前线程不能修改此线程。
		// 也可以看看：
		// getPriority()， checkAccess()， getThreadGroup()， MAX_PRIORITY，
		// MIN_PRIORITY， ThreadGroup.getMaxPriority()
		// getPriority
		// public final int getPriority（）
		// 返回此线程的优先级。
		// 返回：
		// 这个线程的优先级。
		// 也可以看看：
		// setPriority(int)
		// setName
		// public final void setName（String name）
		// 将此线程的名称更改为等于参数 name。
		// 首先checkAccess，这个线程的方法被调用没有参数。这可能会导致投掷 SecurityException。
		//
		// 参数：
		// name - 这个线程的新名称。
		// 投掷：
		// SecurityException - 如果当前线程不能修改此线程。
		// 也可以看看：
		// getName()， checkAccess()
		// getName
		// public final String getName（）
		// 返回此线程的名称。
		// 返回：
		// 这个线程的名字。
		// 也可以看看：
		// setName(String)
		// getThreadGroup
		// public final ThreadGroup getThreadGroup（）
		// 返回此线程所属的线程组。如果此线程已死亡（已停止），此方法将返回null。
		// 返回：
		// 这个线程的线程组。
		// activeCount
		// public static int activeCount（）
		// 返回当前线程的线程组及其子组中的活动线程数的估计值。递归迭代当前线程的线程组中的所有子组。
		// 返回的值仅为估计值，因为线程数可能会在此方法遍历内部数据结构时动态更改，并且可能会受到某些系统线程的存在的影响。此方法主要用于调试和监视目的。
		//
		// 返回：
		// 对当前线程的线程组和将当前线程的线程组作为祖先的任何其他线程组中的活动线程的数量的估计
		// 枚举
		// public static int enumerate（Thread [] tarray）
		// 将当前线程的线程组及其子组中的每个活动线程复制到指定的数组中。这个方法只是调用ThreadGroup.enumerate(Thread[])
		// 当前线程的线程组的方法。
		// 应用程序可能使用activeCount 方法来获取数组大小的估计值，但是 如果数组太短，无法容纳所有线程，则会忽略额外线程。
		// 如果获取当前线程的线程组及其子组中的每个活动线程是至关重要的，则调用者应验证返回的int值是否严格小于其长度tarray。
		//
		// 由于此方法中的固有竞争条件，建议该方法仅用于调试和监视目的。
		//
		// 参数：
		// tarray - 一个数组，放入线程列表
		// 返回：
		// 放入数组的线程数
		// 投掷：
		// SecurityException- 如果ThreadGroup.checkAccess()确定当前线程不能访问其线程组
		// countStackFrames
		// @Deprecated
		// public int countStackFrames（）
		// 已弃用。 此调用的定义取决于suspend()，不推荐使用。此外，这次电话的结果从来没有明确定义。
		// 计算此线程中的堆栈帧数。线程必须挂起。
		// 返回：
		// 在此线程中的堆栈帧数。
		// 投掷：
		// IllegalThreadStateException - 如果这个线程没有挂起。
		// 加入
		// public final void join（long millis）
		// throws InterruptedException
		// 等待最多millis几毫秒这个线程死。超时0意味着永远等待。
		// 这个实现使用一个this.wait调用的循环this.isAlive。当线程终止this.notifyAll时，调用该
		// 方法。它建议应用程序不能使用wait，notify或者 notifyAll在Thread实例。
		//
		// 参数：
		// millis - 以毫秒为单位的等待时间
		// 投掷：
		// IllegalArgumentException- 如果值为millis负
		// InterruptedException - 如果任何线程已中断当前线程。抛出此异常时，将清除当前线程的 中断状态。
		// 加入
		// public final void join（long millis，
		// int nanos）
		// throws InterruptedException
		// 等待最多millis几毫秒加上 nanos这个线程死亡的纳秒。
		// 这个实现使用一个this.wait调用的循环this.isAlive。当线程终止this.notifyAll时，调用该
		// 方法。它建议应用程序不能使用wait，notify或者 notifyAll在Thread实例。
		//
		// 参数：
		// millis - 以毫秒为单位的等待时间
		// nanos- 0-999999额外的纳秒等待
		// 投掷：
		// IllegalArgumentException- 如果值为millis负，或值nanos不在范围内0-999999
		// InterruptedException - 如果任何线程已中断当前线程。抛出此异常时，将清除当前线程的 中断状态。
		// 加入
		// public final void join（）
		// throws InterruptedException
		// 等待这个线程死亡。
		// 此方法的调用行为与调用完全相同
		//
		// 加入(0)
		// 投掷：
		// InterruptedException - 如果任何线程已中断当前线程。抛出此异常时，将清除当前线程的 中断状态。
		// dumpStack
		// public static void dumpStack（）
		// 将当前线程的堆栈跟踪打印到标准错误流。此方法仅用于调试。
		// 也可以看看：
		// Throwable.printStackTrace()
		// setDaemon
		// public final void setDaemon（boolean on）
		// 将此线程标记为守护线程或用户线程。当唯一运行的线程都是守护线程时，Java虚拟机退出。
		// 此方法必须在线程启动之前调用。
		//
		// 参数：
		// on- 如果true，将此线程标记为守护线程
		// 投掷：
		// IllegalThreadStateException- 如果这个线程是活的
		// SecurityException- 如果checkAccess()确定当前线程不能修改此线程
		// 是isemon
		// public final boolean isDaemon（）
		// 测试这个线程是否是守护线程。
		// 返回：
		// true如果这个线程是一个守护线程; false除此以外。
		// 也可以看看：
		// setDaemon(boolean)
		// checkAccess
		// public final void checkAccess（）
		// 确定当前运行的线程是否有修改此线程的权限。
		// 如果有一个安全管理器，它的checkAccess方法被调用与此线程作为其参数。这可能会导致投掷SecurityException。
		//
		// 投掷：
		// SecurityException - 如果当前线程不允许访问此线程。
		// 也可以看看：
		// SecurityManager.checkAccess(Thread)
		// public String toString（）
		// 返回此线程的字符串表示形式，包括线程的名称，优先级和线程组。
		// 覆盖：
		// toString 在班上 Object
		// 返回：
		// 这个线程的字符串表示。
		// getContextClassLoader
		// public ClassLoader getContextClassLoader（）
		// 返回此Thread的上下文ClassLoader。上下文ClassLoader由线程的创建者提供，以便在加载类和资源时在此线程中运行的代码使用。如果没有设置，默认是父Thread的ClassLoader上下文。原始线程的上下文ClassLoader通常设置为用于加载应用程序的类加载器。
		// 如果存在安全管理器，并且调用者的类加载器不是
		// null并且不与上下文类加载器相同或者是上下文类加载器的祖先，则该方法调用具有权限的安全管理器的checkPermission
		// 方法，以验证上下文类加载器的检索是允许。RuntimePermission("getClassLoader")
		//
		// 返回：
		// 这个Thread的上下文ClassLoader，或者null 指示系统类加载器（或者，如果失败，引导类加载器）
		// 投掷：
		// SecurityException - 如果当前线程无法获得上下文ClassLoader
		// 以来：
		// 1.2
		// setContextClassLoader
		// public void setContextClassLoader（ClassLoader cl）
		// 设置此线程的上下文ClassLoader。上下文ClassLoader可以在创建线程时设置，并允许线程的创建者通过getContextClassLoader向在线程中运行的代码加载类和资源时提供适当的类加载器。
		// 如果存在安全管理器，checkPermission
		// 则会调用其方法，并具有允许查看是否允许设置上下文ClassLoader的权限。RuntimePermission("setContextClassLoader")
		//
		// 参数：
		// cl - 这个Thread的上下文ClassLoader，或者null指示系统类加载器（或者，失败，引导类加载器）
		// 投掷：
		// SecurityException - 如果当前线程无法设置上下文ClassLoader
		// 以来：
		// 1.2
		// holdLock
		// public static boolean holdsLock（Object obj）
		// 当且仅当当前线程将监视器锁定在指定对象上时，返回true。
		// 此方法旨在允许程序断言当前线程已保存指定的锁：
		//
		// assert Thread.holdsLock（obj）;
		//
		// 参数：
		// obj - 要在其上测试锁所有权的对象
		// 返回：
		// 真如果当前线程在指定的对象上保持监视器锁。
		// 投掷：
		// NullPointerException- 如果obj为null
		// 以来：
		// 1.4
		// getStackTrace
		// public StackTraceElement [] getStackTrace（）
		// 返回表示此线程的堆栈转储的堆栈跟踪元素的数组。如果此线程尚未启动，已启动但尚未安排由系统运行或已终止，则此方法将返回零长度数组。如果返回的数组是非零长度，则数组的第一个元素表示堆栈的顶部，这是序列中最近的方法调用。数组的最后一个元素表示堆栈的底部，这是序列中最近一次的方法调用。
		// 如果有一个安全管理器，并且这个线程不是当前线程，那么将使用RuntimePermission（“getStackTrace”）权限调用安全管理器的
		// checkPermission方法， 以查看是否可以获取堆栈跟踪。
		//
		// 在一些情况下，一些虚拟机可以从堆栈跟踪中省略一个或多个堆栈帧。在极端情况下，允许没有关于此线程的堆栈跟踪信息的虚拟机从该方法返回零长度数组。
		//
		// 返回：
		// StackTraceElement的数组，每个表示一个堆栈帧。
		// 投掷：
		// SecurityException- 如果存在安全管理器，并且其 checkPermission方法不允许获取线程的堆栈跟踪。
		// 以来：
		// 1.5
		// 也可以看看：
		// SecurityManager.checkPermission(java.security.Permission)，
		// RuntimePermission， Throwable.getStackTrace()
		// getAllStackTracing
		// public static Map < Thread，StackTraceElement []> getAllStackTraces（）
		// 返回所有活动线程的堆栈跟踪的映射。在地图键是线程，每个地图值是一个数组
		// 的StackTraceElement表示相应的堆栈转储线程。返回的堆栈跟踪使用为getStackTrace方法指定的格式。
		// 在调用此方法时，线程可能正在执行。每个线程的堆栈跟踪仅表示快照，并且可以在不同时间获得每个堆栈跟踪。如果虚拟机没有关于线程的堆栈跟踪信息，则将在映射值中返回零长度数组。
		//
		// 如果有安全管理器，则安全管理器的 的checkPermission方法被调用了
		// 的RuntimePermission（“的getStackTrace”）权限和
		// RuntimePermission的（“modifyThreadGroup”）的许可，看它是否是确定获得所有线程的堆栈跟踪。
		//
		// 返回：
		// 一个地图，从主题到数组 的StackTraceElement表示相应线程的堆栈跟踪。
		// 投掷：
		// SecurityException- 如果存在安全管理器，并且其 checkPermission方法不允许获取线程的堆栈跟踪。
		// 以来：
		// 1.5
		// 也可以看看：
		// getStackTrace()，
		// SecurityManager.checkPermission(java.security.Permission)，
		// RuntimePermission， Throwable.getStackTrace()
		// getId
		// public long getId（）
		// 返回此Thread的标识符。线程ID是创建此线程时生成的正
		// 长整数。线程ID是唯一的，在其生命周期中保持不变。当线程被终止时，该线程ID可以被重用。
		// 返回：
		// 这个线程的ID。
		// 以来：
		// 1.5
		// getState
		// public Thread.State getState（）
		// 返回此线程的状态。此方法设计用于监视系统状态，而不是用于同步控制。
		// 返回：
		// 这个线程的状态。
		// 以来：
		// 1.5
		// setDefaultUncaughtExceptionHandler
		// public static void
		// setDefaultUncaughtExceptionHandler（Thread.UncaughtExceptionHandler
		// eh）
		// 设置当线程由于未捕获异常而突然终止时调用的默认处理程序，并且没有为该线程定义任何其他处理程序。
		// 未捕获的异常处理首先由线程控制，然后由线程的ThreadGroup对象控制，最后由默认的未捕获异常处理程序控制。如果线程没有明确的未捕获异常处理程序集，并且线程的线程组（包括父线程组）不专门化其
		// uncaughtException方法，那么将调用默认处理程序的 uncaughtException方法。
		//
		// 通过设置默认未捕获异常处理程序，应用程序可以更改处理未捕获异常的方式（例如记录到特定设备或文件），以便已经接受系统提供的任何“默认”行为的那些线程。
		//
		// 注意，默认的未捕获异常处理程序通常不应该依赖于线程的ThreadGroup对象，因为这可能导致无限递归。
		//
		// 参数：
		// eh - 用作默认未捕获异常处理程序的对象。如果为null，则没有默认处理程序。
		// 投掷：
		// SecurityException- 如果安全管理器存在并且拒绝RuntimePermission
		// （“setDefaultUncaughtExceptionHandler”）
		// 以来：
		// 1.5
		// 也可以看看：
		// setUncaughtExceptionHandler(java.lang.Thread.UncaughtExceptionHandler)，
		// getUncaughtExceptionHandler()，
		// ThreadGroup.uncaughtException(java.lang.Thread, java.lang.Throwable)
		// getDefaultUncaughtExceptionHandler
		// public static Thread.UncaughtExceptionHandler
		// getDefaultUncaughtExceptionHandler（）
		// 返回当线程因未捕获异常而突然终止时调用的默认处理程序。如果返回的值为null，则没有默认值。
		// 以来：
		// 1.5
		// 也可以看看：
		// setDefaultUncaughtExceptionHandler(java.lang.Thread.UncaughtExceptionHandler)
		// getUncaughtExceptionHandler
		// public Thread.UncaughtExceptionHandler getUncaughtExceptionHandler（）
		// 返回当此线程由于未捕获异常而突然终止时调用的处理程序。如果这个线程没有明确设置未捕获的异常处理程序，则返回该线程的
		// ThreadGroup对象，除非该线程已经终止，在这种情况下返回null。
		// 以来：
		// 1.5
		// setUncaughtExceptionHandler
		// public void
		// setUncaughtExceptionHandler（Thread.UncaughtExceptionHandler eh）
		// 设置当此线程由于未捕获异常而突然终止时调用的处理程序。
		// 线程可以完全控制它如何通过显式设置未捕获的异常处理程序来响应未捕获的异常。如果没有设置这样的处理程序，则线程的ThreadGroup
		// 对象充当其处理程序。
		//
		// 参数：
		// eh - 用作此线程的未捕获异常处理程序的对象。如果为null，则此线程没有显式处理程序。
		// 投掷：
		// SecurityException - 如果当前线程不允许修改此线程。
		// 以来：
		// 1.5
		// 也可以看看：
		// setDefaultUncaughtExceptionHandler(java.lang.Thread.UncaughtExceptionHandler)，
		// ThreadGroup.uncaughtException(java.lang.Thread, java.lang.Throwable)
		// 概述包类使用树已弃用指数帮帮我 Java™平台
		// 标准版 7 上一个类下一课框架无框架所有类概要： 嵌套 | 字段 | Constr | 方法详情： 字段 | Constr | 方法
		// 提交错误或功能
		// 有关更多API参考和开发人员文档，请参阅Java
		// SE文档。该文档包含更详细的，面向开发人员的描述，概念概述，术语定义，解决方法和工作代码示例。
		// 版权所有 © 1993，2016，Oracle和/或其分支机构。版权所有。使用须遵守许可条款。另请参阅文档重新分发策略。

		Thread t = new HelloThread();
		t.start();
		// getContextClassLoader()
		// 返回此Thread的上下文ClassLoader。
		System.out.println(t.getContextClassLoader());
		// getState返回此线程的状态。
		System.out.println(t.getState());
		Thread.sleep(2000);
		// t.isAlive()测试此线程是否存活。
		System.out.println(t.isAlive());

		// Waits for this thread to die.
		// An invocation of this method behaves in exactly the same way as the
		// invocation
		// 等待这个线程死亡。此方法的调用行为正确
		// Thread.join(); // 加入一个线程运行，直到该线程运行完毕
		System.out.println("join");
		Thread tb = new ThreadB("ThreadB");
		Thread ta = new ThreadA(tb, "ThreadA");

		ta.start();
		tb.start();
	}

	static class HelloThread extends Thread {

		@Override
		public void run() {
			// 将当前线程的堆栈跟踪打印到标准错误流。
			dumpStack();
			System.out.println(isAlive());
			System.out.println("hello   " + (new Date().toLocaleString()) + ":" + Thread.currentThread());
		}

	}

	static class ThreadA extends Thread {

		private Thread tb;

		public ThreadA(Thread tb, String name) {
			super(name);
			this.tb = tb;
		}

		@Override
		public void run() {

			System.out.println(Thread.currentThread() + "\t开始");
			try {
				// 加入一个线程运行，直到该线程运行完毕
				tb.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread() + "运行...");
			System.out.println(Thread.currentThread() + "\t运行完毕");
		}
	}

	static class ThreadB extends Thread {

		public ThreadB(String name) {
			super(name);
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread() + "\t开始");
			try {
				long st = 10000;
				Thread.sleep(st);
				System.out.println(Thread.currentThread() + "休眠" + (st / 1000) + "秒");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread() + "运行...");
			System.out.println(Thread.currentThread() + "\t运行完毕");
		}
	}

}
