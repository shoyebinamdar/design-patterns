package com.shofee.behavioural;

interface Bird {
    void fly();
    void makeSound();
}

class Sparrow implements Bird {
    public void fly() {
        System.out.println("Fly");
    }

    public void makeSound() {
        System.out.println("Chirp Chirp");
    }
}

interface ToyDuck {
    //A toy duck cannot fly but just does squak!!
    void squak();
}

class PlasticToyDuck implements ToyDuck {
    public void squak() {
        System.out.println("Squak");
    }
}

class BirdAdapter implements ToyDuck {
    Bird bird;

    public BirdAdapter(Bird _bird) {
        this.bird = _bird;
    }

    public void squak() {
        this.bird.makeSound();
    }
}

public class Adapter {
    public static void main(String args[]) {
        //Normal bird can fly and make sound
        Bird bird = new Sparrow();
        bird.fly();
        bird.makeSound();

        //nrmal toy duck
        ToyDuck toyDuck = new PlasticToyDuck();
        toyDuck.squak();

        //toy duck who can make bird sound..
        ToyDuck birdAdapter = new BirdAdapter(bird);
        birdAdapter.squak();
    }
}
