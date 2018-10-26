package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilLog {

    public static void escreverLog(String mensagem) {
        UtilFile.gravarArquivo(UtilFile.LOG,new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + " " + UtilFile.lerArquivo(UtilFile.USER) + " " + mensagem + "\n", true);
    }

}
