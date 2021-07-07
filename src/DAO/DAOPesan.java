/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Koneksi.KoneksiDB;
import Model.ModBus;
import Model.ModPesan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class DAOPesan implements ImplementPesan{
    Connection connection;
    final String insert = "INSERT INTO tb_pemesanan (namaPembeli, kodeBus, namaBus, jumlah, harga, total) VALUES (?,?,?,?,?,?)";
    final String update = "UPDATE tb_pemesanan set namaPembeli=?, kodeBus=?, namaBus=?, jumlah=?, harga=?, total=? WHERE kodeBus=? AND namaPembeli=?";
    final String delete = "DELETE FROM tb_pemesanan WHERE kodeBus=? AND namaPembeli=?";
    final String select = "SELECT * FROM tb_pemesanan";
    final String cariPemesan = "SELECT * FROM tb_bus WHERE namaPembeli=?";

    public DAOPesan(){
        connection = KoneksiDB.connection();
    }
    @Override
    public void insert(ModPesan mp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String kodebus, String namaPembeli) {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(delete);
            statement.setString(1, kodebus);
            statement.setString(2, namaPembeli);
            statement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
                JOptionPane.showMessageDialog(null, "Pesanan Berhasil Di hapus");

            }catch (SQLException ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Pesanan Gagal Di hapus");

            }
        }
    }

    @Override
    public void update(ModPesan mp) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, mp.getNamaPembeli());
            statement.setString(2, mp.getKodeBus());
            statement.setString(3, mp.getNamaBus());
            statement.setInt(4, mp.getJumlah());
            statement.setInt(5, mp.getHarga());
            statement.setInt(6, mp.getTotal());
            statement.setString(7, mp.getKodeBus());
            statement.setString(8, mp.getNamaPembeli());
            statement.execute();
            statement.close();
            JOptionPane.showMessageDialog(null, "Pesanan Berhasil Di update");

        } catch (SQLException ex) {
            Logger.getLogger(DAOPesan.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Pesanan Gagal Di Hapus");

        }
     }

    @Override
    public List<ModPesan> getAll() {
        List<ModPesan> lmp = null;
        try {
            lmp = new ArrayList<ModPesan>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                ModPesan mp = new ModPesan();
                mp.setNamaPembeli(rs.getString("namaPembeli"));
                mp.setKodeBus(rs.getString("kodeBus"));
                mp.setNamaBus(rs.getString("namaBus"));
                mp.setJumlah(rs.getInt("jumlah"));
                mp.setHarga(rs.getInt("harga"));
                mp.setTotal(rs.getInt("total"));
                lmp.add(mp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lmp;
    }

    @Override
    public List<ModPesan> getCariNama(String namaPembeli) {
         List<ModPesan> lmp=null;
        
        try {
            lmp = new ArrayList<ModPesan>();
            PreparedStatement st = connection.prepareStatement(cariPemesan);
            st.setString(1, namaPembeli);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                ModPesan mp = new ModPesan();
                mp.setKodeBus(rs.getString("kodeBus"));
                mp.setNamaBus(rs.getString("namaBus"));
                mp.setNamaPembeli(rs.getString("namaPembeli"));
                mp.setJumlah(rs.getInt("jumlah"));
                mp.setHarga(rs.getInt("harga"));
                mp.setTotal(rs.getInt("total"));
                lmp.add(mp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lmp;
     }
    
}
