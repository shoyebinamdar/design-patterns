package com.shofee.behavioral;

// Abstract as you must have a specific fighter
abstract class Fighter {
    KickBehaviour kickBehaviour;
    JumpBehaviour jumpBehaviour;

    public Fighter(KickBehaviour kickBehaviour, JumpBehaviour jumpBehaviour) {
        this.kickBehaviour = kickBehaviour;
        this.jumpBehaviour = jumpBehaviour;
    }

    public void punch() {
        System.out.println("Default Punch");
    }

    public void roll() {
        System.out.println("Default Roll");
    }

    public void setKickBehaviour(KickBehaviour kickBehaviour) {
        this.kickBehaviour = kickBehaviour;
    }

    public void kick() {
        // delegate to kick behaviour
        kickBehaviour.kick();
    }

    public void jump() {
        // delegate to jump behaviour
        jumpBehaviour.jump();
    }

    public void setJumpBehaviour(JumpBehaviour jumpBehaviour) {
        this.jumpBehaviour = jumpBehaviour;
    }

    abstract void display();
}

interface KickBehaviour {
    void kick();
}

// Encapsulated kick behaviors
class LightningKick implements KickBehaviour{
    public void kick() {
        System.out.println("Lightning Kick");
    }
}

class TornadoKick implements KickBehaviour {
    public void kick() {
        System.out.println("Tornado kick");
    }
}

interface JumpBehaviour {
    void jump();
}

// Encapsulated jump behaviors
class LongJump implements JumpBehaviour {
    public void jump() {
        System.out.println("Long Jump");
    }
}

class ShortJump implements JumpBehaviour {
    public void jump() {
        System.out.println("Short Jump");
    }
}

//Characters
class Ryu extends Fighter {
    public Ryu(KickBehaviour kickBehaviour, JumpBehaviour jumpBehaviour) {
        super(kickBehaviour, jumpBehaviour);
    }

    void display() {
        System.out.println("Ryu");
    }
}

class Ken extends Fighter {
    public Ken(KickBehaviour kickBehaviour, JumpBehaviour jumpBehaviour) {
        super(kickBehaviour, jumpBehaviour);
    }

    void display() {
        System.out.println("Ken");
    }
}

class ChunLi extends Fighter {
    public ChunLi(KickBehaviour kickBehaviour, JumpBehaviour jumpBehaviour) {
        super(kickBehaviour, jumpBehaviour);
    }

    void display() {
        System.out.println("ChunLi");
    }
}

// Client/Driver class
public class Strategy {
    public static void main(String args[]) {
        // make some behaviors first
        JumpBehaviour jumpBehaviour = new LongJump();
        JumpBehaviour jumpBehaviour2 = new ShortJump();
        KickBehaviour kickBehaviour = new LightningKick();
        KickBehaviour kickBehaviour2 = new TornadoKick();

        // Make a fighter with desired behaviors
        Fighter ryu = new Ryu(kickBehaviour, jumpBehaviour);
        ryu.display();

        // Test behaviors
        ryu.jump();
        ryu.kick();
        ryu.punch();
        ryu.roll();

        // Change behavior dynamically (algorithms are interchangeable)
        ryu.setJumpBehaviour(jumpBehaviour2);
        ryu.setKickBehaviour(kickBehaviour2);
        ryu.kick();
        ryu.jump();
    }
}
