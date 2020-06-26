package LIBRARY;

public class TempData {
    
    private static String idTemp = "", idUser = "";
    private static boolean enabled = false;
    
    public TempData() {
        
    }
    
    public static void setId(String id) {
        idTemp = id;
    }
    
    public static void setIdUser(String id) {
        idUser = id;
    }
    
    public static void setStatus(boolean enb) {
        enabled = enb;
    }
    
    public static String getId() {
        return idTemp;
    }
    
    public static String getIdUser() {
        return idUser;
    }
    
    public static boolean getStatus() {
        return enabled;
    }
    
}
