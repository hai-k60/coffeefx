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
public class thanhphandouong {
    private int id_douong;
    private int id_nguyenlieu;
    private int luong;
    private String tennguyenlieu;
    public thanhphandouong(int id_douong, int id_nguyenlieu, int luong, String tennguyenlieu) {
    this.id_douong = id_douong;
    this.id_nguyenlieu = id_nguyenlieu;
    this.luong = luong;
    this.tennguyenlieu = tennguyenlieu;
    }    
    public thanhphandouong()
            {}
    public String getTennguyenlieu() {
        return tennguyenlieu;
    }
    public void setTennguyenlieu(String tennguyenlieu) {
        this.tennguyenlieu = tennguyenlieu;
    }
    public int getId_douong() {
        return id_douong;
    }

    public void setId_douong(int id_douong) {
        this.id_douong = id_douong;
    }

    public int getId_nguyenlieu() {
        return id_nguyenlieu;
    }

    public void setId_nguyenlieu(int id_nguyenlieu) {
        this.id_nguyenlieu = id_nguyenlieu;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }
}
