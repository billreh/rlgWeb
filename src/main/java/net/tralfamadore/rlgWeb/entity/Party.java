package net.tralfamadore.rlgWeb.entity;

import java.awt.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Class: Party
 * Created by billreh on 4/8/17.
 */
public class Party {
    private Set<Creature> members;
    private Point location;

    public Party() {
        members = new HashSet<>();
        location = new Point(0, 0);
    }

    public Party(Creature... members) {
        this();
        if(members != null) {
            for(Creature member : members)
                addMember(member);
        }
    }

    public void addMember(Creature member) {
        members.add(member);
    }

    public void removeMember(Creature member) {
        members.remove(member);
    }

    public Set<Creature> getMembers() {
        return Collections.unmodifiableSet(members);
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public boolean isDead() {
        boolean dead = true;
        for (Creature member : members) {
            System.out.println(member + ":" + member.getHealth());
            if (!member.isDead())
                dead = false;
        }

        return dead;
    }

    public enum Position {
        FRONT,
        BACK
    }
}
