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
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Alexandre
 */

public class SeanceDAO extends DAO<Seance>{
     private final Statement stmt;
    public SeanceDAO(Connection conn) throws SQLException {
    super(conn);
    stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
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
  public  boolean delete(Seance obj) {
      boolean b = false;
    try {
String sql = "delete from seance where id='" +obj.getId()+"'";
System.out.println(sql);
stmt.executeUpdate(sql);
System.out.println("Seance deleted ...");
b = true;

} catch (Exception e) {
System.err.println("problem in deleting ...");
}
return b;
}
   
    /**
     *
     * @param obj
     * @return
     */
    @Override
  public boolean update(Seance obj) {
      String jdbcUrl = "jdbc:mysql://localhost:3308/edp";
    String username = "root";
    String password = "";
    String sql = "update seance set etat= 2  where id=2 ";
    
    try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password); 
        Statement stmt = conn.createStatement();) {
      
      stmt.executeUpdate(sql);
      System.out.println("Record deleted successfully");
    } catch (SQLException e) {
      e.printStackTrace();
    }
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
      
    try {
        ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM seance WHERE id = " + id);
      /*if(result.first())
          seance = new Seance(
          id,
          result.getString("semaine"),
          result.getDate("date"),
          result.getInt("heure_debut"),
          result.getInt("heure_fin"),
          result.getInt("etat"),
          result.getInt("id_cours"),
          result.getInt("id_type")
        );   */
      
         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return seance;
  }
}
