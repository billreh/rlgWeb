package net.tralfamadore.rlgWeb.castle;

import net.tralfamadore.rlgWeb.characterClasses.CharacterClass;

import java.util.List;

/**
 * Class: Keep
 * Created by billreh on 5/18/17.
 */
public class Keep extends AbstractImprovement {
    @Override
    public CharacterClass getCharacterClass() {
        throw new RuntimeException("Implement me!");
    }

    @Override
    public List<Bonus> getBonuses() {
        throw new RuntimeException("Implement me!");
    }
}
