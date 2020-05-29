/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import Controlleur.Cours;


/**
 *
 * @author Alexandre
 */
public class CoursDAO extends DAO<Cours>{
    public CoursDAO(Connection conn) {
    super(conn);
  }

    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean create(Cours obj) {
    return false;
  }

    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean delete(Cours obj) {
    return false;
  }
   
    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean update(Cours obj) {
    return false;
  }
   
    /**
     *
     * @param id
     * @return
     */
    @Override
  public Cours find(int id) {
    Cours eleve = new Cours();      
      
    try {
        ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM cours WHERE id = " + id);
      if(result.first())
        eleve = new Cours(
          id,
          result.getString("nom"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return eleve;
  }
}
