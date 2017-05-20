package net.tralfamadore.rlgWeb.entity;


import net.tralfamadore.base.Die;
import net.tralfamadore.rlgWeb.combat.Attack;
import net.tralfamadore.rlgWeb.combat.DamageType;
import net.tralfamadore.rlgWeb.combat.Effect;
import net.tralfamadore.rlgWeb.combat.Unarmed;
import net.tralfamadore.rlgWeb.item.Item;
import net.tralfamadore.rlgWeb.item.ItemType;
import net.tralfamadore.rlgWeb.item.Weapon;
import net.tralfamadore.rlgWeb.stat.Stat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class: CreatureBase
 * Created by billreh on 3/29/17.
 */
public class CreatureBase implements Creature {
    private Stat[] stats;
    protected int level;
    protected int health;
    protected long experience;
    protected List<Effect> effects;
    protected Party.Position position = Party.Position.FRONT;
    protected Weapon weapon;
    private List<Item> items;
    private int maxHealth;

    public CreatureBase() {
        this.level = 1;
        this.effects = new ArrayList<>();
        this.weapon = new Unarmed(this);
        this.items = new ArrayList<>();
    }

    public CreatureBase(Stat[] stats) {
        this();
        this.stats = stats;
        this.health = getStat(Stat.StatType.VIT).getValue() / 10;
        this.maxHealth = health;
    }

    public CreatureBase(Stat[]stats, Die hitDie) {
        this(stats);
        this.health = hitDie.roll();
        this.maxHealth = health;
    }

    @Override
    public Stat getStat(Stat.StatType statType) {
        return stats[statType.ordinal()];
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getMaxHealth() {
        return maxHealth;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void damage(int health, DamageType damageType) {
        int amount = health;
        switch (damageType) {
            case PHYSICAL:
                amount -= getStat(Stat.StatType.DMA).getValue();
                break;
            case MAGIC:
                amount -= getStat(Stat.StatType.RES).getValue();
        }
        amount = amount < 0 ? 0 : amount;
        this.health -= amount;
    }

    @Override
    public void addHealth(int health) {
        this.health += health;
    }

    @Override
    public long getExperience() {
        return experience;
    }

    @Override
    public void addExperience(long exp) {
        this.experience += exp;
    }

    @Override
    public void addEffect(Effect effect) {
        effects.add(effect);
    }

    @Override
    public void removeEffect(Class<? extends Effect> effectClass) {
        effects.removeIf(e -> e.getClass().equals(effectClass));
    }

    @Override
    public void applyEffects() {
        effects.forEach(effect -> effect.apply(this));
    }

    @Override
    public List<Effect> getEffects() {
        return Collections.unmodifiableList(effects);
    }

    @Override
    public Party.Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Party.Position position) {
        this.position = position;
    }

    @Override
    public Weapon getWeapon() {
        return weapon;
    }

    @Override
    public List<Attack> getAttacks() {
        return getWeapon().getAttacks();
    }

    @Override
    public boolean isDead() {
        return health <= 0;
    }

    @Override
    public List<Item> getItems() {
        return items;
    }

    @Override
    public List<Item> getItems(ItemType itemType) {
        return items.stream().filter(item-> item.getItemType() == itemType).collect(Collectors.toList());
    }

    public void setStats(Stat[] stats) {
        this.stats = stats;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
