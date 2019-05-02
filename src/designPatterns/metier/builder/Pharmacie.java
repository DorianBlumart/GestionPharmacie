/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns.metier.builder;

import designPatterns.metier.Infos;
import java.time.LocalDate;
import designPatterns.metier.Medecin;
import designPatterns.metier.Medicament;
import designPatterns.metier.Patient;
import java.util.Set;

/**
 *
 * @author dorian.blumart
 */
public class Pharmacie {

    public static void main(String[] args) {

        Patient p1 = new Patient(1, "Moke", "Julie", "0473/67.89.76");                 //création du patient nécessaire à la prescription
        System.out.println(p1);
        Medecin med1 = new Medecin(1, "A0001", "Flutard", "Florian", "0471/78.99.01");     //création du médecin nécessaire à la prescription
        System.out.println(med1);
        Medicament medoc1 = new Medicament(1, "Doliprane", "Voici la description", "B0001");       //création du médicament nécessaire à l'info
        System.out.println(medoc1);
        Infos info1 = new Infos("boite", 2, medoc1, null, 1);      //création de l'infos nécessaire à la prescription 
        System.out.println(info1);
        medoc1.getInfo().add(info1);                                //on ajoute au set d'infos du médciament (dépendance)
        System.out.println(medoc1);                             //cet affichage se fait mal, mal ajouté info1 au setinfo de médoc ?
        try {
            Prescription pres1 = new Prescription.PrescriptionBuilder().
                    setDateprescription(LocalDate.of(2012, 02, 02)).
                    setIdpres(1).
                    setMedecin(med1).
                    setPatient(p1).
                    setInfo(info1);//getInfo().add(info1) ne fonctionne pas non plus
                    //il reste à ajouter l'info1 au set d'info de la prescription
                    ;
        } catch (Exception e) {
            System.out.println("erreur "+e);

        }
    }
}
