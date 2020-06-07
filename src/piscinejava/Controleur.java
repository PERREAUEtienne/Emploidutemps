/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piscinejava;

import java.sql.SQLException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * Contrôle l'interrogation de la BDD dans la Fenetre
 *
 * @author segado
 */
public class Controleur {

    /**
     *
     * une methode principal (main) pour lancer l'application
     *
     * @param s
     */
    public static void main(String[] s) throws SQLException {
        // creation de la fenetre
        FenetreAdmin f = new FenetreAdmin();
        f.affichage();
        
       
    }
}
