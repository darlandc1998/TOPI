package Utils;

import java.text.DecimalFormat;

public class UtilNumeric {
 
    public static String getValueFormattedMoney(Double value){
        return new DecimalFormat("#,##0.00").format(value);
    }
    
}
