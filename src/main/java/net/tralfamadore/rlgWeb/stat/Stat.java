package net.tralfamadore.rlgWeb.stat;

/**
 * Class: Stat
 * Created by billreh on 3/29/17.
 */
public class Stat {
    public static final int MAX_STAT = 100;


    private int value;
    private int modifier;
    private final StatType statType;


    public Stat(StatType statType, int value) {
        this.statType = statType;
        this.value = value;
    }


    public String getName() {
        return statType.longName();
    }

    public String getShortName() {
        return statType.name();
    }

    public StatType getStatType() {
        return statType;
    }

    public int getValue() {
        return value + modifier;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getModifier() {
        return modifier;
    }

    public void setModifier(int modifier) {
        this.modifier = modifier;
    }

    @Override
    public String toString() {
        return statType.longName() + ": " + getValue();
    }

    public enum StatType {
        DEX("Dexterity"),
        INT("Intelligence"),
        VIT("Vitality"),
        TAL("Talent"),
        STR("Strength"),
        SPD("Speed"),
        RES("Resistance"),
        EVD("Evasion"),
        DMA("Damage Absorption");

        private final String longName;

        StatType(String longName) {
            this.longName = longName;
        }

        public String longName() {
            return this.longName;
        }
    }
}
