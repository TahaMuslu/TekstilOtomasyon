package com.model;

public class SatinAlimlar {
    int satin_alim_id;
    int tedarikci_id;
    String satin_alim_tarih;

    public SatinAlimlar(int satin_alim_id, int tedarikci_id, String satin_alim_tarih) {
        this.satin_alim_id = satin_alim_id;
        this.tedarikci_id = tedarikci_id;
        this.satin_alim_tarih = satin_alim_tarih;
    }

    public int getSatin_alim_id() {
        return satin_alim_id;
    }

    public void setSatin_alim_id(int satin_alim_id) {
        this.satin_alim_id = satin_alim_id;
    }

    public int getTedarikci_id() {
        return tedarikci_id;
    }

    public void setTedarikci_id(int tedarikci_id) {
        this.tedarikci_id = tedarikci_id;
    }

    public String getSatin_alim_tarih() {
        return satin_alim_tarih;
    }

    public void setSatin_alim_tarih(String satin_alim_tarih) {
        this.satin_alim_tarih = satin_alim_tarih;
    }

}
