/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import Controlleur.Groupe;


/**
 *
 * @author Alexandre
 */
public class GroupeDAO extends DAO<Groupe>{
    public GroupeDAO(Connection conn) {
    super(conn);
  }

    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean create(Groupe obj) {
    return false;
  }

    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean delete(Groupe obj) {
    return false;
  }
   
    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean update(Groupe obj) {
    return false;
  }
   
    /**
     *
     * @param id
     * @return
     */
    @Override
  public Groupe find(int id) {
    Groupe groupe = new Groupe();      
      
    try {
        ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM groupe WHERE id = " + id);
      if(result.first())
        groupe = new Groupe(
          id,
          result.getString("nom"),
          result.getInt("id_promotion"
        ));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return groupe;
  }
}
