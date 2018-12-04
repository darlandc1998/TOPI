package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;


public class UtilDate {
    
    public static String getDateFormatted(Date data){
        return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }
    
}
