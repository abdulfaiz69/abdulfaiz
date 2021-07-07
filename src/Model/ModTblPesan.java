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
public class ModTblPesan extends AbstractTableModel{

    List<ModPesan> lmp;

    public ModTblPesan(List<ModPesan> lmp) {
        this.lmp = lmp;
    }
    @Override
    public int getRowCount() {
        return lmp.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return lmp.get(row).getNamaPembeli();
            case 1:
                return lmp.get(row).getKodeBus();
            case 2:
                return lmp.get(row).getNamaBus();
            case 3:
                return lmp.get(row).getJumlah();
            case 4:
                return lmp.get(row).getTotal();
            default:
                return null;
        }
    }
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "Nama Pemesan";
            case 1:
                return "Kode Kapal";
            case 2:
                return "Nama Kapal";
            case 3:
                return "Jumlah";
            case 4:
                return "Total";
            default:
                return null;
        }
     }
    
}
