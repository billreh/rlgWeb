package net.tralfamadore.rlgWeb.stat;

import net.tralfamadore.rlgWeb.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

/**
 * Class: StatFactoryTest
 * Created by billreh on 5/19/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class })
public class StatFactoryTest {
    @Inject
    private StatFactory statFactory;

    @Test
    public void testStatFactory() throws Exception {
        Stat[] stats = statFactory.getThiefStats();
        assertEquals(56, stats[Stat.StatType.STR.ordinal()].getValue());
        assertEquals(66, stats[Stat.StatType.VIT.ordinal()].getValue());
        assertEquals(71, stats[Stat.StatType.TAL.ordinal()].getValue());
        assertEquals(78, stats[Stat.StatType.SPD.ordinal()].getValue());
        assertEquals(50, stats[Stat.StatType.INT.ordinal()].getValue());
        assertEquals(78, stats[Stat.StatType.DEX.ordinal()].getValue());
        assertEquals(5, stats[Stat.StatType.DMA.ordinal()].getValue());
        assertEquals(5, stats[Stat.StatType.RES.ordinal()].getValue());
        assertEquals(11, stats[Stat.StatType.EVD.ordinal()].getValue());
    }
}
