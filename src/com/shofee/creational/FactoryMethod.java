package com.shofee.creational;

enum VEHICLE_TYPE {
    TWO_WHEELER,
    THREE_WHEELER,
    FOUR_WHEELER
};

interface Vehicle {
    void printName();
}

class TwoWheeler implements Vehicle {

    public void printName() {
        System.out.println("Two Wheeler");
    }
}

class ThreeWheeler implements Vehicle {

    public void printName() {
        System.out.println("Three Wheeler");
    }
}

class FourWheeler implements Vehicle {

    public void printName() {
        System.out.println("Four Wheeler");
    }
}

class VehicleFactory {
    static Vehicle create(VEHICLE_TYPE type) {
        if (type == VEHICLE_TYPE.TWO_WHEELER)
            return new TwoWheeler();
        else if (type == VEHICLE_TYPE.THREE_WHEELER)
            return new ThreeWheeler();
        else if (type == VEHICLE_TYPE.FOUR_WHEELER)
            return new FourWheeler();
        else return null;
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        Vehicle v1 = VehicleFactory.create(VEHICLE_TYPE.TWO_WHEELER);
        v1.printName();
        v1 = VehicleFactory.create(VEHICLE_TYPE.THREE_WHEELER);
        v1.printName();
        v1 = VehicleFactory.create(VEHICLE_TYPE.FOUR_WHEELER);
        v1.printName();
    }
}
