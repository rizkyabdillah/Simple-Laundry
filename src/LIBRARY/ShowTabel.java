package LIBRARY;

import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ShowTabel extends Koneksi{
    
    private final LibColor color = new LibColor();
    private final Dialog dialog = new Dialog();
    
    public void showTabel(JTable tabel, String[] header, String sql) {
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

            ResultSet rs = getQuery(sql);

            int baris = 0;
            while (rs.next()) {
                String[] kolom = new String[header.length];
                for (int i = 0; i < header.length; i++) {
                    kolom[i] = rs.getString(i + 1);
                }
                model.insertRow(baris, kolom);
                baris++;
            }

            tabel.setModel(model);

        } catch (Exception e) {
            dialog.showError("Error show tabel : " + e.getMessage());
        }
    }
    
}
