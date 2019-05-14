package com.shofee.behavioural;

import java.util.HashMap;
import java.util.Random;

interface Player{
    void assignWeapon(String weapon);
    void mission();
}

class Terrorist implements Player {
    //Intrinsic attribute
    String task;
    //Extrinsic attribute
    String weapon;

    Terrorist() {
        task = "PLANT A BOMB";
    }

    public void assignWeapon(String weapon) {
        this.weapon = weapon;
    }

    public void mission() {
        System.out.println("Terrorist with weapon " + weapon + "|" + " Task is " + task);
    }
}

class CounterTerrorist implements Player {
    //Intrinsic attribute
    String task;
    //Extrinsic attribute
    String weapon;

    CounterTerrorist() {
        task = "DIFFUSE BOMB";
    }

    public void assignWeapon(String weapon) {
        this.weapon = weapon;
    }

    public void mission() {
        System.out.println("Counter Terrorist with weapon " + weapon + "|" + " Task is " + task);
    }
}

// Class used to get a player using HashMap (Returns an existing player if a player of given type exists, else creates a new player and returns it.
class PlayerFactory {
    //Map to store player object references
    private static HashMap<String, Player> hm = new HashMap<>();

    public static Player getPlayer(String type) {
        Player player = null;

        if(hm.containsKey(type))
            player =  hm.get(type);
        else {
            switch (type) {
                case "Terrorist":
                    System.out.println("Terrorist Created");
                    player = new Terrorist();
                    break;
                case "CounterTerrorist":
                    System.out.println("Counter Terrorist Created");
                    player = new CounterTerrorist();;
                    break;
                default:
                    System.out.println("Unreachable Code");
            }
            hm.put(type, player);
        }

        return player;
    }
}

//Client code
public class FlyWeight {
    public static void main(String args[]) {
        String[] playerType = {"Terrorist", "CounterTerrorist"};
        String[] weapons = {"AK-47", "Maverick", "Gut Knife", "Desert Eagle"};

        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            Player player = PlayerFactory.getPlayer(playerType[random.nextInt(playerType.length)]);
            player.assignWeapon(weapons[random.nextInt(weapons.length)]);
            player.mission();

        }
    }
}
