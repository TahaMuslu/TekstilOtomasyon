package com.model;

public class SatisDetay {
    int satis_id;
    int miktar;
    int urun_id;

    public SatisDetay(int satis_id, int miktar, int urun_id) {
        this.satis_id = satis_id;
        this.miktar = miktar;
        this.urun_id = urun_id;
    }

    public int getSatis_id() {
        return satis_id;
    }

    public void setSatis_id(int satis_id) {
        this.satis_id = satis_id;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public int getUrun_id() {
        return urun_id;
    }

    public void setUrun_id(int urun_id) {
        this.urun_id = urun_id;
    }

}
