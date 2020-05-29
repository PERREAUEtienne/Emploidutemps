    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import DAO.CoursDAO;
import DAO.EtudiantDAO;
import DAO.DAO;
import piscinejava.SdzConnection;


/**
 *
 * @author etien
 */
public class PiscineJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Testons des élèves
    DAO<Etudiant> etudiantDao = new EtudiantDAO(SdzConnection.getInstance());
    for(int i = 1; i < 5; i++){
      Etudiant etudiant = etudiantDao.find(i);
      System.out.println("Cours N°" + etudiant.getId_utilisateur() + "  - " + etudiant.getNumero());
    }
    }

}
