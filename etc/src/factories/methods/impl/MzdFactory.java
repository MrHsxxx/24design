package factories.methods.impl;


import factories.methods.interfaces.Car;
import factories.methods.interfaces.CarFactory;

public class MzdFactory implements CarFactory {


    @Override
    public Car create() {
        return new Mzd();
    }
}
