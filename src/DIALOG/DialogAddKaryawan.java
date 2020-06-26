package DIALOG;

import LIBRARY.Dialog;
import LIBRARY.Koneksi;
import LIBRARY.TempData;
import LIBRARY.Validasi;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;

public class DialogAddKaryawan extends javax.swing.JDialog {
    
    private Koneksi con = new Koneksi();
    private Dialog dialog = new Dialog();
    private Validasi valid = new Validasi();
    private String sql, sql1, username = "";
    private ResultSet rs;

    public DialogAddKaryawan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        showDetail();
    }

    private void showDetail() {
        try {
            if(TempData.getStatus()) {
                rs = con.getQuery("SELECT * FROM VIEW_KARYAWAN WHERE "
                        + "id_user ='" + TempData.getId() + "'");
                if(rs.next()) {
                    boxID.setText(rs.getString(1));
                    boxNama.setText(rs.getString(2));
                    boxJenis.setSelectedItem(rs.getString(3));
                    boxNo.setText(rs.getString(4));
                    boxAlamat.setText(rs.getString(5));
                    boxUsername.setText(rs.getString(6));
                    boxPassword.setText(rs.getString(7));
                    username = rs.getString(6);
                }
                boxID.setEditable(false);
                btnSimpan.setText("Ubah");
            }
        } catch (Exception e) {
            dialog.showError("Error Show Detail : " + e.getMessage());
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        boxID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        boxNama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        boxNo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        boxAlamat = new javax.swing.JTextField();
        boxJenis = new javax.swing.JComboBox<>();
        boxUsername = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        boxPassword = new javax.swing.JPasswordField();
        cbPass = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Karyawan");
        setBackground(new java.awt.Color(254, 254, 254));

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        jPanel2.setBackground(new java.awt.Color(22, 160, 133));

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/a_karyawan_130.png"))); // NOI18N
        jLabel1.setText("FORM ADD KARYAWAN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Lohit Devanagari", 0, 12)); // NOI18N
        jLabel2.setText("ID Karyawan");

        boxID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                onValidateKtp(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Lohit Devanagari", 0, 12)); // NOI18N
        jLabel3.setText("Nama Karyawan");

        boxNama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                onValidateNama(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lohit Devanagari", 0, 12)); // NOI18N
        jLabel4.setText("Jenis Kelamin");

        jLabel5.setFont(new java.awt.Font("Lohit Devanagari", 0, 12)); // NOI18N
        jLabel5.setText("No Telp");

        boxNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                onValidateTelp(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Lohit Devanagari", 0, 12)); // NOI18N
        jLabel6.setText("Alamat");

        boxJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Jenis Kelamin", "Laki - Laki", "Perempuan" }));
        boxJenis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        boxUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                onValidUsername(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Lohit Devanagari", 0, 12)); // NOI18N
        jLabel7.setText("Username");

        cbPass.setFont(new java.awt.Font("Lohit Devanagari", 0, 10)); // NOI18N
        cbPass.setText("Lihat Password");
        cbPass.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cbPass.setBorderPaintedFlat(true);
        cbPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onLihatPasswd(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Lohit Devanagari", 0, 12)); // NOI18N
        jLabel12.setText("Password");

        btnSimpan.setBackground(new java.awt.Color(22, 160, 133));
        btnSimpan.setForeground(new java.awt.Color(254, 254, 254));
        btnSimpan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/a_simpan.png"))); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSimpan.setOpaque(true);
        btnSimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onSimpan(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(boxID))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(boxNama))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(boxJenis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(boxNo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(boxAlamat))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(boxUsername))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(boxPassword))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(cbPass))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(boxJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(boxPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addComponent(cbPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

        setSize(new java.awt.Dimension(454, 585));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void onLihatPasswd(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onLihatPasswd
        if(cbPass.isSelected()) {
            boxPassword.setEchoChar((char)0);
        } else {
            boxPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_onLihatPasswd

    private void onSimpan(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onSimpan
        try {
            if(boxID.getText().isEmpty()) {
                dialog.showWarning("Mohon isi kolom id ketua \"NO KTP\"");
                boxID.requestFocus();
            } else if(boxNama.getText().isEmpty()) {
                dialog.showWarning("Mohon isi kolom nama");
                boxNama.requestFocus();
            } else if(boxJenis.getSelectedIndex() == 0) {
                dialog.showWarning("Mohon pilih jenis kelamin");
                boxJenis.requestFocus();
            } else if(boxNo.getText().isEmpty()) {
                dialog.showWarning("Mohon isi kolom no telpon");
                boxNo.requestFocus();
            } else if(boxAlamat.getText().isEmpty()) {
                dialog.showWarning("Mohon isi kolom alamat");
                boxAlamat.requestFocus();
            } else if(boxUsername.getText().isEmpty()) {
                dialog.showWarning("Mohon isi kolom username");
                boxUsername.requestFocus();
            } else if(boxPassword.getText().isEmpty()) {
                dialog.showWarning("Mohon isi kolom password");
                boxPassword.requestFocus();
            } else if(boxID.getText().length() < 16) {
                dialog.showWarning("No KTP harus 16 angka");
                boxID.requestFocus();
            } else {
                rs = con.getQuery("SELECT * FROM USER WHERE "
                    + "username ='" + boxUsername.getText() + "'");
                // Cek jika username terdaftar saat menambah atau mengubah
                // Jika terdaftar
                if(rs.next()) {
                    
                    // Jika saat menambah username sama maka tampilkan kesalahan
                    // Jika saat merubah username baru memiliki kesamaan maka tampilkan kesalahan
                    if(!username.equals(boxUsername.getText())) {
                        dialog.showWarning("Username dengan "
                            + boxUsername.getText() + " sudah terdaftar ");
                        
                    // Jika username tidak memiliki kesamaan
                    } else {
                        sql = "UPDATE USER SET "
                            + "username ='" + boxUsername.getText() + "', "
                                + "password ='" + boxPassword.getText() + "' "
                                    + "WHERE id_user ='" + boxID.getText() + "'";
                        sql1 = "UPDATE KARYAWAN SET "
                            + "nama_karyawan ='" + boxNama.getText() + "', "
                                + "jenis_kelamin ='" + boxJenis.getSelectedItem() + "', "
                                    + "no_telpon ='" + boxNo.getText() + "', "
                                        + "alamat ='" + boxAlamat.getText() + "' "
                                            + "WHERE id_user ='" + boxID.getText() + "'";
                        
                        con.setExecute(sql);
                        con.setExecute(sql1);
                        this.dispose();
                    }
                 
                // Jika tidak terdaftar
                } else {
                    // Lakukan update saat update berjalan
                    if(TempData.getStatus()) {
                        sql = "UPDATE USER SET "
                            + "username ='" + boxUsername.getText() + "', "
                                + "password ='" + boxPassword.getText() + "' "
                                    + "WHERE id_user ='" + boxID.getText() + "'";
                        sql1 = "UPDATE KARYAWAN SET "
                            + "nama_karyawan ='" + boxNama.getText() + "', "
                                + "jenis_kelamin ='" + boxJenis.getSelectedItem() + "', "
                                    + "no_telpon ='" + boxNo.getText() + "', "
                                        + "alamat ='" + boxAlamat.getText() + "' "
                                            + "WHERE id_user ='" + boxID.getText() + "'";
                    // Lakukan insert saat insert berjalan
                    } else {
                        rs = con.getQuery("SELECT * FROM KARYAWAN WHERE id_user ='" + boxID.getText() + "'");
                        // Cek id karyawan
                        // Jika id karyawan memiliki kesamaan maka tampilkan kesalahan
                        if(rs.next()) {
                            dialog.showWarning("ID Karyawan " + boxID.getText() + " sudah terdaftar");
                        } else {
                            sql = "INSERT INTO USER SET "
                                + "username ='" + boxUsername.getText() + "', "
                                    + "password ='" + boxPassword.getText() + "', "
                                        + "level ='Karyawan', "
                                            + "id_user ='" + boxID.getText() + "'";
                            sql1 = "INSERT INTO KARYAWAN SET "
                                + "nama_karyawan ='" + boxNama.getText() + "', "
                                    + "jenis_kelamin ='" + boxJenis.getSelectedItem() + "', "
                                        + "no_telpon ='" + boxNo.getText() + "', "
                                            + "alamat ='" + boxAlamat.getText() + "', "
                                                + "id_user ='" + boxID.getText() + "'";
                        }
                    }
                    con.setExecute(sql);
                    con.setExecute(sql1);
                    this.dispose();
                }
            }
        } catch (Exception e) {
            dialog.showError("Error simpan : " + e.getMessage());
        }
    }//GEN-LAST:event_onSimpan

    private void onValidUsername(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_onValidUsername
        char c = evt.getKeyChar();
        if(boxUsername.getText().length() > 24) {
            dialog.showWarning("Username terlalu panjang!");
            evt.consume();
        } else {
            if(c == KeyEvent.VK_SPACE) {
                dialog.showWarning("Username tidak boleh terdapat spasi!");
                evt.consume();
            }
        }
    }//GEN-LAST:event_onValidUsername

    private void onValidateTelp(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_onValidateTelp
        if(boxNo.getText().length() > 12) {
            dialog.showWarning("No Telpon maksimal 13 angka");
            evt.consume();
        } else {
            valid.validInt(evt);
        }
    }//GEN-LAST:event_onValidateTelp

    private void onValidateNama(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_onValidateNama
        valid.validChar(evt);
    }//GEN-LAST:event_onValidateNama

    private void onValidateKtp(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_onValidateKtp
        if(boxID.getText().length() > 15) {
            dialog.showWarning("No KTP hanya boleh 16 angka");
            evt.consume();
        } else {
            valid.validInt(evt);
        }
    }//GEN-LAST:event_onValidateKtp

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogAddKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            DialogAddKaryawan dialog = new DialogAddKaryawan(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField boxAlamat;
    private javax.swing.JTextField boxID;
    private javax.swing.JComboBox<String> boxJenis;
    private javax.swing.JTextField boxNama;
    private javax.swing.JTextField boxNo;
    private javax.swing.JPasswordField boxPassword;
    private javax.swing.JTextField boxUsername;
    private javax.swing.JLabel btnSimpan;
    private javax.swing.JCheckBox cbPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
