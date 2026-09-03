package com.juarez.stream_API.lambdas.interfaces.engine.problem;

import com.juarez.stream_API.lambdas.interfaces.contract.Attackable;
import com.juarez.stream_API.lambdas.interfaces.contract.Healable;

import java.util.logging.Logger;

public class Mage implements Attackable, Healable {


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

    @Override
    public void attack() {

        log.info(name + " attacks with a fireball!");


    }

    @Override
    public void heal() {

        log.info(name + " heals with arcane energy!");

    }
}
