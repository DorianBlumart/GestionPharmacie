/**
 * Classe de gestion medicament
 *
 * @author Blumart Dorian
 * @version 1.0
 * @see Medicament
 * @see MedicamentDAO
 */
package pharmacie;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import myconnections.DBConnection;
import pharmacie.DAO.DAO;
import pharmacie.DAO.MedicamentDAO;
import pharmacie.metier.Medicament;
import pharmacie.DAO.InfosDAO;
import pharmacie.metier.Infos;
import pharmacie.DAO.VUE_QTOT_UNITE_MEDOCDAO;
import pharmacie.metier.VUE_QTOT_UNITE_MEDOC;

public class GestionMedicament {

    /**
     * Scanner
     */
    Scanner sc = new Scanner(System.in);
    /**
     * dernier médicament sur lequel on a travaillé
     */
    Medicament medocActuel = null;
    /**
     * accès DAO pour les médicaments
     */
    DAO<Medicament> medicamentDAO = null;
    /**
     * dernière info sur laquelle on a travaillé
     */
    Infos infoActuel = null;
    /**
     * accès DAO pour les infos
     */
    DAO<Infos> infosDAO = null;
    /**
     * dernière info sur laquelle on a travaillé
     */
    VUE_QTOT_UNITE_MEDOCDAO vueActuel = null;
    /**
     * accès DAO pour les infos
     */
    DAO<VUE_QTOT_UNITE_MEDOC> vueDAO = null;

    public GestionMedicament() {
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

        medicamentDAO = new MedicamentDAO();
        medicamentDAO.setConnection(dbConnect);
        infosDAO = new InfosDAO();
        infosDAO.setConnection(dbConnect);
        vueDAO = new VUE_QTOT_UNITE_MEDOCDAO();
        vueDAO.setConnection(dbConnect);

        int choix;
        String x;
        boolean tmp;
        do {
            System.out.println("----------------------------------------");
            System.out.println("1. Ajout\n2. Recherche\n3. Modifier description\n4. Supprimer\n5. Chercher description\n6. Afficher tous les médicaments\n7. Afficher les quantités écoulées d'un médicament (Par unité)\n8. RETOUR\n9. FIN");
            System.out.println("----------------------------------------");
            x = saisir("", "[1-9]");   //contrôle saisie
            choix = Integer.parseInt(x);
            switch (choix) {
                case 1: {
                    ajout();
                    break;
                }
                case 2: {
                    rechercheExacte();
                    break;
                }
                case 3: {
                    tmp = rechercheExacte();
                    if (tmp) {
                        modif();
                    }
                    break;
                }
                case 4: {
                    tmp = rechercheExacte();
                    if (tmp) {
                        suppr();
                    }
                    break;
                }
                case 5: {
                    recherchePartielle();
                    break;
                }
                case 6: {
                    affMedoc();
                    break;
                }
                case 7: {
                    affUnite();
                    break;
                }
                case 9: {
                    System.exit(0);
                }
            }
        } while (choix != 8);
        DBConnection.closeConnection();
    }

    /**
     * méthode d'ajout d'un médicament
     *
     * @throws SQLException code existant
     */
    public void ajout() throws SQLException {
        System.out.println("Code [5 caractères max] ?");
        String code = sc.nextLine();
        System.out.println("Nom ?");
        String nom = sc.nextLine();
        System.out.println("Description ?");
        String desc = sc.nextLine();
        desc = desc.toLowerCase();
        medocActuel = new Medicament(0, nom, desc, code);   //0 comme id car c'est la DB qui charge ça
        try {
            medocActuel = medicamentDAO.create(medocActuel);    //on récup le medoc de la DB donc avec l'ID
            System.out.println("\nMédicament actuel:\n" + medocActuel);
        } catch (SQLException e) {
            if (e.getMessage().contains("UK")) {
                System.out.println("\nErreur: médicament déjà existant");
            } else {
                if (e.getMessage().contains("grand")) { //si on dépasse la taille du varchar 
                    System.out.println("\nErreur: le code du médicament doit être composé de maximum 5 caractères");
                }
                else
                    System.out.println("\nErreur :" + e.getMessage());
            }
        }
    }

