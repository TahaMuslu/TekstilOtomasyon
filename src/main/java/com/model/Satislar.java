package com.model;

public class Satislar {
    int satis_id;
    int musteri_id;
    String satis_tarihi;
    int nakliye_ucreti;
    int nakliyeci_id;

    public Satislar(int satis_id, int musteri_id, String satis_tarihi, int nakliye_ucreti, int nakliyeci_id) {
        this.satis_id = satis_id;
        this.musteri_id = musteri_id;
        this.satis_tarihi = satis_tarihi;
        this.nakliye_ucreti = nakliye_ucreti;
        this.nakliyeci_id = nakliyeci_id;
    }

    public int getSatis_id() {
        return satis_id;
    }

    public void setSatis_id(int satis_id) {
        this.satis_id = satis_id;
    }

    public int getMusteri_id() {
        return musteri_id;
    }

    public void setMusteri_id(int musteri_id) {
        this.musteri_id = musteri_id;
    }

    public String getSatis_tarihi() {
        return satis_tarihi;
    }

    public void setSatis_tarihi(String satis_tarihi) {
        this.satis_tarihi = satis_tarihi;
    }

    public int getNakliye_ucreti() {
        return nakliye_ucreti;
    }

    public void setNakliye_ucreti(int nakliye_ucreti) {
        this.nakliye_ucreti = nakliye_ucreti;
    }

    public int getNakliyeci_id() {
        return nakliyeci_id;
    }

    public void setNakliyeci_id(int nakliyeci_id) {
        this.nakliyeci_id = nakliyeci_id;
    }

}
