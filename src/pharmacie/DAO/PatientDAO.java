package pharmacie.DAO;

/**
 * classe de mappage poo-relationnel Patient
 *
 * @author Blumart Dorian
 * @version 1.0
 * @see Patient
 */
import pharmacie.metier.Patient;
import java.sql.*;
import java.util.*;

public class PatientDAO extends DAO<Patient> {

    /**
     * récupération des données d'un patient sur base de son identifiant
     *
     * @throws SQLException identifiant inconnu
     * @param idpat identifiant du patient
     * @return patient trouvé
     */
    @Override
    public Patient read(int idpat) throws SQLException {
        String req = "select * from API_PATIENT where idpat=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, idpat);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String nom = rs.getString("nom");
                    String prenom = rs.getString("prenom");
                    String tel = rs.getString("tel");
                    return new Patient(idpat, nom, prenom, tel);
                } else {
                    throw new SQLException("id inconnu");
                }

            }
        }
    }

    /**
     * création d'un patient sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj patient à créer
     * @return patient créé
     */
    @Override
    public Patient create(Patient obj) throws SQLException {
        String req1 = "insert into api_patient(nom,prenom,tel) values(?,?,?)";
        String req2 = "select idpat from api_patient where nom=? and prenom=? and tel=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setString(1, obj.getNom());
            pstm1.setString(2, obj.getPrenom());
            pstm1.setString(3, obj.getTel());
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation du patient, aucune ligne créée");
            }
            pstm2.setString(1, obj.getNom());
            pstm2.setString(2, obj.getPrenom());
            pstm2.setString(3, obj.getTel());
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idpat = rs.getInt("idpat");   //ici est sûrement l'erreur
                    obj.setIdpat(idpat);
                    return read(idpat);
                } else {
                    throw new SQLException("erreur de création du patient, record introuvable");
                }
            }
        }
    }

    /**
     * mise à jour des données du patient sur base de son identifiant
     *
     * @return patient
     * @param obj patient à mettre à jour
     * @throws SQLException erreur de mise à jour
     */
    @Override
    public Patient update(Patient obj) throws SQLException {
        String req = "update api_patient set tel=? where idpat= ?"; //changer nom/description
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1, obj.getTel());
            pstm.setInt(2, obj.getIdpat());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne patient mise à jour");
            }
            return read(obj.getIdpat());
        }
    }

    /**
     * effacement du patient sur base de son identifiant
     *
     * @throws SQLException erreur d'effacement
     * @param obj patient à effacer
     */
    @Override
    public void delete(Patient obj) throws SQLException {
        String req = "delete from api_patient where idpat= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, obj.getIdpat());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne client effacée");
            }

        }
    }

    /**
     * méthode permettant de récupérer tous les patients
     *
     * @return liste de patiens
     * @throws SQLException pas de patient enregistré
     */
    public List<Patient> aff() throws SQLException {
        List<Patient> plusieurs = new ArrayList<>();
        String req = "select * from api_patient";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    int idpat = rs.getInt("idpat");
                    String nom = rs.getString("nom");
                    String prenom = rs.getString("prenom");
                    String tel = rs.getString("tel");
                    plusieurs.add(new Patient(idpat, nom, prenom, tel));
                }

                if (!trouve) {
                    throw new SQLException("pas de patient enregistré");
                } else {
                    return plusieurs;
                }
            }
        }
    }

}
