package com.shofee.creational.abstractFactory;

public class ColorFactory implements AbstractFactory<Color> {
    @Override
    public Color create(String type) {
        if ("White".equalsIgnoreCase(type)) {
            return new White();
        } else if ("Brown".equalsIgnoreCase(type)) {
            return new Brown();
        }

        return null;
    }
}
