package net.tralfamadore.rlgWeb.combat;

import net.tralfamadore.rlgWeb.config.AppConfig;
import net.tralfamadore.rlgWeb.entity.Creature;
import net.tralfamadore.rlgWeb.entity.Party;
import net.tralfamadore.rlgWeb.entity.Player;
import net.tralfamadore.rlgWeb.item.Katana;
import net.tralfamadore.rlgWeb.stat.Stat;
import net.tralfamadore.rlgWeb.stat.StatFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

/**
 * Class: BattlegroundTest
 * Created by billreh on 5/20/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class })
public class BattlegroundTest {
    @Inject
    private StatFactory statFactory;

    @Test
    public void testBattleGround() throws Exception {
        Party party = getParty();
        Party party2 = getParty();

        Battleground battleground = new Battleground(party, party2);
        while(!party.isDead() && !party2.isDead()) {
            printPartyHealth(party);
            printPartyHealth(party2);
            battleground.takeCurrentTurn();
            battleground.nextTurn();
        }
        printPartyHealth(party);
        printPartyHealth(party2);
    }

    private Party getParty() {
        Player player = new Player(statFactory.getRandomStats());
        player.setWeapon(new Katana(player));
        player.getStat(Stat.StatType.DMA).setValue(0);
        Party party = new Party(player);
        player = new Player(statFactory.getRandomStats());
        player.setWeapon(new Katana(player));
        player.getStat(Stat.StatType.DMA).setValue(0);
        party.addMember(player);
        player = new Player(statFactory.getRandomStats());
        player.setWeapon(new Katana(player));
        player.getStat(Stat.StatType.DMA).setValue(0);
        party.addMember(player);

        return party;
    }

    private void printPartyHealth(Party party) {
        System.out.println("----------");
        party.getMembers().stream().map(Creature::getHealth).forEach(System.out::println);
        System.out.println("----------");
    }
}
