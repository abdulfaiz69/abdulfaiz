/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrator
 */
public class ModTblBus extends AbstractTableModel {

    List<ModBus> lmb;

    public ModTblBus(List<ModBus> lmb) {
        this.lmb = lmb;
    }
    
    
    @Override
    public int getRowCount() {
        return lmb.size();
     }

    @Override
    public int getColumnCount() {
        return 5;
      }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return lmb.get(row).getKodebus();
            case 1:
                return lmb.get(row).getNamaBus();
            case 2:
                return lmb.get(row).getKeberangkatan();
            case 3:
                return lmb.get(row).getKedatangan();
            case 4:
                return lmb.get(row).getHarga();
            default:
                return null;
        }
     }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "Kode Kapal";
            case 1:
                return "Nama Kapal";
            case 2:
                return "Keberangkatan";
            case 3:
                return "Kedatangan";
            case 4:
                return "Harga";
            default:
                return null;
        }
     }
    
}
