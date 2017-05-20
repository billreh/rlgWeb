package net.tralfamadore.rlgWeb.entity;


import net.tralfamadore.rlgWeb.stat.Stat;

/**
 * Class: Player
 * Created by billreh on 4/8/17.
 */
public class Player extends CreatureBase {
    public Player(Stat[] stats) {
        super(stats);
        setHealth(getStat(Stat.StatType.VIT).getValue() / 2);
    }
}
