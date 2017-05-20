package net.tralfamadore.rlgWeb.combat;

import net.tralfamadore.rlgWeb.entity.Creature;
import net.tralfamadore.rlgWeb.entity.Party;
import net.tralfamadore.rlgWeb.entity.Player;

import java.util.List;

/**
 * Class: Battleground
 * Created by billreh on 5/20/17.
 */
public class Battleground {
    private Party attackers;
    private Party defenders;
    private List<Creature> turnOrder;
    int turnIndex;

    public Battleground(Party attackers, Party defenders) {
        this.attackers = attackers;
        this.defenders = defenders;
        turnOrder = CombatUtils.turnOrder(attackers, defenders);
        turnIndex = 0;
    }

    public Creature getCurrentTurnCreature() {
        return turnOrder.get(turnIndex);
    }

    public void nextTurn() {
        turnIndex++;
        if(turnIndex >= turnOrder.size())
            turnIndex = 0;
    }

    public void takeCurrentTurn() {
        Creature creature = getCurrentTurnCreature();
        if(creature instanceof Player)
            takePlayerTurn(creature);
        else
            takeCreatureTurn(creature);
    }

    private void takeCreatureTurn(Creature creature) {
        List<Attack> attacks = creature.getAttacks();
        Party enemy;
        if(attackers.getMembers().contains(creature))
            enemy = defenders;
        else
            enemy = attackers;
        Attack attack = CombatUtils.getRandomAttack(attacks);
        if(attack instanceof Aoe) {
            ((Aoe) attack).accept(enemy);
        } else {
            Creature target;
            if(attack.getRange() == AttackRange.MELEE)
                target = CombatUtils.getRandomTarget(CombatUtils.getMeleeTargets(enemy.getMembers()));
            else
                target = CombatUtils.getRandomTarget(enemy.getMembers());
            target.damage(attack.getDamage(), attack.getDamageType());
        }
    }

    private void takePlayerTurn(Creature creature) {
        takeCreatureTurn(creature);
    }
}
