package com.shofee.behavioral;

interface MobileState {
    void alert();
}

class Vibration implements MobileState {
    public void alert() {
        System.out.println("Vibration...");
    }
}

class Silent implements MobileState {
    public void alert() {
        System.out.println("Silent...");
    }
}

class Driving implements MobileState {
    public void alert() {
        System.out.println("Driving...");
    }
}

class Context {
    MobileState mobileState;

    public Context() {
        this.mobileState = new Vibration();
    }

    public void setMobileState(MobileState mobileState) {
        this.mobileState = mobileState;
    }

    public void alert() {
        this.mobileState.alert();
    }
}

public class State {
    public static void main(String args[]) {
        Context context = new Context();
        context.alert();
        context.setMobileState(new Silent());
        context.alert();
        context.setMobileState(new Vibration());
        context.alert();
        context.setMobileState(new Driving());
        context.alert();
    }
}
