/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author MyPC
 */
public class chitietdonhang {
    private int id_douong;
    private int soluong;
    private int dongia;

    public chitietdonhang(int id_douong, int soluong, int dongia) {
        this.id_douong = id_douong;
        this.soluong = soluong;
        this.dongia = dongia;
    }

    public chitietdonhang() {
    }

    public int getId_douong() {
        return id_douong;
    }

    public void setId_douong(int id_douong) {
        this.id_douong = id_douong;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }
}

