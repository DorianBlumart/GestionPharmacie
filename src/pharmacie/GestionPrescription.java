/**
 * Classe de gestion prescription
 *
 * @author Blumart Dorian
 * @version 1.0
 * @see Prescription
 * @see PrescriptionDAO
 */
package pharmacie;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import myconnections.DBConnection;
import pharmacie.DAO.DAO;
import pharmacie.DAO.PrescriptionDAO;
import pharmacie.metier.Prescription;
import pharmacie.DAO.InfosDAO;
import pharmacie.metier.Infos;
import pharmacie.DAO.VUE_PRESCR_MEDOCDAO;
import pharmacie.metier.VUE_PRESCR_MEDOC;

public class GestionPrescription {

    /**
     * Scanner
     */
    Scanner sc = new Scanner(System.in);
    /**
     * dernière prescription sur laquelle on a travaillé
     */
    Prescription prescrActuel = null;
    /**
     * dernière prescription sur laquelle on a travaillé
     */
    DAO<Prescription> prescriptionDAO = null;
    /**
     * dernière info sur laquelle on a travaillé
     */
    Infos infosActuel = null;
    /**
     * accès DAO pour les infos
     */
    DAO<Infos> infosDAO = null;
    /**
     * dernière vue sur laquelle on a travaillé
     */
    VUE_PRESCR_MEDOC vueActuel = null;
    /**
     * accès DAO pour la vue
     */
    DAO<VUE_PRESCR_MEDOC> vueDAO = null;

