package com.model;

public class Urunler {
    int urun_id;
    String urun_adi;
    int kumas_id;
    int paket_miktar;
    int paket_fiyat;
    int stok;

    public Urunler(int urun_id, String urun_adi, int kumas_id,
                   int paket_miktar, int paket_fiyat, int stok) {
        this.urun_id = urun_id;
        this.urun_adi = urun_adi;
        this.kumas_id = kumas_id;
        this.paket_miktar = paket_miktar;
        this.paket_fiyat = paket_fiyat;
        this.stok = stok;
    }

    public int getUrun_id() {
        return urun_id;
    }

    public String getUrun_adi() {
        return urun_adi;
    }

    public int getKumas_id() {
        return kumas_id;
    }

    public int getPaket_miktar() {
        return paket_miktar;
    }

    public int getPaket_fiyat() {
        return paket_fiyat;
    }

    public int getStok() {
        return stok;
    }

    public void setUrun_id(int urun_id) {
        this.urun_id = urun_id;
    }

    public void setUrun_adi(String urun_adi) {
        this.urun_adi = urun_adi;
    }

    public void setKumas_id(int kumas_id) {
        this.kumas_id = kumas_id;
    }

    public void setPaket_miktar(int paket_miktar) {
        this.paket_miktar = paket_miktar;
    }

    public void setPaket_fiyat(int paket_fiyat) {
        this.paket_fiyat = paket_fiyat;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}
