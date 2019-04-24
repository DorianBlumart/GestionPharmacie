
package designPatterns.metier;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import pharmacie.metier.Infos;

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
    private Set<Infos> info=new HashSet<>();

    public int getIdmedoc() {
        return idmedoc;
    }

    public void setIdmedoc(int idmedoc) {
        this.idmedoc = idmedoc;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCodemedoc() {
        return codemedoc;
    }

    public void setCodemedoc(String codemedoc) {
        this.codemedoc = codemedoc;
    }

    public Set<Infos> getInfo() {
        return info;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.codemedoc);
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
        if (!Objects.equals(this.codemedoc, other.codemedoc)) {
            return false;
        }
        return true;
    }
    
}
