package com.shofee.creational;

public class Singleton {
    private Singleton() {
        /*This is a widely used approach for a Singleton class as it doesn’t require synchronization,
        is thread safe, enforces lazy initialization and has comparatively less boilerplate.*/
    }

    private static class SingletonHolder {
        public static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }

    public static void main(String[] args) {
        Singleton.getInstance();
    }
}

