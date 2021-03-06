package net.tralfamadore.rlgWeb.combat;


import net.tralfamadore.base.Die;
import net.tralfamadore.rlgWeb.entity.Creature;
import net.tralfamadore.rlgWeb.stat.Stat;

import java.util.Collections;
import java.util.List;

/**
 * Class: BurningHands
 * Created by billreh on 4/8/17.
 */
public class BurningHands implements Attack, Targeted {
    private Creature attacker;

    public BurningHands(Creature attacker) {
        this.attacker = attacker;
    }

    @Override
    public String getName() {
        return "Burning Hands";
    }

    @Override
    public AttackRange getRange() {
        return AttackRange.MELEE;
    }

    @Override
    public DamageType getDamageType() {
        return DamageType.MAGIC;
    }

    @Override
    public List<Effect> getEffects() {
        return Collections.emptyList();
    }

    @Override
    public int getDamage() {
        int damage = 0;

        for(int i = 0; i < attacker.getLevel(); i++)
            damage += new Die(1, Die.Type.D6, attacker.getStat(Stat.StatType.INT).getValue() / 10).roll();

        return damage;
    }

    @Override
    public void accept(Creature creature) {
        creature.damage(getDamage(), getDamageType());
    }

}
