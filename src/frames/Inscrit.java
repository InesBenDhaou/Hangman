package src.frames;
import javax.swing.*;
import src.models.Utilisateur;
import src.buttons.ButtonRounded;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.*;

public class Inscrit extends JFrame{

    ImageIcon pondu;
    JLabel backgroundImage;
    JButton home;
    JLabel homeLabel;
    JButton Back;
    JLabel BackLabel;
    JLabel bienvenue ;
    JLabel nomJoueur;
    JTextField nom ;
    JLabel motDePasse;
    JPasswordField mdp;
    JLabel motDePasseVerife ;
    JPasswordField mdpv;
    ButtonRounded cancel ;
    ButtonRounded signIn;
    

    public Inscrit ()
    {
        super("jeu de pondu");
                // Create a new Color object with RGB values of 145, 223, and 62
                Color myColor = new Color(145, 223, 62);

                //background image
                pondu = new ImageIcon(this.getClass().getResource("/src/images/principale.jpg"));
                backgroundImage = new JLabel(pondu);
                backgroundImage.setSize(1000,1000);
                

                // le bouttons home 

                ImageIcon buttonHomeIcon = new ImageIcon ("src/images/home.png");
                home = new JButton (null,buttonHomeIcon);
                home.setBorderPainted(false);
                home.setContentAreaFilled(false);
                home.setBounds(30,30,buttonHomeIcon.getIconWidth(),buttonHomeIcon.getIconHeight());
                homeLabel = new JLabel("HOME");
                homeLabel.setFont(new Font(Font.SERIF, Font.BOLD, 10));
                homeLabel.setForeground(Color.WHITE);
                homeLabel.setBounds(30, 30, 100,100);
                // action de home
                home.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                           JFrame oldFrame = (JFrame) ((JButton) e.getSource()).getTopLevelAncestor();
                           oldFrame.dispose();
                           Principale p = new Principale();
                     }
                });

                ImageIcon buttonBackIcon = new ImageIcon ("src/images/back.png");
                Back = new JButton (null,buttonBackIcon);
                Back.setBorderPainted(false);
                Back.setContentAreaFilled(false);
                Back.setBounds(340,30,buttonBackIcon.getIconWidth(),buttonBackIcon.getIconHeight());
                BackLabel = new JLabel("BACK");
                BackLabel.setFont(new Font(Font.SERIF, Font.BOLD, 10));
                BackLabel.setForeground(Color.WHITE);
                BackLabel.setBounds(340, 27, 100,100);
                Back.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                               dispose();
                               Ident i = new Ident();
                         }
                 });

                //label de bienvenue
                bienvenue = new JLabel("BIENVENUE !");
                bienvenue.setFont(new Font(Font.SERIF, Font.BOLD, 27));
                bienvenue.setForeground(myColor);
                bienvenue.setBounds(120, 110, 300,100);

                //label de Nom de joueur
                nomJoueur = new JLabel("Nom Joueur :");
                nomJoueur.setFont(new Font(Font.SERIF, Font.BOLD, 16));
                nomJoueur.setForeground(Color.white);
                nomJoueur.setBounds(50, 150, 300,100);
                
                // zone de texte de Nom joueur
                nom = new JTextField();
                nom.setPreferredSize(new Dimension(200, 10));
                nom.setBounds(50, 225, 300,30);
                nom.setBackground(Color.white);
                nom.setFont(new Font(Font.SERIF, Font.BOLD, 16));
                nom.setForeground(Color.GRAY);
                nom.setText("Entrer votre Nom ");
               // nom.setBorder(new RoundedBorder(30));
                nom.addFocusListener(new FocusListener() {
                    public void focusGained(FocusEvent e) {
                        if (nom.getForeground() == Color.GRAY) {
                            nom.setText("");
                            nom.setForeground(Color.BLACK);
                        }
                    }
                    
                    public void focusLost(FocusEvent e) {
                        if (nom.getText().isEmpty()) {
                            nom.setText("Enter votre Nom");
                            nom.setForeground(Color.black);
                        }
                    }
                });
                nom.addMouseListener(new MouseAdapter() {
                    public void mouseEntered(MouseEvent e) {
                            nom.setBackground(new Color(202, 247, 155));
                        }
                        
                    
                    public void mouseExited(MouseEvent e) {
                        
                            nom.setBackground(Color.white);
                            
                        }
                    
                });

                //label de Password de joueur
                motDePasse = new JLabel("Mot De Passe :");
                motDePasse.setFont(new Font(Font.SERIF, Font.BOLD, 16));
                motDePasse.setForeground(Color.white);
                motDePasse.setBounds(50, 229, 300,100);
                
                // zone de texte de mot de passe joueur
                mdp = new JPasswordField();
                mdp.setPreferredSize(new Dimension(200, 10));
                mdp.setBounds(50, 300, 300,30);
                mdp.setBackground(Color.white);
                mdp.setFont(new Font(Font.SERIF, Font.BOLD, 16));
                mdp.setForeground(Color.BLACK);
               // nom.setBorder(new RoundedBorder(30));
                mdp.addMouseListener(new MouseAdapter() {
                    public void mouseEntered(MouseEvent e) {
                            mdp.setBackground(new Color(202, 247, 155));
                        }
                        
                    
                    public void mouseExited(MouseEvent e) {
                        
                            mdp.setBackground(Color.white);
                            
                        }
                    
                });

                //label de Password   a verfier de joueur
                motDePasseVerife = new JLabel("Mot De Passe De Nouveau :");
                motDePasseVerife.setFont(new Font(Font.SERIF, Font.BOLD, 16));
                motDePasseVerife.setForeground(Color.white);
                motDePasseVerife.setBounds(50, 300, 300,100);
                
                // zone de texte de mot de passe joueur
                mdpv = new JPasswordField();
                mdpv.setPreferredSize(new Dimension(200, 10));
                mdpv.setBounds(50, 375, 300,30);
                mdpv.setBackground(Color.white);
                mdpv.setFont(new Font(Font.SERIF, Font.BOLD, 16));
                mdpv.setForeground(Color.BLACK);
               // nom.setBorder(new RoundedBorder(30));
                mdpv.addMouseListener(new MouseAdapter() {
                    public void mouseEntered(MouseEvent e) {
                            mdpv.setBackground(new Color(202, 247, 155));
                        }
                        
                    
                    public void mouseExited(MouseEvent e) {
                        
                            mdpv.setBackground(Color.white);
                            
                        }
                    
                });

                // les bouttons
                signIn = new ButtonRounded("S'inscrire");
                signIn.setBounds(50,425,145,30);
                signIn.addActionListener(new ActionListener() {
                    public void actionPerformed (ActionEvent e)
                    {
                        String mdpString = String.valueOf(mdp.getPassword());
                        String mdpvString = String.valueOf(mdpv.getPassword());
             
                       
                       
                       if (BaseDeDonnee.existe(nom.getText())==false){
                           //nthabet eli houwa kteb l mdp bes7i7
                           if (mdpString.equals(mdpvString)){
                            //Enregistrer les coordonnées
                            BaseDeDonnee.ajouterJoueurs(nom.getText(),mdpString);
                            Utilisateur utilisateur = new Utilisateur(nom.getText(), mdpString);
                            BaseDeDonnee.setUtilisateur(utilisateur);
                            // n5arajlou dialogue de verification w n3adih
                            JOptionPane.showMessageDialog(null, "Compte creér avec succées");
                            dispose();
                            Secondaire s = new Secondaire();
                            }else{
                                //n5arajlou dialogue n9olo thabet fel mot de passe
                                JOptionPane.showMessageDialog(null, "Verfier votre mot de passe!");
                               
                            }}
                            else{
                                //n5arajlou dialogue n9olo 3ana joueur hedha fi data
                                JOptionPane.showMessageDialog(null, "Nom joueur existe déja!");
                            }
                        }
                    
                       
                       
                    });
                
                cancel = new ButtonRounded("Annuler");
                cancel.setBounds(200,425,145,30);
                cancel.addActionListener(new ActionListener() {
                    public void actionPerformed (ActionEvent e)
                    {
                       //tfaragh les input 
                       mdp.setText("");  
                       mdpv.setText("");
                       nom.setText("Entrer votre Nom ");
                       nom.setForeground(Color.GRAY);
                       nom.addFocusListener(new FocusListener() {
                            public void focusGained(FocusEvent e) {
                                if (nom.getForeground() == Color.GRAY) {
                                    nom.setText("");
                                    nom.setForeground(Color.BLACK);
                                }
                            }
                            
                            public void focusLost(FocusEvent e) {
                                if (nom.getText().isEmpty()) {
                                    nom.setText("Enter votre Nom");
                                    nom.setForeground(Color.black);
                                }
                            }
                        });     

                        }
                    
                });

                //ajout des elements
                backgroundImage.add(home);
                backgroundImage.add(homeLabel);
                backgroundImage.add(bienvenue);
                backgroundImage.add(nomJoueur);
                backgroundImage.add(nom);
                backgroundImage.add(motDePasse);
                backgroundImage.add(mdp);
                backgroundImage.add(motDePasseVerife);
                backgroundImage.add(mdpv);
                backgroundImage.add(signIn);
                backgroundImage.add(cancel);
                backgroundImage.add(Back);
                backgroundImage.add(BackLabel);
                this.add(backgroundImage);
                
                //frame
                this.setSize(410,680);
                this.setVisible(true);
                this.setLocation(570, 90);
                this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }
    
}
