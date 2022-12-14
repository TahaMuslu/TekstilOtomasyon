package com.model;

public class Tedarikciler {
    int tedarikci_id;
    String sirket_adi;
    String web_sayfasi;
    String adres;
    String sehir;
    String ulke;
    String telefon;

    public Tedarikciler(int tedarikci_id, String sirket_adi, String web_sayfasi,
                        String adres, String sehir, String ulke, String telefon) {
        this.tedarikci_id = tedarikci_id;
        this.sirket_adi = sirket_adi;
        this.web_sayfasi = web_sayfasi;
        this.adres = adres;
        this.sehir = sehir;
        this.ulke = ulke;
        this.telefon = telefon;
    }

    public int getTedarikci_id() {
        return tedarikci_id;
    }

    public String getSirket_adi() {
        return sirket_adi;
    }

    public String getWeb_sayfasi() {
        return web_sayfasi;
    }

    public String getAdres() {
        return adres;
    }

    public String getSehir() {
        return sehir;
    }

    public String getUlke() {
        return ulke;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTedarikci_id(int tedarikci_id) {
        this.tedarikci_id = tedarikci_id;
    }

    public void setSirket_adi(String sirket_adi) {
        this.sirket_adi = sirket_adi;
    }

    public void setWeb_sayfasi(String web_sayfasi) {
        this.web_sayfasi = web_sayfasi;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    public void setUlke(String ulke) {
        this.ulke = ulke;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
