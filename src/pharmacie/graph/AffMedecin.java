
package pharmacie.graph;

import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pharmacie.DAO.MedecinDAO;
import pharmacie.metier.Medecin;

public class AffMedecin extends javax.swing.JPanel {

    MedecinDAO medecinDAO = null;
    DefaultTableModel dft1 = new DefaultTableModel();

    public AffMedecin() {
        initComponents();
        dft1.addColumn("numéro");
        dft1.addColumn("nom");
        dft1.addColumn("prénom");
        dft1.addColumn("téléphone");
        dft1.addColumn("matricule");
        jTable1.setModel(dft1);

    }

    public void setMedecinDAO(MedecinDAO medecinDAO) {
        this.medecinDAO = medecinDAO;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btaff = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 407, Short.MAX_VALUE)
                        .addComponent(btaff))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(btaff)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btaffActionPerformed

        try {
            List<Medecin> alc = medecinDAO.aff();
            int nr = dft1.getRowCount();
            for (int i = nr - 1; i >= 0; i--) {
                dft1.removeRow(i);
            }
            for (Medecin cl : alc) {
                Vector v = new Vector();
                v.add(cl.getIdmed());
                v.add(cl.getNom());
                v.add(cl.getPrenom());
                v.add(cl.getTel());
                v.add(cl.getMatricule());
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
