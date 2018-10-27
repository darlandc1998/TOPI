package Utils;

import Telas.PrincipalFrame;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UtilLog {

    public static void escreverLog(String mensagem) {
        UtilFile.gravarArquivo(UtilFile.LOG, new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + " " + UtilFile.lerArquivo(UtilFile.USER) + " " + mensagem + "\n", true);
    }

    public static void escreverExcecao(Exception e) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(UtilFile.PATH + UtilFile.LOG, true);
            e.printStackTrace(new PrintWriter(fw));
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(PrincipalFrame.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fw != null){
                  fw.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(PrincipalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
