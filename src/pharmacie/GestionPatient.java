/**
 * Classe de gestion patient
 *
 * @author Blumart Dorian
 * @version 1.0
 * @see Patient
 * @see PatientDAO
 */
package pharmacie;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import pharmacie.DAO.PatientDAO;
import pharmacie.DAO.DAO;
import pharmacie.metier.Patient;
import myconnections.DBConnection;

public class GestionPatient {

    /**
     * Scanner
     */
    Scanner sc = new Scanner(System.in);
    /**
     * dernier patient sur lequel on a travaillé
     */
    Patient patActuel = null;
    /**
     * accès DAO pour les patients
     */
    DAO<Patient> patientDAO = null;

    /**
     * méthode s'occupant du menu
     *
     * @throws SQLException connexion invalide
     */
    public void menu() throws SQLException {
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connexion invalide");
            System.exit(1);
        }

        System.out.println("connexion établie");
        patientDAO = new PatientDAO();
        patientDAO.setConnection(dbConnect);
        int choix;
        String x;
        do {
            System.out.println("----------------------------------------");
            System.out.println("1. Ajout\n2. Recherche\n3. Modifier numéro de téléphone\n4. Supprimer\n5. Afficher tous les patients\n6. RETOUR\n7. FIN");
            System.out.println("----------------------------------------");
            x = saisir("", "[1-7]");   //contrôle saisie
            choix = Integer.parseInt(x);
            boolean tmp;
            switch (choix) {
                case 1: {
                    ajout();
                    break;
                }
                case 2: {
                    recherche();
                    break;
                }
                case 3: {
                    tmp = recherche();
                    if (tmp) {
                        modif();
                    }
                    break;
                }
                case 4: {
                    tmp = recherche();
                    if (tmp) {
                        suppr();
                    }
                    break;
                }
                case 5: {
                    aff();
                    break;
                }
                case 7: {
                    System.exit(0);
                }
            }
        } while (choix != 6);
        DBConnection.closeConnection();
    }

    /**
     * méthode ajoutant un patient
     *
     * @throws SQLException patient existant
     */
    public void ajout() throws SQLException {
        System.out.println("Nom ?");
        // sc.skip("\n");
        String nom = sc.nextLine();
        System.out.println("Prénom ?");
        String prenom = sc.nextLine();
        String tel = saisir("Numéro de téléphone [0XXX/XX.XX.XX] ?", "0[1-9]{3}/[0-9]{2}\\.[0-9]{2}\\.[0-9]{2}");   //contrôle saisie
        patActuel = new Patient(0, nom, prenom, tel);   //0 comme id car c'est la DB qui charge ça
        try {
            patActuel = patientDAO.create(patActuel);    //on récup le patient de la DB donc avec l'ID
            System.out.println("\nPatient actuel:\n" + patActuel);
        } catch (SQLException e) {
            if (e.getMessage().contains("UK")) {
                System.out.println("\nErreur: patient déjà existant");
            } else {
                System.out.println("\nErreur :" + e.getMessage());
            }
        }
    }

    /**
     * méthode affichant un patient selon l'id fourni
     *
     * @return boolean true or false
     * @throws SQLException id inconnu
     */
    public boolean recherche() throws SQLException {
        try {
            System.out.println("Id du patient ?");
            int id = sc.nextInt();
            patActuel = patientDAO.read(id);
            System.out.println("\nPatient actuel:\n" + patActuel);
            return true;
        } catch (SQLException e) {
            System.out.println("\nErreur: " + e.getMessage());
            return false;
        }
    }

    /**
     * méthode modifiant le numéro de téléphone d'un patient
     *
     * @throws SQLException aucune ligne patient mise à jour
     */
    public void modif() throws SQLException {
        try {
            sc.skip("\n");//buffer
            String tel = saisir("\nNouveau numéro de téléphone [0XXX/XX.XX.XX] ?", "0[1-9]{3}/[0-9]{2}\\.[0-9]{2}\\.[0-9]{2}");//contrôle saisie
            patActuel.setTel(tel);
            patActuel = patientDAO.update(patActuel);
            System.out.println("\nPatient actuel:\n" + patActuel);
        } catch (SQLException e) {
            System.out.println("\nErreur: " + e.getMessage());
        }
    }

    /**
     * méthode de suppression d'un patient par id
     *
     * @throws SQLException erreur d'effacement
     */
    public void suppr() throws SQLException {
        try {
            patientDAO.delete(patActuel);
            System.out.println("\nPatient bien supprimé");
        } catch (SQLException e) {
            if (e.getMessage().contains("int")) {   //erreur d'intégrité
                System.out.println("Vous ne pouvez pas supprimer un patient déjà renseigné dans une prescription, veuillez d'abord supprimer sa/ses prescription(s)");
            } else {
                System.out.println("\nErreur :" + e.getMessage());
            }
        }

    }

    /**
     * méthode affichant tous les patients
     *
     * @throws SQLException pas de médicament enregistré
     */
    public void aff() throws SQLException {
        try {
            List<Patient> listePatient = ((PatientDAO) patientDAO).aff();
            System.out.println("Voici la liste:");
            for (Patient m : listePatient) {//meilleure manière pour afficher liste c'est léquivalent du foreach
                System.out.println(m + "\n");
            }
        } catch (SQLException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }

    /**
     * méthode s'occupant de la saise contrôlée
     *
     * @param msg message à afficher
     * @param expr regex à respecter
     * @return saisie contrôlée
     */
    public String saisir(String msg, String expr) {
        String saisie;
        do {
            System.out.println(msg);
            saisie = sc.nextLine();

        } while (!saisie.matches(expr));
        return saisie;
    }

    public void rech() throws SQLException {
        System.out.println("nom à chercher?");
        String nomrech = sc.nextLine();
        try {
            List<Patient> listePatient = ((PatientDAO) patientDAO).rechNom(nomrech);
            System.out.println("Voici la liste:");
            for (Patient m : listePatient) {//meilleure manière pour afficher liste c'est léquivalent du foreach
                System.out.println(m + "\n");
            }
        } catch (SQLException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }

}
