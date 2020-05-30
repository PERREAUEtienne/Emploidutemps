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

import Controlleur.Etudiant;
import Controlleur.Utilisateur;
import DAO.DAO;
import DAO.EtudiantDAO;
import DAO.UtilisateurDAO;
import java.awt.event.*;
import java.awt.Container;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import java.io.IOException;


public class Interface extends JFrame {
     private JPanel panel, panel2, panelprof, paneletudiant, panelupdate, paneledt, panelreupdate;             // To reference a panel
    private JLabel messageLabel2, messageLabel3, welcome, tozz1, tozz2, tozz3, lb1, msgloc, msgloc3, msgarea, msgpri, msghal, msgkit, msgsemifur, msgfur, msgremove, test1, test2, espace;      // To reference a label
    private JTextField idtext, prop1, prop2, prop3, prop4, prop5, prop6, prop7, propremove, propupdate, prop8, prop9, prop10, prop11, prop12, prop13, prop14;
    private JTextField passwordtext;// To reference a text field
    private JButton loginbutton, edpbutton, addbutton, updatebutton, okremovebutton, createbutton, okupdatebutton, reupdatebutton;
    
    public Interface() throws IOException {
        
        super("hyperplanning");
        panel = new JPanel();
        // Set the size of the window.
        setLocation(600, 250);
        setSize(1000, 600);

        // Specify what happens when the close button is clicked.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Build the panel and add it to the frame.
        messageLabel2 = new JLabel("Email");
        messageLabel3 = new JLabel("password");
        // Create a text field 15 characters wide.
        idtext = new JTextField(15);
        passwordtext = new JTextField(15);
        // Create a button with the caption "Calculate".
        loginbutton = new JButton("log in");
        loginbutton.addActionListener(new LoginButtonListener());
        panel.add(messageLabel2);
        panel.add(idtext);
        panel.add(messageLabel3);
        panel.add(passwordtext);
        panel.add(loginbutton);
        Container frame = getContentPane();
        frame.add(panel);
        setVisible(true);
               
}
    
    private class LoginButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            welcome = new JLabel("Access Granted! Welcome!");
           
            tozz3 = new JLabel("Invalid Username & Password! try again!");
            String id, password;

            id = idtext.getText();
            password = passwordtext.getText();
            
            DAO<Utilisateur> utilisateurDao = new UtilisateurDAO(SdzConnection.getInstance());
            for(int i = 1; i < 7; i++){
            Utilisateur utilisateur = utilisateurDao.find(i);
            //System.out.println("Email N°" + utilisateur.getEmail() + " Password " + utilisateur.getPasswd());
            if (id.equals(utilisateur.getEmail()) && password.equals(utilisateur.getPasswd()) && utilisateur.getDroit()==4) {

                try {
                    panel.add(welcome);
                    new MainWindowEtudiant().setVisible(true);
                    
                } catch (IOException ex) {
                    Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(id.equals(utilisateur.getEmail()) && password.equals(utilisateur.getPasswd()) && utilisateur.getDroit()==3){
                try {
                    panel.add(welcome);
                    new MainWindowProf().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
             else if(id.equals(utilisateur.getEmail()) && password.equals(utilisateur.getPasswd()) && utilisateur.getDroit()==2){
                try {
                    panel.add(welcome);
                    new MainWindowReferent().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
              else if(id.equals(utilisateur.getEmail()) && password.equals(utilisateur.getPasswd()) && utilisateur.getDroit()==1){
                try {
                    panel.add(welcome);
                    new MainWindowAdmin().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

           
                //JOptionPane.showMessageDialog(null,"welcome")
            else {
                //panel.add(tozz3);
                //add(panel);
                //setVisible(true);
            }

        }
    }
    private class MainWindowEtudiant extends JFrame {

        public MainWindowEtudiant() throws IOException {
            setTitle("Page de l'etudiant");
            
            setLocation(600, 250);
            setSize(600, 400);
            paneletudiant = new JPanel();
            tozz1 = new JLabel("Welcome Etudiant");
            paneletudiant.add(tozz1);
            
            edpbutton = new JButton("Emploi du temps");
            edpbutton.addActionListener(new EdpButtonListener());
        
            paneletudiant.add(edpbutton);
            Container frame = getContentPane();
            frame.add(paneletudiant);
            // Display the window.
            setVisible(true);
        }
    }
    
    private class EdpButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        
        
            try {
                new MainWindowEdp().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     private class MainWindowEdp extends JFrame {

        public MainWindowEdp() throws IOException {
            setTitle("Emploi du temps");
            paneledt= new JPanel();
            setLocation(600, 250);
            setSize(600, 400);
            DAO<Etudiant> etudiantDao = new EtudiantDAO(SdzConnection.getInstance());
            for(int i = 1; i < 5; i++){
                 Etudiant etudiant = etudiantDao.find(i);
                System.out.println("Cours N°" + etudiant.getId_utilisateur() + "  - " + etudiant.getNumero());
                tozz2 = new JLabel();
             }
            Container frame = getContentPane();
            frame.add(paneletudiant);
            // Display the window.
            setVisible(true);
        }
    }
    }
         private class MainWindowProf extends JFrame {
        public MainWindowProf() throws IOException {
            setTitle("Page du prof");
           
            setLocation(600, 250);
            setSize(600, 400);
            panelprof = new JPanel();
            tozz1 = new JLabel("Welcome prof");
            panelprof.add(tozz1);
            Container frame = getContentPane();
            frame.add(panelprof);
            // Display the window.
            setVisible(true);
        }
    }
        private class MainWindowAdmin extends JFrame {

        public MainWindowAdmin() throws IOException {
            setTitle("Page Amin");
          
            setLocation(600, 250);
            setSize(600, 400);
            panelprof = new JPanel();
            tozz1 = new JLabel("Admin");
            panelprof.add(tozz1);
            Container frame = getContentPane();
            frame.add(panelprof);
            // Display the window.
            setVisible(true);
        }
    }
       private class MainWindowReferent extends JFrame {

        public MainWindowReferent() throws IOException {
            setTitle("Page Référent Pédagogique");
        
            setLocation(600, 250);
            setSize(600, 400);
            panelprof = new JPanel();
            tozz1 = new JLabel("Référent Pédagogique");
            panelprof.add(tozz1);
            Container frame = getContentPane();
            frame.add(panelprof);
            // Display the window.
            setVisible(true);
        }
    }
        
    
     public static void main(String[] args) throws FileNotFoundException, IOException {

        //PrintWriter outputFile = new PrintWriter(""C:\\Users\\etien\\Desktop\\ECE cours\\Projet Programming london\\ProjectV0\\Textfile.txt"");
        Interface v = new Interface();

    }

}

