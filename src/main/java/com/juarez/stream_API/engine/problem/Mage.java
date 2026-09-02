package com.juarez.stream_API.engine.problem;

import java.util.logging.Logger;

public class Mage {


    private static final Logger log = Logger.getLogger(Mage.class.getName());

    private String name;
    private int health;

    public Mage(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void mageAttack() {
        log.info(name + " attacks with a fireball!");
    }

    public void mageHeal() {
        log.info(name + " heals with arcane energy!");
    }
}
