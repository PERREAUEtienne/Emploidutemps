/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import Controlleur.Site;


/**
 *
 * @author Alexandre
 */
public class SiteDAO extends DAO<Site>{
    public SiteDAO(Connection conn) {
    super(conn);
  }

    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean create(Site obj) {
    return false;
  }

    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean delete(Site obj) {
    return false;
  }
   
    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean update(Site obj) {
    return false;
  }
   
    /**
     *
     * @param id
     * @return
     */
    @Override
  public Site find(int id) {
    Site site = new Site();      
      
    try {
        ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM site WHERE id = " + id);
      if(result.first())
        site = new Site(
          id,
          result.getString("nom"
        ));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return site;
  }
}
