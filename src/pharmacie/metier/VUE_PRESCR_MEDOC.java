package pharmacie.metier;

import java.time.LocalDate;

/**
 * classe métier de gestion de la vue pour l'affichage complet d'une prescription
 *
 * @author Blumart Dorian
 * @version 1.0
 * @see Prescription
 */
public class VUE_PRESCR_MEDOC {

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
     * référence du médicament
     */
    private int idmedoc;
    /**
     * nom du médicament concerné par la prescription
     */
    private String nom;
    /**
     * description du médicament concerbé par la prescrption
     */
    private String description;
    /**
     * code du médicament concerné par la prescription
     */
    private String codemedoc;
       /**
     * constructeur paramétré
     *
     * @param idpres identifiant unique de la prescription, affecté par la base
     * de données
     * @param dateprescription date de la prescription du médicament
     * @param idmedecin référence du médecin
     * @param idpat référence du patient
     * @param idmedoc référence du médicament
     * @param nom nom du médicament
     * @param description description du médicament
     * @param codemedoc code du médicament
     */
    public VUE_PRESCR_MEDOC(int idpres, LocalDate dateprescription, int idmedecin, int idpat, int idmedoc, String nom, String description, String codemedoc) {
        this.idpres = idpres;
        this.dateprescription = dateprescription;
        this.idmedecin = idmedecin;
        this.idpat = idpat;
        this.idmedoc = idmedoc;
        this.nom = nom;
        this.description = description;
        this.codemedoc = codemedoc;
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
 * getter idmedoc
 * @return référence du médicament
 */
    public int getIdmedoc() {
        return idmedoc;
    }
/**
 * setter idmedoc
 * @param idmedoc référence du médicament 
 */
    public void setIdmedoc(int idmedoc) {
        this.idmedoc = idmedoc;
    }
/**
 * getter nom
 * @return nom du médicament
 */
    public String getNom() {
        return nom;
    }
/**
 * setter nom
 * @param nom nom du médicament
 */
    public void setNom(String nom) {
        this.nom = nom;
    }
/**
 * getter description
 * @return description du médicament
 */
    public String getDescription() {
        return description;
    }
/**
 * setter
 * @param description description du médicament
 */
    public void setDescription(String description) {
        this.description = description;
    }
/**
 * getter codemedoc
 * @return code du médicament
 */
    public String getCodemedoc() {
        return codemedoc;
    }
/**
 * setter codemedoc
 * @param codemedoc code du médicament
 */
    public void setCodemedoc(String codemedoc) {
        this.codemedoc = codemedoc;
    }
/**
 * méthode toString
 * @return information complète sauf la date qui doit subir un traitement préalable
 */
    @Override
    public String toString() {
        return "identifiant de la prescription: " + idpres + ", référence du médecin: " + idmedecin + ", référence du patient: " + idpat + ", référence du médicament: " + idmedoc + ", nom: " + nom + ", description: " + description + ", code: " + codemedoc;
    }
    
    
}
