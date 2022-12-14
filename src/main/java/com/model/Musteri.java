package com.model;

public class Musteri {
    int musteri_id;
    String ad;
    String soyad;
    String unvan;
    String adres;
    String sehir;
    String ulke;
    String telefon;
    String sirket_ad;

    public Musteri(int musteri_id, String ad, String soyad, String unvan, String adres, String sehir,
                   String ulke, String telefon, String sirket_ad) {
        this.musteri_id = musteri_id;
        this.ad = ad;
        this.soyad = soyad;
        this.unvan = unvan;
        this.adres = adres;
        this.sehir = sehir;
        this.ulke = ulke;
        this.telefon = telefon;
        this.sirket_ad = sirket_ad;
    }

    public int getMusteri_id() {
        return musteri_id;
    }

    public void setMusteri_id(int musteri_id) {
        this.musteri_id = musteri_id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    public String getUlke() {
        return ulke;
    }

    public void setUlke(String ulke) {
        this.ulke = ulke;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getSirket_ad() {
        return sirket_ad;
    }

    public void setSirket_ad(String sirket_ad) {
        this.sirket_ad = sirket_ad;
    }
}
