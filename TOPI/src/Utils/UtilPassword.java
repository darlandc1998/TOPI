package Utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UtilPassword {
    
    public static String criptografarSenha(String senha){
        try {
            MessageDigest m= MessageDigest.getInstance("MD5");
            m.update(senha.getBytes(),0,senha.length());
            return new BigInteger(1,m.digest()).toString(16);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UtilPassword.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
