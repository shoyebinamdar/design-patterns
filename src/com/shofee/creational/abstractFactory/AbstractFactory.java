package com.shofee.creational.abstractFactory;

public interface AbstractFactory<T> {
    T create(String animalType) ;
}

