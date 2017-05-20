package net.tralfamadore.rlgWeb.castle;


import net.tralfamadore.rlgWeb.entity.Player;

/**
 * Class: Bonus
 * Created by billreh on 5/18/17.
 */
public interface Bonus {
    String getName();

    void apply(Player player);

    void gainLevel();
}