    /**
     * constructeur par défaut
     */
    public GestionPrescription() {
    }

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
        prescriptionDAO = new PrescriptionDAO();
        prescriptionDAO.setConnection(dbConnect);
        infosDAO = new InfosDAO();
        infosDAO.setConnection(dbConnect);
        vueDAO = new VUE_PRESCR_MEDOCDAO();
        vueDAO.setConnection(dbConnect);
        int choix;
        String x;
        do {
            cherchPat();
            System.out.println("----------------------------------------");
            System.out.println("1. Ajouter une prescription\n2. Rechercher une prescription\n3. Modifier date de prescription\n4. Supprimer une prescription\n5. Afficher toutes les prescriptions\n6. RETOUR\n7. FIN");
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
                    recherche();    //recherche sur la vue
                    break;
                }
                case 3: {
                    tmp = recherche2();  //recherche sur la table prescription
                    if (tmp) {
                        modif();
                    }
                    break;
                }
                case 4: {
                    tmp = recherche2();
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
     * méthode ajoutant une prescription et une info correspondant
     *
     * @throws SQLException patient existant
     */
    public void ajout() throws SQLException {
        //pour la prescription
        LocalDate datepresc = saisieDate();
        System.out.println("Référence du médecin ?");
        int idmed = sc.nextInt();
        System.out.println("Référence du patient ?");
        int idpat = sc.nextInt();
        prescrActuel = new Prescription(0, datepresc, idmed, idpat);   //0 comme id car c'est la DB qui charge ça
        //pour l'info correspondant
        System.out.println("Référence du médicament ?");
        int idmedoc = sc.nextInt();
        sc.skip("\n");
        System.out.println("Unité de mesure ?");
        String unite = sc.nextLine();
        System.out.println("Quantité ?");
        int quantite = sc.nextInt();
        boolean integrityPresc = true;    //pour tester si l'erreur d'intégrité vient d'info ou prescription et agir conséquence
        try {
            prescrActuel = prescriptionDAO.create(prescrActuel);    //on récup la prescription de la DB donc avec l'ID
            integrityPresc = false;
            infosActuel = new Infos(unite, quantite, prescrActuel.getIdpres(), idmedoc, 0);
            infosActuel = infosDAO.create(infosActuel);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E d MMMM yyyy", Locale.FRENCH);
            String date = prescrActuel.getDateprescription().format(dtf);
            System.out.println("\nPrescription actuelle:\n" + prescrActuel + "\nDate: " + date);
        } catch (SQLException e) {
            if (e.getMessage().contains("int") && !integrityPresc) {   //intégrité, alors on supprime la prescription car il y a une erreur au niveau de la création infos (mauvais médicament entré par exemple)
                prescriptionDAO.delete(prescrActuel);
            }
            System.out.println("\nErreur: informations incorrectes, veuillez vérifier et réessayer");
        }

    }

    /**
     * méthode affichant une prescription via la vue selon l'id fourni
     *
     * @return boolean true or false
     * @throws SQLException id inconnu
     */
    public boolean recherche() throws SQLException {
        try {
            System.out.println("Id de la prescription ?");
            int id = sc.nextInt();
            vueActuel = vueDAO.read(id);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E d MMMM yyyy", Locale.FRENCH);
            String date = vueActuel.getDateprescription().format(dtf);
            System.out.println("\nPrescription actuelle:\n" + vueActuel + "\nDate: " + date);
            return true;
        } catch (SQLException e) {
            System.out.println("\nErreur: " + e.getMessage());
            return false;
        }
    }

    public void cherchPat() throws SQLException {
            System.out.println("Id du pat ?");
            int id = sc.nextInt();
        try {
            List<VUE_PRESCR_MEDOC> listePres = ((VUE_PRESCR_MEDOCDAO) vueDAO).rechPat(id);
            System.out.println("\nVoici la liste:");
            for (VUE_PRESCR_MEDOC l : listePres) {//meilleure manière pour afficher liste c'est léquivalent du foreach
                System.out.println(l + "\n");
            }
        } catch (SQLException e) {
            System.out.println("\nErreur: " + e.getMessage());
        }
    }

    /**
     * méthode affichant une prescription via la table selon l'id fourni
     *
     * @return boolean true or false
     * @throws SQLException id inconnu
     */
    public boolean recherche2() throws SQLException {
        try {
            System.out.println("Id de la prescription ?");
            int id = sc.nextInt();
            prescrActuel = prescriptionDAO.read(id);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E d MMMM yyyy", Locale.FRENCH);
            String date = prescrActuel.getDateprescription().format(dtf);
            System.out.println("\nPrescription actuelle:\n" + prescrActuel + "\nDate: " + date);
            return true;
        } catch (SQLException e) {
            System.out.println("\nErreur: " + e.getMessage());
            return false;
        }
    }

//pour le delete on va supp dans info quand même prescription puis dans prescription
    /**
     * méthode de suppression d'une prescription par id
     *
     * @throws SQLException erreur d'effacement
     */
    public void suppr() throws SQLException {
        try {
            ((InfosDAO) (infosDAO)).deleteForPrescr(prescrActuel);
            prescriptionDAO.delete(prescrActuel);
            System.out.println("\nPrescription bien supprimée");
        } catch (SQLException e) {
            System.out.println("\nErreur :" + e.getMessage());
        }

    }

    /**
     * méthode affichant toutes les prescriptions via la vue
     *
     * @throws SQLException pas de prescription enregistrée
     */
    public void aff() throws SQLException {
        try {
            List<VUE_PRESCR_MEDOC> listeMedoc = ((VUE_PRESCR_MEDOCDAO) vueDAO).aff();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E d MMMM yyyy", Locale.FRENCH);
            String date;
            System.out.println("Voici la liste:");
            for (VUE_PRESCR_MEDOC m : listeMedoc) {//meilleure manière pour afficher liste c'est léquivalent du foreach
                date = m.getDateprescription().format(dtf);
                System.out.println(m + "\nDate: " + date + "\n");
            }
        } catch (SQLException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }

    /**
     * méthode modifiant la date d'une prescription
     *
     * @throws SQLException aucune ligne prescription mise à jour
     */
    public void modif() throws SQLException {
        try {
            sc.skip("\n");
            System.out.println("\n");
            LocalDate datepresc = saisieDate();
            prescrActuel.setDateprescription(datepresc);
            prescrActuel = prescriptionDAO.update(prescrActuel);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E d MMMM yyyy", Locale.FRENCH);
            String date = prescrActuel.getDateprescription().format(dtf);
            System.out.println("\nPrescription actuelle: " + prescrActuel + "\nDate: " + date);
        } catch (SQLException e) {
            System.out.println("\nErreur: " + e.getMessage());
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

    /**
     * méthode s'occupant de la saise de la date
     *
     * @return date
     */
    public LocalDate saisieDate() {
        int j = Integer.parseInt(saisir("Date:\nJour(jj) ?", "[0-3][0-9]"));
        int m = Integer.parseInt(saisir("Mois(mm) ?", "[0-1][0-9]"));
        int a = Integer.parseInt(saisir("Année(yyyy) ?", "[2][0-1][0-2][0-9]"));
        LocalDate dt = LocalDate.of(a, m, j);
        return dt;
    }
}
