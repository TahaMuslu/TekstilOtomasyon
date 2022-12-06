package com.model;

public class Deneme {
    int id;
    String isim;
    String soyisim;
    String sehir;
    int maas;

    public Deneme(int id, String isim, String soyisim, String sehir, int maas) {
        this.id = id;
        this.isim = isim;
        this.soyisim = soyisim;
        this.sehir = sehir;
        this.maas = maas;
    }

    public int getId() {
        return id;
    }

    public String getIsim() {
        return isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public String getSehir() {
        return sehir;
    }

    public int getMaas() {
        return maas;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    public void setMaas(int maas) {
        this.maas = maas;
    }

}
