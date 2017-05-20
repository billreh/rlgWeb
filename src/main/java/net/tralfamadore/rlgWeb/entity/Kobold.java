package net.tralfamadore.rlgWeb.entity;


import net.tralfamadore.rlgWeb.Die;
import net.tralfamadore.rlgWeb.combat.CombatUtils;
import net.tralfamadore.rlgWeb.combat.DamageType;
import net.tralfamadore.rlgWeb.stat.Stat;

/**
 * Class: Kobold
 * Created by billreh on 4/8/17.
 */
public class Kobold extends CreatureBase implements Monster {
    private Die hitDice;

    public Kobold(Stat[] stats, Die hitDice, int level) {
        super(stats, hitDice);
        this.setLevel(level);
        this.hitDice = hitDice;
        this.setHealth(hitDice.roll());
    }

    @Override
    public void attack(Party party) {
        Creature victim = CombatUtils.getRandomTarget(CombatUtils.getMeleeTargets(party.getMembers()));

        System.out.println("Attacking " + victim);

        int roll = new Die(Die.Type.D6).roll();
        victim.damage(roll, DamageType.PHYSICAL);
    }

    @Override
    public Die getHitDice() {
        return hitDice;
    }
}
