/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author An Le Ha
 */
public class douong {
    private int id_douong;
    private String tendouong;
    private String loaidouong;
    private int gia;
    private String donvi;

    public douong(int id_douong, String tendouong, String loaidouong, int gia, String donvi) {
        this.id_douong = id_douong;
        this.tendouong = tendouong;
        this.loaidouong = loaidouong;
        this.gia = gia;
        this.donvi = donvi;
    }

    public douong() {
    }

    public int getId_douong() {
        return id_douong;
    }

    public void setId_douong(int id_douong) {
        this.id_douong = id_douong;
    }

    public String getTendouong() {
        return tendouong;
    }

    public void setTendouong(String tendouong) {
        this.tendouong = tendouong;
    }

    public String getLoaidouong() {
        return loaidouong;
    }

    public void setLoaidouong(String loaidouong) {
        this.loaidouong = loaidouong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }
    
}
