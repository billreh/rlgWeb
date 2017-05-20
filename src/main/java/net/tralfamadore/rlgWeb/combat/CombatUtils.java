package net.tralfamadore.rlgWeb.combat;



import net.tralfamadore.rlgWeb.entity.Creature;
import net.tralfamadore.rlgWeb.entity.Party;
import net.tralfamadore.rlgWeb.stat.Stat;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Class: CombatUtils
 * Created by billreh on 4/8/17.
 */
public class CombatUtils {
    private static final Random rand = new Random();

    public static List<Creature> getMeleeTargets(Collection<Creature> creatures) {
        List<Creature> targets = creatures.stream().filter(t -> t.getPosition() == Party.Position.FRONT)
                .filter(t -> !t.isDead()).collect(Collectors.toList());
        if(targets.isEmpty())
            targets.addAll(creatures);
        return targets;
    }

    public static Creature getRandomTarget(Collection<Creature> creatures) {
        return creatures.stream().filter(t -> !t.isDead()).collect(Collectors.toList())
                .toArray(new Creature[0])[rand.nextInt(creatures.size())];
    }

    public static List<Creature> turnOrder(Party party, Party party2) {
        List<Creature> creatures = new ArrayList<>();
        creatures.addAll(party.getMembers());
        creatures.addAll(party2.getMembers());
        creatures.sort((creature, creature2) -> (
                creature.getStat(Stat.StatType.SPD).getValue() > creature2.getStat(Stat.StatType.SPD).getValue()) ? -1 :
                ((creature.getStat(Stat.StatType.SPD).getValue() == creature2.getStat(Stat.StatType.SPD).getValue())
                        ? 0 : 1));
        int i = 3;
        return creatures;
    }

    public static Attack getRandomAttack(List<Attack> attacks) {
        if(attacks == null || attacks.isEmpty())
            return null;
        return attacks.get(rand.nextInt(attacks.size()));

    }
}
