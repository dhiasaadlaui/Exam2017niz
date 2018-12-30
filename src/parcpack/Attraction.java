/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcpack;

/**
 *
 * @author Dhia
 */
public class Attraction implements Comparable<Attraction>{
    
    private int age_min;
    private String type;
    private String designation;
    private int nbr_ticket;

    public Attraction() {
    }

    @Override
    public String toString() {
        return "Attraction{" + "age_min=" + age_min + ", type=" + type + ", designation=" + designation + ", nbr_ticket=" + nbr_ticket + '}'+ "\n";
    }

    public Attraction(int age_min, String type, String designation, int nbr_ticket) {
        this.age_min = age_min;
        this.type = type;
        this.designation = designation;
        this.nbr_ticket = nbr_ticket;
    }

    public int getAge_min() {
        return age_min;
    }

    public void setAge_min(int age_min) {
        this.age_min = age_min;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getNbr_ticket() {
        return nbr_ticket;
    }

    public void setNbr_ticket(int nbr_ticket) {
        this.nbr_ticket = nbr_ticket;
    }

    @Override
    public int compareTo(Attraction o) {
       return this.type.compareTo(o.type) ;
       
    }
 
    
    
}
