/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOPesan;
import DAO.ImplementBus;
import DAO.ImplementPesan;
import Model.ModBus;
import Model.ModPesan;
import Model.ModTblPesan;
import View.formCekPesan;
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
public class ControllerCek {
    formCekPesan frame;
    ImplementBus implBus;
    ImplementPesan implPesan;
    List<ModBus> lmb;
    List<ModPesan> lmp;
    
    public ControllerCek(formCekPesan frame) {
        this.frame = frame;
        implPesan = new DAOPesan();
        lmp = implPesan.getAll();
    }
    public void reset(){
        frame.getiNamaPembeli().setText("");
        frame.getiKodeBus().setText("");
        frame.getiPemesan().setText("");
        frame.getiJumlah().setText("");
        frame.getiHarga().setText("");


    }
    public void isiTable(){
        lmp = implPesan.getAll();
        ModTblPesan mtp = new ModTblPesan(lmp);
        frame.gettPemesan().setModel(mtp);
    }
    public void isiField(int row){
        frame.getiKodeBus().setText(String.valueOf(lmp.get(row).getKodeBus()));
        frame.getiHarga().setText(String.valueOf(lmp.get(row).getHarga()));
        frame.getiNamaBus().setText(String.valueOf(lmp.get(row).getNamaBus()));
        frame.getiPemesan().setText(String.valueOf(lmp.get(row).getNamaPembeli()));
        frame.getiJumlah().setText(String.valueOf(lmp.get(row).getJumlah()));
    }
    public void update() throws SQLException{
        if(!frame.getiKodeBus().getText().trim().isEmpty() && !frame.getiPemesan().getText().trim().isEmpty() && !frame.getiJumlah().getText().trim().isEmpty()){
            ModPesan dt = new ModPesan();
            int harga = Integer.parseInt(frame.getiHarga().getText().trim());
            int jumlah = Integer.parseInt(frame.getiJumlah().getText().trim());
            int total = harga*jumlah;
            dt.setNamaPembeli(frame.getiPemesan().getText().trim());
            dt.setKodeBus(frame.getiKodeBus().getText().trim());
            dt.setNamaBus(frame.getiNamaBus().getText().trim());
            dt.setJumlah(jumlah);
            dt.setHarga(harga);
            dt.setTotal(total);
            implPesan.update(dt);
            
        }else{
            JOptionPane.showMessageDialog(null, "Mohon isi data dengan Benar");
        }
    }
    public void cancel(){
        if(!frame.getiKodeBus().getText().trim().isEmpty() && !frame.getiPemesan().getText().trim().isEmpty() && !frame.getiJumlah().getText().trim().isEmpty()){
            implPesan.delete(frame.getiKodeBus().getText().trim(), frame.getiPemesan().getText().trim());
        }else{
            JOptionPane.showMessageDialog(null, "Mohon isi data dengan benar");
        }
    }
}
