package LIBRARY;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {

    public String getTime() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    public String getDate() {
        return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    }
    
    public String getDateTimeStruck() {
        return new SimpleDateFormat("dd.MM.yyyy - HH:mm").format(new Date());
    }
    
    public String getDateSQL() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
    
    public String getDateFull() {
        return new SimpleDateFormat("EE, MMM dd, yyyy").format(new Date());
    }

}
