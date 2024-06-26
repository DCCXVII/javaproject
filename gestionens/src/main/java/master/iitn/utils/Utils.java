package master.iitn.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import master.iitn.model.Roles;

// Class that return a hash of passwrod 
public class Utils {

    public String generateHash(String password) {
        String algorithm = "SHA-256";
        String salt = "iitn-23/24";
        String data = password + salt;
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            byte[] hash = digest.digest(data.getBytes());

            // Convert byte array to hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error generating hash: " + e.getMessage());
            return null;
        }
    }

    public String generateEmail(String nom, String prenom) {
        return nom.substring(0, 2).toLowerCase() + "." + prenom.toLowerCase() + "@uit.ac.ma";

    }

    public Roles setRole(String role) {
        Roles r = null;
        switch (role) {
            case "ETUDIANT":
                r = Roles.Etudiant;
                break;

            case "PROFESSEUR":
                r = Roles.Professeur;
                break;

            case "ADMINISTRATEUR":
                r = Roles.Administrateur;
                break;

            case "DIRECTEUR":
                r = Roles.DircteurPedagogique;
                break;
            default:
                break;

        }
        return r;
    }

}