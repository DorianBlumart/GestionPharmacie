
package pharmacie.metier;
/**
 * classe métier de gestion de la vue pour l'affichage complet des quantités totales prescrites d'un médicament (par unité)
 *
 * @author Blumart Dorian
 * @version 1.0
 * @see Medicament
 */
public class VUE_QTOT_UNITE_MEDOC {
    /**
     * identifiant du médicament
     */
    private int idmedoc;
    /**
     * nom du médicament
     */
    private String nom;
    /**
     * unité de mesure correspondant à la quantité prescrite du médicament
     */
    private String unite;
    /**
     * quantité totales prescrite du médicament
     */
    private int qtot;
    
    /**
     * Constrcuteur paramétré
     * @param idmedoc identifiant du médicament
     * @param nom nom du médicament
     * @param unite unité de mesure correspondant à la quantité prescrite du médicament
     * @param qtot quantité totale prescrite
     */
    public VUE_QTOT_UNITE_MEDOC(int idmedoc, String nom, String unite, int qtot){
        this.idmedoc = idmedoc;
        this.nom = nom;
        this.unite = unite;
        this.qtot = qtot;
    }
/**
 * getter idmedoc
 * @return identifiant du médicament
 */
    public int getIdmedoc() {
        return idmedoc;
    }
/**
 * setter idmedoc
 * @param idmedoc identifiant du médicament 
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
 * getter unite
 * @return unité de mesure correspondant à la quantité totale prescrite du médicament
 */
    public String getUnite() {
        return unite;
    }
/**
 * setter unite
 * @param unite unité de mesure correspondant à la quantité totale prescrite du médicament
 */
    public void setUnite(String unite) {
        this.unite = unite;
    }
/**
 * getter qtot
 * @return quantité totale prescrite du médicament
 */
    public int getQtot() {
        return qtot;
    }
/**
 * setter qtot
 * @param qtot quantité totale prescrite du médicament
 */
    public void setQtot(int qtot) {
        this.qtot = qtot;
    }
/**
 * méthode toString
 * @return information complète
 */
    @Override
    public String toString() {
        return "Identifiant du médicament: " + idmedoc + ", nom: " + nom + "\n"+ qtot + " " + unite;
    }
    
    
}
