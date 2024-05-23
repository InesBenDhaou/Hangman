package src.frames;
import javax.swing.*;

import src.buttons.ButtonRounded;
import src.models.Utilisateur;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.JOptionPane;



public class Ident extends JFrame{

    ImageIcon pondu;
    JLabel backgroundImage;

    JButton home;
    JLabel homeLabel;

    JLabel bienvenue ;

    JLabel nomJoueur;
    JTextField nom ;

    JLabel motDePasse;
    JPasswordField mdp;

    ButtonRounded cancel ;
    ButtonRounded signIn;

    JLabel create ;
    ButtonRounded logIn;
    

    public Ident ()
            {
                super("jeu de pondu");

                // Create a new Color object with RGB values of 145, 223, and 62
                Color myColor = new Color(145, 223, 62);

                //background image
                pondu = new ImageIcon(this.getClass().getResource("/src/images/principale.jpg"));
                backgroundImage = new JLabel(pondu);
                backgroundImage.setSize(1000,1000);
                

                // le boutton home et son action

                ImageIcon buttonHomeIcon = new ImageIcon ("src/images/home.png");
                home = new JButton (null,buttonHomeIcon);
                home.setBorderPainted(false);
                home.setContentAreaFilled(false);
                home.setBounds(30,30,buttonHomeIcon.getIconWidth(),buttonHomeIcon.getIconHeight());
                homeLabel = new JLabel("HOME");
                homeLabel.setFont(new Font(Font.SERIF, Font.BOLD, 10));
                homeLabel.setForeground(Color.WHITE);
                homeLabel.setBounds(30, 30, 100,100);
                home.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                           dispose();
                           Principale p = new Principale();
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
                // zone de texte de Nom joueur
                mdp = new JPasswordField();
                mdp.setPreferredSize(new Dimension(200, 10));
                mdp.setBounds(50, 300, 300,30);
                mdp.setBackground(Color.white);
                mdp.setFont(new Font(Font.SERIF, Font.BOLD, 16));
                mdp.setForeground(Color.BLACK);
                mdp.addMouseListener(new MouseAdapter() {
                    public void mouseEntered(MouseEvent e) {
                            mdp.setBackground(new Color(202, 247, 155));
                        }
                        
                    
                    public void mouseExited(MouseEvent e) {
                        
                            mdp.setBackground(Color.white);
                            
                        }
                    
                });

                // les bouttons d'identification et annulation
                signIn = new ButtonRounded("S'identifier");
                signIn.setBounds(50,350,145,30);
                signIn.addActionListener(new ActionListener() {
                    public void actionPerformed (ActionEvent e)
                    {
                       //verfier les coordonnées
                         
                         String mdpString = String.valueOf(mdp.getPassword());
                         if (mdpString.equals("") || nom.getText().equals(""))
                         {
                            JOptionPane.showMessageDialog(null, "Remplir tous les champs svp!");
                         }
                         else{
                         if(BaseDeDonnee.VerfierUtilisateur(nom.getText(),mdpString)){
                                //na3mel mise a jour lel utilisateur connecte
                                Utilisateur utilisateur = new Utilisateur(nom.getText(), mdpString);
                                BaseDeDonnee.setUtilisateur(utilisateur);
                                // ken verfier n7elou secondaire
                                dispose();
                                Secondaire s = new Secondaire();


                        }else
                            {   
                                JOptionPane.showMessageDialog(null, "Compte Introuvable!");  }    }                    
                        
                    }
                });
                
                cancel = new ButtonRounded("Annuler");
                cancel.setBounds(200,350,145,30);
                cancel.addActionListener(new ActionListener() {
                    public void actionPerformed (ActionEvent e)
                    {
                       //tfaragh les input 
                       mdp.setText("");  
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
                
                // label de creation de compte
                create = new JLabel("vous n'avez pas de compte? Rejoignez le plaisir!");
                create.setFont(new Font(Font.SERIF, Font.BOLD, 13));
                create.setForeground(Color.white);
                create.setBounds(65, 360, 300,100);

                logIn = new ButtonRounded("S'inscrire");
                logIn.setBounds(120,430,145,30);
                logIn.addActionListener(new ActionListener() {
                    public void actionPerformed (ActionEvent e)
                    {
                       //t7el frame jdida eli hia crationAccount w nansawesh e dispose betbi3a
                       dispose();
                       Inscrit i = new Inscrit();
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
                backgroundImage.add(signIn);
                backgroundImage.add(cancel);
                backgroundImage.add(create);
                backgroundImage.add(logIn);
                this.add(backgroundImage);
                
                //frame
                this.setSize(410,680);
                this.setVisible(true);
                this.setLocation(570, 90);
                this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

                

    
}
}
