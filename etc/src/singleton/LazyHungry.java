package singleton;


import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 资源利用率高了。但是，每次调用getInstance()方法都要同步，并发 效率较低
 */
public class LazyHungry implements Serializable {

    private static LazyHungry singleton = null;

    private LazyHungry() {
        if (singleton != null){
            throw new RuntimeException();
        }

    }

    public static synchronized LazyHungry getInstance() {
        //防止反射构造多个对象
        if (singleton == null) {
            singleton = new LazyHungry();
        }
        return singleton;
    }

    //readResolve 方法的意思是，当你反序列化时，返回当前定义的对象，而不是返回反序列话生成的新对象
    private Object readResolve() throws ObjectStreamException {
        return singleton;
    }
}
