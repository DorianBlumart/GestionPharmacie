/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacie.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import myconnections.DBConnection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pharmacie.metier.Medecin;
import pharmacie.metier.Medicament;
import pharmacie.metier.Patient;
import pharmacie.metier.Prescription;
import pharmacie.metier.VUE_PRESCR_MEDOC;

/**
 *
 * @author Dorian
 */
public class VUE_PRESCR_MEDOCDAOTest {

    static Connection dbConnect;

    public VUE_PRESCR_MEDOCDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            System.exit(1); //on quitte 
        }
        System.out.println("Connexion établie");
    }

    @AfterClass
    public static void tearDownClass() {
        DBConnection.closeConnection();
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of read method, of class VUE_PRESCR_MEDOCDAO.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        int idpres = 0;
        //création du médecin
        Medecin med = new Medecin(0, "testM", "TestNom", "TestPrenom", "0XXX/XX.XX.XX");
        MedecinDAO medInstance = new MedecinDAO();
        medInstance.setConnection(dbConnect);
        med = medInstance.create(med);
        //création du patient
        Patient pat = new Patient(0, "TestNom", "testPrenom", "0XXX/XX.XX.XX");
        PatientDAO patInstance = new PatientDAO();
        patInstance.setConnection(dbConnect);
        pat = patInstance.create(pat);
        //création du médoc 
        Medicament obj = new Medicament(0, "TestNom", "TestDesc", "TCode");
        MedicamentDAO medocInstance = new MedicamentDAO();
        medocInstance.setConnection(dbConnect);
        obj = medocInstance.create(obj);
        //création de la prescription
        int a = 2009;
        int m = 9;
        int j = 9;
        LocalDate dt = LocalDate.of(a, m, j);
        Prescription pres = new Prescription(0, dt, med.getIdmed(), pat.getIdpat());  //prescription via le patient créé et le médecin créé
        PrescriptionDAO presInstance = new PrescriptionDAO();
        presInstance.setConnection(dbConnect);
        pres = presInstance.create(pres);
        //test de read sur la vue associée aux objets
        VUE_PRESCR_MEDOCDAO vueInstance = new VUE_PRESCR_MEDOCDAO();
        vueInstance.setConnection(dbConnect);
        VUE_PRESCR_MEDOC expResult = new VUE_PRESCR_MEDOC(pres.getIdpres(), pres.getDateprescription(), pres.getIdmedecin(), pres.getIdpat(), obj.getIdmedoc(), obj.getNom(), obj.getDescription(), obj.getCodemedoc());
        System.out.println("expResult: " + expResult);
        idpres = expResult.getIdpres();
        System.out.println("id pres: "+idpres);
        try {
            VUE_PRESCR_MEDOC result = vueInstance.read(idpres); ///////////////le read ne se fait pas//////////////////
            System.out.println("result: " + result);

            medocInstance.delete(obj);
            presInstance.delete(pres);
            patInstance.delete(pat);
            medInstance.delete(med);
        } catch (SQLException e) {
            medocInstance.delete(obj);
            presInstance.delete(pres);
            patInstance.delete(pat);
            medInstance.delete(med);
            fail("on a pas su read");
        }       
        /***************************** Ne fonctionne pas*******************************************************************/
        
        
    }

    /**
     * Test of aff method, of class VUE_PRESCR_MEDOCDAO.
     */
    //@Test
    public void testAff() throws Exception {
        System.out.println("aff");
        VUE_PRESCR_MEDOCDAO instance = new VUE_PRESCR_MEDOCDAO();
        List<VUE_PRESCR_MEDOC> expResult = null;
        List<VUE_PRESCR_MEDOC> result = instance.aff();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * ********************************************************************************************************
     */
    
    
    
    
    /**
     * Test of create method, of class VUE_PRESCR_MEDOCDAO.
     */
    //@Test
    public void testCreate() throws Exception {
        System.out.println("create");
        VUE_PRESCR_MEDOC obj = null;
        VUE_PRESCR_MEDOCDAO instance = new VUE_PRESCR_MEDOCDAO();
        VUE_PRESCR_MEDOC expResult = null;
        VUE_PRESCR_MEDOC result = instance.create(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class VUE_PRESCR_MEDOCDAO.
     */
    //@Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        VUE_PRESCR_MEDOC obj = null;
        VUE_PRESCR_MEDOCDAO instance = new VUE_PRESCR_MEDOCDAO();
        VUE_PRESCR_MEDOC expResult = null;
        VUE_PRESCR_MEDOC result = instance.update(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class VUE_PRESCR_MEDOCDAO.
     */
    // @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        VUE_PRESCR_MEDOC obj = null;
        VUE_PRESCR_MEDOCDAO instance = new VUE_PRESCR_MEDOCDAO();
        instance.delete(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
