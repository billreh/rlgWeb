package net.tralfamadore.rlgWeb.entity;


import net.tralfamadore.rlgWeb.combat.Attack;
import net.tralfamadore.rlgWeb.combat.DamageType;
import net.tralfamadore.rlgWeb.combat.Effect;
import net.tralfamadore.rlgWeb.item.Weapon;
import net.tralfamadore.rlgWeb.stat.Stat;

import java.util.List;

/**
 * Class: Creature
 * Created by billreh on 3/29/17.
 */
public interface Creature {
    Stat getStat(Stat.StatType statType);

    int getLevel();

    int getHealth();

    void damage(int health, DamageType damageType);

    void addHealth(int health);

    long getExperience();

    void addExperience(long exp);

    void addEffect(Effect effect);

    void removeEffect(Class<? extends Effect> effectClass);

    void applyEffects();

    List<Effect> getEffects();

    Party.Position getPosition();

    void setPosition(Party.Position position);

    Weapon getWeapon();

    List<Attack> getAttacks();

    boolean isDead();
}
