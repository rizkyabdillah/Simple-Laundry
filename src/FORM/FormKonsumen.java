package FORM;

import DIALOG.DialogAddKonsumen;
import LIBRARY.Dialog;
import LIBRARY.Koneksi;
import LIBRARY.ShowTabel;
import LIBRARY.TempData;
import javax.swing.JOptionPane;


public class FormKonsumen extends javax.swing.JDialog{
    
    private final Dialog dialog = new Dialog();
    private final Koneksi con = new Koneksi();
    private final ShowTabel tabell = new ShowTabel();
    private String id = "", nama = "";

    private final String header[] = {
        "Id Konsumen", "Nama Konsumen", "Jenis Kelamin", "No Telpon", "Tanggal Jadi Konsumen", "Alamat"
    };

    public FormKonsumen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        showTabel("");
    }
        
    private void showTabel(String key) {
        try {
            String sql = "SELECT * FROM KONSUMEN WHERE "
                    + "id_konsumen LIKE '%" + key + "%' OR "
                        + "nama_konsumen LIKE '%" + key + "%' OR "
                            + "jenis_kelamin LIKE '%" + key + "%' OR "
                                + "no_telpon LIKE '%" + key + "%' OR "
                                    + "alamat LIKE '%" + key + "%' OR "
                                        + "tgl_jadi_konsumen LIKE '%" + key + "%'";

            tabell.showTabel(tabel, header, sql);
            tabel.getColumnModel().getColumn(0).setMinWidth(100);
            tabel.getColumnModel().getColumn(1).setMinWidth(280);
            tabel.getColumnModel().getColumn(2).setMinWidth(100);
            tabel.getColumnModel().getColumn(3).setMinWidth(100);
            tabel.getColumnModel().getColumn(4).setMinWidth(120);
            tabel.getColumnModel().getColumn(5).setMinWidth(300);
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
        btnHapus2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnHapus3 = new javax.swing.JLabel();
        btnHapus4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Konsumen");

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

        btnHapus2.setBackground(new java.awt.Color(22, 160, 133));
        btnHapus2.setForeground(new java.awt.Color(254, 254, 254));
        btnHapus2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnHapus2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/a_tambah.png"))); // NOI18N
        btnHapus2.setText("Tambah");
        btnHapus2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHapus2.setOpaque(true);
        btnHapus2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onTambah(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(22, 160, 133));

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/a_konsumen_130.png"))); // NOI18N
        jLabel1.setText("FORM KELOLA KONSUMEN");

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

        btnHapus3.setBackground(new java.awt.Color(22, 160, 133));
        btnHapus3.setForeground(new java.awt.Color(254, 254, 254));
        btnHapus3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnHapus3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/a_edit.png"))); // NOI18N
        btnHapus3.setText("Ubah");
        btnHapus3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHapus3.setOpaque(true);
        btnHapus3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onUbah(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnHapus2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(btnHapus3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(btnHapus4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(boxCari, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
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
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(boxCari, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHapus2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHapus3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHapus4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            nama = tabel.getValueAt(tabel.getSelectedRow(), 1).toString();
        } catch (Exception e) {
            id = "";
            System.err.println("Error pilih tabel : " + e.getMessage());
        }
    }//GEN-LAST:event_onPilihTabel

    private void onTambah(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onTambah
        TempData.setStatus(false);
        new DialogAddKonsumen(null, true).setVisible(true);
        showTabel("");
        id = "";
    }//GEN-LAST:event_onTambah

    private void onUbah(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onUbah
        try {
            if(id.equals("")) {
                dialog.showWarning("Mohon pilih data yang akan diubah!");
            } else {
                TempData.setId(id);
                TempData.setStatus(true);
                new DialogAddKonsumen(null, true).setVisible(true);
                id = "";
            }
            showTabel("");
        } catch (Exception e) {
            dialog.showError("Error ubah : " + e.getMessage());
        }
    }//GEN-LAST:event_onUbah

    private void onHapus(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onHapus
        if(!id.equals("")) {
            int i = dialog.showConfirm("Apakah anda yakin ingin menghapus konsumen bernama " + nama + " ?");
            if(i == JOptionPane.YES_OPTION) {
                con.setExecute("DELETE FROM KONSUMEN WHERE id_konsumen ='" + id + "'");
            }
        } else {
            dialog.showWarning("Mohon pilih data yang akan dihapus!");
        }
        showTabel("");
    }//GEN-LAST:event_onHapus

    private void onCari(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_onCari
        showTabel(boxCari.getText());
    }//GEN-LAST:event_onCari

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormKonsumen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            FormKonsumen dialog = new FormKonsumen(new javax.swing.JFrame(), true);
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
    private static javax.swing.JLabel btnHapus2;
    private static javax.swing.JLabel btnHapus3;
    private static javax.swing.JLabel btnHapus4;
    private javax.swing.JLabel btnReload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}
