/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author dhimas
 */
public class connector {
    static Connection conn;
    
    public static Connection connection() {
    if(conn==null){
        MysqlDataSource data = new MysqlDataSource();
        data.setDatabaseName("movie");
        data.setUser("root");
        data.setPassword("");
        try{
            conn = data.getConnection();
            System.out.println("Koneksi berhasil");
        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("koneksi gagal");
        }
        
    }
    return conn;
    }
}
