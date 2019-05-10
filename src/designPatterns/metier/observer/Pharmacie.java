/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns.metier.observer;

public class Pharmacie {

    public static void main(String[] args) {
        /*Produit p1 = new Produit(1, "P00001", "écran", 200, 10);
        Produit p2 = new Produit(2, "P00002", "souris", 15, 100);
        Client cl1 = new Client(1, "Durand", "Jean", 1000, "BXL","de la Senne","12A","0456/990088");
        Client cl2 = new Client(2, "Dupond", "Annie", 1000, "BXL","de labière","14","0451/441122");
        p1.addObserver(cl1);
        p1.addObserver(cl2);
        p2.addObserver(cl1);
        p1.setPhtva(210);
        p2.setPhtva(12);*/
        Medecin m1 = new Medecin(1,"A0001","Dubois","Philippe","0456/89.22.56");
        Medecin m2 = new Medecin(2,"A0002","Mingolet","Edouard","0478/19.82.43");
        Patient p1 = new Patient(1,"Syrius","Jack","0471/89.66.34");
        Patient p2 = new Patient(2,"Bolingo","Manuel","0479/34.21.09");
        m1.addObserver(p1);
        m1.addObserver(p2);
        m2.addObserver(p1);
        m1.setTel("0678/99.11.22");
        m2.setTel("0878/22.11.55");
    }
}

