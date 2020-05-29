/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import Controlleur.Seance_salles;


/**
 *
 * @author Alexandre
 */
public class Seance_sallesDAO extends DAO<Seance_salles>{
    public Seance_sallesDAO(Connection conn) {
    super(conn);
  }

    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean create(Seance_salles obj) {
    return false;
  }

    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean delete(Seance_salles obj) {
    return false;
  }
   
    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean update(Seance_salles obj) {
    return false;
  }
   
    /**
     *
     * @param id
     * @return
     */
    @Override
  public Seance_salles find(int id) {
    Seance_salles seance_salles = new Seance_salles();      
      
    try {
        ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM seance_salles WHERE id_seance = " + id);
      if(result.first())
        seance_salles = new Seance_salles(
          id,
          id
        );         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return seance_salles;
  }
}
