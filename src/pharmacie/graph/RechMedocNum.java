package pharmacie.graph;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import pharmacie.DAO.InfosDAO;
import pharmacie.DAO.MedicamentDAO;
import pharmacie.metier.Infos;
import pharmacie.metier.Medicament;

public class RechMedocNum extends javax.swing.JPanel {

    MedicamentDAO medicamentDAO = null;
    Medicament medicament = null;
    InfosDAO infosDAO = null;
    //Infos infos = null;

    public RechMedocNum() {
        initComponents();
    }

    public void setMedicamentDAO(MedicamentDAO medicamentDAO) {
        this.medicamentDAO = medicamentDAO;
    }

    public void setInfosDAO(InfosDAO infosDAO) {
        this.infosDAO = infosDAO;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblcode = new javax.swing.JLabel();
        lblnummedoc = new javax.swing.JLabel();
        lblnom = new javax.swing.JLabel();
        lbldesc = new javax.swing.JLabel();
        txtnummedoc = new javax.swing.JTextField();
        txtnom = new javax.swing.JTextField();
        txtcode = new javax.swing.JTextField();
        txtdesc = new javax.swing.JTextField();
        btmaj = new javax.swing.JButton();
        btrech = new javax.swing.JButton();
        btdel = new javax.swing.JButton();

        lblcode.setText("code");

        lblnummedoc.setText("numéro de médicament");

        lblnom.setText("nom");

        lbldesc.setText("description");

        txtnummedoc.setMinimumSize(new java.awt.Dimension(50, 20));
        txtnummedoc.setNextFocusableComponent(txtcode);
        txtnummedoc.setPreferredSize(new java.awt.Dimension(150, 30));
        txtnummedoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnummedocActionPerformed(evt);
            }
        });

        txtnom.setMinimumSize(new java.awt.Dimension(50, 20));
        txtnom.setNextFocusableComponent(txtdesc);
        txtnom.setPreferredSize(new java.awt.Dimension(150, 30));

        txtcode.setMinimumSize(new java.awt.Dimension(50, 20));
        txtcode.setNextFocusableComponent(txtnom);
        txtcode.setPreferredSize(new java.awt.Dimension(150, 30));

        txtdesc.setMinimumSize(new java.awt.Dimension(50, 20));
        txtdesc.setPreferredSize(new java.awt.Dimension(150, 30));

        btmaj.setText("Màj description du dernier médoc trouvé");
        btmaj.setPreferredSize(new java.awt.Dimension(150, 30));
        btmaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmajActionPerformed(evt);
            }
        });

        btrech.setText("Rechercher (via id)");
        btrech.setPreferredSize(new java.awt.Dimension(150, 30));
        btrech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btrechActionPerformed(evt);
            }
        });

        btdel.setText("Effacer le dernier médoc trouvé");
        btdel.setPreferredSize(new java.awt.Dimension(150, 30));
        btdel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblnom)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblnummedoc)
                            .addComponent(lblcode)
                            .addComponent(lbldesc))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnummedoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btrech, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(176, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btmaj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btdel, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblnummedoc)
                    .addComponent(txtnummedoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcode)
                    .addComponent(txtcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblnom)
                    .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbldesc)
                    .addComponent(txtdesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btrech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btdel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btmaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btmajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmajActionPerformed

        try {
            int nummedoc = Integer.parseInt(txtnummedoc.getText());
            String code = txtcode.getText();
            String nom = txtnom.getText();
            String desc = txtdesc.getText();
            desc = desc.toLowerCase();
            Medicament medicament = new Medicament(nummedoc, nom, desc, code);
            medicamentDAO.update(medicament);
            JOptionPane.showMessageDialog(this, "médicament mis à jour", "SUCCES", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btmajActionPerformed

    private void btrechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btrechActionPerformed
        try {
            int nummedoc = Integer.parseInt(txtnummedoc.getText());
            medicament = medicamentDAO.read(nummedoc);
            txtcode.setText(medicament.getCodemedoc());
            txtnom.setText(medicament.getNom());
            txtdesc.setText(medicament.getDescription());
            JOptionPane.showMessageDialog(this, "patient trouvé", "SUCCES", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btrechActionPerformed

    private void btdelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdelActionPerformed
        try {
            int nummedoc = Integer.parseInt(txtnummedoc.getText());
            try {
                ((InfosDAO) (infosDAO)).deleteForMedoc(medicament);
                medicamentDAO.delete(medicament);
            } catch (SQLException f) {
                medicamentDAO.delete(medicament);
            }
            txtnummedoc.setText("");
            txtcode.setText("");
            txtnom.setText("");
            txtdesc.setText("");
            JOptionPane.showMessageDialog(this, "médicament effacé", "SUCCES", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btdelActionPerformed

    private void txtnummedocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnummedocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnummedocActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btdel;
    private javax.swing.JButton btmaj;
    private javax.swing.JButton btrech;
    private javax.swing.JLabel lblcode;
    private javax.swing.JLabel lbldesc;
    private javax.swing.JLabel lblnom;
    private javax.swing.JLabel lblnummedoc;
    private javax.swing.JTextField txtcode;
    private javax.swing.JTextField txtdesc;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtnummedoc;
    // End of variables declaration//GEN-END:variables
}
