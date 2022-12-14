package com.model;

public class Nakliyeci {
    int nakliyeci_id;
    String sirket_ad;
    String telefon;

    public Nakliyeci(int nakliyeci_id, String sirket_ad, String telefon) {
        this.nakliyeci_id = nakliyeci_id;
        this.sirket_ad = sirket_ad;
        this.telefon = telefon;
    }

    public int getNakliyeci_id() {
        return nakliyeci_id;
    }

    public void setNakliyeci_id(int nakliyeci_id) {
        this.nakliyeci_id = nakliyeci_id;
    }

    public String getSirket_ad() {
        return sirket_ad;
    }

    public void setSirket_ad(String sirket_ad) {
        this.sirket_ad = sirket_ad;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
