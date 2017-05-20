package net.tralfamadore.rlgWeb.combat;

import net.tralfamadore.rlgWeb.Die;
import net.tralfamadore.rlgWeb.entity.Creature;

import java.util.Collections;
import java.util.List;

/**
 * Class: UnarmedAttack
 * Created by billreh on 4/11/17.
 */
public class UnarmedAttack implements Attack {
    private Creature attacker;

    public UnarmedAttack(Creature attacker) {
        this.attacker = attacker;
    }

    @Override
    public String getName() {
        return "Unarmed Attack";
    }

    @Override
    public AttackRange getRange() {
        return AttackRange.MELEE;
    }

    @Override
    public DamageType getDamageType() {
        return DamageType.PHYSICAL;
    }

    @Override
    public List<Effect> getEffects() {
        return Collections.emptyList();
    }

    @Override
    public int getDamage() {
        return new Die(Die.Type.D4).roll();
    }
}