    /**
     * méthode de recherche d'un médicament sur l'id
     *
     * @return boolean true or false
     * @throws SQLException id inconnu
     */
    public boolean rechercheExacte() throws SQLException {
        try {
            System.out.println("Id du médoc ?");
            int id = sc.nextInt();
            medocActuel = medicamentDAO.read(id);
            System.out.println("\nMédicament actuel:\n" + medocActuel);
            return true;
        } catch (SQLException e) {
            System.out.println("\nErreur: " + e.getMessage());
            return false;
        }
    }

    /**
     * Méthode de modification de la description d'un médicament
     *
     * @throws SQLException aucune ligne médicament mise à jour
     */
    public void modif() throws SQLException {
        try {
            System.out.println("\nDescription: ");
            sc.nextLine();
            String desc = sc.nextLine();
            desc = desc.toLowerCase();
            medocActuel.setDescription(desc);
            medocActuel = medicamentDAO.update(medocActuel);
            System.out.println("\nMédicament actuel:\n" + medocActuel);
        } catch (SQLException e) {
            System.out.println("\nErreur: " + e.getMessage());
        }
    }

    /**
     * Méthode de recherche par mot-clé sur la description
     *
     * @throws SQLException description inconnue
     */
    public void recherchePartielle() throws SQLException {
        System.out.println("Mot-clé dans la description recherché : ");
        String desc = sc.nextLine();
        desc = desc.toLowerCase();
        try {
            List<Medicament> listeMedoc = ((MedicamentDAO) medicamentDAO).rechDesc(desc);
            System.out.println("\nVoici la liste:");
            for (Medicament m : listeMedoc) {//meilleure manière pour afficher liste c'est léquivalent du foreach
                System.out.println(m+ "\n");
            }
        } catch (SQLException e) {
            System.out.println("\nErreur: " + e.getMessage());
        }
    }

    /**
     * méthode de suppression d'un médicament par id
     *
     * @throws SQLException erreur d'effacement
     */
    public void suppr() throws SQLException {
        try {
            medicamentDAO.delete(medocActuel);
            System.out.println("\nMédicament bien supprimé");
        } catch (SQLException e) {
            if (e.getMessage().contains("int")) {   //erreur d'intégrité
                ((InfosDAO) (infosDAO)).deleteForMedoc(medocActuel);
                medicamentDAO.delete(medocActuel);
                System.out.println("\nMédicament bien supprimé");
            } else {
                System.out.println("\nErreur :" + e.getMessage());
            }
        }

    }

    /**
     * méthode affichant tous les médicaments
     *
     * @throws SQLException pas de médicament enregistré
     */
    public void affMedoc() throws SQLException {
        try {
            List<Medicament> listeMedoc = ((MedicamentDAO) medicamentDAO).aff();
            System.out.println("Voici la liste:");
            for (Medicament m : listeMedoc) {//meilleure manière pour afficher liste c'est léquivalent du foreach
                System.out.println(m+ "\n");
            }
        } catch (SQLException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }

    /**
     * méthode affichant les médicaments prescrits par unité via l'id
     *
     * @throws SQLException id inconnu
     */
    public void affUnite() throws SQLException {
        try {
            System.out.println("Id du médiament ?");
            int idmedoc = sc.nextInt();
            List<VUE_QTOT_UNITE_MEDOC> listeMedoc = ((VUE_QTOT_UNITE_MEDOCDAO) vueDAO).aff(idmedoc);
            System.out.println("\nVoici la liste:");
            for (VUE_QTOT_UNITE_MEDOC m : listeMedoc) {//meilleure manière pour afficher liste c'est léquivalent du foreach
                System.out.println(m+ "\n");
            }
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
}
