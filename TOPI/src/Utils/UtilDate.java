package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UtilDate {
    
    public static String getDateFormatted(Date data){
        return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }
    
    public static Date getDateString(String data){
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(UtilDate.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return null;
    }
    
}
