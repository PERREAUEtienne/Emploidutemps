/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import Controlleur.Etudiant;

/**
 *
 * @author Alexandre
 */

public class EtudiantDAO extends DAO<Etudiant> {
  public EtudiantDAO(Connection conn) {
    super(conn);
  }

    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean create(Etudiant obj) {
    return false;
  }

    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean delete(Etudiant obj) {
    return false;
  }
   
    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean update(Etudiant obj) {
    return false;
  }
   
    /**
     *
     * @param id
     * @return
     */
    @Override
  public Etudiant find(int id) {
    Etudiant eleve = new Etudiant();      
      
    try {
        ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM etudiant WHERE id_utilisateur = " + id);
      if(result.first())
        eleve = new Etudiant(
          id,
          result.getInt("numero"),
          result.getInt("id_groupe"
        ));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return eleve;
  }
}
