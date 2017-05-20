package net.tralfamadore.rlgWeb;

import java.util.Random;

/**
 * Class: Die
 * Created by billreh on 4/8/17.
 */
public class Die {
    private static final Random random = new Random();

    private Type type;
    private int mod = 0;
    private int num = 1;

    public Die(Type type) {
        this.type = type;
    }

    public Die(int num, Type type) {
        this(type);
        this.num = num;
    }

    public Die(int num, Type type, int mod) {
        this(num, type);
        this.mod = mod;
    }

    public int roll() {
        int total = 0;

        for(int i = 0; i < num; i++)
            total += random.nextInt(type.sides()) + 1;
        total += mod;

        return total;
    }

    public enum Type {
        D4(4),
        D6(6),
        D8(8),
        D10(10),
        D12(12),
        D20(20),
        D100(100);

        private int sides;

        Type(int sides) {
            this.sides = sides;
        }

        int sides() {
            return sides;
        }
    }
}
