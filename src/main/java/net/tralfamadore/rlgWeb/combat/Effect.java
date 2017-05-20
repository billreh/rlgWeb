package net.tralfamadore.rlgWeb.combat;


import net.tralfamadore.rlgWeb.entity.Creature;

/**
 * Class: Effect
 * Created by billreh on 4/2/17.
 */
public interface Effect {
    String getName();
    void apply(Creature creature);
    int getDuration();
    void remove(Creature creature);
}
