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
import java.util.*;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Affiche dans la fenetre graphique les champs de tables et les requetes de la
 * BDD
 *
 * @author segado
 */
public class Fenetre extends JFrame implements ActionListener, ItemListener {

    /*
     * Attribut privés : objets de Connexion, AWT et Swing
     * 
     */

    private Connexion maconnexion;
    private final JLabel lundi, mercredi, jeudi, mardi,vendredi;
    private final JLabel nameBDD, requeteLabel;
    private final JTextField requeteTexte, nameBDDTexte;
    private final JButton exec, local;
    private final java.awt.List courLundi, courMardi, courMercredi, courJeudi, courVendredi;
    private final JPanel p0, p1, nord, p2, p3, p4;

    /**
     * Constructeur qui initialise tous les objets graphiques de la fenetre
     */
    public Fenetre() {

        // creation par heritage de la fenetre
        super("Projet d'utilisation de JDBC dans MySQL");

        // mise en page (layout) de la fenetre visible
        setLayout(new BorderLayout());
        setBounds(0, 0, 400, 400);
        setResizable(true);
        setVisible(true);

        // creation des boutons
        //connect = new JButton("Connexion ECE");
        local = new JButton("Connexion locale");
        exec = new JButton("Executer");

        // creation des listes pour les tables et les requetes
        courLundi = new java.awt.List(10, false);
        courMardi = new java.awt.List(10, false);
        courMercredi = new java.awt.List(10, false);
        courJeudi = new java.awt.List(10, false);
        courVendredi = new java.awt.List(10, false);

        // creation des textes

        nameBDDTexte = new JTextField();
        requeteTexte = new JTextField();

        // creation des labels
        lundi = new JLabel("Lundi", JLabel.CENTER);
        mardi = new JLabel("Mardi", JLabel.CENTER);
        mercredi = new JLabel("Mercredi", JLabel.CENTER);
        jeudi = new JLabel("Jeudi", JLabel.CENTER);
        vendredi = new JLabel("vendredi", JLabel.CENTER);
        
        nameBDD = new JLabel("nom base :", JLabel.CENTER);
        requeteLabel = new JLabel("Entrez votre requete de sélection :", JLabel.CENTER);

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

        p0.add(nameBDD);
        p0.add(nameBDDTexte);
        p0.add(local);
        p1.add(lundi);
        p1.add(mardi);
        p1.add(mercredi);
        p1.add(jeudi);
        p1.add(vendredi);
        nord.add("North", p0);
        nord.add("North", p1);
        p2.add(courLundi);
        p2.add(courMercredi);
        p2.add(courMardi);
        p2.add(courJeudi);
        p2.add(courVendredi);
        p3.add(requeteLabel);
        p3.add(requeteTexte);
        p3.add(exec);

        // ajout des listeners
        exec.addActionListener(this);
        local.addActionListener(this);
        courLundi.addItemListener(this);
        courMardi.addItemListener(this);

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
     * Méthode privée qui initialise la liste des tables
     */
    private void remplirTables() {

        maconnexion.ajouterTable("utilisateur");
        maconnexion.ajouterTable("cours");

    }

    /**
     * Méthode privée qui initialise la liste des requetes de selection
     */
    private void remplirRequetes() {
        maconnexion.ajouterRequete("SELECT ename, sal FROM Emp ORDER BY sal;");
        maconnexion.ajouterRequete("SELECT Dept.*, Emp.*, Mission.* FROM Dept, Emp, Mission WHERE Dept.deptno=Emp.deptno AND Emp.empno=Mission.empno;");
        maconnexion.ajouterRequete("SELECT AVG (Emp.sal) FROM Emp, Mission WHERE Emp.empno = Mission.empno;");
        maconnexion.ajouterRequete("SELECT Dept.*, Emp.* FROM Dept, Emp WHERE Dept.deptno=Emp.deptno AND comm>0;");
        maconnexion.ajouterRequete("SELECT hiredate, empno, ename FROM Emp WHERE (((hiredate)>='1981-05-01' And (hiredate)<'1981-05-31'))ORDER BY hiredate;");
        maconnexion.ajouterRequete("SELECT ename, job FROM Emp ORDER BY job;");
        maconnexion.ajouterRequete("SELECT DISTINCT dname, job FROM Dept, Emp WHERE Dept.deptno=Emp.deptno AND job='Clerk';");
        maconnexion.ajouterRequete("SELECT id FROM utilisateur;");
        maconnexion.ajouterRequete("SELECT Prenom FROM utilisateur;");
    }

    /**
     * Méthode privée qui initialise la liste des requetes de MAJ
     */
    private void remplirRequetesMaj() {
        // Requêtes d'insertion
        maconnexion.ajouterRequeteMaj("INSERT INTO Dept (deptno,dname,loc) VALUES (50,'ECE','Paris');");

        // Requêtes de modification
        maconnexion.ajouterRequeteMaj("UPDATE Dept SET loc='Eiffel' WHERE loc='Paris';");

        // Requêtes de suppression
        maconnexion.ajouterRequeteMaj("DELETE FROM Dept WHERE loc='Eiffel';");

    }

    /**
     *
     * Afficher les tables
     */
    public void afficherTables() {
        for (String table : maconnexion.tables) {
            courLundi.add(table);
            courMercredi.add(table);
            courJeudi.add(table);
            courVendredi.add(table);
        }
    }

    /**
     *
     * Afficher les lignes de la table sélectionnée
     *
     * @param nomTable
     */
    public void afficherLignes(String nomTable) {
        
    }

    /**
     *
     * Afficher les requetes de selection et de MAJ dans la fenetre
     */
    public void afficherRequetes() {
        for (String requete : maconnexion.requetes) {
            courMardi.add(requete);
        }
    }

    /**
     *
     * Afficher et retourner les résultats de la requete sélectionnée
     *
     * @param requeteSelectionnee
     * @return
     * @throws java.sql.SQLException
     */
    public ArrayList<String> afficherLundi(String requeteSelectionnee) throws SQLException {
        ArrayList<String> listeLundi = null;
        ArrayList<String> listeJeudi = null;
        ArrayList<String> listeVendredi = null;
        try {

            // recupérér les résultats de la requete selectionnee
            listeLundi = maconnexion.remplirChampsRequete("SELECT seance.id, utilisateur.nom, groupe.nom, salle.nom, site.nom, cours.nom "
                    + "FROM seance, utilisateur, seance_enseignants, groupe, seance_groupes,salle,site,seance_salles,cours "
                    + "WHERE utilisateur.id=seance_enseignants.id_enseignant "
                    + "AND seance.id=seance_groupes.id_seance "
                    + "AND groupe.id=seance_groupes.id_groupe "
                    + "AND seance.id=seance_salles.id_seance "
                    + "AND salle.id=seance_salles.id_salle "
                    + "AND site.id=salle.id_site "
                    + "AND cours.id=seance.id_cours ");
                   
                       
            // afficher les lignes de la requete selectionnee a partir de la liste
            for (String liste1 : listeLundi) {
                courLundi.add(liste1);
            }
        } catch (SQLException e) {
        }
        return listeLundi;        
    }

    public ArrayList<String> afficherMardi(String requeteSelectionnee) throws SQLException {
        ArrayList<String> listeMardi = null;
        try {
            // recupérér les résultats de la requete
            listeMardi = maconnexion.remplirChampsRequete("SELECT seance.id, utilisateur.nom, groupe.nom, salle.nom, site.nom, cours.nom "
                        + "FROM seance, utilisateur, seance_enseignants, groupe, seance_groupes,salle,site,seance_salles,cours "
                        + "WHERE utilisateur.id=seance_enseignants.id_enseignant "
                        + "AND seance.id=seance_groupes.id_seance "
                        + "AND groupe.id=seance_groupes.id_groupe "
                        + "AND seance.id=seance_salles.id_seance "
                        + "AND salle.id=seance_salles.id_salle "
                        + "AND site.id=salle.id_site "
                        + "AND cours.id=seance.id_cours ");

            for (String liste1 : listeMardi) {
                    courMardi.add(liste1);
                }
        }catch (SQLException e) {
        }
        return listeMardi;
    }
    
    public ArrayList<String> afficherMercredi(String requeteSelectionnee) throws SQLException {
        ArrayList<String> listeMercredi = null;
        try {
            // recupérér les résultats de la requete
            listeMercredi = maconnexion.remplirChampsRequete("SELECT seance.id, utilisateur.nom, groupe.nom, salle.nom, site.nom, cours.nom "
                        + "FROM seance, utilisateur, seance_enseignants, groupe, seance_groupes,salle,site,seance_salles,cours "
                        + "WHERE utilisateur.id=seance_enseignants.id_enseignant "
                        + "AND seance.id=seance_groupes.id_seance "
                        + "AND groupe.id=seance_groupes.id_groupe "
                        + "AND seance.id=seance_salles.id_seance "
                        + "AND salle.id=seance_salles.id_salle "
                        + "AND site.id=salle.id_site "
                        + "AND cours.id=seance.id_cours ");

            for (String liste1 : listeMercredi) {
                    courMardi.add(liste1);
                }
        }catch (SQLException e) {
        }
        return listeMercredi;
    }
    
    public ArrayList<String> afficherJeudi(String requeteSelectionnee) throws SQLException {
        ArrayList<String> listeJeudi = null;
        try {
            // recupérér les résultats de la requete
            listeJeudi = maconnexion.remplirChampsRequete("SELECT seance.id, utilisateur.nom, groupe.nom, salle.nom, site.nom, cours.nom "
                        + "FROM seance, utilisateur, seance_enseignants, groupe, seance_groupes,salle,site,seance_salles,cours "
                        + "WHERE utilisateur.id=seance_enseignants.id_enseignant "
                        + "AND seance.id=seance_groupes.id_seance "
                        + "AND groupe.id=seance_groupes.id_groupe "
                        + "AND seance.id=seance_salles.id_seance "
                        + "AND salle.id=seance_salles.id_salle "
                        + "AND site.id=salle.id_site "
                        + "AND cours.id=seance.id_cours ");

            for (String liste1 : listeJeudi) {
                    courMardi.add(liste1);
                }
        }catch (SQLException e) {
        }
        return listeJeudi;
    }
    
    public ArrayList<String> afficherVendredi(String requeteSelectionnee) throws SQLException {
        ArrayList<String> listeVendredi = null;
        try {
            // recupérér les résultats de la requete
            listeVendredi = maconnexion.remplirChampsRequete("SELECT seance.id, utilisateur.nom, groupe.nom, salle.nom, site.nom, cours.nom "
                        + "FROM seance, utilisateur, seance_enseignants, groupe, seance_groupes,salle,site,seance_salles,cours "
                        + "WHERE utilisateur.id=seance_enseignants.id_enseignant "
                        + "AND seance.id=seance_groupes.id_seance "
                        + "AND groupe.id=seance_groupes.id_groupe "
                        + "AND seance.id=seance_salles.id_seance "
                        + "AND salle.id=seance_salles.id_salle "
                        + "AND site.id=salle.id_site "
                        + "AND cours.id=seance.id_cours ");

            for (String liste1 : listeVendredi) {
                    courMardi.add(liste1);
                }
        }catch (SQLException e) {
        }
        return listeVendredi;
    }
    
    /**
     *
     * Pour gerer les actions sur les boutons on utilise la fonction
     * actionPerformed
     *
     * @param evt
     */
    @Override
    @SuppressWarnings("CallToThreadDumpStack")
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();

        // tester cas de la commande evenementielle
        if (source == local) {
            ArrayList<String> liste;
            try {
                try {
                    // tentative de connexion si les 4 attributs sont remplis
                    //maconnexion = new Connexion("jps", "root", "");
                    maconnexion = new Connexion(nameBDDTexte.getText(), "root", "");

                    // effacer les listes de tables et de requêtes
                    courLundi.removeAll();
                    courMardi.removeAll();
                    courMercredi.removeAll();
                    courJeudi.removeAll();
                    courVendredi.removeAll();
                    

                    // initialisation de la liste des requetes de selection et de MAJ
                    remplirTables();
                    remplirRequetes();
                    remplirRequetesMaj();

                    // afficher la liste de tables et des requetes
                    afficherTables();
                    afficherRequetes();

                    // se positionner sur la première table et requête de selection
                    courLundi.select(0);
                    courMardi.select(0);
                    courMercredi.select(0);
                    courJeudi.select(0);
                    courVendredi.select(0);

                    // afficher les champs de la table sélectionnée
                    String nomTable = courLundi.getSelectedItem();

                    // recuperer les lignes de la table selectionnee
                    afficherLignes(nomTable);

                    // recuperer la liste des lignes de la requete selectionnee
                    String requeteSelectionnee = courMardi.getSelectedItem();

                    // afficher les résultats de la requete selectionnee
                    afficherLundi(requeteSelectionnee);
                    afficherMardi(requeteSelectionnee);
                    afficherMercredi(requeteSelectionnee);
                    afficherJeudi(requeteSelectionnee);
                    afficherVendredi(requeteSelectionnee);
                } catch (ClassNotFoundException cnfe) {
                    System.out.println("Connexion echouee : probleme de classe");
                    cnfe.printStackTrace();
                }
            } catch (SQLException e) {
                System.out.println("Connexion echouee : probleme SQL");
                e.printStackTrace();
            }
        } else if (source == exec) {
            String requeteSelectionnee = requeteTexte.getText(); // récupérer le texte de la requête

            // effacer les résultats
            courJeudi.removeAll();

            try {
                // afficher les résultats de la requete selectionnee
                if (afficherLundi(requeteSelectionnee) != null) {
                    maconnexion.ajouterRequete(requeteSelectionnee);
                    courMardi.removeAll();
                    afficherRequetes();
                }

            } catch (SQLException ex) {

            }

        }
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
        // sélection d'une requete et afficher ses résultats
        if (evt.getSource() == courMardi) {
            // recuperer la liste des lignes de la requete selectionnee
            String requeteSelectionnee = courMardi.getSelectedItem();
            try {
                afficherLundi(requeteSelectionnee);
                afficherMardi(requeteSelectionnee);
                afficherMercredi(requeteSelectionnee);
                afficherJeudi(requeteSelectionnee);
                afficherVendredi(requeteSelectionnee);
            } catch (SQLException ex) {
                Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (evt.getSource() == courLundi) {
            // afficher les lignes de la table sélectionnée
            String nomTable = courLundi.getSelectedItem();
            afficherLignes(nomTable);
        }
    }
}
