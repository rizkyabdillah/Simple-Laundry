package DIALOG;

import LIBRARY.Dialog;
import LIBRARY.Koneksi;
import LIBRARY.TempData;
import LIBRARY.Validasi;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class DialogSetLunas extends javax.swing.JDialog {

    public DialogSetLunas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        showTotal();
        boxBayar.requestFocus();
    }
    
    private final Dialog dialog = new Dialog();
    private final Koneksi con = new Koneksi();
    private int total = 0, kembali = 0, bayar = 0;
    private ResultSet rs;
    
    private void showTotal() {
        try {
            rs = con.getQuery("SELECT total FROM TAGIHAN WHERE id_tagihan ='" + TempData.getId() + "'");
            if(rs.next()) {
                total = rs.getInt(1);
                boxTotal.setText("Total : " + currencyRpFormat(total));
            }
        } catch (Exception e) {
            dialog.showError("Error show total : " + e.getMessage());
        }
    }
    
    public final String currencyRpFormat(int value) {
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);
        return kursIndonesia.format(value);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        boxTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        boxBayar = new javax.swing.JTextField();
        boxKembali = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Pembayaran");

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        jLabel4.setBackground(new java.awt.Color(22, 160, 133));
        jLabel4.setFont(new java.awt.Font("Lohit Devanagari", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/a_simpan.png"))); // NOI18N
        jLabel4.setText("Bayar");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.setOpaque(true);
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onClickBayar(evt);
            }
        });

        boxTotal.setEditable(false);
        boxTotal.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        boxTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        boxTotal.setText("Total : Rp. 0,00");

        jLabel2.setFont(new java.awt.Font("Lohit Devanagari", 0, 13)); // NOI18N
        jLabel2.setText("  Bayar");

        boxBayar.setFont(new java.awt.Font("Lohit Devanagari", 0, 13)); // NOI18N
        boxBayar.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 5, 2, 1));
        boxBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onBayar(evt);
            }
        });
        boxBayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                onValidBayar(evt);
            }
        });

        boxKembali.setEditable(false);
        boxKembali.setFont(new java.awt.Font("Lohit Devanagari", 0, 13)); // NOI18N
        boxKembali.setText("Rp. 0,00");
        boxKembali.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 5, 2, 1));

        jLabel3.setFont(new java.awt.Font("Lohit Devanagari", 0, 13)); // NOI18N
        jLabel3.setText("  Kembali");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(boxBayar))
                    .addComponent(boxTotal, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(boxKembali)))
                .addGap(3, 3, 3))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(boxTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(boxBayar)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(boxKembali)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(414, 208));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void onClickBayar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onClickBayar
        try {
            if(boxBayar.getText().equals("")) {
                dialog.showWarning("Kolom pembayaran kosong!");
            }else if(total > new Integer(boxBayar.getText())) {
                dialog.showWarning("Pembayaran anda kurang!");
                boxKembali.setText("Rp. 0,00");
            } else {
                kembali = new Integer(boxBayar.getText()) - total;
                boxKembali.setText(currencyRpFormat(kembali));
                
                con.setExecute("UPDATE TAGIHAN SET "
                    + "bayar ='" + boxBayar.getText() + "',"
                        + "kembali ='" + kembali + "', "
                            + "status ='Dibayar' "
                                + "WHERE id_tagihan ='" + TempData.getId() + "'");
                dispose();
            }
        } catch (Exception e) {
            dialog.showError("Error login : " +  e.getMessage());
        }
    }//GEN-LAST:event_onClickBayar

    private void onValidBayar(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_onValidBayar
        new Validasi().validInt(evt);
    }//GEN-LAST:event_onValidBayar

    private void onBayar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onBayar
        if(boxBayar.getText().equals("")) {
                dialog.showWarning("Kolom pembayaran kosong!");
        }else if(total > new Integer(boxBayar.getText())) {
            dialog.showWarning("Pembayaran anda kurang!");
            boxKembali.setText("Rp. 0,00");
        } else {
            kembali = new Integer(boxBayar.getText()) - total;
            boxKembali.setText(currencyRpFormat(kembali));
        }
    }//GEN-LAST:event_onBayar

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogSetLunas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DialogSetLunas dialog = new DialogSetLunas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField boxBayar;
    private javax.swing.JTextField boxKembali;
    private javax.swing.JTextField boxTotal;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
