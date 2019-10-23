package singleton;

/** 饿汉
 * 饿汉式单例模式代码中，static变量会在类装载时初始化，此时也不会涉及多个线程对象访问该对象的问 题。虚拟机保证只会装载一次该类，肯定不会发生并发访问的问题。因此，可以省略synchronized关键字。
 * 问题:如果只是加载本类，而不是要调用getInstance()，甚至永远没有调用，则会造成资源浪费!
 * */
public class Hungry {

    private static final Hungry singleton = new Hungry();

    private Hungry() {
    }

    public static Hungry getInstance() {
        return singleton;
    }

    public void hello() {
        System.out.println("hello this is hungry singleton");
    }
}
