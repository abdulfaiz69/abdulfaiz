/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Administrator
 */
public class ModPesan {
    private String namaBus;
    private String namaPembeli;
    private String kodeBus;
    private int jumlah;
    private int harga;
    private int total;

    public String getNamaBus() {
        return namaBus;
    }

    public void setNamaBus(String namaBus) {
        this.namaBus = namaBus;
    }

    public String getNamaPembeli() {
        return namaPembeli;
    }

    public void setNamaPembeli(String namaPembeli) {
        this.namaPembeli = namaPembeli;
    }

    public String getKodeBus() {
        return kodeBus;
    }

    public void setKodeBus(String kodeBus) {
        this.kodeBus = kodeBus;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
    
    
}
