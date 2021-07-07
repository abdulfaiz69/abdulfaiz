/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ModBus;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface ImplementBus {
    public void insert(ModBus mb);
    public void delete(String kodebus);
    public void update(ModBus mb);
    public List<ModBus> getAll();
    public List<ModBus> getCariBus(String Keberangkatan, String Kedatangan);
    
}
