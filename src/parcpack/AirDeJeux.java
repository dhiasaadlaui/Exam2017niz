/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcpack;

import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Dhia
 */
public class AirDeJeux {
    
    private Set<Attraction> attractions;

    public AirDeJeux() {
        attractions = new TreeSet<>();
    }
    
    public void ajouterAttraction (Attraction a){
        attractions.add(a);
    }
    
    public void supprimerAttraction (Attraction a){
        attractions.remove(a);
    }
}
