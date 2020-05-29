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
public class Utilisateur {
   private int id;
   private String email;
   private String passwd;
   private String nom;
   private String prenom;
   private int droit;
  
   
   public Utilisateur(int id,String email, String passwd, String prenom, String nom,int droit ) {
    this.id = id;
    this.nom = nom;
    this.prenom = prenom;
    this.email = email;
    this.passwd = passwd;
    this.droit = droit;
  }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getDroit() {
        return droit;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDroit(int droit) {
        this.droit = droit;
    }
   
   
}
