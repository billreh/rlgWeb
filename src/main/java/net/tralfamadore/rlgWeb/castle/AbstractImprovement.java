package net.tralfamadore.rlgWeb.castle;

/**
 * Class: AbstractImprovement
 * Created by billreh on 5/18/17.
 */
public abstract class AbstractImprovement implements Improvement {
    private int level;

    public AbstractImprovement() {
        level = 1;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int nextLevelGold() {
        return level * 100;
    }

    @Override
    public int unlockGold() {
        return 200;
    }

    @Override
    public void gainLevel() {
        level++;
        getBonuses().forEach(Bonus::gainLevel);
    }
}
