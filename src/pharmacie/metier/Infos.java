
package pharmacie.metier;
/**
 * classe métier de gestion des infos d'un médoc prescrit (quantité/unité)
 *
 * @author Blumart Dorian
 * @version 1.0
 * @see Medicament
 * @see Prescription
 * @see VUE_QTOT_UNITE_MEDOC
 */
public class Infos {
    /**
     * unité de mesure du médicament
     */
    private String unite;
    /**
     * quantité totale des prescriptions du médicament
     */
    private int quantite;
    /**
     * référence de la prescription
     */
    private int idpres;
    /**
     * référence du médicament
     */
    private int idmedoc;
    /**
     * id de l'info
     */
    private int idinfo;   
    
    /**
     * Constructeur paramétré
     * @param unite unité de mesure du médicament
     * @param quantite quantité totale des prescriptions du médicament
     * @param idpres référence de la prescription
     * @param idmedoc référence du médicament
     * @param idinfo id de l'info
     */
    public Infos(String unite, int quantite, int idpres, int idmedoc, int idinfo){
        this.unite = unite;
        this.quantite = quantite;
        this.idpres = idpres;
        this.idmedoc = idmedoc;
        this.idinfo = idinfo;  
    }
/**
 * getter unite
 * @return unité de mesure du médicament
 */
    public String getUnite() {
        return unite;
    }
/**
 * setter unite
 * @param unite unité de mesure du médicament
 */
    public void setUnite(String unite) {
        this.unite = unite;
    }
/**
 * getter quantite
 * @return quantité totale des prescriptions du médicament
 */
    public int getQuantite() {
        return quantite;
    }
/**
 * setter
 * @param quantite quantité totale des prescriptions du médicament
 */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
/**
 * getter idpres
 * @return référence de la prescription
 */
    public int getIdpres() {
        return idpres;
    }
/**
 * setter idpres
 * @param idpres référence de la prescription 
 */
    public void setIdpres(int idpres) {
        this.idpres = idpres;
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
 * getter idinfo
 * @return identifiant de l'info
 */
    public int getIdinfo() {
        return idinfo;
    }
/**setter idinfo
 * @param idinfo identifiant de l'info
 */
    public void setIdinfo(int idinfo) {
        this.idinfo = idinfo;
    }
/**
 * méthode toString
 * @return information complète
 */
    @Override
    public String toString() {
        return "Infos{" + "unite=" + unite + ", quantite=" + quantite + ", idpres=" + idpres + ", idmedoc=" + idmedoc + ", idinfo=" + idinfo + '}';
    }
    
    
    
    
}
