/**
 * classe de mappage poo-relationnel VUE_PRESCR_MEDOC
 *
 * @author Blumart Dorian
 * @version 1.0
 * @see VUE_PRESCR_MEDOC
 */
package pharmacie.DAO;

import pharmacie.metier.VUE_PRESCR_MEDOC;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class VUE_PRESCR_MEDOCDAO extends DAO<VUE_PRESCR_MEDOC> {

    /**
     * récupération des données de la vue VUE_PRESCR_MEDOC sur base de
     * l'identifiant de la prescription
     *
     * @throws SQLException identifiant inconnu
     * @param idpres identifiant de la prescription
     * @return les éléments de la vue correspondants à la prescription trouvée
     */
    @Override
    public VUE_PRESCR_MEDOC read(int idpres) throws SQLException {
        String req = "select * from API_VUE_PRESCR_MEDOC where idpres=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, idpres);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    LocalDate date = rs.getDate("dateprescription").toLocalDate();
                    int idmedecin = rs.getInt("idmedecin");
                    int idpat = rs.getInt("idpat");
                    int idmedoc = rs.getInt("idmedoc");
                    String nom = rs.getString("nom");
                    String desc = rs.getString("description");
                    String code = rs.getString("codemedoc");
                    return new VUE_PRESCR_MEDOC(idpres, date, idmedecin, idpat, idmedoc, nom, desc, code);
                } else {
                    throw new SQLException("id inconnu");
                }

            }
        }
    }

    @Override
    public VUE_PRESCR_MEDOC create(VUE_PRESCR_MEDOC obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VUE_PRESCR_MEDOC update(VUE_PRESCR_MEDOC obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(VUE_PRESCR_MEDOC obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * méthode permettant de récupérer tous les médicaments
     *
     * @return liste de médicaments
     * @throws SQLException pas de médicament enregistré
     */
    public List<VUE_PRESCR_MEDOC> aff() throws SQLException {
        List<VUE_PRESCR_MEDOC> plusieurs = new ArrayList<>(); 
        String req = "select * from api_VUE_PRESCR_MEDOC";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) { 
                    trouve = true;
                    int idpres = rs.getInt("idpres");
                    LocalDate date = rs.getDate("dateprescription").toLocalDate();
                    int idmedecin = rs.getInt("idmedecin");
                    int idpat = rs.getInt("idpat");
                    int idmedoc = rs.getInt("idmedoc");
                    String nom = rs.getString("nom");
                    String desc = rs.getString("description");
                    String code = rs.getString("codemedoc");
                    plusieurs.add(new VUE_PRESCR_MEDOC(idpres, date, idmedecin, idpat, idmedoc, nom, desc, code));
                }

                if (!trouve) {
                    throw new SQLException("pas de médicament enregistré");
                } else {
                    return plusieurs;
                }
            }
        }

    }

    public List<VUE_PRESCR_MEDOC> rechPat(int idpat) throws SQLException {
        List<VUE_PRESCR_MEDOC> plusieurs = new ArrayList<>(); 
        String req = "select * from api_VUE_PRESCR_MEDOC where idpat=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, idpat);
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) { 
                    trouve = true;
                    int idpres = rs.getInt("idpres");
                    LocalDate date = rs.getDate("dateprescription").toLocalDate();
                    int idmedecin = rs.getInt("idmedecin");
                    int idmedoc = rs.getInt("idmedoc");
                    String nom = rs.getString("nom");
                    String desc = rs.getString("description");
                    String code = rs.getString("codemedoc");
                    plusieurs.add(new VUE_PRESCR_MEDOC(idpres, date, idmedecin, idpat, idmedoc, nom, desc, code));
                }

                if (!trouve) {
                    throw new SQLException("ce patient n'a pas de prescription");
                } else {
                    return plusieurs;
                }
            }
        }
    }
}
