package net.tralfamadore.rlgWeb.combat;


import net.tralfamadore.rlgWeb.Die;
import net.tralfamadore.rlgWeb.Spell;
import net.tralfamadore.rlgWeb.Targeted;
import net.tralfamadore.rlgWeb.entity.Creature;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Class: BurningHands
 * Created by billreh on 4/8/17.
 */
public class BurningHands implements Attack, Spell, Targeted {
    private int level = 1;
    int exp = 0;

    @Override
    public void cast() {
        if(++exp % 10 == 0)
            level++;
    }

    @Override
    public int getLevel() {
        return level;
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

        for(int i = 0; i < getLevel(); i++)
            damage += new Die(Die.Type.D6).roll();

        return damage;
    }

    @Override
    public void accept(Creature creature) {
        creature.damage(getDamage(), getDamageType());
    }

}
