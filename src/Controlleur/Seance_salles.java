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
public class Seance_salles {
    private int id_seance;
    private int id_salle;

    public Seance_salles(int id_seance, int id_salle) {
        this.id_seance = id_seance;
        this.id_salle = id_salle;
    }

    public int getId_seance() {
        return id_seance;
    }

    public int getId_salle() {
        return id_salle;
    }

    public void setId_seance(int id_seance) {
        this.id_seance = id_seance;
    }

    public void setId_salle(int id_salle) {
        this.id_salle = id_salle;
    }
}
