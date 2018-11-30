package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UtilConnection {
    
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/agendadb", "sa", "");
        } catch (SQLException | ClassNotFoundException e) {
            Logger.getLogger(UtilConnection.class.getName()).log(Level.SEVERE, null, e);
        }

        return conn;
    }
    
}
