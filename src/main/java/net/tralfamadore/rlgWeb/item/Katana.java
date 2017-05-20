package net.tralfamadore.rlgWeb.item;

import net.tralfamadore.rlgWeb.Die;
import net.tralfamadore.rlgWeb.combat.Attack;
import net.tralfamadore.rlgWeb.combat.AttackRange;
import net.tralfamadore.rlgWeb.combat.DamageType;
import net.tralfamadore.rlgWeb.combat.Effect;
import net.tralfamadore.rlgWeb.entity.Creature;
import net.tralfamadore.rlgWeb.stat.Stat;

import java.util.Collections;
import java.util.List;

/**
 * Class: Katana
 * Created by billreh on 4/11/17.
 */
public class Katana extends Sword {
    public Katana(Creature attacker) {
        super(attacker);
        attacks.add(new Attack() {
            @Override
            public String getName() {
                return "Strike";
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
                return new Die(attacker.getLevel(), Die.Type.D12,
                        attacker.getStat(Stat.StatType.STR).getValue() / 10).roll();
            }
        });
    }
}
