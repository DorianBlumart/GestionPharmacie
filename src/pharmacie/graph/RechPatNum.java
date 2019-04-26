
package pharmacie.graph;

import javax.swing.JOptionPane;
import pharmacie.DAO.PatientDAO;
import pharmacie.metier.Patient;

public class RechPatNum extends javax.swing.JPanel {

    PatientDAO patientDAO = null;
    Patient pat = null;

    public RechPatNum() {
        initComponents();
    }

    public void setPatientDAO(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblnom = new javax.swing.JLabel();
        llblnumpat = new javax.swing.JLabel();
        lblprenom = new javax.swing.JLabel();
        lbltel = new javax.swing.JLabel();
        txtnumpat = new javax.swing.JTextField();
        txtprenom = new javax.swing.JTextField();
        txtnom = new javax.swing.JTextField();
        txttel = new javax.swing.JTextField();
        btmaj = new javax.swing.JButton();
        btrech = new javax.swing.JButton();
        btdel = new javax.swing.JButton();

        lblnom.setText("nom");

        llblnumpat.setText("numéro de patient");

        lblprenom.setText("prénom");

        lbltel.setText("numéro de téléphone");

        txtnumpat.setMinimumSize(new java.awt.Dimension(50, 20));
        txtnumpat.setNextFocusableComponent(txtnom);
        txtnumpat.setPreferredSize(new java.awt.Dimension(150, 30));
        txtnumpat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumpatActionPerformed(evt);
            }
        });

        txtprenom.setMinimumSize(new java.awt.Dimension(50, 20));
        txtprenom.setNextFocusableComponent(txttel);
        txtprenom.setPreferredSize(new java.awt.Dimension(150, 30));

        txtnom.setMinimumSize(new java.awt.Dimension(50, 20));
        txtnom.setNextFocusableComponent(txtprenom);
        txtnom.setPreferredSize(new java.awt.Dimension(150, 30));

        txttel.setMinimumSize(new java.awt.Dimension(50, 20));
        txttel.setPreferredSize(new java.awt.Dimension(150, 30));

        btmaj.setText("Màj téléphone du dernier patient trouvé");
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

        btdel.setText("Effacer le dernier patient trouvé");
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btmaj, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btdel, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblprenom)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(llblnumpat)
                                    .addComponent(lblnom)
                                    .addComponent(lbltel))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txttel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtprenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnumpat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btrech, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(llblnumpat)
                    .addComponent(txtnumpat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblnom)
                    .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblprenom)
                    .addComponent(txtprenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltel)
                    .addComponent(txttel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            int numpat = Integer.parseInt(txtnumpat.getText());
            String nom = txtnom.getText();
            String prenom = txtprenom.getText();
            String tel = txttel.getText();
            Patient pat = new Patient(numpat, nom, prenom, tel);
            patientDAO.update(pat);
            JOptionPane.showMessageDialog(this, "patient mis à jour", "SUCCES", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btmajActionPerformed

    private void btrechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btrechActionPerformed
        try {
            int numpat = Integer.parseInt(txtnumpat.getText());
            pat = patientDAO.read(numpat);
            txtnom.setText(pat.getNom());
            txtprenom.setText(pat.getPrenom());
            txttel.setText(pat.getTel());
            JOptionPane.showMessageDialog(this, "patient trouvé", "SUCCES", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btrechActionPerformed

    private void btdelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdelActionPerformed
        try {
            int numpat = Integer.parseInt(txtnumpat.getText());
            patientDAO.delete(pat);
            txtnumpat.setText("");
            txtnom.setText("");
            txtprenom.setText("");
            txttel.setText("");
            JOptionPane.showMessageDialog(this, "patient effacé", "SUCCES", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            if (e.getMessage().contains("int")) {   //erreur d'intégrité
                JOptionPane.showMessageDialog(this, "Vous ne pouvez pas supprimer un patient déjà renseigné dans une prescription, veuillez d'abord supprimer sa/ses prescription(s)", "ERREUR", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btdelActionPerformed

    private void txtnumpatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumpatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumpatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btdel;
    private javax.swing.JButton btmaj;
    private javax.swing.JButton btrech;
    private javax.swing.JLabel lblnom;
    private javax.swing.JLabel lblprenom;
    private javax.swing.JLabel lbltel;
    private javax.swing.JLabel llblnumpat;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtnumpat;
    private javax.swing.JTextField txtprenom;
    private javax.swing.JTextField txttel;
    // End of variables declaration//GEN-END:variables
}
