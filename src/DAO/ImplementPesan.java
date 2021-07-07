/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ModPesan;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface ImplementPesan {
    public void insert(ModPesan mp);
    public void delete(String kodebus, String namaPembeli);
    public void update(ModPesan mb);
    public List<ModPesan> getAll();
    public List<ModPesan> getCariNama(String namaPembeli);
}
