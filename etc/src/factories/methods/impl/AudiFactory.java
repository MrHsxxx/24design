package factories.methods.impl;


import factories.methods.interfaces.Car;
import factories.methods.interfaces.CarFactory;

public class AudiFactory implements CarFactory {


    @Override
    public Car create() {
        return new Audi();
    }
}
