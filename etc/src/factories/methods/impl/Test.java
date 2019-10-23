package factories.methods.impl;

//方法工厂
import factories.methods.interfaces.Car;

public class Test {


    @org.junit.jupiter.api.Test
    public void test() {
        Car audi =  new AudiFactory().create();
        Car mzd = new MzdFactory().create();
        audi.engine();
        mzd.engine();


    }
}
