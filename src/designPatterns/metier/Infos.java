/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns.metier;

import java.util.Objects;

/**
 *
 * @author dorian.blumart
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
    private Medicament medicament;
    private Prescription prescription;
    private int idinfo;

    public Infos(String unite, int quantite, Medicament medicament, Prescription prescription, int idinfo) {
        this.unite = unite;
        this.quantite = quantite;
        this.prescription = prescription;
        this.medicament = medicament;
        this.idinfo = idinfo;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.medicament);
        hash = 83 * hash + Objects.hashCode(this.prescription);
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
        final Infos other = (Infos) obj;
        if (!Objects.equals(this.medicament, other.medicament)) {
            return false;
        }
        if (!Objects.equals(this.prescription, other.prescription)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Infos{" + "unite=" + unite + ", quantite=" + quantite + ", medicament=" + medicament + ", prescription=" + prescription + ", idinfo=" + idinfo + '}';
    }

}
