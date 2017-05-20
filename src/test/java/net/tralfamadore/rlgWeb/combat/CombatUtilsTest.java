package net.tralfamadore.rlgWeb.combat;

import net.tralfamadore.rlgWeb.config.AppConfig;
import net.tralfamadore.rlgWeb.entity.Creature;
import net.tralfamadore.rlgWeb.entity.Party;
import net.tralfamadore.rlgWeb.entity.Player;
import net.tralfamadore.rlgWeb.stat.Stat;
import net.tralfamadore.rlgWeb.stat.StatFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;

/**
 * Class: CombatUtilsTest
 * Created by billreh on 5/19/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class })
public class CombatUtilsTest {
    @Inject
    private StatFactory statFactory;

    @Test
    public void testTurnOrder() throws Exception {
        Party party = new Party(new Player(statFactory.getRandomStats()),
                new Player(statFactory.getRandomStats()),
                new Player(statFactory.getRandomStats()));
        Party party2 = new Party(new Player(statFactory.getRandomStats()),
                new Player(statFactory.getRandomStats()),
                new Player(statFactory.getRandomStats()));
        List<Creature> turnOrder = CombatUtils.turnOrder(party, party2);
        int[] lastSpd = {100};
        turnOrder.stream().map(creature -> creature.getStat(Stat.StatType.SPD).getValue()).forEach( spd ->
                Assert.assertTrue(spd <= lastSpd[0]));
    }
}
