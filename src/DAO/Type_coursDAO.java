/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import Controlleur.Type_cours;


/**
 *
 * @author Alexandre
 */
public class Type_coursDAO extends DAO<Type_cours>{
    public Type_coursDAO(Connection conn) {
    super(conn);
  }

    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean create(Type_cours obj) {
    return false;
  }

    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean delete(Type_cours obj) {
    return false;
  }
   
    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean update(Type_cours obj) {
    return false;
  }
   
    /**
     *
     * @param id
     * @return
     */
    @Override
  public Type_cours find(int id) {
    Type_cours type_cours = new Type_cours();      
      
    try {
        ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM type_cours WHERE id = " + id);
      if(result.first())
        type_cours = new Type_cours(
          id,
          result.getString("nom")
        );         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return type_cours;
  }
}
