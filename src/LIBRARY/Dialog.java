package LIBRARY;

import javax.swing.JOptionPane;

public class Dialog {
    
    public void showInfo(String pesan) {
        JOptionPane.showMessageDialog(null, pesan, "Informasi!", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void showWarning(String pesan) {
        JOptionPane.showMessageDialog(null, pesan, "Kesalahan!", JOptionPane.WARNING_MESSAGE);
    }
    
    public void showError(String pesan) {
        JOptionPane.showMessageDialog(null, pesan, "Error!", JOptionPane.ERROR_MESSAGE);
    }
    
    public int showConfirm(String pesan) {
        return JOptionPane.showConfirmDialog(null, pesan, "Konfirmasi!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }
    
}
