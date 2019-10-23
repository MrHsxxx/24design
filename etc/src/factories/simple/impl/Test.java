package factories.simple.impl;

import factories.simple.interfaces.Car;

public class Test {
    @org.junit.jupiter.api.Test
    public void test() {
        Car audi = CarFactories.give_audi();
        audi.engine();
        Car mzd = CarFactories.give_mzd();
        mzd.engine();

    }
}
