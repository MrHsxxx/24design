package singleton;

/**
 * – 外部类没有static属性，则不会像饿汉式那样立即加载对象。
 * – 只有真正调用getInstance(),才会加载静态内部类。加载类时是线程 安全的。 instance是static final 类型，保证了内存中只有这样一个实例存在，而且只能被赋值一次，从而保证了线程安全性.
 * – 兼备了并发高效调用和延迟加载的优势!
 **/
public class StaticInnerClass {

    private StaticInnerClass() {
    }

    public static StaticInnerClass getInstance() {
        return InnerClass.singleton;
    }

    public static class InnerClass {
        private static final StaticInnerClass singleton = new StaticInnerClass();
    }
}
