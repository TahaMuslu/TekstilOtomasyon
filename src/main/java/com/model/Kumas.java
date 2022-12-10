package com.model;

public class Kumas {

    int kumas_id;
    String kumas_ad;
    int stok;
    int tedarikci_id;
    int birim_fiyat;

    public Kumas(int kumas_id, String kumas_ad,
                 int stok, int tedarikci_id, int birim_fiyat) {
        this.kumas_id = kumas_id;
        this.kumas_ad = kumas_ad;
        this.stok = stok;
        this.tedarikci_id = tedarikci_id;
        this.birim_fiyat = birim_fiyat;
    }

    public int getKumas_id() {
        return kumas_id;
    }

    public String getKumas_ad() {
        return kumas_ad;
    }

    public int getStok() {
        return stok;
    }

    public int getTedarikci_id() {
        return tedarikci_id;
    }

    public int getBirim_fiyat() {
        return birim_fiyat;
    }

    public void setKumas_id(int kumas_id) {
        this.kumas_id = kumas_id;
    }

    public void setKumas_ad(String kumas_ad) {
        this.kumas_ad = kumas_ad;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public void setTedarikci_id(int tedarikci_id) {
        this.tedarikci_id = tedarikci_id;
    }

    public void setBirim_fiyat(int birim_fiyat) {
        this.birim_fiyat = birim_fiyat;
    }
}
