package com.model;

public class Personel {
    int personel_id;
    String ad;
    String soyad;
    String ise_baslama_tarih;
    String unvan;
    String adres;
    String sehir;
    String ulke;
    String telefon;
    String dogum_tarihi;
    int maas;
    String cinsiyet;

    public Personel(int personel_id, String ad, String soyad, String ise_baslama_tarih, String unvan, String adres,
            String sehir, String ulke, String telefon, String dogum_tarihi, int maas, String cinsiyet) {
        this.personel_id = personel_id;
        this.ad = ad;
        this.soyad = soyad;
        this.ise_baslama_tarih = ise_baslama_tarih;
        this.unvan = unvan;
        this.adres = adres;
        this.sehir = sehir;
        this.ulke = ulke;
        this.telefon = telefon;
        this.dogum_tarihi = dogum_tarihi;
        this.maas = maas;
        this.cinsiyet = cinsiyet;
    }

    public int getPersonel_id() {
        return personel_id;
    }

    public void setPersonel_id(int personel_id) {
        this.personel_id = personel_id;
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

    public String getIse_baslama_tarih() {
        return ise_baslama_tarih;
    }

    public void setIse_baslama_tarih(String ise_baslama_tarih) {
        this.ise_baslama_tarih = ise_baslama_tarih;
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

    public String getDogum_tarihi() {
        return dogum_tarihi;
    }

    public void setDogum_tarihi(String dogum_tarihi) {
        this.dogum_tarihi = dogum_tarihi;
    }

    public int getMaas() {
        return maas;
    }

    public void setMaas(int maas) {
        this.maas = maas;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

}
