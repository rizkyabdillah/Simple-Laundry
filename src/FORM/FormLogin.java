package FORM;

import LIBRARY.Dialog;
import LIBRARY.Koneksi;
import LIBRARY.TempData;
import java.sql.ResultSet;

public class FormLogin extends javax.swing.JDialog{
    
    private final Koneksi con = new Koneksi();
    private final Dialog dialog = new Dialog();
    private ResultSet rs;

    public FormLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbl_header = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        boxUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        boxPassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Form Login");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                onClosing(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                onClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        jPanel2.setBackground(new java.awt.Color(22, 160, 133));

        lbl_header.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        lbl_header.setForeground(new java.awt.Color(254, 254, 254));
        lbl_header.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/a_login_120.png"))); // NOI18N
        lbl_header.setText("FORM LOGIN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_header, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Lohit Devanagari", 0, 10)); // NOI18N
        jLabel2.setText("Username");

        boxUsername.setFont(new java.awt.Font("Lohit Devanagari", 0, 13)); // NOI18N
        boxUsername.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 5, 2, 1));

        jLabel3.setFont(new java.awt.Font("Lohit Devanagari", 0, 10)); // NOI18N
        jLabel3.setText("password");

        boxPassword.setFont(new java.awt.Font("Lohit Devanagari", 0, 13)); // NOI18N
        boxPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 5, 2, 1));
        boxPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onEnterPassword(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(22, 160, 133));
        jLabel4.setFont(new java.awt.Font("Lohit Devanagari", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/login.png"))); // NOI18N
        jLabel4.setText("Login");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.setOpaque(true);
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onLogin(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boxUsername)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boxPassword)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(boxUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel3)
                .addGap(2, 2, 2)
                .addComponent(boxPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
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

        setSize(new java.awt.Dimension(510, 338));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void onLogin(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onLogin
        try {
            if(boxUsername.getText().isEmpty()) {
                dialog.showWarning("Mohon isi kolom username!");
                boxUsername.requestFocus();
            } else if(boxPassword.getText().isEmpty()) {
                dialog.showWarning("Mohon isi kolom password!");
                boxPassword.requestFocus();
            } else {
                String username = boxUsername.getText();
                String password = boxPassword.getText();
                
                rs = con.getQuery("SELECT * FROM USER WHERE username='" + username + "'");
                if(rs.next()) {
                    if(rs.getString("username").equals(username)) {
                        
                        rs = con.getQuery("SELECT * FROM USER WHERE username='" + username + "' AND password='" + password + "'");
                        if(rs.next()){
                            if(rs.getString("password").equals(password)) {
                                
                                TempData.setIdUser(rs.getString("id_user"));
                                switch(rs.getString("level")) {
                                    case "Admin" :
                                        new FormMainAdmin().setVisible(true);
                                        break;
                                    case "Karyawan" :
                                        new FormMainKaryawan().setVisible(true);
                                        break;
                                }
                                this.dispose();
                            } else {
                                dialog.showWarning("Password anda salah!");
                                boxPassword.requestFocus();
                            }
                        }
                    } else {
                        dialog.showWarning("Username anda salah!");
                        boxUsername.requestFocus();
                    }
                }
            }
        } catch (Exception e) {
            dialog.showError("Error login : " +  e.getMessage());
        }
    }//GEN-LAST:event_onLogin

    private void onClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_onClosing

        int i = dialog.showConfirm("Apakah anda yakin ingin keluar ?");
        if(i == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_onClosing

    private void onClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_onClosed
        
    }//GEN-LAST:event_onClosed

    private void onEnterPassword(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onEnterPassword
        onLogin(null);
    }//GEN-LAST:event_onEnterPassword

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FormLogin dialog = new FormLogin(new javax.swing.JFrame(), true);
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
    private javax.swing.JPasswordField boxPassword;
    private javax.swing.JTextField boxUsername;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_header;
    // End of variables declaration//GEN-END:variables
}
