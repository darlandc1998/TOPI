package Utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class UtilFile {
    
    public static final String PATH = "../";
    public static final String LOG = "log.txt";
    public static final String USER = "usuario.txt";
    
    public static void gravarArquivo(String nomeArquivo, String textoArquivo){
        gravarArquivo(nomeArquivo, textoArquivo, false);
    }
    
    public static void gravarArquivo(String nomeArquivo, String textoArquivo, boolean append) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(PATH + nomeArquivo, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(textoArquivo);
            bufferedWriter.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static String lerArquivo(String nomeArquivo) {
        
        if (!new File(PATH + nomeArquivo).exists()){
            return null;
        }
        
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(PATH + nomeArquivo);
            bufferedReader = new BufferedReader(fileReader);
            StringBuilder sb = new StringBuilder();
            while (bufferedReader.ready()) {
                sb.append(bufferedReader.readLine());
            }
            return sb.toString();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return null;
    }
    
}
