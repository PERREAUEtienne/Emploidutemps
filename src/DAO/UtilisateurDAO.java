/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import Controlleur.Utilisateur;


/**
 *
 * @author Alexandre
 */
public class UtilisateurDAO extends DAO<Utilisateur>{
    public UtilisateurDAO(Connection conn) {
    super(conn);
  }

    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean create(Utilisateur obj) {
    return false;
  }

    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean delete(Utilisateur obj) {
    return false;
  }
   
    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean update(Utilisateur obj) {
    return false;
  }
   
    /**
     *
     * @param id
     * @return
     */
    @Override
  public Utilisateur find(int id) {
    Utilisateur utilisateur = new Utilisateur();      
      
    try {
        ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM utilisateur WHERE id = " + id);
      if(result.first())
        utilisateur = new Utilisateur(
          id,
          result.getString("email"),
          result.getString("passwd"),
          result.getString("nom"),        
          result.getString("prenom"),
          result.getInt("droit")
          );         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return utilisateur;
  }
}
