package net.tralfamadore.rlgWeb.combat;

import net.tralfamadore.rlgWeb.entity.Creature;
import net.tralfamadore.rlgWeb.item.Weapon;

import java.util.Collections;
import java.util.List;

/**
 * Class: Unarmed
 * Created by billreh on 4/11/17.
 */
public class Unarmed implements Weapon {
    private Creature attacker;

    public Unarmed(Creature attacker) {
        this.attacker = attacker;
    }

    @Override
    public List<Attack> getAttacks() {
        return Collections.singletonList(new UnarmedAttack(attacker));
    }
}
