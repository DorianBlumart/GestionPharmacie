package pharmacie.graph;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import pharmacie.DAO.MedecinDAO;
import pharmacie.metier.Medecin;

public class CreaMedecin extends javax.swing.JPanel {

    MedecinDAO medecinDAO = null;

    public CreaMedecin() {
        initComponents();
    }

    public void setMedecinDAO(MedecinDAO medecinDAO) {
        this.medecinDAO = medecinDAO;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblcode = new javax.swing.JLabel();
        llblnummed = new javax.swing.JLabel();
        lblprenom = new javax.swing.JLabel();
        lbltel = new javax.swing.JLabel();
        txtnumpat = new javax.swing.JTextField();
        txtprenom = new javax.swing.JTextField();
        txtnom = new javax.swing.JTextField();
        txttel = new javax.swing.JTextField();
        btcreate = new javax.swing.JButton();
        txtmatricule = new javax.swing.JTextField();
        lblmatricule = new javax.swing.JLabel();

        lblcode.setText("nom");

        llblnummed.setText("numéro de médecin");

        lblprenom.setText("prénom");

        lbltel.setText("numéro de téléphone");

        txtnumpat.setEditable(false);
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

        btcreate.setText("création");
        btcreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcreateActionPerformed(evt);
            }
        });

        lblmatricule.setText("matricule");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btcreate)
                    .addComponent(lblprenom)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(llblnummed)
                            .addComponent(lblcode)
                            .addComponent(lbltel)
                            .addComponent(lblmatricule))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txttel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtprenom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtnumpat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtnom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtmatricule))))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(llblnummed)
                    .addComponent(txtnumpat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcode)
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
                    .addComponent(txtmatricule, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblmatricule))
                .addGap(44, 44, 44)
                .addComponent(btcreate)
                .addContainerGap(91, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtnumpatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumpatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumpatActionPerformed

    private void btcreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcreateActionPerformed
        try {
            String nom = txtnom.getText();
            String prenom = txtprenom.getText();
            String tel = txttel.getText();
            String matricule = txtmatricule.getText();
            Medecin medecin = new Medecin(0, matricule,nom, prenom, tel);
            try {
                medecin = medecinDAO.create(medecin);
                txtnumpat.setText("" + medecin.getIdmed());
                JOptionPane.showMessageDialog(this, "medecin créé", "SUCCES", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException f) {
                if (f.getMessage().contains("UK")) {
                    JOptionPane.showMessageDialog(this, "medecin déjà existant", "ERREUR", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (f.getMessage().contains("grand")) { //si on dépasse la taille du varchar 
                        JOptionPane.showMessageDialog(this, "le matricule dépasse la taille limite de 5 caractères", "ERREUR", JOptionPane.ERROR_MESSAGE);
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
        txtnumpat.setText("");
        txtnom.setText("");
        txtprenom.setText("");
        txttel.setText("");
        txtmatricule.setText("");

    }//GEN-LAST:event_btcreateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btcreate;
    private javax.swing.JLabel lblcode;
    private javax.swing.JLabel lblmatricule;
    private javax.swing.JLabel lblprenom;
    private javax.swing.JLabel lbltel;
    private javax.swing.JLabel llblnummed;
    private javax.swing.JTextField txtmatricule;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtnumpat;
    private javax.swing.JTextField txtprenom;
    private javax.swing.JTextField txttel;
    // End of variables declaration//GEN-END:variables
}
