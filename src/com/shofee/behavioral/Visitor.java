package com.shofee.behavioral;

// Visitable interface
interface ItemElement {
    int accept(ShoppingCartVisitor shoppingCartVisitor);
}

// Concrete Visitable class
class Book implements ItemElement {
    int price;
    String isbnNumber;

    Book(int _price, String _isbnNumber) {
        this.price = _price;
        this.isbnNumber = _isbnNumber;
    }

    public int getPrice() {
        return price;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public int accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }
}

// Concrete Visitable class
class Fruit implements ItemElement {
    int pricePerKg;
    int weight;
    String name;

    public Fruit(int pricePerKg, int weight, String name) {
        this.pricePerKg = pricePerKg;
        this.weight = weight;
        this.name = name;
    }

    public int getPricePerKg() {
        return pricePerKg;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public int accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }
}


// Visitor
interface ShoppingCartVisitor {
    // you can implement as many visitors you want depending on the requirement
    int visit(Book book);
    int visit(Fruit fruit);
}

// Concrete Visitor
class ShoppingCartVisitorImpl implements ShoppingCartVisitor {
    public int visit(Book book) {
        int cost;

        cost = book.getPrice();

        // apply 5% discount if cost is above 50
        if(book.getPrice() > 50)
            cost -= 5;

        System.out.println("Book ISBN::"+book.getIsbnNumber() + " cost = "+cost);

        return  cost;
    }

    public int visit(Fruit fruit) {
        int cost = fruit.getPricePerKg() * fruit.getWeight();
        System.out.println(fruit.getName() + " cost = " + cost);
        return cost;
    }
}

public class Visitor {
    public static void main(String[] args)
    {
        ItemElement[] items = new ItemElement[]{new Book(20, "1234"),
                new Book(100, "5678"), new Fruit(10, 2, "Banana"),
                new Fruit(5, 5, "Apple")};

        int total = calculatePrice(items);
        System.out.println("Total Cost = "+total);
    }

    private static int calculatePrice(ItemElement[] items)
    {
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        int sum=0;
        for(ItemElement item : items)
        {
            sum = sum + item.accept(visitor);
        }
        return sum;
    }
}
