/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

/**
 *
 * @author etien
 */
public class Salle {
      
 private int id;
   private String nom;
   private int capacité;
    private int id_site;

   
   public Salle(int id,int capacité,int id_site,String nom ) {
    this.id = id;
    this.capacité=capacité;
    this.id_site=id_site;
    this.nom=nom;
  }
   
   
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getCapacité() {
        return capacité;
    }

    public int getId_site() {
        return id_site;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCapacité(int capacité) {
        this.capacité = capacité;
    }

    public void setId_site(int id_site) {
        this.id_site = id_site;
    }
  
}
