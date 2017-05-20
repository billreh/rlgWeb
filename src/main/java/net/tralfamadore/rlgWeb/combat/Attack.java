package net.tralfamadore.rlgWeb.combat;

import java.util.List;

/**
 * Class: Attack
 * Created by billreh on 4/8/17.
 */
public interface Attack {
    String getName();
    AttackRange getRange();
    DamageType getDamageType();
    List<Effect> getEffects();
    int getDamage();
}
