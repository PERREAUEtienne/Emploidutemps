/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import Controlleur.Enseignant;


/**
 *
 * @author Alexandre
 */
public class EnseignantDAO extends DAO<Enseignant>{
    public EnseignantDAO(Connection conn) {
    super(conn);
  }

    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean create(Enseignant obj) {
    return false;
  }

    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean delete(Enseignant obj) {
    return false;
  }
   
    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean update(Enseignant obj) {
    return false;
  }
   
    /**
     *
     * @param id
     * @return
     */
    @Override
  public Enseignant find(int id_user) {
    Enseignant enseignant = new Enseignant();      
      
    try {
        ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM enseignant WHERE id_utilisateur = " + id_user);
      if(result.first())
        enseignant = new Enseignant(
          id_user,
          id_user);         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return enseignant;
  }
}
