package kata5View;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import kata5Model.Mail;

public class MailListReaderDB {
    public List<Mail> read(){
        List<Mail> emailsFromDB = new ArrayList<>();
        String url = "jdbc:sqlite:Kata5.db";
        String sql = "SELECT * FROM Email";
        
        Connection conn;
        try{
            conn = DriverManager.getConnection(url);
            Statement sentence = conn.createStatement();
            System.out.println("Conectado a la BD.");
            ResultSet rs = sentence.executeQuery(sql);
            
            while (rs.next()){
                emailsFromDB.add(new Mail(rs.getString("correo")));
            }
            
        } catch (SQLException error) {
            System.out.println("Se ha producido el siguiente fallo: " + error.getMessage());
        }
        return emailsFromDB;
    }
}
