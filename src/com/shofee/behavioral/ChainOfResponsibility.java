package com.shofee.behavioral;

interface Chain {
    void setNext(Chain next);
    void process(int n);
}

class PositiveProcessor implements Chain {
    private Chain nextInChain;

    public void setNext(Chain next) {
        this.nextInChain = next;
    }

    public void process(int n) {
        if (n > 0) {
            System.out.println("PositiveProcessor : " + n);
        } else {
            this.nextInChain.process(n);
        }
    }
}

class NegativeProcessor implements Chain {
    private Chain nextInChain;

    public void setNext(Chain next) {
        this.nextInChain = next;
    }

    public void process(int n) {
        if (n < 0) {
            System.out.println("NegativeProcessor : " + n);
        } else {
            this.nextInChain.process(n);
        }
    }
}

class ZeroProcessor implements Chain {
    private Chain nextInChain;

    public void setNext(Chain next) {
        this.nextInChain = next;
    }

    public void process(int n) {
        if (n == 0) {
            System.out.println("ZeroProcessor : " + n);
        } else {
            this.nextInChain.process(n);
        }
    }
}

public class ChainOfResponsibility {
    public static void main(String args[]) {
        //configuring chain of responsibility
        Chain c1 = new PositiveProcessor();
        Chain c2 = new NegativeProcessor();
        Chain c3 = new ZeroProcessor();
        c1.setNext(c2);
        c2.setNext(c3);

        //calling chain of responsibility
        c1.process(78);
        c1.process(-8);
        c1.process(45);
        c1.process(0);
        c1.process(-9);
    }
}
