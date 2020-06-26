package FORM;

import DIALOG.DialogSetLunas;
import DIALOG.DialogShowDetail;
import LIBRARY.Dialog;
import LIBRARY.Koneksi;
import LIBRARY.ShowTabel;
import LIBRARY.TempData;
import javax.swing.JOptionPane;


public class FormTagihan extends javax.swing.JDialog{
    
    private final Dialog dialog = new Dialog();
    private final Koneksi con = new Koneksi();
    private final ShowTabel tabell = new ShowTabel();
    private String id = "", sql, prefix, column;

    private final String header[] = {
        "Id Tagihan", "Nama Konsumen", "Nama Karyawan", "Tanggal Transaksi", "Total", "Bayar", "Kembali", "Status"
    };

    public FormTagihan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        showTabel("");
    }
        
    private void showTabel(String key) {
        try {
            String status = (boxStatus.getSelectedIndex() == 0) ? "Dibayar" : "Belum Bayar";
            // Jika user adalah admin, maka tampilkan semua tagihan
            // 0000000000000000 adalah id user untuk admin
            column = "id_tagihan, nama_konsumen, username, tgl_transaksi, total, bayar, kembali, status";
            if(TempData.getIdUser().equals("0000000000000000")) {
                prefix = "SELECT " + column + " FROM VIEW_TAGIHAN WHERE "
                        + "status ='" + status + "' AND (";
            } else {
                prefix = "SELECT " + column + " FROM VIEW_TAGIHAN WHERE "
                    + "id_user ='" + TempData.getIdUser() + "' AND "
                        + "status ='" + status + "' AND (";
            }
            sql = prefix + "id_tagihan LIKE '%" + key + "%' OR "
                + "nama_konsumen LIKE '%" + key + "%' OR "
                    + "username LIKE '%" + key + "%' OR "
                        + "tgl_transaksi LIKE '%" + key + "%' OR "
                            + "total LIKE '%" + key + "%' OR "
                                + "bayar LIKE '%" + key + "%' OR "
                                    + "kembali LIKE '%" + key + "%')";

            tabell.showTabel(tabel, header, sql);
            tabel.getColumnModel().getColumn(0).setMinWidth(100);
            tabel.getColumnModel().getColumn(1).setMinWidth(200);
            tabel.getColumnModel().getColumn(2).setMinWidth(200);
            tabel.getColumnModel().getColumn(3).setMinWidth(100);
            tabel.getColumnModel().getColumn(4).setMinWidth(100);
            tabel.getColumnModel().getColumn(5).setMinWidth(100);
            tabel.getColumnModel().getColumn(6).setMinWidth(100);
        } catch (Exception e) {
            dialog.showError("Error tabel : " + e.getMessage());
        }
   
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        boxCari = new javax.swing.JTextField();
        btnReload = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnHapus4 = new javax.swing.JLabel();
        btnHapus5 = new javax.swing.JLabel();
        btnHapus6 = new javax.swing.JLabel();
        boxStatus = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Tagihan");

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        boxCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                onCari(evt);
            }
        });

        btnReload.setBackground(new java.awt.Color(22, 160, 133));
        btnReload.setForeground(new java.awt.Color(254, 254, 254));
        btnReload.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnReload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/a_segarkan.png"))); // NOI18N
        btnReload.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReload.setOpaque(true);
        btnReload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onReload(evt);
            }
        });

        tabel.setBorder(null);
        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {}
            },
            new String [] {

            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onPilihTabel(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        jPanel2.setBackground(new java.awt.Color(22, 160, 133));

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/a_kelola_transaksi_130.png"))); // NOI18N
        jLabel1.setText("FORM KELOLA TRANSAKSI");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
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

        btnHapus4.setBackground(new java.awt.Color(22, 160, 133));
        btnHapus4.setForeground(new java.awt.Color(254, 254, 254));
        btnHapus4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnHapus4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/a_hapus.png"))); // NOI18N
        btnHapus4.setText("Hapus");
        btnHapus4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHapus4.setOpaque(true);
        btnHapus4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onHapus(evt);
            }
        });

        btnHapus5.setBackground(new java.awt.Color(22, 160, 133));
        btnHapus5.setForeground(new java.awt.Color(254, 254, 254));
        btnHapus5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnHapus5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/a_detail.png"))); // NOI18N
        btnHapus5.setText("Lihat Detail");
        btnHapus5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHapus5.setOpaque(true);
        btnHapus5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onDetail(evt);
            }
        });

        btnHapus6.setBackground(new java.awt.Color(22, 160, 133));
        btnHapus6.setForeground(new java.awt.Color(254, 254, 254));
        btnHapus6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnHapus6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/a_check.png"))); // NOI18N
        btnHapus6.setText("Set Lunas");
        btnHapus6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHapus6.setOpaque(true);
        btnHapus6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onSetLunas(evt);
            }
        });

        boxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dibayar", "Belum Bayar" }));
        boxStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        boxStatus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onSelectStatus(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnHapus4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(btnHapus5, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(btnHapus6, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(boxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(boxCari, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                        .addGap(3, 3, 3)
                        .addComponent(btnReload, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(boxStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxCari, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHapus4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHapus5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHapus6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnReload, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
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

        setSize(new java.awt.Dimension(1320, 464));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void onReload(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onReload
        showTabel("");
        boxCari.setText("");
    }//GEN-LAST:event_onReload

    private void onPilihTabel(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onPilihTabel
        try {
            id = tabel.getValueAt(tabel.getSelectedRow(), 0).toString();
        } catch (Exception e) {
            id = "";
            System.err.println("Error pilih tabel : " + e.getMessage());
        }
    }//GEN-LAST:event_onPilihTabel

    private void onHapus(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onHapus
        if(!id.equals("")) {
            int i = dialog.showConfirm("Apakah anda yakin ingin menghapus tagihan dengan id " + id + " ?");
            if(i == JOptionPane.YES_OPTION) {
                con.setExecute("DELETE FROM TAGIHAN WHERE id_tagihan ='" + id + "'");
            }
        } else {
            dialog.showWarning("Mohon pilih data yang akan dihapus!");
        }
        showTabel("");
    }//GEN-LAST:event_onHapus

    private void onCari(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_onCari
        showTabel(boxCari.getText());
    }//GEN-LAST:event_onCari

    private void onDetail(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onDetail
        if(!id.equals("")) {
            TempData.setId(id);
            new DialogShowDetail(null, true).setVisible(true);
        } else {
            dialog.showWarning("Mohon pilih data yang akan di set bayar!");
        }
        showTabel("");
        id = "";
    }//GEN-LAST:event_onDetail

    private void onSetLunas(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onSetLunas
        if(!id.equals("")) {
            if(boxStatus.getSelectedIndex() == 0) {
                dialog.showWarning("Mohon pilih data yang belum dibayar!");
            } else {
                int i = dialog.showConfirm("Apakah anda yakin ingin mengganti data menjadi Lunas?");
                if(i == JOptionPane.YES_OPTION) {
                    TempData.setId(id);
                    new DialogSetLunas(null, true).setVisible(true);
                }
            }
        } else {
            dialog.showWarning("Mohon pilih data yang akan di set bayar!");
        }
        showTabel("");
        id = "";
    }//GEN-LAST:event_onSetLunas

    private void onSelectStatus(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onSelectStatus
        showTabel("");
        boxCari.setText("");
    }//GEN-LAST:event_onSelectStatus

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTagihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            FormTagihan dialog = new FormTagihan(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField boxCari;
    private javax.swing.JComboBox<String> boxStatus;
    private static javax.swing.JLabel btnHapus4;
    private static javax.swing.JLabel btnHapus5;
    private static javax.swing.JLabel btnHapus6;
    private javax.swing.JLabel btnReload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}
