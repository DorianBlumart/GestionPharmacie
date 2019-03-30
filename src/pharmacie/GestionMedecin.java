/**
 * Classe de gestion médecin
 *
 * @author Blumart Dorian
 * @version 1.0
 * @see Médecin
 * @see MédecinDAO
 */
package pharmacie;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import pharmacie.DAO.MedecinDAO;
import pharmacie.DAO.DAO;
import pharmacie.metier.Medecin;
import myconnections.DBConnection;

public class GestionMedecin {

    /**
     * Scanner
     */
    Scanner sc = new Scanner(System.in);
    /**
     * dernier médecin sur lequel on a travaillé
     */
    Medecin medActuel = null;
    /**
     * accès DAO pour les médecins
     */
    DAO<Medecin> medecinDAO = null;

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
        medecinDAO = new MedecinDAO();
        medecinDAO.setConnection(dbConnect);
        int choix;
        String x;
        do {
            System.out.println("----------------------------------------");
            System.out.println("1. Ajout\n2. Recherche\n3. Modifier numéro de téléphone\n4. Supprimer\n5. Afficher tous les médecins\n6. RETOUR\n7. FIN");
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
     * méthode ajoutant un médecin
     *
     * @throws SQLException médecin existant
     */
    public void ajout() throws SQLException {
        System.out.println("Matricule ?");
        String matricule = sc.nextLine();
        System.out.println("Nom ?");
        String nom = sc.nextLine();
        System.out.println("Prénom ?");
        String prenom = sc.nextLine();
        String tel = saisir("Numéro de téléphone [0XXX/XX.XX.XX] ?", "0[1-9]{3}/[0-9]{2}\\.[0-9]{2}\\.[0-9]{2}");   //contrôle saisie
        medActuel = new Medecin(0, matricule, nom, prenom, tel);   //0 comme id car c'est la DB qui charge ça
        try {
            medActuel = medecinDAO.create(medActuel);    //on récup le patient de la DB donc avec l'ID
            System.out.println("\nMédecin actuel:\n" + medActuel);
        } catch (SQLException e) {
            if (e.getMessage().contains("UK")) {
                System.out.println("\nErreur: médecin déjà existant");
            } else {
                if (e.getMessage().contains("grand")) { //si on dépasse la taille du varchar 
                    System.out.println("\nErreur: le matricule du médecin doit être composé de maximum 5 caractères");
                } else {
                    System.out.println("\nErreur :" + e.getMessage());
                }
            }
        }
    }

    /**
     * méthode affichant un médecin selon l'id fourni
     *
     * @return boolean true or false
     * @throws SQLException id inconnu
     */
    public boolean recherche() throws SQLException {
        try {
            System.out.println("Id du médecin ?");
            int id = sc.nextInt();
            medActuel = medecinDAO.read(id);
            System.out.println("\nMedecin actuel:\n" + medActuel);
            return true;
        } catch (SQLException e) {
            System.out.println("\nErreur: " + e.getMessage());
            return false;
        }
    }

    /**
     * méthode modifiant le numéro de téléphone d'un médecin
     *
     * @throws SQLException aucune ligne médecin mise à jour
     */
    public void modif() throws SQLException {
        try {
            sc.skip("\n");//buffer
            String tel = saisir("Numéro de téléphone [0XXX/XX.XX.XX] ?", "0[1-9]{3}/[0-9]{2}\\.[0-9]{2}\\.[0-9]{2}");//contrôle saisie
            medActuel.setTel(tel);
            medActuel = medecinDAO.update(medActuel);
            System.out.println("\nMédecin actuel:\n" + medActuel);
        } catch (SQLException e) {
            System.out.println("\nErreur: " + e.getMessage());
        }
    }

    /**
     * méthode de suppression d'un médecin par id
     *
     * @throws SQLException erreur d'effacement
     */
    public void suppr() throws SQLException {
        try {
            medecinDAO.delete(medActuel);
            System.out.println("\nMédecin bien supprimé");
        } catch (SQLException e) {
            if (e.getMessage().contains("int")) {   //erreur d'intégrité
                System.out.println("Vous ne pouvez pas supprimer un médecin déjà renseigné dans une prescription, veuillez d'abord supprimer sa/ses prescription(s)");
            } else {
                System.out.println("\nErreur :" + e.getMessage());
            }
        }

    }

    /**
     * méthode affichant tous les médecins
     *
     * @throws SQLException pas de médecin enregistré
     */
    public void aff() throws SQLException {
        try {
            List<Medecin> listeMedecin = ((MedecinDAO) medecinDAO).aff();
            System.out.println("Voici la liste:");
            for (Medecin m : listeMedecin) {//meilleure manière pour afficher liste c'est léquivalent du foreach
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
}
