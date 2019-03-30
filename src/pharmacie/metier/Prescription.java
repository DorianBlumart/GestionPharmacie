package pharmacie.metier;

import java.time.LocalDate;

/**
 * classe métier de gestion d'une prescription
 *
 * @author Blumart Dorian
 * @version 1.0
 * @see Medicament
 * @see Infos
 * @see Patient
 * @see Medecin
 * @see VUE_PRESCR_MEDOC
 */
public class Prescription {

    /**
     * identifiant unique de la prescription
     */
    private int idpres;
    /**
     * date de la prescription
     */
    private LocalDate dateprescription;
    /**
     * référence du médecin
     */
    private int idmedecin;
    /**
     * référence du patient
     */
    private int idpat;

    /**
     * constructeur paramétré
     *
     * @param idpres identifiant unique de la prescription, affecté par la base
     * de données
     * @param dateprescription date de la prescription du médicament
     * @param idmedecin référence du médecin
     * @param idpat référence du patient
     */
    public Prescription(int idpres, LocalDate dateprescription, int idmedecin, int idpat) {
        this.idpres = idpres;
        this.dateprescription = dateprescription;
        this.idmedecin = idmedecin;
        this.idpat = idpat;
    }

    /**
     * getter idpres
     *
     * @return identifiant de la prescription
     */
    public int getIdpres() {
        return idpres;
    }

    /**
     * setter idpres
     *
     * @param idpres identifiant de la prescription
     */
    public void setIdpres(int idpres) {
        this.idpres = idpres;
    }
    /**
     * getter dateprescription
     *
     * @return date de la prescription
     */
    public LocalDate getDateprescription() {
        return dateprescription;
    }
    /**
     * setter dateprescription
     *
     * @param dateprescription date de la prescription
     */
    public void setDateprescription(LocalDate dateprescription) {
        this.dateprescription = dateprescription;
    }
    /**
     * getter idmedecin
     *
     * @return référence du médecin
     */
    public int getIdmedecin() {
        return idmedecin;
    }
    /**
     * setter dateprescription
     *
     * @param idmedecin référence du médecin
     */
    public void setIdmedecin(int idmedecin) {
        this.idmedecin = idmedecin;
    }
    /**
     * getter idpat
     *
     * @return référence du patient
     */
    public int getIdpat() {
        return idpat;
    }
    /**
     * setter idpat
     *
     * @param idpat référence du patient
     */
    public void setIdpat(int idpat) {
        this.idpat = idpat;
    }
    /**
     * méthode toString
     * @return information complète
     */
    @Override
    public String toString() {
        return "identifiant de la prescription: " + idpres + ", référence du médecin: " + idmedecin + ", référence du patient: " + idpat;
        //pas de dateprescription ici car on va redéfinir le format extérieurement et l'ajouter à l'affichage
    }

}
