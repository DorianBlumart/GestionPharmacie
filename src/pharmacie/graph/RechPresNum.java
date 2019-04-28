package pharmacie.graph;

import java.time.LocalDate;
import javax.swing.JOptionPane;
import pharmacie.DAO.InfosDAO;
import pharmacie.DAO.PrescriptionDAO;
import pharmacie.metier.Infos;
import pharmacie.metier.Prescription;

public class RechPresNum extends javax.swing.JPanel {

    PrescriptionDAO prescriptionDAO = null;
    Prescription prescription = null;
    InfosDAO infosDAO = null;
    Infos infos = null;

    public RechPresNum() {
        initComponents();
    }

    public void setPrescriptionDAO(PrescriptionDAO prescriptionDAO) {
        this.prescriptionDAO = prescriptionDAO;
    }

    public void setInfosDAO(InfosDAO infosDAO) {
        this.infosDAO = infosDAO;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbldate = new javax.swing.JLabel();
        llblnumpres = new javax.swing.JLabel();
        lblnummed = new javax.swing.JLabel();
        lblnumpat = new javax.swing.JLabel();
        txtnumpres = new javax.swing.JTextField();
        txtnummed = new javax.swing.JTextField();
        txtdate = new javax.swing.JTextField();
        txtnumpat = new javax.swing.JTextField();
        btmaj = new javax.swing.JButton();
        btrech = new javax.swing.JButton();
        btdel = new javax.swing.JButton();

        lbldate.setText("date (YYYY-MM-DD)");

        llblnumpres.setText("numéro de prescription");

        lblnummed.setText("numéro de médecin");

        lblnumpat.setText("numéro de patient");

        txtnumpres.setMinimumSize(new java.awt.Dimension(50, 20));
        txtnumpres.setNextFocusableComponent(txtdate);
        txtnumpres.setPreferredSize(new java.awt.Dimension(150, 30));
        txtnumpres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumpresActionPerformed(evt);
            }
        });

        txtnummed.setMinimumSize(new java.awt.Dimension(50, 20));
        txtnummed.setNextFocusableComponent(txtnumpat);
        txtnummed.setPreferredSize(new java.awt.Dimension(150, 30));

        txtdate.setMinimumSize(new java.awt.Dimension(50, 20));
        txtdate.setNextFocusableComponent(txtnummed);
        txtdate.setPreferredSize(new java.awt.Dimension(150, 30));

        txtnumpat.setMinimumSize(new java.awt.Dimension(50, 20));
        txtnumpat.setPreferredSize(new java.awt.Dimension(150, 30));

        btmaj.setText("Màj date de la dernière prescription trouvée");
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

        btdel.setText("Effacer la dernière prescription trouvée");
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
                    .addComponent(lblnummed)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(llblnumpres)
                            .addComponent(lbldate)
                            .addComponent(lblnumpat))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnumpat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnummed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnumpres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btrech, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(208, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(btmaj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btdel, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(llblnumpres)
                    .addComponent(txtnumpres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbldate)
                    .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblnummed)
                    .addComponent(txtnummed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblnumpat)
                    .addComponent(txtnumpat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            int numpres = Integer.parseInt(txtnumpres.getText());
            String date = txtdate.getText();
            int nummed = Integer.parseInt(txtnummed.getText());
            int numpat = Integer.parseInt(txtnumpat.getText());
            LocalDate datepres = LocalDate.parse(date);

            Prescription prescription = new Prescription(numpres, datepres, nummed, numpat);
            prescriptionDAO.update(prescription);
            JOptionPane.showMessageDialog(this, "patient mis à jour", "SUCCES", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            if (e.getMessage().contains("input")) {
                JOptionPane.showMessageDialog(this, "veuillez identifier la prescription cherchée", "ERREUR", JOptionPane.ERROR_MESSAGE);
            } else {
                if (e.getMessage().contains("parsed")) {
                    JOptionPane.showMessageDialog(this, "Date entrée invalide", "ERREUR", JOptionPane.ERROR_MESSAGE);        //erreur date
                } else {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }//GEN-LAST:event_btmajActionPerformed

    private void btrechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btrechActionPerformed
        try {
            int numpres = Integer.parseInt(txtnumpres.getText());
            prescription = prescriptionDAO.read(numpres);
            txtdate.setText("" + prescription.getDateprescription());
            txtnummed.setText("" + prescription.getIdmedecin());
            txtnumpat.setText("" + prescription.getIdpat());
            JOptionPane.showMessageDialog(this, "presciption trouvée", "SUCCES", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            if (e.getMessage().contains("input")) {
                JOptionPane.showMessageDialog(this, "veuillez identifier la prescription cherchée", "ERREUR", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btrechActionPerformed

    private void btdelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdelActionPerformed
        try {
            int numpres = Integer.parseInt(txtnumpres.getText());
            try {
                ((InfosDAO) (infosDAO)).deleteForPrescr(prescription);      //on va faire ici une supression en cascade pour l'info associée car le user n'a aucun moyen de supprimer une info                
                prescriptionDAO.delete(prescription);
            } catch (Exception f) {
                prescriptionDAO.delete(prescription);
            }
            txtnumpres.setText("");
            txtdate.setText("");
            txtnummed.setText("");
            txtnumpat.setText("");
            JOptionPane.showMessageDialog(this, "prescription effacée", "SUCCES", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            if (e.getMessage().contains("input")) {
                JOptionPane.showMessageDialog(this, "veuillez identifier la prescription cherchée", "ERREUR", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btdelActionPerformed

    private void txtnumpresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumpresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumpresActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btdel;
    private javax.swing.JButton btmaj;
    private javax.swing.JButton btrech;
    private javax.swing.JLabel lbldate;
    private javax.swing.JLabel lblnummed;
    private javax.swing.JLabel lblnumpat;
    private javax.swing.JLabel llblnumpres;
    private javax.swing.JTextField txtdate;
    private javax.swing.JTextField txtnummed;
    private javax.swing.JTextField txtnumpat;
    private javax.swing.JTextField txtnumpres;
    // End of variables declaration//GEN-END:variables
}
