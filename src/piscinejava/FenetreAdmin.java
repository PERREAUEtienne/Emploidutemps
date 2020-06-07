/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piscinejava;

/**
 *
 * @author etien
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * 
 * Librairies importées
 */
import java.awt.event.*;
import java.awt.*;
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.Container;
/**
 *
 * Affiche dans la fenetre graphique les champs de tables et les requetes de la
 * BDD
 *
 * @author segado
 */
public class FenetreAdmin extends JFrame implements ActionListener, ItemListener {

    /*
     * Attribut privés : objets de Connexion, AWT et Swing
     * 
     */

    private Connexion maconnexion;
    private final JLabel lundi, mercredi, jeudi, mardi,vendredi, titre;
    private JLabel courr;
    private final java.awt.List courLundi, courMardi, courMercredi, courJeudi, courVendredi;
    private final JPanel p0, p1, nord, p2, p3, p4;
    private JButton bouton,updtsengeignant;
    private JPanel p6;
    private JTextField newenseignant,idseance;
    String nom,nom2;
  
   


    /**
     * Constructeur qui initialise tous les objets graphiques de la fenetre
     */
    public FenetreAdmin() {

        // creation par heritage de la fenetre
        super("Projet d'utilisation de JDBC dans MySQL");

        // mise en page (layout) de la fenetre visible
        setLayout(new BorderLayout());
        setBounds(0, 0, 1000,1000);
        setResizable(true);
        setVisible(true);
         JButton bouton = new JButton("Page ADMIN");
        // creation des boutons
        //connect = new JButton("Connexion ECE");

        // creation des listes pour les tables et les requetes
        courLundi = new java.awt.List(10, false);
        courMardi = new java.awt.List(10, false);
        courMercredi = new java.awt.List(10, false);
        courJeudi = new java.awt.List(10, false);
        courVendredi = new java.awt.List(10, false);

        // creation des textes

        
        
        // creation des labels
        lundi = new JLabel("Lundi", JLabel.CENTER);
        mardi = new JLabel("Mardi", JLabel.CENTER);
        mercredi = new JLabel("Mercredi", JLabel.CENTER);
        jeudi = new JLabel("Jeudi", JLabel.CENTER);
        vendredi = new JLabel("vendredi", JLabel.CENTER);
        titre = new JLabel("Bienvenue sur votre emploi du temps", JLabel.CENTER);
      
        bouton.addActionListener(new BoutonListener());
        

        // creation des panneaux
        p0 = new JPanel();
        p1 = new JPanel();
        nord = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        

        // mise en page des panneaux
        p0.setLayout(new GridLayout(1, 3));
        p1.setLayout(new GridLayout(1, 4));
        nord.setLayout(new GridLayout(2, 1));
        p2.setLayout(new GridLayout(1, 4));
        p3.setLayout(new GridLayout(1, 3));
        p4.setLayout(new GridLayout(1, 3));

        // ajout des objets graphqiues dans les panneaux
         Border blackline = BorderFactory.createLineBorder(Color.black);
        p2.setBorder(blackline);

        p0.add(titre);
        p1.add(lundi);
        p1.add(mardi);
        p1.add(mercredi);
        p1.add(jeudi);
        p1.add(vendredi);
        nord.add("North", p0);
        nord.add("North", p1);
       
        p0.add(bouton);
        p2.add(courLundi); 
        p2.add(courMardi);
        p2.add(courMercredi);
        p2.add(courJeudi);
        p2.add(courVendredi);

        // ajout des listeners

        // couleurs des objets graphiques
        lundi.setBackground(Color.MAGENTA);
        mardi.setBackground(Color.MAGENTA);
        mercredi.setBackground(Color.MAGENTA);
        jeudi.setBackground(Color.MAGENTA);
        vendredi.setBackground(Color.MAGENTA);
        courLundi.setBackground(Color.GRAY);
        courMercredi.setBackground(Color.GRAY);
        courMardi.setBackground(Color.GRAY);
        courJeudi.setBackground(Color.GRAY);
        courVendredi.setBackground(Color.GRAY);
        p1.setBackground(Color.LIGHT_GRAY);

        // disposition geographique des panneaux
        add("North", nord);
        add("Center", p2);
        add("South", p3);

        // pour fermer la fenetre
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                System.exit(0); // tout fermer												System.exit(0); // tout fermer
            }
        });
    }

    /**
     *
     * Afficher et retourner les résultats de la requete sélectionnée
     *
     * @return
     * @throws java.sql.SQLException
     */
    public ArrayList<String> afficherLundi() throws SQLException {
        ArrayList<String> listeLundi = null;
        try {

            // recupérér les résultats de la requete selectionnee
              listeLundi = maconnexion.remplirChampsRequete("SELECT seance.id,cours.nom , groupe.nom,salle.nom,site.nom,type_cours.nom, utilisateur.nom, seance.heure_debut,seance.heure_fin,seance.etat "
                          + "FROM seance,seance_groupes,groupe,cours,salle,seance_salles,site,type_cours,utilisateur,seance_enseignants"
                          + " WHERE seance_groupes.id_seance=seance.id "
                          + "AND groupe.id=seance_groupes.id_groupe "
                          + "AND DAYOFWEEK(seance.date) = 2 "
                          + "AND cours.id= seance.id_cours"
                          + " AND seance.id= seance_salles.id_seance "
                          + "AND salle.id=seance_salles.id_salle "
                          + "AND salle.id_site=site.id "
                          + "AND type_cours.id=seance.id_type"
                          + " AND seance.id=seance_enseignants.id_seance "
                          + "AND seance_enseignants.id_enseignant=utilisateur.id ");
                    
                       
            // afficher les lignes de la requete selectionnee a partir de la liste
            for (String liste1 : listeLundi) {
                courLundi.add(liste1);
               
            }
        } catch (SQLException e) {
        }
        return listeLundi;        
    }
    

    public ArrayList<String> afficherMardi() throws SQLException {
        ArrayList<String> listeMardi = null;
        try {
            // recupérér les résultats de la requete
            
                  listeMardi = maconnexion.remplirChampsRequete("SELECT seance.id,cours.nom , groupe.nom,salle.nom,site.nom,type_cours.nom, utilisateur.nom, seance.heure_debut,seance.heure_fin,seance.etat "
                          + "FROM seance,seance_groupes,groupe,cours,salle,seance_salles,site,type_cours,utilisateur,seance_enseignants"
                          + " WHERE seance_groupes.id_seance=seance.id "
                          + "AND groupe.id=seance_groupes.id_groupe "
                          + "AND DAYOFWEEK(seance.date) = 3 "
                          + "AND cours.id= seance.id_cours"
                          + " AND seance.id= seance_salles.id_seance "
                          + "AND salle.id=seance_salles.id_salle "
                          + "AND salle.id_site=site.id "
                          + "AND type_cours.id=seance.id_type"
                          + " AND seance.id=seance_enseignants.id_seance "
                          + "AND seance_enseignants.id_enseignant=utilisateur.id ");
            for (String liste1 : listeMardi) {
                    courMardi.add(liste1);
                }
        }catch (SQLException e) {
        }
        return listeMardi;
    }
    
    public ArrayList<String> afficherMercredi() throws SQLException {
        ArrayList<String> listeMercredi = null;
        try {
            // recupérér les résultats de la requete
              listeMercredi = maconnexion.remplirChampsRequete("SELECT seance.id,cours.nom , groupe.nom,salle.nom,site.nom,type_cours.nom, utilisateur.nom, seance.heure_debut,seance.heure_fin,seance.etat"
                          + "FROM seance,seance_groupes,groupe,cours,salle,seance_salles,site,type_cours,utilisateur,seance_enseignants"
                          + " WHERE seance_groupes.id_seance=seance.id "
                          + "AND groupe.id=seance_groupes.id_groupe "
                          + "AND DAYOFWEEK(seance.date) = 4 "
                          + "AND cours.id= seance.id_cours"
                          + " AND seance.id= seance_salles.id_seance "
                          + "AND salle.id=seance_salles.id_salle "
                          + "AND salle.id_site=site.id "
                          + "AND type_cours.id=seance.id_type"
                          + " AND seance.id=seance_enseignants.id_seance "
                          + "AND seance_enseignants.id_enseignant=utilisateur.id "
                   );


            for (String liste1 : listeMercredi) {
                    courMercredi.add(liste1);
                }
        }catch (SQLException e) {
        }
        return listeMercredi;
    }
    
    public ArrayList<String> afficherJeudi() throws SQLException {
        ArrayList<String> listeJeudi = null;
        try {
            // recupérér les résultats de la requete
             listeJeudi = maconnexion.remplirChampsRequete("SELECT seance.id,cours.nom , groupe.nom,salle.nom,site.nom,type_cours.nom, utilisateur.nom, seance.heure_debut,seance.heure_fin,seance.etat "
                          + "FROM seance,seance_groupes,groupe,cours,salle,seance_salles,site,type_cours,utilisateur,seance_enseignants"
                          + " WHERE seance_groupes.id_seance=seance.id "
                          + "AND groupe.id=seance_groupes.id_groupe "
                          + "AND DAYOFWEEK(seance.date) = 5 "
                          + "AND cours.id= seance.id_cours"
                          + " AND seance.id= seance_salles.id_seance "
                          + "AND salle.id=seance_salles.id_salle "
                          + "AND salle.id_site=site.id "
                          + "AND type_cours.id=seance.id_type"
                          + " AND seance.id=seance_enseignants.id_seance "
                          + "AND seance_enseignants.id_enseignant=utilisateur.id "
                    );

            for (String liste1 : listeJeudi) {
                    courJeudi.add(liste1);
                    
                }
        }catch (SQLException e) {
        }
        return listeJeudi;
    }
    
    public ArrayList<String> afficherVendredi() throws SQLException {
        ArrayList<String> listeVendredi = null;
        try {
            // recupérér les résultats de la requete
                listeVendredi = maconnexion.remplirChampsRequete("SELECT seance.id,cours.nom , groupe.nom,salle.nom,site.nom,type_cours.nom, utilisateur.nom, seance.heure_debut,seance.heure_fin,seance.etat "
                          + "FROM seance,seance_groupes,groupe,cours,salle,seance_salles,site,type_cours,utilisateur,seance_enseignants"
                          + " WHERE seance_groupes.id_seance=seance.id "
                          + "AND groupe.id=seance_groupes.id_groupe "
                          + "AND DAYOFWEEK(seance.date) = 6 "
                          + "AND cours.id= seance.id_cours"
                          + " AND seance.id= seance_salles.id_seance "
                          + "AND salle.id=seance_salles.id_salle "
                          + "AND salle.id_site=site.id "
                          + "AND type_cours.id=seance.id_type"
                          + " AND seance.id=seance_enseignants.id_seance "
                          + "AND seance_enseignants.id_enseignant=utilisateur.id "
                        
                   );

            for (String liste1 : listeVendredi) {
                    
                    courVendredi.add(liste1);
                    courVendredi.add("");
                }
        }catch (SQLException e) {
        }
        return listeVendredi;
    }
    
    
    public void affichage() throws SQLException{
        try {
                    // tentative de connexion si les 4 attributs sont remplis
                    //maconnexion = new Connexion("jps", "root", "");
                    maconnexion = new Connexion("edp", "root", "");

                    // effacer les listes de tables et de requêtes
                    courLundi.removeAll();
                    courMardi.removeAll();
                    courMercredi.removeAll();
                    courJeudi.removeAll();
                    courVendredi.removeAll();
                    

                    // initialisation de la liste des requetes de selection et de MAJ

                    // afficher la liste de tables et des requetes

                    // se positionner sur la première table et requête de selection
                    courLundi.select(0);
                    courMardi.select(0);
                    courMercredi.select(0);
                    courJeudi.select(0);
                    courVendredi.select(0);

                    // afficher les champs de la table sélectionnée

                    // recuperer les lignes de la table selectionnee

                    // recuperer la liste des lignes de la requete selectionnee
                    

                    // afficher les résultats de la requete selectionnee
                    
                    afficherLundi();
                    afficherMardi();
                    afficherMercredi();
                    afficherJeudi();
                    afficherVendredi();
                } catch (ClassNotFoundException cnfe) {
                    System.out.println("Connexion echouee : probleme de classe");
                    cnfe.printStackTrace();
                }
    }    
   

    /**
     *
     * Pour gerer les actions sur les boutons on utilise la fonction
     * actionPerformed
     *
     * @param evt
     */
    private class BoutonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
             String insr,updt;
             int i;
             //nom = nommec.getText();
             //i= Integer.parseInt(nom);
            try {
                //System.out.println(nom);
                new MainWindowAdmin2().setVisible(true);
                
            } catch (IOException ex) {
                Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
            }
           /* try {
                
                nom="INSERT INTO cours " + "VALUES ('"+i+"','binks')";
                updt="UPDATE type_cours SET nom = 'Travaux pratiques' where id ='"+i+"' ";
                maconnexion.executeUpdate(updt);
                affichage();
                executeUpdate
            } catch (SQLException ex) {
                Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
            }
            */
        }
    }
      private class MainWindowAdmin2 extends JFrame {

        public MainWindowAdmin2() throws IOException {
            

        // mise en page (layout) de la fenetre visible
           
                setLocation(600, 250);
                setSize(600, 400);
             Container frame = getContentPane();   
                
      
             p6 = new JPanel();
             //newenseignant = new JTextField(10);
             
             idseance = new JTextField(10);
             
             idseance.setText("Id séance");
             Button updtsengeignant= new Button("Validé cette séance");
             Button suppengeignant= new Button("Annulé cette séance");
             updtsengeignant.addActionListener(new BoutonupdtListener());
             suppengeignant.addActionListener(new BoutonsuppListener());
             p6.add(idseance);
             p6.add(updtsengeignant);
             p6.add(suppengeignant);
             p6.setVisible(true);
             
                frame.add(p6);
                frame.setVisible(true);
  
        }
    }


     
      private class BoutonupdtListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String insr,updt;
            int i;
            
            nom2 = idseance.getText();
            i= Integer.parseInt(nom2);
            updt="UPDATE seance SET etat = 'Validé' where id ='"+i+"' ";
            try {
                maconnexion.executeUpdate(updt);
                affichage();
            } catch (SQLException ex) {
                Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
            }
         
        }}
       
      private class BoutonsuppListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String insr,updt;
            int i;
            
            nom2 = idseance.getText();
            i= Integer.parseInt(nom2);
            updt="UPDATE seance SET etat = 'Annulé' where id ='"+i+"' ";
            try {
                maconnexion.executeUpdate(updt);
                affichage();
            } catch (SQLException ex) {
                Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
            }
         
        }}  
    @Override
    @SuppressWarnings("CallToThreadDumpStack")
    
    public void actionPerformed(ActionEvent evt) {
       
    }

    /**
     *
     * Pour gerer les actions sur items d'une liste on utilise la methode
     * itemStateChanged
     *
     * @param evt
     */
    @Override
    @SuppressWarnings("CallToThreadDumpStack")
    public void itemStateChanged(ItemEvent evt) {
        
    }
}
