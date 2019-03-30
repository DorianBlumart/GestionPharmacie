package pharmacie.metier;

/**
 * classe métier de gestion d'un médicament
 *
 * @author Blumart Dorian
 * @version 1.0
 * @see VUE_QTOT_UNITE_MEDOC
 */
public class Medicament {

    /**
     * identifiant unique du médicament
     */
    private int idmedoc;
    /**
     * Nom du médicament
     */
    private String nom;
    /**
     * Description du médicament
     */
    private String description;
    /**
     * Code du médicament
     */
    private String codemedoc;

    /**
     * constructeur paramétré, pas besoin unite et quantite ici
     *
     * @param idmedoc identifiant unique du médicament, affecté par la base de
     * données
     * @param nom nom du médicament
     * @param description description du médicament
     * @param codemedoc code unique du médicament
     */
    public Medicament(int idmedoc, String nom, String description, String codemedoc) {
        this.idmedoc = idmedoc;
        this.nom = nom;
        this.description = description;
        this.codemedoc = codemedoc;
    }
    /**
     * getter idmedoc
     *
     * @return identifiant du médicament
     */
    public int getIdmedoc() {
        return idmedoc;
    }

    /**
     * setter idmedoc
     *
     * @param idmedoc identifiant du médicament
     */
    public void setIdmedoc(int idmedoc) {
        this.idmedoc = idmedoc;
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
     * setter idclient
     *
     * @param nom nom du médicament
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * getter description
     *
     * @return descrption du médicament
     */
    public String getDescription() {
        return description;
    }

    /**
     * setter idclient
     *
     * @param description description du médicament
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * getter codemedoc
     *
     * @return code du médicament
     */
    public String getCodemedoc() {
        return codemedoc;
    }

    /**
     * setter codemedoc
     *
     * @param codemedoc code du médicament
     */
    public void setCodemedoc(String codemedoc) {
        this.codemedoc = codemedoc;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.idmedoc;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Medicament other = (Medicament) obj;
        if (this.idmedoc != other.idmedoc) {
            return false;
        }
        return true;
    }
 
    
    
    /**
     * méthode toString
     *
     * @return informations complètes
     */
    @Override
    public String toString() {
        return "Identifiant du médicament: " + idmedoc + ", nom: " + nom + ", description: " + description + ", code: " + codemedoc;
    }

}
