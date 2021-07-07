/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Koneksi;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class KoneksiDB {
    static Connection con;
    
    public static Connection connection(){
        if(con == null){
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("db_pesanbus");
            data.setUser("root");
            data.setPassword("");
            
            try {
            con = (Connection) data.getConnection();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return con;
    }
}
