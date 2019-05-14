package com.shofee.structural;

// Base interface for all pizza's
interface Pizza {
    String getDescription();
    int getCost();
}

// To decorate pizza dynamically
interface ToppingsDecorator extends Pizza {
}

class FarmHouse implements Pizza {
    public String getDescription() {
        return "Farm House Pizza";
    }

    public int getCost() {
        return 40;
    }
}

class Margheritta implements Pizza {
    public String getDescription() {
        return "Margheritta Pizza";
    }

    public int getCost() {
        return 30;
    }
}

class PeppyPaneer implements Pizza {
    public String getDescription() {
        return "Peppy Paneer Pizza";
    }

    public int getCost() {
        return 50;
    }
}

class ChickenFiesta implements Pizza {
    public String getDescription() {
        return "Chicken Fiesta Pizza";
    }

    public int getCost() {
        return 60;
    }
}

class FreshTomato implements ToppingsDecorator {
    //type of pizza object to decorate
    Pizza pizza;

    FreshTomato(Pizza _pizza) {
        this.pizza = _pizza;
    }

    public String getDescription() {
        return this.pizza.getDescription() + ", with Fresh Tomato";
    }

    public int getCost() {
        return this.pizza.getCost() + 20;
    }
}

class Jalapeno implements ToppingsDecorator {
    //type of pizza object to decorate
    Pizza pizza;

    Jalapeno(Pizza _pizza) {
        this.pizza = _pizza;
    }

    public String getDescription() {
        return this.pizza.getDescription() + ", with Jalapeno";
    }

    public int getCost() {
        return this.pizza.getCost() + 25;
    }
}

class Barbeque implements ToppingsDecorator {
    //type of pizza object to decorate
    Pizza pizza;

    Barbeque(Pizza _pizza) {
        this.pizza = _pizza;
    }

    public String getDescription() {
        return this.pizza.getDescription() + ", with Barbeque";
    }

    public int getCost() {
        return this.pizza.getCost() + 30;
    }
}

class Paneer implements ToppingsDecorator {
    //type of pizza object to decorate
    Pizza pizza;

    Paneer(Pizza _pizza) {
        this.pizza = _pizza;
    }

    public String getDescription() {
        return this.pizza.getDescription() + ", with Paneer";
    }

    public int getCost() {
        return this.pizza.getCost() + 30;
    }
}

public class Decorator {
    public static void main(String[] args) {

        //Create a margherita pizza
        Pizza p1 = new Margheritta();

        System.out.println(p1.getDescription());
        System.out.println(p1.getCost());

        //decorate margherita pizza with barbeque
        p1 = new Barbeque(p1);

        System.out.println(p1.getDescription());
        System.out.println(p1.getCost());

        //create chicken fiesta pizza
        Pizza p2 = new ChickenFiesta();

        System.out.println(p2.getDescription());
        System.out.println(p2.getCost());

        //decorate chicken fiesta pizza with jalapeeno
        p2 = new Jalapeno(p2);

        System.out.println(p2.getDescription());
        System.out.println(p2.getCost());
    }
}

