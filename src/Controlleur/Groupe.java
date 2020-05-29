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
public class Groupe {
    
    
   private int id;

   private String nom;
   
   private int id_promotion;
  
   
   public Groupe(int id, String nom,int id_promotion) {
    this.id = id;
    this.nom = nom;
    this.id_promotion=id_promotion;
   
}

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getId_promotion() {
        return id_promotion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setId_promotion(int id_promotion) {
        this.id_promotion = id_promotion;
    }
}
