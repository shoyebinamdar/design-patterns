package com.shofee.structural;

// base abstractor
abstract class Vehicle {
    Workshop w1, w2;

    Vehicle(Workshop _w1, Workshop _w2) {
        this.w1 = _w1;
        this.w2 = _w2;
    }

    abstract void manufacture();
}

//refined abstractor
class Car extends Vehicle {
    Car(Workshop w1, Workshop w2) {
        super(w1, w2);
    }

    void manufacture() {
        System.out.println("Car");
        w1.work();
        w2.work();
    }
}

//refined abstractor2
class Bike extends Vehicle {
    Bike(Workshop w1, Workshop w2) {
        super(w1, w2);
    }

    void manufacture() {
        System.out.println("Bike");
        w1.work();
        w2.work();
    }
}

// implementer
interface Workshop {
    void work();
}

class Produce implements Workshop {
    public void work() {
        System.out.println("Produced");
    }
}

class Assemble implements Workshop {
    public void work() {
        System.out.println("Assembled");
    }
}

public class Bridge {
    public static void main(String args[]) {
        Vehicle vehicle1 = new Car(new Produce(), new Assemble());
        vehicle1.manufacture();
        Vehicle vehicle2 = new Bike(new Produce(), new Assemble());
        vehicle2.manufacture();
    }
}
