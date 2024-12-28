package com.example.oyuncuservice;

import jakarta.persistence.*;


@Entity
public class Oyuncu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String ad;
    private String soyad;

    private String mevki;


    private int fizikselDurum;
    private int hiz;
    private int sut;
    private int pas;
    private int savunma;
    private int topSurme;

    private double totalOvral;

    // Getters ve Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getMevki() {
        return mevki;
    }

    public void setMevki(String mevki) {
        this.mevki = mevki;
    }

    public int getFizikselDurum() {
        return fizikselDurum;
    }

    public void setFizikselDurum(int fizikselDurum) {
        this.fizikselDurum = fizikselDurum;
        updateTotalOvral();
    }

    public int getHiz() {
        return hiz;
    }

    public void setHiz(int hiz) {
        this.hiz = hiz;
        updateTotalOvral();
    }

    public int getSut() {
        return sut;
    }

    public void setSut(int sut) {
        this.sut = sut;
        updateTotalOvral();
    }

    public int getPas() {
        return pas;
    }

    public void setPas(int pas) {
        this.pas = pas;
        updateTotalOvral();
    }

    public int getSavunma() {
        return savunma;
    }

    public void setSavunma(int savunma) {
        this.savunma = savunma;
        updateTotalOvral();
    }

    public int getTopSurme() {
        return topSurme;
    }

    public void setTopSurme(int topSurme) {
        this.topSurme = topSurme;
        updateTotalOvral();
    }

    public double getTotalOvral() {
        return totalOvral;
    }

    private void updateTotalOvral() {
        this.totalOvral = (fizikselDurum + hiz + sut + pas + savunma + topSurme) / 6.0;
    }
}
