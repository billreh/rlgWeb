package net.tralfamadore.rlgWeb.entity;


import net.tralfamadore.base.Die;

/**
 * Class: Monster
 * Created by billreh on 4/8/17.
 */
public interface Monster {
    void attack(Party party);
    Die getHitDice();
}
