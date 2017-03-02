package helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection_Test {
    public static void main(String[] args){
        DatabaseConnection s = new DatabaseConnection();
        s.getConnection();
        try {
            Statement stm = s.con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT msbn, socmnd, hoten, diachi FROM benhnhan");
            System.out.println("MaBN\tCMND\t\tHo Ten\t\tDia chi");
            while(rs.next()){
               System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
            }
            s.getClose(rs, stm);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
