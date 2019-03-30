/**
 * classe de mappage poo-relationnel VUE_QTOT_UNITE_MEDOC
 *
 * @author Blumart Dorian
 * @version 1.0
 * @see VUE_QTOT_UNITE_MEDOC
 */
package pharmacie.DAO;

import java.sql.*;
import java.util.*;
import pharmacie.metier.VUE_QTOT_UNITE_MEDOC;


public class VUE_QTOT_UNITE_MEDOCDAO extends DAO<VUE_QTOT_UNITE_MEDOC> {
    @Override
    public VUE_QTOT_UNITE_MEDOC create(VUE_QTOT_UNITE_MEDOC obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VUE_QTOT_UNITE_MEDOC update(VUE_QTOT_UNITE_MEDOC obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(VUE_QTOT_UNITE_MEDOC obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VUE_QTOT_UNITE_MEDOC read(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
    /**
     * Afficher les quantités totales prescrites d'un médicament (Par unité)
     *
     * @throws SQLException pas de prescription associée
     * @param idmedoc identifiant du médicament
     * @return médicament concerné
     */
    public List<VUE_QTOT_UNITE_MEDOC> aff(int idmedoc) throws SQLException {
        List<VUE_QTOT_UNITE_MEDOC> plusieurs = new ArrayList<>(); 
        String req = "select * from API_VUE_QTOT_UNITE_MEDOC where idmedoc = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, idmedoc);
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) { 
                    trouve = true;
                    String nom = rs.getString("nom");
                    String unite = rs.getString("unite");
                    int quantite = rs.getInt("qtot");
                    plusieurs.add(new VUE_QTOT_UNITE_MEDOC(idmedoc, nom, unite, quantite));
                }

                if (!trouve) {
                    throw new SQLException("pas de prescription associée");
                } else {
                    return plusieurs; 
                }
            }
        }

    }

}
