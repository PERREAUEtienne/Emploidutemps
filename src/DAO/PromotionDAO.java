/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import Controlleur.Promotion;


/**
 *
 * @author Alexandre
 */
public class PromotionDAO extends DAO<Promotion>{
    public PromotionDAO(Connection conn) {
    super(conn);
  }

    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean create(Promotion obj) {
    return false;
  }

    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean delete(Promotion obj) {
    return false;
  }
   
    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean update(Promotion obj) {
    return false;
  }
   
    /**
     *
     * @param id
     * @return
     */
    @Override
  public Promotion find(int id) {
    Promotion promotion = new Promotion();      
      
    try {
        ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM promotion WHERE id = " + id);
      if(result.first())
        promotion = new Promotion(
          id,
          result.getString("nom")
          );         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return promotion;
  }
}
