package net.tralfamadore.rlgWeb.combat;

import net.tralfamadore.rlgWeb.config.AppConfig;
import net.tralfamadore.rlgWeb.entity.Creature;
import net.tralfamadore.rlgWeb.entity.Party;
import net.tralfamadore.rlgWeb.entity.Player;
import net.tralfamadore.rlgWeb.stat.Stat;
import net.tralfamadore.rlgWeb.stat.StatFactory;
import org.junit.Assert;
import org.junit.Before;
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
    @Inject
    private StatFactory statFactory;

    @Test
    public void testTurnOrder() throws Exception {
        Party party = getParty();
        Party party2 = getParty();
        List<Creature> turnOrder = CombatUtils.turnOrder(party, party2);
        int[] lastSpd = {100};
        turnOrder.stream().map(creature -> creature.getStat(Stat.StatType.SPD).getValue()).forEach( spd -> {
            Assert.assertTrue(spd <= lastSpd[0]);
            lastSpd[0] = spd;
        });
    }

    @Test
    public void testGetMeleeTarget() throws Exception {
        Party party = getParty();
        party.getMembers().forEach(m -> m.setPosition(Party.Position.BACK));
        party.getMembers().get(0).setPosition(Party.Position.FRONT);
        Assert.assertEquals(party.getMembers().get(0), CombatUtils.getMeleeTargets(party.getMembers()).get(0));
    }

    @Test
    public void testGetRandomTarget() throws Exception {
        Party party = getParty();
        Creature target = CombatUtils.getRandomTarget(party.getMembers());
        Assert.assertTrue(party.getMembers().contains(target));
    }

    private Party getParty() {
        return new Party(new Player(statFactory.getRandomStats()),
                new Player(statFactory.getRandomStats()),
                new Player(statFactory.getRandomStats()));
    }
}
