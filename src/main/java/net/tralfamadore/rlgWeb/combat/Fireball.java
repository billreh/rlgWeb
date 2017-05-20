package net.tralfamadore.rlgWeb.combat;

import net.tralfamadore.base.Die;
import net.tralfamadore.rlgWeb.entity.Creature;
import net.tralfamadore.rlgWeb.entity.Party;
import net.tralfamadore.rlgWeb.stat.Stat;

import java.util.Collections;
import java.util.List;

/**
 * Class: Fireball
 * Created by billreh on 5/19/17.
 */
public class Fireball implements Attack, Aoe {
    private Creature attacker;

    public Fireball(Creature attacker) {
        this.attacker = attacker;
    }

    @Override
    public void accept(Party party) {
        party.getMembers().forEach(member -> member.damage(getDamage(), getDamageType()));
    }

    @Override
    public String getName() {
        return "Fireball";
    }

    @Override
    public AttackRange getRange() {
        return AttackRange.RANGED;
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
        return new Die(attacker.getLevel(), Die.Type.D8, attacker.getStat(Stat.StatType.INT).getValue() / 10).roll();
    }
}
