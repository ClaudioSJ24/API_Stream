package com.juarez.stream_API.engine.problem;

import java.util.logging.Logger;

public class BattleEngine {

    private static final Logger log = Logger.getLogger(BattleEngine.class.getName());

    // PROBLEM: This method only works with Warrior
    // Adding a new character type requires modifying this class
    public void startBattleWithWarrior(Warrior warrior) {
        log.info("Battle startBattleWithWarrior!");
        warrior.warriorAttack();
    }

    // PROBLEM: Duplicated method for Mage — same logic, different type
    public void startBattleWithMage(Mage mage) {
        log.info("Battle startBattleWithMage!");
        mage.mageAttack();
    }

    // PROBLEM: Duplicated again for Archer
    public void startBattleWithArcher(Archer archer) {
        log.info("Battle startBattleWithArcher!");
        archer.archerAttack();
    }

    // How would you add a new character type — Paladin — without
    //
}
