package DIALOG;

import LIBRARY.DateTime;
import LIBRARY.Dialog;
import LIBRARY.Koneksi;
import LIBRARY.TempData;
import LIBRARY.Transaksi;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DialogPrintPreview extends javax.swing.JDialog {

    public DialogPrintPreview(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getSource();
        boxArea.setText(areaString());
    }
    
    private final Dialog dialog = new Dialog();
    private final Koneksi con = new Koneksi();
    
    private int total, bayar, kembali, qtyTotal = 0;
    private final ArrayList<Transaksi> array = new ArrayList<>();
    private String areaa, username, status;
    private ResultSet rs;
    
    private final String id_tagihan = TempData.getId();
    
    private void getSource() {
        try {
            rs = con.getQuery("SELECT * FROM VIEW_TAGIHAN WHERE id_tagihan ='" + id_tagihan + "'");
            if(rs.next()) {
                total = rs.getInt(6);
                bayar = rs.getInt(7);
                kembali = rs.getInt(8);
                username = rs.getString(4);
                status = rs.getString(9);
            }
            rs = con.getQuery("SELECT * FROM VIEW_DETAIL_TAGIHAN WHERE id_tagihan ='" + id_tagihan + "'");
            while(rs.next()) {
                array.add(new Transaksi(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6)));
                qtyTotal += rs.getInt(5);
            }
        } catch (Exception e) {
            System.err.println("Error getNama : " + e.getMessage());
        }
    }
    
    private String centerString (int width, String s) {
        return String.format("%-" + width  + "s %n", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    }
    
    private String areaString() {
        areaa = "\n" + centerString(50, "UD. STIKI LAUNDRY.") + 
               "" + centerString(50, "JL. Tidar, No.100  Malang") +
               "" + centerString(50, "Telp. 0332-7847283, Fax : ") + 
               "" + centerString(50, "MENERIMA SEGALA MACAM BENTUK") +
               "" + centerString(50, "KEBUTUHAN CUCIAN ANDA") +
               "" + centerString(50, "-------------------------------------------") +
               "" + String.format("%-18s %25s", "   " + new DateTime().getDateTimeStruck()
                       , id_tagihan + "/" + username + "/kasir\n");
        
        areaa += centerString(50, "-------------------------------------------");
        
        for(int i = 0; i < array.size(); i++) {
            areaa += String.format("%-43s%n", "   " + array.get(i).getNamapaket());
            
            areaa += String.format("%-15s%-15s%16s", 
                    "   " + array.get(i).getHarga(),
                        "  x  " + array.get(i).getQuantity(), 
                            array.get(i).getSubTotal());
            areaa += "\n";
        }
        
        areaa += centerString(50, "-------------------------------------------");
        areaa += String.format("%30s%16s%n", "TOTAL/QTY : Rp.", total + "/" + qtyTotal);
        areaa += String.format("%30s%16d%n", "BAYAR : Rp.", bayar);
        areaa += String.format("%30s%16d%n", "KEMBALI : Rp.", kembali);
        areaa += centerString(50, "-------------------------------------------");
        areaa += centerString(50,  status.toUpperCase());
        areaa += centerString(50, "-------------------------------------------");
        areaa += centerString(50, "TERIMAKASIH ATAS KUNJUNGAN ANDA");
        areaa += centerString(50, "JANGAN LUPA UNTUK DATANG KEMBALI");
        areaa += centerString(50, "TERIMA KASIH");
        
        return areaa;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        boxArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Print Preview");

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        jLabel4.setBackground(new java.awt.Color(22, 160, 133));
        jLabel4.setFont(new java.awt.Font("Lohit Devanagari", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/a_print.png"))); // NOI18N
        jLabel4.setText("Print");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.setOpaque(true);
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onPrint(evt);
            }
        });

        boxArea.setEditable(false);
        boxArea.setColumns(8);
        boxArea.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N
        boxArea.setRows(3);
        boxArea.setTabSize(4);
        jScrollPane1.setViewportView(boxArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE))
                .addGap(3, 3, 3))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                .addGap(3, 3, 3)
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

        setSize(new java.awt.Dimension(412, 469));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void onPrint(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onPrint
        try {
            this.dispose();
            boxArea.print();
        } catch (PrinterException e) {
            dialog.showError("Error login : " +  e.getMessage());
        }
    }//GEN-LAST:event_onPrint

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogPrintPreview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DialogPrintPreview dialog = new DialogPrintPreview(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextArea boxArea;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
