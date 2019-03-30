
package pharmacie.metier;
/**
 * classe métier de gestion d'un médecin
 * @author Blumart Dorian
 * @version 1.0
 */
public class Medecin {
    /**
     * identifiant du médecin
     */
    private int idmed;
    /**
     * matricule du médecin
     */
    private String matricule;
    /**
     * nom du médecin
     */
    private String nom;
    /**
     * prénom du médecin
     */
    private String prenom;
    /**
     * numéro de téléphone du médecin
     */
    private String tel;
    /**
     * constructeur paramétré
     * @param idmed identifiant du médecin
     * @param matricule matricule du médecin
     * @param nom nom du médecin
     * @param prenom prénom du médecin
     * @param tel numéro de téléphone du médecin
     */
    public Medecin(int idmed, String matricule, String nom, String prenom, String tel){
        this.idmed = idmed;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
    }
/**
 * getter idmed
 * @return identifiant du médecin
 */
    public int getIdmed() {
        return idmed;
    }
/**
 * setter idmed
 * @param idmed identifiant du médecin 
 */
    public void setIdmed(int idmed) {
        this.idmed = idmed;
    }
/**
 * getter matricule
 * @return matricule du médecin
 */
    public String getMatricule() {
        return matricule;
    }
/**
 * setter matricule
 * @param matricule matricule du médecin 
 */
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
/**
 * getter nom
 * @return nom du médecin
 */
    public String getNom() {
        return nom;
    }
/**
 * setter nom
 * @param nom nom du médecin 
 */
    public void setNom(String nom) {
        this.nom = nom;
    }
/**
 * getter prenom
 * @return prenom du médecin
 */
    public String getPrenom() {
        return prenom;
    }
/**
 * setter prenom
 * @param prenom prenom du medecin
 */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
/**
 * getter tel
 * @return numéro de téléphone du médecin
 */
    public String getTel() {
        return tel;
    }
/**
 * setter tel
 * @param tel numéro de téléphone du médecin 
 */
    public void setTel(String tel) {
        this.tel = tel;
    }
/**
 * méthode toString
 * @return affichage complet des informations
 */
    @Override
    public String toString() {
        return "Identifiant du médecin: " + idmed + ", matricule: " + matricule + ", nom: " + nom + ", prenom: " + prenom + ", numéro de téléphone: " + tel;
    }
    
}
