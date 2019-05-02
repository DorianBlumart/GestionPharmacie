package designPatterns.metier;

import java.util.HashSet;
import java.util.Set;

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

    private Set<Prescription> prescription = new HashSet<>();

    public Patient(int idpat, String nom, String prenom, String tel) {
        this.idpat = idpat;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
    }

    public int getIdpat() {
        return idpat;
    }

    public void setIdpat(int idpat) {
        this.idpat = idpat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Set<Prescription> getPrescription() {
        return prescription;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.idpat;
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
        final Patient other = (Patient) obj;
        if (this.idpat != other.idpat) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Patient{" + "idpat=" + idpat + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + ", prescription=" + prescription + '}';
    }
    

}
