/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Koneksi.KoneksiDB;
import Model.ModBus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class DAOBus implements ImplementBus {
    
    Connection connection;
    final String insert = "INSERT INTO tb_bus (kodebus, namaBus, kedatangan, keberangkatan, harga) VALUES (?,?,?,?,?)";
    final String update = "UPDATE tb_bus set kodebus=?, namaBus=?, kedatangan=?, keberangkatan=?, harga=? WHERE kodebus=?";
    final String delete = "DELETE FROM tb_bus WHERE kodebus=?";
    final String select = "SELECT * FROM tb_bus";
    final String cariBus = "SELECT * FROM tb_bus WHERE keberangkatan=? and kedatangan=?";
    
    public DAOBus(){
        connection = KoneksiDB.connection();
    }
    @Override
    public void insert(ModBus mb) {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, mb.getKodebus());
            statement.setString(2, mb.getNamaBus());
            statement.setString(3, mb.getKedatangan());
            statement.setString(4, mb.getKeberangkatan());
            statement.setInt(5, mb.getHarga());
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()){
                mb.setKodebus(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOBus.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOBus.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void delete(String kodebus) {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(delete);
            statement.setString(1, kodebus);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void update(ModBus mb){
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, mb.getKodebus());
            statement.setString(2, mb.getNamaBus());
            statement.setString(3, mb.getKedatangan());
            statement.setString(4, mb.getKeberangkatan());
            statement.setInt(5, mb.getHarga());
            statement.setString(6, mb.getKodebus());
          
            ResultSet rs = statement.getGeneratedKeys();
            

            while (rs.next()){
                mb.setKodebus(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOBus.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOBus.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public List<ModBus> getAll() {
        List<ModBus> lmb=null;
        
        try {
            lmb = new ArrayList<ModBus>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                ModBus mb = new ModBus();
                mb.setKodebus(rs.getString("kodebus"));
                mb.setNamaBus(rs.getString("namaBus"));
                mb.setKeberangkatan(rs.getString("keberangkatan"));
                mb.setKedatangan(rs.getString("kedatangan"));
                mb.setHarga(rs.getInt("harga"));
                lmb.add(mb);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lmb;
     }

    @Override
    public List<ModBus> getCariBus(String Keberangkatan, String Kedatangan) {
        List<ModBus> lmb=null;
        
        try {
            lmb = new ArrayList<ModBus>();
            PreparedStatement st = connection.prepareStatement(cariBus);
            st.setString(1, Keberangkatan);
            st.setString(2, Kedatangan);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                ModBus mb = new ModBus();
                mb.setKodebus(rs.getString("kodebus"));
                mb.setNamaBus(rs.getString("namaBus"));
                mb.setKeberangkatan(rs.getString("keberangkatan"));
                mb.setKedatangan(rs.getString("kedatangan"));
                mb.setHarga(rs.getInt("harga"));
                lmb.add(mb);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lmb;
    }
    
}
