/**
 * classe de mappage poo-relationnel Medecin
 *
 * @author Blumart Dorian
 * @version 1.0
 * @see Medecin
 */
package pharmacie.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pharmacie.metier.Medecin;

/**
 *
 * @author Dorian
 */
public class MedecinDAO extends DAO<Medecin>{
    /**
     * récupération des données d'un médecin sur base de son identifiant
     *
     * @throws SQLException identifiant inconnu
     * @param idmed identifiant du médecin
     * @return médecin trouvé
     */
    @Override
    public Medecin read(int idmed) throws SQLException {
        String req = "select * from api_medecin where idmed=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, idmed);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String nom = rs.getString("nom");
                    String prenom = rs.getString("prenom");
                    String tel = rs.getString("tel");
                    String matricule = rs.getString("matricule");
                    return new Medecin(idmed, matricule, nom, prenom, tel);
                } else {
                    throw new SQLException("id inconnu");
                }

            }
        }
    }

    /**
     * création d'un médecin sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj médecin à créer
     * @return médecin créé
     */
    @Override
    public Medecin create(Medecin obj) throws SQLException {
        String req1 = "insert into api_medecin(matricule,nom,prenom,tel) values(?,?,?,?)";
        String req2 = "select idmed from api_medecin where matricule=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setString(1, obj.getMatricule());
            pstm1.setString(2, obj.getNom());
            pstm1.setString(3, obj.getPrenom());
            pstm1.setString(4, obj.getTel());
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation du médecin, aucune ligne créée");
            }
            pstm2.setString(1, obj.getMatricule());
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idmed = rs.getInt("idmed");   //ici est sûrement l'erreur
                    obj.setIdmed(idmed);
                    return read(idmed);
                } else {
                    throw new SQLException("erreur de création du médecin, record introuvable");
                }
            }
        }
    }

    /**
     * mise à jour des données du médecin sur base de son identifiant
     *
     * @return médecin
     * @param obj médecin à mettre à jour
     * @throws SQLException erreur de mise à jour
     */
    @Override
    public Medecin update(Medecin obj) throws SQLException {
        String req = "update api_medecin set tel=? where idmed= ?"; //changer nom/description
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1, obj.getTel());
            pstm.setInt(2, obj.getIdmed());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne médecin mise à jour");
            }
            return read(obj.getIdmed());
        }
    }

    /**
     * effacement du médecin sur base de son identifiant
     *
     * @throws SQLException erreur d'effacement
     * @param obj médecin à effacer
     */
    @Override
    public void delete(Medecin obj) throws SQLException {
        String req = "delete from api_medecin where idmed = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, obj.getIdmed());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne médecin effacée");
            }

        }
    }
    /**
     * méthode permettant de récupérer tous les médecins
     *
     * @return liste de médecins
     * @throws SQLException pas de médecin enregistré
     */
    public List<Medecin> aff() throws SQLException {
        List<Medecin> plusieurs = new ArrayList<>(); 
        String req = "select * from api_medecin";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) { 
                    trouve = true;
                    int idmed = rs.getInt("idmed");
                    String nom = rs.getString("nom");
                    String prenom = rs.getString("prenom");
                    String tel = rs.getString("tel");
                    String matricule = rs.getString("matricule");
                    plusieurs.add(new Medecin(idmed, matricule, nom, prenom, tel));
                }

                if (!trouve) {
                    throw new SQLException("pas de médecin enregistré");
                } else {
                    return plusieurs; 
                }
            }
        }
    }

}

