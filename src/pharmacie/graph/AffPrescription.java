
package pharmacie.graph;

import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pharmacie.DAO.VUE_PRESCR_MEDOCDAO;
import pharmacie.metier.VUE_PRESCR_MEDOC;


public class AffPrescription extends javax.swing.JPanel {

    VUE_PRESCR_MEDOCDAO vueDAO = null;
    DefaultTableModel dft1 = new DefaultTableModel();

    public AffPrescription() {
        initComponents();
        dft1.addColumn("num prescription");
        dft1.addColumn("date");
        dft1.addColumn("num médecin");
        dft1.addColumn("num patient");
        dft1.addColumn("num médoc");
        dft1.addColumn("nom médoc");
        dft1.addColumn("code médoc");
        jTable1.setModel(dft1);

    }
    public void setVUE_PRESCR_MEDOCDAO(VUE_PRESCR_MEDOCDAO vueDAO) {
        this.vueDAO = vueDAO;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btaff = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btaff.setText("Récupérer la liste");
        btaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btaffActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btaff)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btaff)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btaffActionPerformed

        try {
            List<VUE_PRESCR_MEDOC> alc = vueDAO.aff();
            int nr = dft1.getRowCount();
            for (int i = nr - 1; i >= 0; i--) {
                dft1.removeRow(i);
            }
            for (VUE_PRESCR_MEDOC cl : alc) {
                Vector v = new Vector();
                v.add(cl.getIdpres());
                v.add(cl.getDateprescription());
                v.add(cl.getIdmedecin());
                v.add(cl.getIdpat());
                v.add(cl.getIdmedoc());
                v.add(cl.getNom());
                v.add(cl.getCodemedoc());
                dft1.addRow(v);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btaffActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btaff;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
