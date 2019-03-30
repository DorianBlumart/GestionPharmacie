package pharmacie.DAO;

/**
 * classe de mappage poo-relationnel Prescription
 *
 * @author Blumart Dorian
 * @version 1.0
 * @see Prescription
 */
import pharmacie.metier.Prescription;
import java.sql.*;
import java.time.LocalDate;
import pharmacie.metier.Medecin;

public class PrescriptionDAO extends DAO<Prescription> {

    /**
     * récupération des données d'une prescription sur base de son identifiant
     *
     * @throws SQLException identifiant inconnu
     * @param idpres identifiant de la prescription
     * @return prescription trouvée
     */
    @Override
    public Prescription read(int idpres) throws SQLException {
        String req = "select * from api_prescription where idpres = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, idpres);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    LocalDate date = rs.getDate("dateprescription").toLocalDate();
                    int idmed = rs.getInt("idmedecin");
                    int idpat = rs.getInt("idpat");
                    return new Prescription(idpres, date, idmed, idpat);
                } else {
                    throw new SQLException("id inconnu");
                }

            }
        }
    }

    @Override
    public Prescription create(Prescription obj) throws SQLException {
        String req1 = "insert into api_prescription(dateprescription,idmedecin,idpat) values(?,?,?)";
        String req2 = "select idpres from api_prescription order by idpres desc";   //on select l'id le plus grand vu que création à l'instant
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setDate(1, java.sql.Date.valueOf(obj.getDateprescription()));    
            pstm1.setInt(2, obj.getIdmedecin());
            pstm1.setInt(3, obj.getIdpat());
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("Erreur de creation prescription, aucune ligne créée");
            }
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idpres = rs.getInt("idpres");
                    obj.setIdpres(idpres);
                    return read(idpres);
                } else {
                    throw new SQLException("erreur de création prescription, record introuvable");
                }
            }
        }
    }

    @Override
    public Prescription update(Prescription obj) throws SQLException {
        String req = "update api_prescription set dateprescription=? where idpres=?"; //changer nom/description
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setDate(1, java.sql.Date.valueOf(obj.getDateprescription())); 
            pstm.setInt(2, obj.getIdpres());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne prescription mise à jour");
            }
            return read(obj.getIdpres());
        }
    }

    @Override
    public void delete(Prescription obj) throws SQLException {
        String req = "delete from api_prescription where idpres= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, obj.getIdpres());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne prescription effacée");
            }

        }
    }
}
