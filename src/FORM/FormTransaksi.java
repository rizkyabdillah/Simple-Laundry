package FORM;

import DIALOG.DialogPilihKonsumen;
import DIALOG.DialogPrintPreview;
import LIBRARY.DateTime;
import LIBRARY.Dialog;
import LIBRARY.KelolaTransaksi;
import LIBRARY.Koneksi;
import LIBRARY.TempData;
import LIBRARY.Validasi;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;


public class FormTransaksi extends javax.swing.JDialog{
    
    private final Dialog dialog = new Dialog();
    private final Koneksi con = new Koneksi();
    private final DateTime date = new DateTime();
    private final Validasi valid = new Validasi();
    private ArrayList<String> id_paket = new ArrayList<>();
    private ArrayList<Integer> hrg_paket = new ArrayList<>();
    private KelolaTransaksi transaksi = new KelolaTransaksi();
    private ResultSet rs;
    private String id = "", qty = "", charr = "", status = "";
    private int kembali = 0, bayar = 0;
    private boolean isEdit = false;

    private void showDate() {
        try {
            Thread tr = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            lbl_date.setText(date.getDateFull() + " " + date.getTime());
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            dialog.showInfo(ex.getMessage());
                        }
                    }
                }
            });
            tr.start();
        } catch (Exception e) {
            dialog.showError("Error show date : " + e.getMessage());
        }
    }

    private final String header[] = {
        "Id Paket", "Quantity", "Sub Total"
    };

    public FormTransaksi(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        showDate();
        showComponen();
        reloadNoTagihan();
        showTabel();
//        showTabel("");
    }
    
    private void showComponen() {
        try {
            id_paket.clear();
            hrg_paket.clear();
            rs = con.getQuery("SELECT id_paket, nama_paket, harga_perkg FROM PAKET");
            while(rs.next()) {
                boxPilihPaket.addItem(rs.getString(2));
                id_paket.add(rs.getString(1));
                hrg_paket.add(rs.getInt(3));
            }            
        } catch (Exception e) {
            dialog.showError("Error show paket : " + e.getMessage());
        }
    }
    
    private void reloadNoTagihan() {
        charr = "";
        String character = "0123456789";
        for(int i = 0; i < 8; i++) {
            charr += character.charAt(new Random().nextInt(character.length()));
        }
        lblNoTagihan.setText("No. Tagihan : " + charr);
    }
        
    private void showTabel() {
        try {
            transaksi.showTabel(tabel, header);
            tabel.getColumnModel().getColumn(0).setMinWidth(200);
            tabel.getColumnModel().getColumn(1).setMinWidth(150);
            tabel.getColumnModel().getColumn(2).setMinWidth(150);
        } catch (Exception e) {
            dialog.showError("Error tabel : " + e.getMessage());
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
    
    private void showTotal() {
        boxTotal.setText(currencyRpFormat(transaksi.getTotal()));
    }
    
    private void save(boolean is_print) {
        try {
            if(boxIDKonsumen.getText().isEmpty()) {
                dialog.showWarning("Mohon pilih id konsumen");
            } else if(transaksi.getTotal() == 0) {
                dialog.showWarning("Transaksi laundry masih kosong!");
                boxKembali.setText("Rp. 0,00");
            } else {
                int i = dialog.showConfirm("Apakah anda yakin ingin menyimpan?");
                if(i == JOptionPane.YES_OPTION) {
                    int j = dialog.showConfirm("Apakah pembayaran dilakukan secara lunas?");
                    if(j == JOptionPane.YES_OPTION) {
                        if(boxBayar.getText().equals("")) {
                            dialog.showWarning("Kolom pembayaran kosong!");
                            boxBayar.requestFocus();
                        }else if(transaksi.getTotal() > new Integer(boxBayar.getText())) {
                            dialog.showWarning("Pembayaran anda kurang!");
                            boxKembali.setText("Rp. 0,00");
                        } else {
                            kembali = new Integer(boxBayar.getText()) - transaksi.getTotal();
                            boxKembali.setText(currencyRpFormat(kembali));
                            bayar = new Integer(boxBayar.getText());
                            status = "Dibayar";
                            con.setExecute("INSERT INTO TAGIHAN VALUES('"
                                + charr + "','" + boxIDKonsumen.getText() + "','" + TempData.getIdUser() + "','"
                                    + date.getDateSQL()+ "','" + transaksi.getTotal() + "','" + bayar + "','" 
                                        + kembali + "','" + status + "')");

                            for(int k = 0; k < tabel.getRowCount() - 1; k++) {
                                con.setExecute("INSERT INTO DETAIL_TAGIHAN VALUES('"
                                    + charr + "','" + tabel.getValueAt(k, 0) + "','"
                                        + tabel.getValueAt(k, 1) + "','" + tabel.getValueAt(k, 2) + "')");
                            }
                            if(is_print) {
                                TempData.setId(charr);
                                new DialogPrintPreview(null, true).setVisible(true);
                            }
                            transaksi.clearAll();
                            showTotal();
                            boxBayar.setText("");
                            kembali = 0;
                            bayar = 0;
                            boxKembali.setText("Rp. 0,00");
                            boxIDKonsumen.setText("");
                            onReload(null);
                            reloadNoTagihan();
                        }
                    } else {
                        kembali = 0;
                        bayar = 0;
                        status = "Belum Bayar";
                        con.setExecute("INSERT INTO TAGIHAN VALUES('"
                            + charr + "','" + boxIDKonsumen.getText() + "','" + TempData.getIdUser() + "','"
                                + date.getDateSQL()+ "','" + transaksi.getTotal() + "','" + bayar + "','" 
                                    + kembali + "','" + status + "')");

                        for(int k = 0; k < tabel.getRowCount() - 1; k++) {
                            con.setExecute("INSERT INTO DETAIL_TAGIHAN VALUES('"
                                + charr + "','" + tabel.getValueAt(k, 0) + "','"
                                    + tabel.getValueAt(k, 1) + "','" + tabel.getValueAt(k, 2) + "')");
                        }
                        if(is_print) {
                            TempData.setId(charr);
                            new DialogPrintPreview(null, true).setVisible(true);
                        }
                        transaksi.clearAll();
                        showTotal();
                        boxBayar.setText("");
                        kembali = 0;
                        bayar = 0;
                        boxKembali.setText("Rp. 0,00");
                        boxIDKonsumen.setText("");
                        onReload(null);
                        reloadNoTagihan();
                    }
                    
                }
            }
        } catch (Exception e) {
            dialog.showError("Error save : " + e.getMessage());
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnHapus4 = new javax.swing.JLabel();
        btnHapus5 = new javax.swing.JLabel();
        btnHapus6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        boxIDKonsumen = new javax.swing.JTextField();
        btnHapus7 = new javax.swing.JLabel();
        boxPilihPaket = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        boxQty = new javax.swing.JTextField();
        lblNoTagihan = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        boxBayar = new javax.swing.JTextField();
        boxKembali = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        boxTotal = new javax.swing.JTextField();
        lbl_date = new javax.swing.JLabel();
        btnHapus8 = new javax.swing.JLabel();
        btnHapus9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Transaksi");

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

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
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/a_transaksi_130.png"))); // NOI18N
        jLabel1.setText("FORM TRANSAKSI");

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
        btnHapus4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/a_edit.png"))); // NOI18N
        btnHapus4.setText("Edit");
        btnHapus4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHapus4.setOpaque(true);
        btnHapus4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onEdit(evt);
            }
        });

        btnHapus5.setBackground(new java.awt.Color(22, 160, 133));
        btnHapus5.setForeground(new java.awt.Color(254, 254, 254));
        btnHapus5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnHapus5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/a_segarkan.png"))); // NOI18N
        btnHapus5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHapus5.setOpaque(true);
        btnHapus5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onReload(evt);
            }
        });

        btnHapus6.setBackground(new java.awt.Color(22, 160, 133));
        btnHapus6.setForeground(new java.awt.Color(254, 254, 254));
        btnHapus6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnHapus6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/a_hapus.png"))); // NOI18N
        btnHapus6.setText("Hapus");
        btnHapus6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHapus6.setOpaque(true);
        btnHapus6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onHapus(evt);
            }
        });

        jLabel2.setText("ID Konsumen");

        boxIDKonsumen.setEditable(false);

        btnHapus7.setBackground(new java.awt.Color(22, 160, 133));
        btnHapus7.setForeground(new java.awt.Color(254, 254, 254));
        btnHapus7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnHapus7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/a_cari.png"))); // NOI18N
        btnHapus7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHapus7.setOpaque(true);
        btnHapus7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onPilihKonsumen(evt);
            }
        });

        boxPilihPaket.setMaximumRowCount(3);
        boxPilihPaket.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Paket" }));
        boxPilihPaket.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        boxPilihPaket.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boxPilihPaket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onPilihPaket(evt);
            }
        });

        jLabel3.setText("|  Paket");

        boxQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onEnterQty(evt);
            }
        });
        boxQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                onValidate(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                onFocusBayar(evt);
            }
        });

        lblNoTagihan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNoTagihan.setText("No. Tagihan : 88927382");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Bayar : ");

        boxBayar.setFont(new java.awt.Font("Lohit Devanagari", 1, 13)); // NOI18N
        boxBayar.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        boxBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onBayar(evt);
            }
        });
        boxBayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                onValidateBayar(evt);
            }
        });

        boxKembali.setEditable(false);
        boxKembali.setFont(new java.awt.Font("Lohit Devanagari", 1, 13)); // NOI18N
        boxKembali.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        boxKembali.setText("Rp. 0,00");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Kembali : ");

        boxTotal.setEditable(false);
        boxTotal.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        boxTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        boxTotal.setText("Rp. 0,00");

        lbl_date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_date.setText("Date");

        btnHapus8.setBackground(new java.awt.Color(22, 160, 133));
        btnHapus8.setForeground(new java.awt.Color(254, 254, 254));
        btnHapus8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnHapus8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/a_print.png"))); // NOI18N
        btnHapus8.setText("Simpan & Cetak");
        btnHapus8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHapus8.setOpaque(true);
        btnHapus8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onSimpanCetak(evt);
            }
        });

        btnHapus9.setBackground(new java.awt.Color(22, 160, 133));
        btnHapus9.setForeground(new java.awt.Color(254, 254, 254));
        btnHapus9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnHapus9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/a_simpan.png"))); // NOI18N
        btnHapus9.setText("Simpan");
        btnHapus9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHapus9.setOpaque(true);
        btnHapus9.addMouseListener(new java.awt.event.MouseAdapter() {
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
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boxTotal)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(boxBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(boxKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHapus9, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(btnHapus8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(boxIDKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(btnHapus7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(boxPilihPaket, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(boxQty, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNoTagihan, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHapus4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(btnHapus6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(btnHapus5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(boxTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNoTagihan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnHapus4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHapus5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHapus6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(boxIDKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHapus7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(boxPilihPaket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(boxQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_date, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        setSize(new java.awt.Dimension(1320, 530));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void onPilihTabel(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onPilihTabel
        try {
            id = tabel.getValueAt(tabel.getSelectedRow(), 0).toString();
            qty = tabel.getValueAt(tabel.getSelectedRow(), 1).toString();
        } catch (Exception e) {
            id = "";
            System.err.println("Error pilih tabel : " + e.getMessage());
        }
    }//GEN-LAST:event_onPilihTabel

    private void onPilihKonsumen(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onPilihKonsumen
        new DialogPilihKonsumen(null, true).setVisible(true);
        boxIDKonsumen.setText(TempData.getId());
    }//GEN-LAST:event_onPilihKonsumen

    private void onPilihPaket(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onPilihPaket
        if(boxPilihPaket.getSelectedIndex() != 0) {
            boxQty.requestFocus();
        }
    }//GEN-LAST:event_onPilihPaket

    private void onReload(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onReload
        showTabel();
        boxPilihPaket.setSelectedIndex(0);
        boxQty.setText("");
        id = "";
        qty = "";
        isEdit = false;
        boxPilihPaket.setEnabled(true);
    }//GEN-LAST:event_onReload

    private void onEnterQty(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onEnterQty
        try {
            int i = boxPilihPaket.getSelectedIndex();
            if(boxQty.getText().equals("")){
                dialog.showWarning("Banyak cucian tidak boleh kosong!");
            } else if(boxQty.getText().equals("0")) {
                dialog.showWarning("Banyak cucian tidak boleh nol (0)!");
            } else if(i == 0) {
                dialog.showWarning("Mohon pilih paket terlebih dahulu!");
            } else {
                if(transaksi.isFoundData(id_paket.get(i - 1))) {
                    if(isEdit) {
                        transaksi.editData(transaksi.getIndex(), 
                            new Integer(boxQty.getText()), 
                                hrg_paket.get(i - 1));
                    } else {
                        transaksi.replaceData(transaksi.getIndex(), 
                            new Integer(boxQty.getText()), 
                                hrg_paket.get(i - 1));
                    }
                } else {
                    transaksi.addData(id_paket.get(i - 1), 
                            new Integer(boxQty.getText()), 
                                hrg_paket.get(i - 1));
                }
                showTotal();
                onReload(null);
            }
        } catch (Exception e) {
            dialog.showError("Error enter : " + e.getMessage());
        }
    }//GEN-LAST:event_onEnterQty

    private void onValidate(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_onValidate
        if(boxQty.getText().length() > 1) {
            evt.consume();
            dialog.showWarning("Banyak laundry tidak boleh lebih dari 99 KG!");
        } else {
            valid.validInt(evt);
        }
    }//GEN-LAST:event_onValidate

    private void onHapus(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onHapus
        if(!id.equals("")) {
            int i = dialog.showConfirm("Apakah anda yakin ingin menghapus ?");
            if(i == JOptionPane.YES_OPTION) {
                transaksi.removeData(transaksi.searchIndexData(id));
            }
        } else {
            dialog.showWarning("Mohon pilih data yang akan dihapus!");
        }
        showTotal();
        onReload(null);
    }//GEN-LAST:event_onHapus

    private void onEdit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onEdit
        if(!id.equals("")) {
            isEdit = true;
            boxPilihPaket.setEnabled(false);
            boxQty.setText(qty);
            for(int i = 0; i < id_paket.size(); i++) {
               if(id_paket.get(i).equals(id)) {
                   boxPilihPaket.setSelectedIndex(i + 1);
               } 
            }
        } else {
            dialog.showWarning("Mohon pilih data yang akan di edit!");
            showTotal();
            onReload(null);
        }
    }//GEN-LAST:event_onEdit

    private void onFocusBayar(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_onFocusBayar
        // Jika menekan esc pada kolom quantity maka cursor akan fokus ke kolom bayar
        char c = evt.getKeyChar();
        if(c == KeyEvent.VK_ESCAPE) {
            boxBayar.requestFocus();
        }
    }//GEN-LAST:event_onFocusBayar

    private void onValidateBayar(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_onValidateBayar
        valid.validInt(evt);
    }//GEN-LAST:event_onValidateBayar

    private void onBayar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onBayar
        try {
            if(boxBayar.getText().equals("")) {
                dialog.showWarning("Kolom pembayaran kosong!");
                boxBayar.requestFocus();
            } else if(transaksi.getTotal() == 0) {
                dialog.showWarning("Transaksi laundry masih kosong!");
                boxKembali.setText("Rp. 0,00");
            }else if(transaksi.getTotal() > new Integer(boxBayar.getText())) {
                dialog.showWarning("Pembayaran anda kurang!");
                boxKembali.setText("Rp. 0,00");
            } else {
                kembali = new Integer(boxBayar.getText()) - transaksi.getTotal();
                boxKembali.setText(currencyRpFormat(kembali));
            }
        } catch (Exception e) {
            dialog.showError("Error bayar : " + e.getMessage());
        }
    }//GEN-LAST:event_onBayar

    private void onSimpanCetak(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onSimpanCetak
        save(true);
    }//GEN-LAST:event_onSimpanCetak

    private void onSimpan(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onSimpan
        save(false);
    }//GEN-LAST:event_onSimpan

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            FormTransaksi dialog = new FormTransaksi(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField boxBayar;
    private javax.swing.JTextField boxIDKonsumen;
    private javax.swing.JTextField boxKembali;
    private javax.swing.JComboBox<String> boxPilihPaket;
    private javax.swing.JTextField boxQty;
    private javax.swing.JTextField boxTotal;
    private static javax.swing.JLabel btnHapus4;
    private static javax.swing.JLabel btnHapus5;
    private static javax.swing.JLabel btnHapus6;
    private static javax.swing.JLabel btnHapus7;
    private static javax.swing.JLabel btnHapus8;
    private static javax.swing.JLabel btnHapus9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNoTagihan;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}
