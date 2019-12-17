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
public class nguyenlieu {
    private int id_nguyenlieu;
    private String tennguyenlieu;
    private int luong;
    private String donvi;

    public nguyenlieu(int id_nguyenlieu, String tennguyenlieu, int luong, String donvi) {
        this.id_nguyenlieu = id_nguyenlieu;
        this.tennguyenlieu = tennguyenlieu;
        this.luong = luong;
        this.donvi = donvi;
    }
    public nguyenlieu()
    {}
    public int getId_nguyenlieu() {
        return id_nguyenlieu;
    }

    public void setId_nguyenlieu(int id_nguyenlieu) {
        this.id_nguyenlieu = id_nguyenlieu;
    }

    public String getTennguyenlieu() {
        return tennguyenlieu;
    }

    public void setTennguyenlieu(String tennguyenlieu) {
        this.tennguyenlieu = tennguyenlieu;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }
    
}
