package com.juarez.stream_API.lambdas.interfaces.engine.problem;

import com.juarez.stream_API.lambdas.interfaces.contract.Attackable;
import com.juarez.stream_API.lambdas.interfaces.contract.Healable;

import java.util.logging.Logger;

public class BattleEngine {

    private static final Logger log = Logger.getLogger(BattleEngine.class.getName());

//    // PROBLEM: This method only works with Warrior
//    // Adding a new character type requires modifying this class
//    public void startBattleWithWarrior(Warrior warrior) {
//        log.info("Battle startBattleWithWarrior!");
//        warrior.attack();
//    }
//
//    // PROBLEM: Duplicated method for Mage — same logic, different type
//    public void startBattleWithMage(Mage mage) {
//        log.info("Battle startBattleWithMage!");
//        mage.attack();
//    }
//
//    // PROBLEM: Duplicated again for Archer
//    public void startBattleWithArcher(Archer archer) {
//        log.info("Battle startBattleWithArcher!");
//        archer.attack();
//    }

    public void startBattle(Attackable character) {
        log.info("Battle startBattle");
        character.attack();
    }

    public void setHeal(Healable character) {
        log.info("Battle setHeal");
        character.heal();
    }

    // How would you add a new character type — Paladin — without
    //
}
