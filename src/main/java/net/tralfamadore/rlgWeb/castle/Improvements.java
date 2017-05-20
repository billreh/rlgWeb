package net.tralfamadore.rlgWeb.castle;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Class: Improvements
 * Created by billreh on 5/18/17.
 */
@Service
public class Improvements {
    private List<Improvement> possibleImprovements;

    public Improvements() {
        possibleImprovements = new ArrayList<>();
        possibleImprovements.add(new Keep());
        possibleImprovements.add(new MageTower());
        possibleImprovements.add(new ThievesDen());
        possibleImprovements.add(new Castle());
    }

    public List<Improvement> getOpenImprovements(List<Improvement> improvements) {
        List<Improvement> openImprovements = new ArrayList<>();
        improvements.forEach(improvement -> {
            if(!possibleImprovements.contains(improvement))
                openImprovements.add(improvement);
        });
        return openImprovements;
    }
}
