package net.tralfamadore.rlgWeb.combat;



import net.tralfamadore.rlgWeb.entity.Creature;
import net.tralfamadore.rlgWeb.entity.Party;

import java.util.Collection;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Class: CombatUtils
 * Created by billreh on 4/8/17.
 */
public class CombatUtils {
    private static final Random rand = new Random();

    public static Set<Creature> getMeleeTargets(Collection<Creature> creatures) {
        Set<Creature> targets =
                creatures.stream().filter(t -> t.getPosition() == Party.Position.FRONT).collect(Collectors.toSet());
        if(targets.isEmpty())
            targets.addAll(creatures);
        return targets;
    }

    public static Creature getRandomTarget(Collection<Creature> creatures) {
        return creatures.toArray(new Creature[0])[rand.nextInt(creatures.size())];
    }
}
