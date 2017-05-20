package net.tralfamadore.rlgWeb.combat;


import net.tralfamadore.rlgWeb.entity.Creature;

/**
 * Class: Effect
 * Created by billreh on 4/2/17.
 */
@FunctionalInterface
public interface Effect {
    void apply(Creature creature);
}
