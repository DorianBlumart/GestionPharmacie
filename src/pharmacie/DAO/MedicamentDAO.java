package pharmacie.DAO;

/**
 * classe de mappage poo-relationnel Medicament
 *
 * @author Blumart Dorian
 * @version 1.0
 * @see Medicament
 */
import java.sql.*;
import java.util.*;
import pharmacie.metier.Medicament;

public class MedicamentDAO extends DAO<Medicament> {

    /**
     * création d'un médicament sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj médicament à créer
     * @return médicament créé
     */
    @Override
    public Medicament create(Medicament obj) throws SQLException {
        String req1 = "insert into api_medicament(nom,description,codemedoc) values(?,?,?)";
        String req2 = "select idmedoc from api_medicament where codemedoc=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setString(1, obj.getNom());
            pstm1.setString(2, obj.getDescription());
            pstm1.setString(3, obj.getCodemedoc());
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation médicament, aucune ligne créée");
            }
            pstm2.setString(1, obj.getCodemedoc());
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idmedoc = rs.getInt(1);
                    obj.setIdmedoc(idmedoc);
                    return read(idmedoc);
                } else {
                    throw new SQLException("erreur de création médicament, record introuvable");
                }
            }
        }
    }

    /**
     * récupération des données d'un médicament sur base de son identifiant
     *
     * @throws SQLException identifiant inconnu
     * @param idmedoc identifiant du médicament
     * @return médicament trouvé
     */
    @Override
    public Medicament read(int idmedoc) throws SQLException {
        String req = "select * from api_medicament where idmedoc = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idmedoc);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String nom = rs.getString("nom");
                    String description = rs.getString("description");
                    String codemedoc = rs.getString("codemedoc");
                    return new Medicament(idmedoc, nom, description, codemedoc);
                } else {
                    throw new SQLException("id inconnu");
                }

            }
        }
    }

    /**
     * mise à jour des données du méidament sur base de son identifiant
     *
     * @return Médicament
     * @param obj médicament à mettre à jour
     * @throws SQLException erreur de mise à jour
     */
    @Override
    public Medicament update(Medicament obj) throws SQLException {
        String req = "update api_medicament set description=? where idmedoc= ?"; //changer nom/description
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1, obj.getDescription());
            pstm.setInt(2, obj.getIdmedoc());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne médicament mise à jour");
            }
            return read(obj.getIdmedoc());
        }
    }

    /**
     * effacement du médicament sur base de son identifiant
     *
     * @throws SQLException erreur d'effacement
     * @param obj médicament à effacer
     */
    @Override
    public void delete(Medicament obj) throws SQLException {

        String req = "delete from api_medicament where idmedoc= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, obj.getIdmedoc());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne médicament effacée");
            }

        }
    }

    /**
     * méthode permettant de récupérer tous les médicaments ayant un certain
     * mot-clé dans leur description
     *
     * @param descrech description recherchée
     * @return liste de médicaments
     * @throws SQLException description inconnue
     */
    public List<Medicament> rechDesc(String descrech) throws SQLException {
        List<Medicament> plusieurs = new ArrayList<>(); //plusieurs clients peucvent avoir même nom donc liste de client
        String req = "select * from api_medicament where description like ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1, "%" + descrech + "%");
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) { //while car plusieurs clients possibles
                    trouve = true;
                    int idmedoc = rs.getInt("idmedoc");
                    String nom = rs.getString("nom");
                    String desc = rs.getString("description");
                    String codemedoc = rs.getString("codemedoc");
                    plusieurs.add(new Medicament(idmedoc, nom, desc, codemedoc));
                }

                if (!trouve) {
                    throw new SQLException("Description inconnue");
                } else {
                    return plusieurs; //car plusieurs clients peucvent avoir même nom donc liste de client
                }
            }
        }

    }

    /**
     * méthode permettant de récupérer tous les médicaments
     *
     * @return liste de médicaments
     * @throws SQLException pas de médicament enregistré
     */
    public List<Medicament> aff() throws SQLException {
        List<Medicament> plusieurs = new ArrayList<>(); //plusieurs clients peucvent avoir même nom donc liste de client
        String req = "select * from api_medicament";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) { //while car plusieurs clients possibles
                    trouve = true;
                    int idmedoc = rs.getInt("idmedoc");
                    String nom = rs.getString("nom");
                    String desc = rs.getString("description");
                    String codemedoc = rs.getString("codemedoc");
                    plusieurs.add(new Medicament(idmedoc, nom, desc, codemedoc));
                }

                if (!trouve) {
                    throw new SQLException("pas de médicament enregistré");
                } else {
                    return plusieurs; //car plusieurs clients peucvent avoir même nom donc liste de client
                }
            }
        }

    }
}
