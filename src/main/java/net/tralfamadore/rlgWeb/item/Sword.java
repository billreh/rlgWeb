package net.tralfamadore.rlgWeb.item;

import net.tralfamadore.base.Die;
import net.tralfamadore.rlgWeb.combat.Attack;
import net.tralfamadore.rlgWeb.combat.AttackRange;
import net.tralfamadore.rlgWeb.combat.DamageType;
import net.tralfamadore.rlgWeb.combat.Effect;
import net.tralfamadore.rlgWeb.entity.Creature;
import net.tralfamadore.rlgWeb.stat.Stat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class: Sword
 * Created by billreh on 4/11/17.
 */
public class Sword implements Weapon {
    protected List<Attack> attacks = new ArrayList<>();

    public Sword(Creature attacker) {
        attacks.add(new Attack() {
            @Override
            public String getName() {
                return "Stab";
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
                return new Die(attacker.getLevel(), Die.Type.D10,
                        attacker.getStat(Stat.StatType.STR).getValue() / 10).roll();
            }
        });
        attacks.add(new Attack() {
            @Override
            public String getName() {
                return "Slash";
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
                Effect bleeding = new Effect() {
                    @Override
                    public String getName() {
                        return "Bleeding";
                    }

                    @Override
                    public void apply(Creature creature) {
                        creature.damage(new Die(Die.Type.D4).roll(), DamageType.BLEEDING);
                    }

                    @Override
                    public int getDuration() {
                        return new Die(1, Die.Type.D4, 1).roll();
                    }

                    @Override
                    public void remove(Creature creature) {
                    }
                };
                return Collections.singletonList(bleeding);
            }

            @Override
            public int getDamage() {
                return new Die(attacker.getLevel(), Die.Type.D8,
                        attacker.getStat(Stat.StatType.STR).getValue() / 10).roll();
            }
        });
    }

    @Override
    public List<Attack> getAttacks() {
        return Collections.unmodifiableList(attacks);
    }

    @Override
    public ItemType getItemType() {
        return ItemType.WEAPON;
    }
}
