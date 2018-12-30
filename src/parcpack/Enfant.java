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
public class Enfant {
    
    private String nom,prenom;
    private Integer age;
    private int ticket;

    public Enfant() {
    }

    public Enfant(String nom, String prenom, Integer age, int ticket) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.ticket = ticket;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "Enfant{" + "nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", ticket=" + ticket + '}'+ "\n";
    }
    
    
    
    
}
