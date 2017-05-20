package net.tralfamadore.base;


import net.tralfamadore.rlgWeb.entity.Party;

/**
 * Class: GameContext
 * Created by billreh on 4/8/17.
 */
public interface GameContext {
//    Map getMap();
//    void setMap(Map map);
    Party getParty();
//    boolean inEncounter();
//    Encounter getEncounter();
//    void setEncounter(Encounter encounter);
    void setParty(Party party);
}
