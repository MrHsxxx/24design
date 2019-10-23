package singleton;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

class Test {

    @org.junit.jupiter.api.Test
    public void hungry_test() {
        Hungry hungry1 = Hungry.getInstance();
        Hungry hungry2 = Hungry.getInstance();
        System.out.println(hungry1 == hungry2);
    }

    @org.junit.jupiter.api.Test
    public void lazy_test(){
        LazyHungry lazy1 = LazyHungry.getInstance();
        LazyHungry lazy2 = LazyHungry.getInstance();
        System.out.println(lazy1 == lazy2);
    }

    @org.junit.jupiter.api.Test
    public void emnu_test(){
        Enumerate s =  Enumerate.SINGLETON;
        Enumerate s2 =  Enumerate.SINGLETON;
        System.out.println(s == s2);
    }

    @org.junit.jupiter.api.Test
    public void reflection_test () throws Exception {
        LazyHungry lazy1 = LazyHungry.getInstance();
        LazyHungry lazy2 = LazyHungry.getInstance();
        System.out.println(lazy1);
        System.out.println(lazy2);
        //除枚举外的单例，可以通过反射创建新用户
        Class<LazyHungry> lazy = (Class<LazyHungry>) Class.forName("singleton.LazyHungry");
        Constructor<LazyHungry> l = lazy.getDeclaredConstructor(null);
        l.setAccessible(true); //将私有构造方法公开
        //System.out.println(l.newInstance());


        //除枚举外的单例，可以通过反序列化创建新用户
        FileOutputStream fos = new FileOutputStream("/Users/hnxinzai/a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(lazy1);
        oos.close();
        fos.close();

        ObjectInputStream ois  = new ObjectInputStream(new FileInputStream("/Users/hnxinzai/a.txt"));
        LazyHungry lazy3 = (LazyHungry) ois.readObject();
        System.out.println(lazy3);
    }

    @org.junit.jupiter.api.Test
    public void thread_test(){
        //new Thread()
    }





}