/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import Controlleur.Seance_groupes;


/**
 *
 * @author Alexandre
 */
public class Seance_groupesDAO extends DAO<Seance_groupes>{
    public Seance_groupesDAO(Connection conn) {
    super(conn);
  }

    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean create(Seance_groupes obj) {
    return false;
  }

    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean delete(Seance_groupes obj) {
    return false;
  }
   
    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean update(Seance_groupes obj) {
    return false;
  }
   
    /**
     *
     * @param id
     * @return
     */
    @Override
  public Seance_groupes find(int id) {
    Seance_groupes seance_groupes = new Seance_groupes();      
      
    try {
        ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM seance_groupes WHERE id_seance = " + id);
      if(result.first())
        seance_groupes = new Seance_groupes(
          id,
          id
        );         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return seance_groupes;
  }
}
