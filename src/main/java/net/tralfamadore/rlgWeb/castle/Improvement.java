package net.tralfamadore.rlgWeb.castle;

import net.tralfamadore.rlgWeb.characterClasses.CharacterClass;

import java.util.List;

/**
 * Class: Improvement
 * Created by billreh on 5/18/17.
 */
public interface Improvement {
    CharacterClass getCharacterClass();

    int getLevel();

    int nextLevelGold();

    int unlockGold();

    List<Bonus> getBonuses();

    void gainLevel();
}
