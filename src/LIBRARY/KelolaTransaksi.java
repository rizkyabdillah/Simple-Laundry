package LIBRARY;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class KelolaTransaksi{
    
    private ArrayList<Transaksi> array = new ArrayList<>();
    private final LibColor color = new LibColor();
    private Dialog dialog = new Dialog();
    
    private int index = 0;

    public KelolaTransaksi() {
        
    }
    
    public void addData(String id_paket, int quantity, int harga) {
        array.add(new Transaksi(id_paket, quantity, (quantity * harga)));
    }
    
    public void removeData(int index) {
        if(index > array.size() || index < 0) {
            dialog.showWarning("Index out of bound!");
        } else {
            array.remove(index);
        }
    }
    
    public void replaceData(int index, int quantity, int harga) {
        if(index > array.size() || index < 0) {
            dialog.showWarning("Index out of bound!");
        } else {
            int qtyAwal = array.get(index).getQuantity();
            array.get(index).setQuantity(qtyAwal + quantity);
            array.get(index).setSubTotal((qtyAwal + quantity) * harga);
        }
    }
    
    public void editData(int index, int quantity, int harga) {
        if(index > array.size() || index < 0) {
            dialog.showWarning("Index out of bound!");
        } else {
            array.get(index).setQuantity(quantity);
            array.get(index).setSubTotal(quantity * harga);
        }
    }
    
    public int searchIndexData(String key) {
        int i = 0;
        for(int j = 0; j < array.size(); j++) {
            if(array.get(j).getIDPaket().equals(key)) {
                i = j;
            }
        }
        return i;
    }
    
    public int getIndex() {
        return index;
    }
    
    public boolean isFoundData(String key) {
        boolean found = false;
        for(int j = 0; j < array.size(); j++) {
            if(array.get(j).getIDPaket().equals(key)) {
                found = true;
                index = j;
            }
        }
        return found;
    }
    
    public int getTotal() {
        int total = 0;
        for(int j = 0; j < array.size(); j++) {
            total += array.get(j).getSubTotal();
        }
        return total;
    }
    
    public void clearAll() {
        array.clear();
    }
    
    public void showTabel(JTable tabel, String[] header) {
        try {
            DefaultTableModel model = new DefaultTableModel(header, 1) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            tabel.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

                DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                    Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    if (isSelected) {
                        c.setBackground(color.getHrefColor());
                        c.setForeground(Color.WHITE);
                    } else if (row % 2 == 0) {
                        c.setBackground(color.getColor());
                        c.setForeground(Color.WHITE);
                    } else {
                        c.setBackground(color.foreColor());
                        c.setForeground(Color.WHITE);
                    }
                    return c;
                }
            });

            tabel.setRowHeight(38);

            int baris = 0;
            while (baris < array.size()) {
                String[] kolom = new String[header.length];
                kolom[0] = array.get(baris).getIDPaket();
                kolom[1] = String.valueOf(array.get(baris).getQuantity());
                kolom[2] = String.valueOf(array.get(baris).getSubTotal());
                model.insertRow(baris, kolom);
                baris++;
            }

            tabel.setModel(model);

        } catch (Exception e) {
            dialog.showError("Error show tabel : " + e.getMessage());
        }
    }
    
}
