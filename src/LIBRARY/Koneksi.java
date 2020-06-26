package LIBRARY;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Koneksi {

    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String SERVER = "localhost";
    private final String PORT = "3306";
    private final String DATABASE = "laundry_pbo";
    private final String USERNAME = "root";
    private final String PASSWORD = "";

    private Connection con;
    private Statement st;

    private final Dialog dialog = new Dialog();

    public Koneksi() {
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection("jdbc:mysql://" + SERVER + ":" + PORT + "/" + DATABASE, USERNAME, PASSWORD);
            st = con.createStatement();
            
            if (!con.isClosed()) {
//                System.out.println("Koneksi berhasil!");
            }
        } catch (Exception e) {
            dialog.showError("Error koneksi : " + e.getMessage());
        }
    }
    
    public ResultSet getQuery(String query) {
        try {
            return st.executeQuery(query);
        } catch (Exception e) {
            dialog.showError("Error query : " + e.getMessage());
            return null;
        }
    }
    
    public void setExecute(String query) {
        try {
            st.executeUpdate(query);
        } catch (Exception e) {
            dialog.showError("Error execute : " + e.getMessage());
        }
    }

    public String getAutoMaxID(String prefix, int length, String table, String column) {
        String id = null;
        try {
            ResultSet rs = getQuery("SELECT MAX(SUBSTRING("
                    + column + ", " + (prefix.length() + 1) + ", " + length + ")) "
                    + "FROM " + table + "");
            if (rs.next()) {
                id = prefix + String.format("%0" + (length - prefix.length()) + "d", rs.getInt(1) + 1);
            } else {
                id = prefix + String.format("%0" + (length - prefix.length()) + "d", 1);
            }
        } catch (Exception e) {
            dialog.showError("Error max id : " + e.getMessage());
        }
        return id;
    }

}
