/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacie.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import myconnections.DBConnection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pharmacie.metier.Medicament;

/**
 *
 * @author Dorian
 */
public class MedicamentDAOTest {

    static Connection dbConnect;

    public MedicamentDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {                   //va être appelé au début du test global et à la fin, on ouvre la connexion pour le test
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            System.exit(1); //on quitte 
        }
        System.out.println("Connexion établie");
    }

    @AfterClass
    public static void tearDownClass() {        //on ferme connection après tous les tests
        DBConnection.closeConnection();
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class MedicamentDAO.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        //on crée objet Medicament
        Medicament obj = new Medicament(0, "TestNom", "TestDesc", "TCode");
        //on crée accès bd
        MedicamentDAO instance = new MedicamentDAO();
        instance.setConnection(dbConnect);//inject coo dans l'instance DAO
        Medicament expResult = new Medicament(0, "TestNom", "TestDesc", "TCode");//on s att à bien avoir envoyé ça
        Medicament result = instance.create(obj);

        //on teste si tout est pareil entre l'objet créé et l'ajout dans la DB
        assertEquals("Noms différents", expResult.getNom(), result.getNom());
        assertEquals("Descriptions différentes", expResult.getDescription(), result.getDescription());
        assertEquals("Codes différents", expResult.getCodemedoc(), result.getCodemedoc());
        assertNotEquals("Id non généré", expResult.getIdmedoc(), result.getIdmedoc()); // si si c'est différent pas de message, si c'est pas différent "id non généré"
        //on va forcer création doublon pour voir si on a aura bien l'exception, même code (uk)
        obj = new Medicament(0, "TestNom2", "TestDesc2", "TCode");
        try {
            Medicament result2 = instance.create(obj);
            //si on est pas parti dans le catch on met message d'erreur et on supp le dounlon
            fail("exception de doublon uk non déclenchée");
            instance.delete(result2);//pour supp de la db
        } catch (SQLException e) {
        }
        instance.delete(result);//on supprime result première result car si on test plusieurs fois on aurait eu des souci, il aurait déjà dit doublon
        //test avec un code à + de 5 char DONC non correspondant pour voir si exception
        obj = new Medicament(0, "TestNom2", "TestDesc2", "TestCode");
        try {
            Medicament result3 = instance.create(obj);
            fail("exception de code trop long non déclenché");
            instance.delete(result3);
        } catch (SQLException e) {
        }
    }

    /**
     * Test of read method, of class MedicamentDAO.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        int idmedoc = 0;
        MedicamentDAO instance = new MedicamentDAO();
        instance.setConnection(dbConnect);  //toujours injecter connexion qd on crée instance sinon on sait pas joindre la DB
        Medicament obj = new Medicament(0, "TestNom", "TestDesc", "TCode");
        Medicament expResult = instance.create(obj);
        idmedoc = expResult.getIdmedoc();
        Medicament result = instance.read(idmedoc);
        assertEquals("Noms différents", expResult.getNom(), result.getNom());
        assertEquals("Descriptions différentes", expResult.getDescription(), result.getDescription());
        assertEquals("Codes différents", expResult.getCodemedoc(), result.getCodemedoc());
        assertEquals("Id différents", expResult.getIdmedoc(), result.getIdmedoc());
        try {
            result = instance.read(0);    //on lit numéro, qui n'existe pas donc devrait passer dans le catch si on a bien codé
            //si on cherche un id qui n'existe pas
            fail("exception d'id inconnu non générée");
        } catch (SQLException e) {
        }
        instance.delete(result);
    }

    /**
     * Test of update method, of class MedicamentDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Medicament obj = new Medicament(0, "TestNom", "TestDesc", "TCode");
        MedicamentDAO instance = new MedicamentDAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj); //crée objet
        obj.setDescription("TestDesc2"); //on change la description
        Medicament expResult = obj;
        Medicament result = instance.update(obj);   //on update
        assertEquals(expResult.getNom(), result.getNom());  //on regarde si les champs ont bien changé
        instance.delete(obj);
    }

    /**
     * Test of delete method, of class MedicamentDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Medicament obj = new Medicament(0, "TestNom", "TestDesc", "TCode");
        MedicamentDAO instance = new MedicamentDAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        instance.delete(obj);
        try {
            instance.read(obj.getIdmedoc());   //on regarde si l'objet a bien été supp car on est pas sensé récup qlqch
            fail("exception de record introuvable non générée");
        } catch (SQLException e) {
        }
        //TODO vérifier qu'on a bien une exception en cas de record parent de clé étrangère (par exemple table commande) = créer client, créer commande avec id client tester puis tout effacer
        //TODO effacer record inexistant
    }

    /**
     * Test of rechDesc method, of class MedicamentDAO.
     */
    @Test
    public void testRechDesc() throws Exception {
        //d abord avoir développé la méthode equals dans Medicament
        System.out.println("rechNom");
        //créer 2 médicaments avec même description 
        Medicament obj1 = new Medicament(0, "TestNom", "testDesc", "Code");
        Medicament obj2 = new Medicament(0, "TestNom2", "testDesc", "Code2");
        String descrech = "TEST";
        MedicamentDAO instance = new MedicamentDAO();
        instance.setConnection(dbConnect);
        obj1 = instance.create(obj1);
        obj2 = instance.create(obj2);
        List<Medicament> result = instance.rechDesc(descrech.toLowerCase());
        if (result.indexOf(obj1) < 0) {
            fail("obj1 introuvable " + obj1);    //obj1 dans la liste ? basé sur id retour -1 si existe pas
        }
        if (result.indexOf(obj2) < 0) {
            fail("obj2 introuvable" + obj2);     //obj2 dans la liste ?
        }
        //tester si mot n'est pas dans description
        descrech = "none";
        try {
            result = instance.rechDesc(descrech.toLowerCase());
            fail("exception de record introuvable non générée");
        } catch (SQLException e) {
        }
        instance.delete(obj1);
        instance.delete(obj2);

    }

    /**
     * Test of aff method, of class MedicamentDAO.
     */
    @Test
    public void testAff() throws Exception {
        Medicament obj1 = new Medicament(0, "TestNom", "testDesc", "Code");
        Medicament obj2 = new Medicament(0, "TestNom2", "testDesc", "Code2");
        MedicamentDAO instance = new MedicamentDAO();
        instance.setConnection(dbConnect);
        obj1 = instance.create(obj1);
        obj2 = instance.create(obj2);
        List<Medicament> result = instance.aff();
        if (result.indexOf(obj1) < 0) {
            fail("obj1 introuvable " + obj1);    //obj1 dans la liste ? basé sur id retour -1 si existe pas
        }
        if (result.indexOf(obj2) < 0) {
            fail("obj2 introuvable" + obj2);     //obj2 dans la liste ?
        }
        instance.delete(obj1);
        instance.delete(obj2);
        //tester affichage si rien dans liste      
        result = instance.aff();
        if (result.indexOf(obj1) >= 0) {
            fail("liste non vide");    //obj1 dans la liste ? basé sur id retour -1 si existe pas
        }
        if (result.indexOf(obj2) >= 0) {
            fail("liste non vide");     //obj2 dans la liste ?
        }
    }

}
