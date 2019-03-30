/**
 * Classe de gestion pharmacie
 *
 * @author Blumart Dorian
 * @version 1.0
 * @see GestionMedicament
 * @see GestionPatient
 * @see GestionPrescription
 * @see GestionMedecin
 */
package pharmacie;

import java.sql.SQLException;
import java.util.Scanner;

public class Pharmacie {
    Scanner sc = new Scanner(System.in);

    public void menu() throws SQLException {
        int choix;
        String x;
        do {
            System.out.println("----------------------------------------");
            System.out.println("1. Médicaments\n2. Patients\n3. Médecins\n4. Prescriptions\n5. FIN");
            System.out.println("----------------------------------------");
            x = saisir("", "[1-5]");   //contrôle saisie
            choix = Integer.parseInt(x);
            switch (choix) {
                case 1: {
                    GestionMedicament g = new GestionMedicament();
                    System.out.println("Connexion à la base de données...");
                    g.menu();
                    break;
                }
                case 2: {
                   GestionPatient g2 = new GestionPatient();
                    System.out.println("Connexion à la base de données...");
                    g2.menu();
                    break;
                }
                case 3: {
                    GestionMedecin g3 = new GestionMedecin();
                    System.out.println("Connexion à la base de données...");
                    g3.menu();
                    break;
                }
                case 4: {
                    GestionPrescription g4 = new GestionPrescription();
                    System.out.println("Connexion à la base de données...");
                    g4.menu();
                    break;
                            
                }
                case 5: {
                    System.exit(0);
                }
            }
        } while (choix != 5);
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

    public static void main(String[] args) throws SQLException {
        Pharmacie a = new Pharmacie();
        a.menu();
    }
}
