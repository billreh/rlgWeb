package net.tralfamadore.rlgWeb;

import net.tralfamadore.rlgWeb.entity.Party;
import org.springframework.stereotype.Component;

/**
 * Class: GameContextImpl
 * Created by billreh on 5/19/17.
 */
@Component
public class GameContextImpl implements GameContext {
    private Party party;

    @Override
    public Party getParty() {
        return party;
    }

    @Override
    public void setParty(Party party) {
        this.party = party;
    }
}
