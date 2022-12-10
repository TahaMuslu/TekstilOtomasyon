package com.model;

public class SatinAlimDetay {

    int satin_alim_id;
    int kumas_id;
    int miktar;

    public SatinAlimDetay(int satin_alim_id, int kumas_id, int miktar) {
        this.satin_alim_id = satin_alim_id;
        this.kumas_id = kumas_id;
        this.miktar = miktar;
    }

    public int getSatin_alim_id() {
        return satin_alim_id;
    }

    public void setSatin_alim_id(int satin_alim_id) {
        this.satin_alim_id = satin_alim_id;
    }

    public int getKumas_id() {
        return kumas_id;
    }

    public void setKumas_id(int kumas_id) {
        this.kumas_id = kumas_id;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

}
