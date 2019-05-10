/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns.metier.observer;

import designPatterns.metier.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Medecin extends Subject{

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

    private Set<Prescription> prescription = new HashSet<>();

    public Medecin(int idmed, String matricule, String nom, String prenom, String tel) {
        this.idmed = idmed;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
    }

    public int getIdmed() {
        return idmed;
    }

    public void setIdmed(int idmed) {
        this.idmed = idmed;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
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
        notifyObservers();
    }

    public Set<Prescription> getPrescription() {
        return prescription;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.matricule);
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
        final Medecin other = (Medecin) obj;
        if (!Objects.equals(this.matricule, other.matricule)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Medecin{" + "idmed=" + idmed + ", matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + ", prescription=" + prescription + '}';
    }

    @Override
    public String getNotification() {
        return "nouveau numéro de téléphone de "+nom+" = "+tel;
    }
    

}
