package factories.methods.impl;

import factories.methods.interfaces.Car;

public class Mzd implements Car {
    @Override
    public void engine() {
        System.out.println("生产马自达引擎");
    }
}
