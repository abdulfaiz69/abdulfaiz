/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOBus;
import DAO.ImplementBus;
import DAO.ImplementPesan;
import Koneksi.KoneksiDB;
import Model.ModBus;
import Model.ModPesan;
import Model.ModTblBus;
import View.formListBus;
import View.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class ControllerPesan {
    formListBus frame;
    ImplementBus implBus;
    ImplementPesan implPesan;
    List<ModBus> lmb;
    List<ModPesan> lmp;

    
    public ControllerPesan(formListBus frame) {
        this.frame = frame;
        implBus = new DAOBus();
        lmb = implBus.getAll();
    } 
    
    public void reset(){
        frame.getiKeberangkatan().setText("");
        frame.getiKeberangkatan().setText("");
        frame.getiKodeBus().setText("");
        frame.getiNamaPemesan().setText("");
        frame.getiJumlah().setText("");

    }
    public void isiTable(){
        lmb = implBus.getAll();
        ModTblBus mtb = new ModTblBus(lmb);
        frame.gettListBus().setModel(mtb);
    }
    public void isiField(int row){
        frame.getiKodeBus().setText(String.valueOf(lmb.get(row).getKodebus()));
        frame.getiHarga().setText(String.valueOf(lmb.get(row).getHarga()));
        frame.getiNamaBus().setText(String.valueOf(lmb.get(row).getNamaBus()));
    }
    public void insert() throws SQLException{
        if(!frame.getiKodeBus().getText().trim().isEmpty() && !frame.getiNamaPemesan().getText().trim().isEmpty() && !frame.getiJumlah().getText().trim().isEmpty()){
            Connection con = koneksi.getKoneksi();
            int harga,jumlah,total;
            harga = Integer.parseInt(frame.getiHarga().getText().trim());
            jumlah = Integer.parseInt(frame.getiJumlah().getText().trim());
            total = harga*jumlah;
            String sql = "INSERT INTO tb_pemesanan(namaPembeli,kodeBus,namaBus,jumlah,harga,total)VALUE(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, frame.getiNamaPemesan().getText().trim());
            ps.setString(2, frame.getiKodeBus().getText().trim());
            ps.setString(3, frame.getiNamaBus().getText().trim());
            ps.setInt(4, jumlah);
            ps.setInt(5, harga);
            ps.setInt(6, total);
            ps.execute();
            ps.close();

        }else{
            JOptionPane.showMessageDialog(null, "Silahkan Masukan Data Dengan Benar");
        }
        
    }
    public void isiTableCariBus(){
        lmb = implBus.getCariBus(frame.getiKeberangkatan().getText(), frame.getiKedatangan().getText());
        ModTblBus mtb = new ModTblBus(lmb);
        frame.gettListBus().setModel(mtb);
    }
    
    public void cariBus(){
        if(!frame.getiKeberangkatan().getText().trim().isEmpty() && !frame.getiKedatangan().getText().trim().isEmpty()){
            implBus.getCariBus(frame.getiKeberangkatan().getText(), frame.getiKedatangan().getText());
            isiTableCariBus();
            
        }else{
            JOptionPane.showMessageDialog(null, "Silahkan Masukan Keberangkatan dan Kedatangan");
        }
    }
}
