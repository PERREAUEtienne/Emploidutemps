/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import Controlleur.Seance;


/**
 *
 * @author Alexandre
 */
public class SeanceDAO extends DAO<Seance>{
    public SeanceDAO(Connection conn) {
    super(conn);
  }

    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean create(Seance obj) {
    return false;
  }

    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean delete(Seance obj) {
    return false;
  }
   
    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean update(Seance obj) {
    return false;
  }
   
    /**
     *
     * @param id
     * @return
     */
    @Override
  public Seance find(int id) {
    Seance seance = new Seance();      
      
    /*try {
        ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM seance WHERE id = " + id);
      if(result.first())
          seance = new Seance(
          id,
          result.getString("semaine"),
          result.getDate("date"),
          result.getTime("heure_debut"),
          result.getTime("heure_fin"),
          result.getInt("etat"),
          result.getInt("id_cours"),
          result.getInt("id_type")
        );         
    } catch (SQLException e) {
      e.printStackTrace();
    }*/
    return seance;
  }
}
