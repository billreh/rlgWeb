package net.tralfamadore.rlgWeb;

import net.tralfamadore.rlgWeb.config.AppConfig;
import net.tralfamadore.rlgWeb.entity.Party;
import net.tralfamadore.rlgWeb.entity.Player;
import net.tralfamadore.rlgWeb.stat.StatFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

/**
 * Class: GameContextTest
 * Created by billreh on 5/19/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class })
public class GameContextTest {
    @Inject
    private GameContext gameContext;

    @Inject
    private StatFactory statFactory;

    @Test
    public void testParty() throws Exception {
        Party party = new Party(new Player(statFactory.getRandomStats()),
                new Player(statFactory.getRandomStats()),
                new Player(statFactory.getRandomStats()));
        gameContext.setParty(party);
        assertEquals(party, gameContext.getParty());
    }
}
