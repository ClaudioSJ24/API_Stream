package com.juarez.stream_API.lambdas.interfaces.engine.problem;

import com.juarez.stream_API.lambdas.interfaces.contract.Attackable;
import com.juarez.stream_API.lambdas.interfaces.contract.Healable;

import java.util.logging.Logger;

public class Archer implements Attackable, Healable {

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

     @Override
    public void attack() {

        logger.info(name + " attacks with an arrow!");

    }

    @Override
    public void heal() {

        logger.info(name + " heals with herbs!");

    }
}
