package com.shofee.structural;

class A {
    public void methodA() {
        System.out.println("Method A");
    }
}

class B {
    public void methodB() {
        System.out.println("Method B");
    }
}

class C {
    public void methodC() {
        System.out.println("Method C");
    }
}

// Main interface class to hide the background complexity
class FacadeWrapper{
    A a;
    B b;
    C c;

    FacadeWrapper() {
        a = new A();
        b = new B();
        c = new C();
    }

    public void compute() {
        a.methodA();
        b.methodB();
        c.methodC();
    }

}

public class Facade {
    public static void main(String args[]) {
        // here we just call the compute method of FacadeWrapper which in turn takes care of the rest
        FacadeWrapper facadeWrapper = new FacadeWrapper();
        facadeWrapper.compute();
    }
}
