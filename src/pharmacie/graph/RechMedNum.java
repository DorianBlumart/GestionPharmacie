package pharmacie.graph;

import javax.swing.JOptionPane;
import pharmacie.DAO.MedecinDAO;
import pharmacie.metier.Medecin;

public class RechMedNum extends javax.swing.JPanel {

    MedecinDAO medecinDAO = null;
    Medecin med = null;

    public RechMedNum() {
        initComponents();
    }

    public void setMedecinDAO(MedecinDAO medecinDAO) {
        this.medecinDAO = medecinDAO;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblnom = new javax.swing.JLabel();
        llblnummed = new javax.swing.JLabel();
        lblprenom = new javax.swing.JLabel();
        lbltel = new javax.swing.JLabel();
        txtnummed = new javax.swing.JTextField();
        txtprenom = new javax.swing.JTextField();
        txtnom = new javax.swing.JTextField();
        txttel = new javax.swing.JTextField();
        btmaj = new javax.swing.JButton();
        btrech = new javax.swing.JButton();
        btdel = new javax.swing.JButton();
        txtmatricule = new javax.swing.JTextField();
        lblmatricule = new javax.swing.JLabel();

        lblnom.setText("nom");

        llblnummed.setText("numéro de médecin");

        lblprenom.setText("prénom");

        lbltel.setText("numéro de téléphone");

        txtnummed.setMinimumSize(new java.awt.Dimension(50, 20));
        txtnummed.setNextFocusableComponent(txtnom);
        txtnummed.setPreferredSize(new java.awt.Dimension(150, 30));
        txtnummed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnummedActionPerformed(evt);
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

        lblmatricule.setText("matricule");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblprenom)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(llblnummed)
                            .addComponent(lblnom)
                            .addComponent(lbltel)
                            .addComponent(lblmatricule))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txttel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtprenom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtnummed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtnom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtmatricule)))
                    .addComponent(btrech, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(185, Short.MAX_VALUE))
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
                    .addComponent(llblnummed)
                    .addComponent(txtnummed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmatricule, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(lblmatricule))
                .addGap(29, 29, 29)
                .addComponent(btrech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btdel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btmaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btmajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmajActionPerformed
        try {
            int nummed = Integer.parseInt(txtnummed.getText());
            String nom = txtnom.getText();
            String prenom = txtprenom.getText();
            String tel = txttel.getText();
            String matricule = txtmatricule.getText();
            Medecin med = new Medecin(nummed, matricule, nom, prenom, tel);
            medecinDAO.update(med);
            JOptionPane.showMessageDialog(this, "médecin mis à jour", "SUCCES", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            if (e.getMessage().contains("input")) {
                JOptionPane.showMessageDialog(this, "veuillez identifier le médecin cherché", "ERREUR", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btmajActionPerformed

    private void btrechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btrechActionPerformed
        try {
            int nummed = Integer.parseInt(txtnummed.getText());
            med = medecinDAO.read(nummed);
            txtnom.setText(med.getNom());
            txtprenom.setText(med.getPrenom());
            txttel.setText(med.getTel());
            txtmatricule.setText(med.getMatricule());
            JOptionPane.showMessageDialog(this, "médecin trouvé", "SUCCES", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            if (e.getMessage().contains("input")) {
                JOptionPane.showMessageDialog(this, "veuillez identifier le médecin cherché", "ERREUR", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btrechActionPerformed

    private void btdelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdelActionPerformed
        try {
            int nummed = Integer.parseInt(txtnummed.getText());
            medecinDAO.delete(med);
            txtnummed.setText("");
            txtnom.setText("");
            txtprenom.setText("");
            txttel.setText("");
            JOptionPane.showMessageDialog(this, "médecin effacé", "SUCCES", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            if (e.getMessage().contains("input")) {
                JOptionPane.showMessageDialog(this, "veuillez identifier le médecin cherché", "ERREUR", JOptionPane.ERROR_MESSAGE);
            } else {
                if (e.getMessage().contains("int")) {   //erreur d'intégrité
                    JOptionPane.showMessageDialog(this, "Vous ne pouvez pas supprimer un médecin déjà renseigné dans une prescription, veuillez d'abord supprimer sa/ses prescription(s)", "ERREUR", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btdelActionPerformed

    private void txtnummedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnummedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnummedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btdel;
    private javax.swing.JButton btmaj;
    private javax.swing.JButton btrech;
    private javax.swing.JLabel lblmatricule;
    private javax.swing.JLabel lblnom;
    private javax.swing.JLabel lblprenom;
    private javax.swing.JLabel lbltel;
    private javax.swing.JLabel llblnummed;
    private javax.swing.JTextField txtmatricule;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtnummed;
    private javax.swing.JTextField txtprenom;
    private javax.swing.JTextField txttel;
    // End of variables declaration//GEN-END:variables
}
