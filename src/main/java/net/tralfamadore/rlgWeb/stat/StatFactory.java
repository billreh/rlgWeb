package net.tralfamadore.rlgWeb.stat;

import net.tralfamadore.ApplicationProperties;
import net.tralfamadore.Tuple2;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.function.Function;

/**
 * Class: StatFactory
 * Created by billreh on 3/29/17.
 */
@Service
public class StatFactory {
    private static final Random rand = new Random();
    private final ApplicationProperties applicationProperties;

    public StatFactory() {
        this.applicationProperties = ApplicationProperties.getInstance();
    }

    public Stat[] getRandomStats() {
        Stat[] stats = new Stat[Stat.StatType.values().length];

        for(Stat.StatType statType : Stat.StatType.values())
            stats[statType.ordinal()] = new Stat(statType, rand.nextInt(Stat.MAX_STAT));

        return stats;
    }

    public Stat[] getThiefStats() {
        Stat[] stats = new Stat[Stat.StatType.values().length];

        stats[Stat.StatType.STR.ordinal()] =
                new Stat(Stat.StatType.STR,Integer.valueOf(applicationProperties.getProperty("classes", "thief.str").get()));
        stats[Stat.StatType.INT.ordinal()] =
                new Stat(Stat.StatType.INT, Integer.valueOf(applicationProperties.getProperty("classes", "thief.int").get()));
        stats[Stat.StatType.DEX.ordinal()] =
                new Stat(Stat.StatType.DEX, Integer.valueOf(applicationProperties.getProperty("classes", "thief.dex").get()));
        stats[Stat.StatType.VIT.ordinal()] =
                new Stat(Stat.StatType.VIT, Integer.valueOf(applicationProperties.getProperty("classes", "thief.vit").get()));
        stats[Stat.StatType.TAL.ordinal()] =
                new Stat(Stat.StatType.TAL, Integer.valueOf(applicationProperties.getProperty("classes", "thief.tal").get()));
        stats[Stat.StatType.SPD.ordinal()] =
                new Stat(Stat.StatType.SPD, Integer.valueOf(applicationProperties.getProperty("classes", "thief.spd").get()));

        setExtendedStats(stats);

        return stats;
    }

    public Stat[] getFighterStats() {
        Stat[] stats = new Stat[Stat.StatType.values().length];

        stats[Stat.StatType.STR.ordinal()] =
                new Stat(Stat.StatType.STR, Integer.valueOf(applicationProperties.getProperty("classes", "fighter.str").get()));
        stats[Stat.StatType.INT.ordinal()] =
                new Stat(Stat.StatType.INT, Integer.valueOf(applicationProperties.getProperty("classes", "fighter.int").get()));
        stats[Stat.StatType.DEX.ordinal()] =
                new Stat(Stat.StatType.DEX, Integer.valueOf(applicationProperties.getProperty("classes", "fighter.dex").get()));
        stats[Stat.StatType.VIT.ordinal()] =
                new Stat(Stat.StatType.VIT, Integer.valueOf(applicationProperties.getProperty("classes", "fighter.vit").get()));
        stats[Stat.StatType.TAL.ordinal()] =
                new Stat(Stat.StatType.TAL, Integer.valueOf(applicationProperties.getProperty("classes", "fighter.tal").get()));
        stats[Stat.StatType.SPD.ordinal()] =
                new Stat(Stat.StatType.SPD, Integer.valueOf(applicationProperties.getProperty("classes", "fighter.spd").get()));

        setExtendedStats(stats);

        return stats;
    }

    public Stat[] getKoboldStats() {
        Stat[] stats = new Stat[Stat.StatType.values().length];

        stats[Stat.StatType.STR.ordinal()] =
                new Stat(Stat.StatType.STR, Integer.valueOf(applicationProperties.getProperty("classes", "kobold.str").get()));
        stats[Stat.StatType.INT.ordinal()] =
                new Stat(Stat.StatType.INT, Integer.valueOf(applicationProperties.getProperty("classes", "kobold.int").get()));
        stats[Stat.StatType.DEX.ordinal()] =
                new Stat(Stat.StatType.DEX, Integer.valueOf(applicationProperties.getProperty("classes", "kobold.dex").get()));
        stats[Stat.StatType.VIT.ordinal()] =
                new Stat(Stat.StatType.VIT, Integer.valueOf(applicationProperties.getProperty("classes", "kobold.vit").get()));
        stats[Stat.StatType.TAL.ordinal()] =
                new Stat(Stat.StatType.TAL, Integer.valueOf(applicationProperties.getProperty("classes", "kobold.tal").get()));
        stats[Stat.StatType.SPD.ordinal()] =
                new Stat(Stat.StatType.SPD, Integer.valueOf(applicationProperties.getProperty("classes", "kobold.spd").get()));

        setExtendedStats(stats);

        return stats;
    }

    Function<Tuple2<Stat,Stat>, Integer> generateExtendedStat = st -> {
        int stat = (st.getValue1().getValue() + st.getValue2().getValue()) / 2;
        if(stat >= 95) return 25;
        if(stat >= 90) return 20;
        if(stat >= 85) return 15;
        if(stat >= 80) return 13;
        if(stat >= 75) return 11;
        if(stat >= 70) return 9;
        if(stat >= 65) return 7;
        if(stat >= 60) return 5;
        if(stat >= 55) return 3;
        if(stat >= 50) return 1;
        return 0;
    };

    private void setExtendedStats(Stat[] stats) {
        stats[Stat.StatType.EVD.ordinal()] = new ExtendedStat(Stat.StatType.EVD, stats[Stat.StatType.SPD.ordinal()],
                stats[Stat.StatType.DEX.ordinal()], generateExtendedStat);
        stats[Stat.StatType.RES.ordinal()] = new ExtendedStat(Stat.StatType.RES, stats[Stat.StatType.INT.ordinal()],
                stats[Stat.StatType.TAL.ordinal()], generateExtendedStat);
        stats[Stat.StatType.DMA.ordinal()] = new ExtendedStat(Stat.StatType.DMA, stats[Stat.StatType.STR.ordinal()],
                stats[Stat.StatType.VIT.ordinal()], generateExtendedStat);
    }
}
