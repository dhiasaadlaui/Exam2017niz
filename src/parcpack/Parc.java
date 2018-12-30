/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcpack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;
import java.util.stream.Stream;

/**
 *
 * @author Dhia
 */
public class Parc {

    Map<Attraction, List<Enfant>> parc;

    public Parc() {
        parc = new HashMap<>();
    }

    public void ajouterAttraction(Attraction a) {

        parc.putIfAbsent(a, new ArrayList<>());
    }
  public void jouerAttraction(Attraction a, Enfant e) {

        if((e.getAge()>=a.getAge_min())&&(e.getTicket()>=a.getNbr_ticket())){
            ajouterAttraction(a);
            parc.get(e).add(e);
            e.setTicket(e.getTicket()-a.getNbr_ticket());
        }
        
        
    }

    
    
    public Enfant getEnfantPlusJeune(Attraction a) {

        return parc
                .get(a)
                .stream()
                .max(Comparator.comparing(Enfant::getAge))
                .orElse(null);
    }

    public Enfant getEnfantMaxAttraction(Attraction a) {

        Map<Enfant, Integer> duplicates = new HashMap<Enfant, Integer>();
        for (Enfant item : parc.get(a)) {
            if (duplicates.containsKey(item)) {
                duplicates.put(item, duplicates.get(item) + 1);
            } else {
                duplicates.put(item, 1);
            }
        }
        Map.Entry<Enfant, Integer> maxEntry = null;

        for (Map.Entry<Enfant, Integer> entry : duplicates.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        return maxEntry.getKey();

    }

    public Attraction getAttractionPlusJoue() {

        return parc
                .entrySet()
                .stream()
                .max((o1, o2) -> o1.getValue().size() - o2.getValue().size())
                .get().getKey();
    }

    

    public List<String> getNomEnfants() {

         return parc.values().stream()
                .flatMap(e->e.stream())              
                .map(Enfant::getNom).collect(Collectors.toList());

    }

    public Map<Attraction, List<Enfant>> trierMapParc() {

        Map<Attraction, List<Enfant>> sortedParc = new TreeMap<>((o1, o2) -> o1.getDesignation().compareTo(o2.getDesignation()));
        sortedParc.putAll(parc);
        return sortedParc;
    }

    public Map<Integer, List<Enfant>> getEnfantsParAge() {
        List<Enfant> ls = new ArrayList<>();
        parc.values().forEach((t) -> {
            t.forEach((e) -> {
                ls.add(e);
            });
        });

        return ls.stream()
                .collect(groupingBy(Enfant::getAge));

    }

    public Boolean isEnfantJouePlusieursAttraction() {
        boolean res= false;
        for (Map.Entry<Attraction, List<Enfant>> entry : parc.entrySet()) {
          res =  parc.values()
                  .stream()
                  .filter(e -> !e.equals(entry.getValue()))
                  .anyMatch(e->Collections.disjoint(entry.getValue(), e));
            if (res) {
                return res;
            }
                  
        }

        return res;
    }
}
