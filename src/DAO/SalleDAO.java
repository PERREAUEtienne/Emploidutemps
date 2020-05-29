/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import Controlleur.Salle;


/**
 *
 * @author Alexandre
 */
public class SalleDAO extends DAO<Salle>{
    public SalleDAO(Connection conn) {
    super(conn);
  }

    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean create(Salle obj) {
    return false;
  }

    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean delete(Salle obj) {
    return false;
  }
   
    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean update(Salle obj) {
    return false;
  }
   
    /**
     *
     * @param id
     * @return
     */
    @Override
  public Salle find(int id) {
    Salle salle = new Salle();      
      
    try {
        ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM salle WHERE elv_id = " + id);
      if(result.first())
        salle = new Salle(
          id,
          result.getString("nom"),
          result.getInt("capacite"),
          result.getInt("id_site")
        );         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return salle;
  }
}
