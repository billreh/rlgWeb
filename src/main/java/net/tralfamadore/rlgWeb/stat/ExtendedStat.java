package net.tralfamadore.rlgWeb.stat;

import net.tralfamadore.Tuple2;

import java.util.function.Function;

/**
 * Class: ExtendedStat
 * Created by billreh on 3/30/17.
 */
public class ExtendedStat extends Stat {
    private Stat stat1;
    private Stat stat2;
    private Function<Tuple2<Stat,Stat>,Integer> getFunction;

    public ExtendedStat(StatType statType, Stat stat1, Stat stat2, Function<Tuple2<Stat,Stat>, Integer> getFunction) {
        super(statType, 0);
        this.stat1 = stat1;
        this.stat2 = stat2;
        this.getFunction = getFunction;
    }

    @Override
    public int getValue() {
        return getFunction.apply(new Tuple2<>(stat1, stat2)) + getModifier();
    }
}
