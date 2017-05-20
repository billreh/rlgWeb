package net.tralfamadore.rlgWeb.item;


import net.tralfamadore.rlgWeb.combat.Attack;

import java.util.List;

/**
 * Class: Weapon
 * Created by billreh on 4/11/17.
 */
public interface Weapon extends Item {
    List<Attack> getAttacks();
}
