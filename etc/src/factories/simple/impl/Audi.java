package factories.simple.impl;

import factories.simple.interfaces.Car;

public class Audi implements Car {


    @Override
    public void engine() {
        System.out.println("生产奥迪引擎");
    }
}
