/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import Controlleur.Seance_enseignants;


/**
 *
 * @author Alexandre
 */
public class Seance_enseignantsDAO extends DAO<Seance_enseignants>{
    public Seance_enseignantsDAO(Connection conn) {
    super(conn);
  }

    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean create(Seance_enseignants obj) {
    return false;
  }

    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean delete(Seance_enseignants obj) {
    return false;
  }
   
    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean update(Seance_enseignants obj) {
    return false;
  }
   
    /**
     *
     * @param id
     * @return
     */
    @Override
  public Seance_enseignants find(int id) {
    Seance_enseignants seance_enseignants = new Seance_enseignants();      
      
    try {
        ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM seance_enseignants WHERE id_seance = " + id);
      if(result.first())
        seance_enseignants = new Seance_enseignants(
          id,
          id
          );         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return seance_enseignants;
  }
}
