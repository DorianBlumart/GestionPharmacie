package pharmacie.graph;

import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pharmacie.DAO.PatientDAO;
import pharmacie.DAO.VUE_PRESCR_MEDOCDAO;
import pharmacie.metier.Patient;
import pharmacie.metier.VUE_PRESCR_MEDOC;

public class RechPresPat extends javax.swing.JPanel {

    PatientDAO patientDAO = null;
    Patient pat = null;
    VUE_PRESCR_MEDOCDAO vueDAO = null;
    DefaultTableModel dft1 = new DefaultTableModel();

    public RechPresPat() {
        initComponents();
        dft1.addColumn("nom patient");
        dft1.addColumn("prénom patient");
        dft1.addColumn("num prescription");
        dft1.addColumn("date");
        dft1.addColumn("num médecin");
        dft1.addColumn("num médoc");
        dft1.addColumn("nom médoc");
        jTable1.setModel(dft1);

    }

    public void setPatientDAO(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    public void setVUE_PRESCR_MEDOCDAO(VUE_PRESCR_MEDOCDAO vueDAO) {
        this.vueDAO = vueDAO;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblnumpat = new javax.swing.JLabel();
        txtnumpat = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        lblnumpat.setText("Numéro du patient");

        txtnumpat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumpatActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblnumpat)
                        .addGap(92, 92, 92)
                        .addComponent(txtnumpat, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 348, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblnumpat)
                    .addComponent(txtnumpat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtnumpatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumpatActionPerformed
        try {
            int numpat = Integer.parseInt(txtnumpat.getText());
            pat = patientDAO.read(numpat);
            List<VUE_PRESCR_MEDOC> alc = vueDAO.rechPat(numpat);
            int nr = dft1.getRowCount();
            for (int i = nr - 1; i >= 0; i--) {
                dft1.removeRow(i);
            }
            for (VUE_PRESCR_MEDOC cl : alc) {
                Vector v = new Vector();
                v.add(pat.getNom());
                v.add(pat.getPrenom());
                v.add(cl.getIdpres());
                v.add(cl.getDateprescription());
                v.add(cl.getIdmedecin());
                v.add(cl.getIdmedoc());
                v.add(cl.getNom());
                dft1.addRow(v);

            }
        } catch (Exception e) {
            if (e.getMessage().contains("input")) {
                JOptionPane.showMessageDialog(this, "veuillez remplir le champ", "ERREUR", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_txtnumpatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblnumpat;
    private javax.swing.JTextField txtnumpat;
    // End of variables declaration//GEN-END:variables
}
