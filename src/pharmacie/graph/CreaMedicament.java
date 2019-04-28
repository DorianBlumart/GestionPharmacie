package pharmacie.graph;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import pharmacie.DAO.MedicamentDAO;
import pharmacie.metier.Medicament;

public class CreaMedicament extends javax.swing.JPanel {

    MedicamentDAO medicamentDAO = null;

    public CreaMedicament() {
        initComponents();
    }

    public void setMedicamentDAO(MedicamentDAO medicamentDAO) {
        this.medicamentDAO = medicamentDAO;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblcode = new javax.swing.JLabel();
        llblnummedoc = new javax.swing.JLabel();
        lblnom = new javax.swing.JLabel();
        lbldesc = new javax.swing.JLabel();
        txtnummedoc = new javax.swing.JTextField();
        txtnom = new javax.swing.JTextField();
        txtcode = new javax.swing.JTextField();
        btcreate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdesc = new javax.swing.JTextArea();

        lblcode.setText("code");

        llblnummedoc.setText("numéro de médicament");

        lblnom.setText("nom");

        lbldesc.setText("description");

        txtnummedoc.setEditable(false);
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

        btcreate.setText("création");
        btcreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcreateActionPerformed(evt);
            }
        });

        txtdesc.setColumns(20);
        txtdesc.setRows(5);
        jScrollPane1.setViewportView(txtdesc);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btcreate)
                    .addComponent(lblnom)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(llblnummedoc)
                            .addComponent(lblcode)
                            .addComponent(lbldesc))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtnom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtnummedoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtcode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(llblnummedoc)
                    .addComponent(txtnummedoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcode)
                    .addComponent(txtcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblnom)
                    .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbldesc))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(btcreate)
                .addGap(76, 76, 76))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtnummedocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnummedocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnummedocActionPerformed

    private void btcreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcreateActionPerformed
        try {
            String code = txtcode.getText();
            String nom = txtnom.getText();
            String desc = txtdesc.getText();
            desc = desc.toLowerCase();
            Medicament medoc = new Medicament(0, nom, desc, code);
            try {
                medoc = medicamentDAO.create(medoc);
                txtnummedoc.setText("" + medoc.getIdmedoc());
                JOptionPane.showMessageDialog(this, "médicament créé", "SUCCES", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException f) {
                if (f.getMessage().contains("UK")) {
                    JOptionPane.showMessageDialog(this, "médicament déjà existant", "ERREUR", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (f.getMessage().contains("grand")) { //si on dépasse la taille du varchar 
                        JOptionPane.showMessageDialog(this, "le code dépasse la taille limite de 5 caractères", "ERREUR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (f.getMessage().contains("NULL")) {
                            JOptionPane.showMessageDialog(this, "veuillez remplir tous les champs", "ERREUR", JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(this, f.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        } catch (Exception e) {
            if (e.getMessage().contains("input")) {
                JOptionPane.showMessageDialog(this, "veuillez remplir tous les champs", "ERREUR", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btcreateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btcreate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblcode;
    private javax.swing.JLabel lbldesc;
    private javax.swing.JLabel lblnom;
    private javax.swing.JLabel llblnummedoc;
    private javax.swing.JTextField txtcode;
    private javax.swing.JTextArea txtdesc;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtnummedoc;
    // End of variables declaration//GEN-END:variables
}
