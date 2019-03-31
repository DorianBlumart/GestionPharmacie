package pharmacie.DAO;

/**
 * classe de mappage poo-relationnel Infos
 *
 * @author Blumart Dorian
 * @version 1.0
 * @see Infos
 */
import pharmacie.metier.Infos;
import java.sql.*;
import pharmacie.metier.Medicament;
import pharmacie.metier.Prescription;

public class InfosDAO extends DAO<Infos> {

    /**
     * récupération des données d'une info sur base de son identifiant
     *
     * @throws SQLException identifiant inconnu
     * @param idinfo identifiant du médicament
     * @return info trouvée
     */
    @Override
    public Infos read(int idinfo) throws SQLException {
        String req = "select * from api_infos where idinfo = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idinfo);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String unite = rs.getString("unite");
                    int quantite = rs.getInt("quantite");
                    int idpres = rs.getInt("idpres");
                    int idmedoc = rs.getInt("idmedoc");
                    return new Infos(unite, quantite, idpres, idmedoc, idinfo);
                } else {
                    throw new SQLException("id inconnu");
                }

            }
        }
    }

    /**
     * création d'une info sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj info à créer
     * @return info créée
     */
    @Override
    public Infos create(Infos obj) throws SQLException {
        String req1 = "insert into api_infos(unite,quantite,idpres,idmedoc) values(?,?,?,?)";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);) {
            pstm1.setString(1, obj.getUnite());
            pstm1.setInt(2, obj.getQuantite());
            pstm1.setInt(3, obj.getIdpres());
            pstm1.setInt(4, obj.getIdmedoc());
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation infos, aucune ligne créée");
            }
        }
        return null;    //pas besoin de retour l'id de l'info ici, elle ne sera pas utile
    }

    @Override
    public Infos update(Infos obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Infos obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * effacement des infos d'un médicament sur base de l'identifiant de la
     * prescription
     *
     * @throws SQLException erreur d'effacement
     * @param obj prescription dont les infos sont à effacer
     */
    public void deleteForPrescr(Prescription obj) throws SQLException {
        String req = "delete from api_infos where idpres= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, obj.getIdpres());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("effacement des infos impossible");
            }

        }
    }

    /**
     * effacement des infos d'un médicament sur base de l'identifiant du
     * médicament
     *
     * @throws SQLException erreur d'effacement
     * @param obj médoc dont les infos sont à effacer
     */
    public void deleteForMedoc(Medicament obj) throws SQLException {

        String req = "delete from api_infos where idmedoc= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, obj.getIdmedoc());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("Effacement des infos impossible");
            }

        }
    }

}
