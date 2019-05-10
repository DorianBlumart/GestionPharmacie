package designPatterns.metier.builder;

import designPatterns.metier.Infos;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import designPatterns.metier.Patient;
import designPatterns.metier.Medecin;

/**
 * classe métier de gestion d'un client
 *
 * @author Michel Poriaux
 * @version 1.0
 *
 */
public class Prescription {

    protected int idpres;
    protected LocalDate dateprescription;
    protected Set<Infos> info = new HashSet<>();
    protected Patient patient;
    protected Medecin medecin;

    private Prescription(PrescriptionBuilder cb) {
        this.idpres = cb.idpres;
        this.dateprescription = cb.dateprescription;
        this.info = cb.info;
        this.patient = cb.patient;
        this.medecin = cb.medecin;
    }

    public int getIdpres() {
        return idpres;
    }

    public LocalDate getDateprescription() {
        return dateprescription;
    }

    public Set<Infos> getInfo() {
        return info;
    }

    public Patient getPatient() {
        return patient;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    @Override
    public String toString() {
        return "Prescription{" + "idpres=" + idpres + ", dateprescription=" + dateprescription + ", info=" + info + ", patient=" + patient + ", medecin=" + medecin + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.idpres;
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
        final Prescription other = (Prescription) obj;
        if (this.idpres != other.idpres) {
            return false;
        }
        return true;
    }

    public static class PrescriptionBuilder {

        protected int idpres;
        protected LocalDate dateprescription;
        protected Set<Infos> info = new HashSet<>();
        protected Patient patient;
        protected Medecin medecin;

        public PrescriptionBuilder setIdpres(int idpres) {
            this.idpres = idpres;
            return this;
        }

        public PrescriptionBuilder setDateprescription(LocalDate dateprescription) {
            this.dateprescription = dateprescription;
            return this;
        }

        public PrescriptionBuilder setInfo(Set<Infos> info) {
            this.info = info;
            return this;
        }

        public PrescriptionBuilder setPatient(Patient patient) {
            this.patient = patient;
            return this;
        }

        public PrescriptionBuilder setMedecin(Medecin medecin) {
            this.medecin = medecin;
            return this;
        }

        //méthode add info avec param info et retour this. elle va ajouter dans le set l'info
        public PrescriptionBuilder addInfo(Infos i) {
            //this.medecin = medecin;
            info.add(i);
            return this;
        }

        public Prescription build() throws Exception {
            if (idpres <= 0 || patient == null || medecin == null || info == null) {
                throw new Exception("informations de construction incomplètes");
            }
            return new Prescription(this);
        }

    }

}
