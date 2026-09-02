package com.juarez.stream_API.engine.problem;

import java.util.logging.Logger;

public class Warrior {

    private static final Logger log = Logger.getLogger(Warrior.class.getName());

    private String name;
    private int health;

    public Warrior(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void warriorAttack() {
        log.info(name + " attacks with sword!");
    }

    public void warriorHeal() {
        log.info(name + " heals with a potion!");
    }
}
