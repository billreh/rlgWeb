package net.tralfamadore.rlgWeb.combat;

import net.tralfamadore.rlgWeb.config.AppConfig;
import net.tralfamadore.rlgWeb.entity.Creature;
import net.tralfamadore.rlgWeb.entity.Party;
import net.tralfamadore.rlgWeb.entity.Player;
import net.tralfamadore.rlgWeb.stat.Stat;
import net.tralfamadore.rlgWeb.stat.StatFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
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
    private static Party party;
    private static Party party2;
    @Inject
    private StatFactory statFactory;

    @BeforeClass
    public void setUp() {
        party = new Party(new Player(statFactory.getRandomStats()),
                new Player(statFactory.getRandomStats()),
                new Player(statFactory.getRandomStats()));
        party2 = new Party(new Player(statFactory.getRandomStats()),
                new Player(statFactory.getRandomStats()),
                new Player(statFactory.getRandomStats()));
    }

    @Test
    public void testTurnOrder() throws Exception {
        List<Creature> turnOrder = CombatUtils.turnOrder(party, party2);
        int[] lastSpd = {100};
        turnOrder.stream().map(creature -> creature.getStat(Stat.StatType.SPD).getValue()).forEach( spd ->
                Assert.assertTrue(spd <= lastSpd[0]));
    }

    @Test
    public void testGetMeleeTarget() throws Exception {
        party.getMembers().forEach(m -> m.setPosition(Party.Position.BACK));
        party.getMembers().iterator().next().setPosition(Party.Position.FRONT);
        Assert.assertEquals(party.getMembers().iterator().next(),
                CombatUtils.getMeleeTargets(party.getMembers()).iterator().next());
    }
}
