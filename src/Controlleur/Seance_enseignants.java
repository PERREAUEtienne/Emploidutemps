<<<<<<< HEAD
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
public class Seance_enseignants {
        private int id_seance;
    private int id_enseignant;

    public Seance_enseignants(int id_seance, int id_enseignant) {
        this.id_seance = id_seance;
        this.id_enseignant = id_enseignant;
    }

    public int getId_seance() {
        return id_seance;
    }

    public int getId_enseignant() {
        return id_enseignant;
    }

    public void setId_seance(int id_seance) {
        this.id_seance = id_seance;
    }

    public void setId_enseignant(int id_enseignant) {
        this.id_enseignant = id_enseignant;
    }
    
    
}
=======
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
public class Seance_enseignants {
        private int id_seance;
    private int id_enseignant;

    public Seance_enseignants(int id_seance, int id_enseignant) {
        this.id_seance = id_seance;
        this.id_enseignant = id_enseignant;
    }

    public Seance_enseignants() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_seance() {
        return id_seance;
    }

    public int getId_enseignant() {
        return id_enseignant;
    }

    public void setId_seance(int id_seance) {
        this.id_seance = id_seance;
    }

    public void setId_enseignant(int id_enseignant) {
        this.id_enseignant = id_enseignant;
    }
    
    
}
>>>>>>> master
