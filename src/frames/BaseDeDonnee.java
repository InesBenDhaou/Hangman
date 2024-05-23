package src.frames;
import java.util.HashMap;
import java.util.HashMap.*;


import javax.lang.model.util.ElementScanner14;

import src.models.*;


public class BaseDeDonnee {

    private static  HashMap<String, Utilisateur> Data;
    private static Utilisateur UtilisateurConnecte;
    
    public BaseDeDonnee() {
        
        Data = new HashMap<String, Utilisateur>();
        
        // des utilisateurs 3andi deja
        
        Data.put("Ines", new Utilisateur("Ines", "123456"));
        Data.put("Chayma", new Utilisateur("Chayma", "123456"));
        Data.put("zayn", new Utilisateur("zayn", "159357"));
        /*
        Data.put("loulou", "258369");
        Data.put("zayn", "159357");
        Data.put("kali", "012347");
        Data.put("Malek", "235689");*/
    }


    public static boolean VerfierUtilisateur (String nom , String mdp)
    {
        /*if (!existe(nom)) return false;
        Utilisateur utilisateur = Data.get(nom);
        String password = utilisateur.getPassword();
        System.out.println(password);
        //verfier l'identification d'utilisateur w tchargi chkoun connecte
        if (password != null && password.equals(mdp)) {
           // BaseDeDonnee.UtilisateurConnecte = utilisateur;
            return true;
        }
        return false;*/
        if (!existe(nom)) return false;
        Utilisateur utilisateur = Data.get(nom);
        String password = utilisateur.getPassword();
        if (password != null && password.equals(mdp)) {
              return true;
         }
         else return false;

    }

    public static boolean existe (String nom)
    {
    
        // malazemesh nal9a nafss joueur akther men marra be creative cher joueur 
        return Data.containsKey(nom);
    }
    public static void setNomUtilisateuConnected (String nom)
    {
        UtilisateurConnecte.setNom (nom);
    }
    
    public static void ajouterJoueurs (String nom , String mdp)
    {
       Data.put(nom, new Utilisateur(nom, mdp));
       //y5arajli dialogue mta3 verification
    }

    public static void setUtilisateur (Utilisateur utilisateur)
    {
        UtilisateurConnecte = utilisateur;
    }

    public static Utilisateur getUtilisateur ()
    {
        return UtilisateurConnecte;
    }

    public static String getNomUtilisateurConnecte  ()
    {
        return UtilisateurConnecte.getNom();
    }
    
}
