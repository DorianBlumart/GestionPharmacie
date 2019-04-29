package pharmacie.graph;

import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pharmacie.DAO.VUE_QTOT_UNITE_MEDOCDAO;
import pharmacie.metier.VUE_QTOT_UNITE_MEDOC;

public class AffQuantMedoc extends javax.swing.JPanel {

    VUE_QTOT_UNITE_MEDOCDAO vueDAO = null;
    DefaultTableModel dft1 = new DefaultTableModel();

    public AffQuantMedoc() {
        initComponents();
        initComponents();
        dft1.addColumn("numéro");
        dft1.addColumn("nom");
        dft1.addColumn("quantité");
        dft1.addColumn("unité");
        jTable1.setModel(dft1);

    }

    public void setVUE_QTOT_UNITE_MEDOCDAO(VUE_QTOT_UNITE_MEDOCDAO vueDAO) {
        this.vueDAO = vueDAO;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblnummedoc = new javax.swing.JLabel();
        txtnummedoc = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        lblnummedoc.setText("Numéro du médicament");

        txtnummedoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnummedocActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblnummedoc)
                        .addGap(18, 18, 18)
                        .addComponent(txtnummedoc, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblnummedoc)
                    .addComponent(txtnummedoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtnummedocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnummedocActionPerformed
        try {
            int nummedoc = Integer.parseInt(txtnummedoc.getText());
            List<VUE_QTOT_UNITE_MEDOC> alc = vueDAO.aff(nummedoc);
            int nr = dft1.getRowCount();
            for (int i = nr - 1; i >= 0; i--) {
                dft1.removeRow(i);
            }
            for (VUE_QTOT_UNITE_MEDOC cl : alc) {
                Vector v = new Vector();
                v.add(cl.getIdmedoc());
                v.add(cl.getNom());
                v.add(cl.getQtot());
                v.add(cl.getUnite());
                dft1.addRow(v);

            }
        } catch (Exception e) {
            if (e.getMessage().contains("input")) {
                JOptionPane.showMessageDialog(this, "veuillez remplir le champ", "ERREUR", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_txtnummedocActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblnummedoc;
    private javax.swing.JTextField txtnummedoc;
    // End of variables declaration//GEN-END:variables
}
