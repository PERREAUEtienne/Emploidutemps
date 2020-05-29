/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piscinejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandre
 */
    public class SdzConnection{

  /**
  * URL de connection
  */
  private static final String url = "jdbc:mysql://localhost:3308/edp";

  /**
  * Nom du user
  */
  private static final String user = "root";

  /**
  * Mot de passe du user
  */
  private static final String passwd = "";

  /**
  * Objet Connection
  */
  private static Connection connect;

  /**
  * Méthode qui va retourner notre instance
  * et la créer si elle n'existe pas...
  * @return
  */
  public static Connection getInstance(){
    if(connect == null){
      try {
        connect = DriverManager.getConnection(url, user, passwd);
      } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.getMessage(), "ERREUR DE CONNEXION ! ", JOptionPane.ERROR_MESSAGE);
      }
    }		
    return connect;	
  }
    }
