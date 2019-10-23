package singleton;

/***
 * 双重锁模式 也是懒加载的一种，volatile是关键
 *
 * 为什么要使用volatile修饰？
 * 虽然已经使用synchronized进行同步，但在第4步创建对象时，会有下面的伪代码：
 * memory=allocate(); //1：分配内存空间
 * ctorInstance(); //2:初始化对象
 * singleton=memory; //3:设置singleton指向刚排序的内存空间
 * 当线程A在执行上面伪代码时，2和3可能会发生重排序，因为重排序并不影响运行结果，还可以提升性能
 * ，所以JVM是允许的。如果此时伪代码发生重排序，步骤变为1->3->2,线程A执行到第3步时，
 * 线程B调用getsingleton方法，在判断singleton==null时不为null，则返回singleton。
 * 但此时singleton并还没初始化完毕，线程B访问的将是个还没初始化完毕的对象。当声明对象的引用为volatile后，伪代码的2、3的重排序在多线程中将被禁止!
 */
public class DoubleLock {

    private volatile static DoubleLock singleton = null;

    public DoubleLock() {
    }

    public static DoubleLock getInstance() {
        if (singleton == null) {
            synchronized (DoubleLock.class) {
                if (singleton == null) {
                    singleton = new DoubleLock();
                }
            }
        }
        return singleton;
    }
}
