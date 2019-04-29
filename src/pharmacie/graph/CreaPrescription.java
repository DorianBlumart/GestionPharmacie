package pharmacie.graph;

import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import pharmacie.DAO.InfosDAO;
import pharmacie.DAO.PatientDAO;
import pharmacie.DAO.PrescriptionDAO;
import pharmacie.metier.Infos;
import pharmacie.metier.Prescription;

public class CreaPrescription extends javax.swing.JPanel {

    PatientDAO patientDAO = null;
    PrescriptionDAO prescriptionDAO = null;
    InfosDAO infosDAO = null;

    public CreaPrescription() {
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

        lblnummed = new javax.swing.JLabel();
        llblnumpres = new javax.swing.JLabel();
        lblnumpat = new javax.swing.JLabel();
        lblquantite = new javax.swing.JLabel();
        txtnumpres = new javax.swing.JTextField();
        txtnumpat = new javax.swing.JTextField();
        txtnummed = new javax.swing.JTextField();
        txtquant = new javax.swing.JTextField();
        btcreate = new javax.swing.JButton();
        txtunite = new javax.swing.JTextField();
        lblunite = new javax.swing.JLabel();
        txtnummedoc = new javax.swing.JTextField();
        lblnummedoc = new javax.swing.JLabel();
        txtdate = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        lblnummed.setText("numéro du médecin");

        llblnumpres.setText("numéro de prescription");

        lblnumpat.setText("numéro du patient");

        lblquantite.setText("quantité");

        txtnumpres.setEditable(false);
        txtnumpres.setMinimumSize(new java.awt.Dimension(50, 20));
        txtnumpres.setNextFocusableComponent(txtnummed);
        txtnumpres.setPreferredSize(new java.awt.Dimension(150, 30));
        txtnumpres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumpresActionPerformed(evt);
            }
        });

        txtnumpat.setMinimumSize(new java.awt.Dimension(50, 20));
        txtnumpat.setNextFocusableComponent(txtquant);
        txtnumpat.setPreferredSize(new java.awt.Dimension(150, 30));

        txtnummed.setMinimumSize(new java.awt.Dimension(50, 20));
        txtnummed.setNextFocusableComponent(txtnumpat);
        txtnummed.setPreferredSize(new java.awt.Dimension(150, 30));

        txtquant.setMinimumSize(new java.awt.Dimension(50, 20));
        txtquant.setPreferredSize(new java.awt.Dimension(150, 30));

        btcreate.setText("création");
        btcreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcreateActionPerformed(evt);
            }
        });

        lblunite.setText("unité");

        lblnummedoc.setText("numéro du médicament");

        jLabel1.setText("date (YYYY-MM-DD)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblnumpat)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(llblnumpres)
                            .addComponent(lblnummed)
                            .addComponent(lblquantite)
                            .addComponent(lblunite)
                            .addComponent(lblnummedoc)
                            .addComponent(jLabel1)
                            .addComponent(btcreate))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtdate)
                            .addComponent(txtnummedoc)
                            .addComponent(txtquant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtnumpat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtnumpres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtnummed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtunite))))
                .addContainerGap(90, Short.MAX_VALUE))
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
                    .addComponent(lblnummed)
                    .addComponent(txtnummed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblnumpat)
                    .addComponent(txtnumpat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnummedoc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblnummedoc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblquantite)
                    .addComponent(txtquant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblunite)
                    .addComponent(txtunite, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btcreate)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtnumpresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumpresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumpresActionPerformed

    private void btcreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcreateActionPerformed
        try {
            int idmed = Integer.parseInt(txtnummed.getText());
            int idpat = Integer.parseInt(txtnumpat.getText());
            int idmedoc = Integer.parseInt(txtnummedoc.getText());
            int q = Integer.parseInt(txtquant.getText());
            String unite = txtunite.getText();
            String date = txtdate.getText();
            LocalDate datepres = LocalDate.parse(date);

            boolean integrityPresc = true;    //pour tester si l'erreur d'intégrité vient d'info ou prescription et agir conséquence
            Prescription prescription = new Prescription(0, datepres, idmed, idpat);
            try {
                prescription = prescriptionDAO.create(prescription);    //on récup la prescription de la DB donc avec l'ID
                integrityPresc = false;
                Infos infos = new Infos(unite, q, prescription.getIdpres(), idmedoc, 0);
                infos = infosDAO.create(infos);
                txtnumpres.setText("" + prescription.getIdpres());
                JOptionPane.showMessageDialog(this, "prescription créée", "SUCCES", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                if (e.getMessage().contains("int") && !integrityPresc) {   //intégrité, alors on supprime la prescription car il y a une erreur au niveau de la création infos (mauvais médicament entré par exemple)
                    prescriptionDAO.delete(prescription);
                } else {
                    if (e.getMessage().contains("parsed")) {
                        JOptionPane.showMessageDialog(this, "date entrée invalide", "ERREUR", JOptionPane.ERROR_MESSAGE);        //erreur date                    
                    } else {
                        JOptionPane.showMessageDialog(this, "informations incorrectes, veuillez vérifier et réessayer", "ERREUR", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

        } catch (Exception e) {
            if (e.getMessage().contains("input")) {
                JOptionPane.showMessageDialog(this, "veuillez remplir tous les champs", "ERREUR", JOptionPane.ERROR_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
        txtnumpres.setText("");
        txtnummed.setText("");
        txtnumpat.setText("");
        txtquant.setText("");
        txtnummedoc.setText("");
        txtunite.setText("");
        txtdate.setText("");
    }//GEN-LAST:event_btcreateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btcreate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblnummed;
    private javax.swing.JLabel lblnummedoc;
    private javax.swing.JLabel lblnumpat;
    private javax.swing.JLabel lblquantite;
    private javax.swing.JLabel lblunite;
    private javax.swing.JLabel llblnumpres;
    private javax.swing.JTextField txtdate;
    private javax.swing.JTextField txtnummed;
    private javax.swing.JTextField txtnummedoc;
    private javax.swing.JTextField txtnumpat;
    private javax.swing.JTextField txtnumpres;
    private javax.swing.JTextField txtquant;
    private javax.swing.JTextField txtunite;
    // End of variables declaration//GEN-END:variables
}
