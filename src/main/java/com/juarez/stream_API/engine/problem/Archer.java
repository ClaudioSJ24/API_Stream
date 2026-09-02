package com.juarez.stream_API.engine.problem;

import java.util.logging.Logger;

public class Archer {

    private static final Logger logger = Logger.getLogger(Archer.class.getName());

    private String name;
    private int health;

    public Archer(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void archerAttack() {
        logger.info(name + " attacks with an arrow!");
    }

    public void archerHeal() {
        logger.info(name + " heals with herbs!");
    }
}
