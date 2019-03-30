package pharmacie.metier;

/**
 * classe métier de gestion d'un patient
 *
 * @author Blumart Dorian
 * @version 1.0
 *
 */
public class Patient {
     /**
     * identifiant unique du patient
     */
    private int idpat;
    /**
     * nom du patient
     */
    private String nom;
    /**
     * prénom du patient
     */
    private String prenom;
    /**
     * numéro de téléphone du patient
     */
    private String tel;
   
    /**
     * constructeur paramétré, pas besoin unite et quantite ici
     *
     * @param idpat identifiant unique du patient, affecté par la base de données
     * @param nom nom du patient
     * @param prenom prenom du patient
     * @param tel numéro de téléphone du patient
     */
    public Patient(int idpat, String nom, String prenom, String tel) {
        this.idpat = idpat;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
    }
    /**
     * getter idpat
     *
     * @return identifiant du patient
     */
    public int getIdpat() {
        return idpat;
    }
    /**
     * setter idpat
     *
     * @param identifiant du patient
     */
    public void setIdpat(int idpat) {
        this.idpat = idpat;
    }
    /**
     * getter nom
     *
     * @return nom du médicament
     */
    public String getNom() {
        return nom;
    }
    /**
     * setter nom
     *
     * @param nom du médicament
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * getter prenom
     * @return prenom
     */
    public String getPrenom() {
        return prenom;
    }
    /**
     * setter prenom
     * @param prenom 
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    /**
     * getter tel
     * @return tel
     */
    public String getTel() {
        return tel;
    }
    /**
     * setter tel
     * @param tel 
     */
    public void setTel(String tel) {
        this.tel = tel;
    }
    /**
     * méthode toString
     *
     * @return informations complètes
     */
    @Override
    public String toString() {
        return "Identifiant du patient: " + idpat + ", nom: " + nom + ", prénom: " + prenom + ", numéro de téléphone: " + tel;
    }
    
    
}
