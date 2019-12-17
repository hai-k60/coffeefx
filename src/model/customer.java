/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Windows 8.1 pro
 */
public class customer {
    
    private int id_khachhang;
    private String hoten;
    private String sodienthoai;
    private String diemtichluy;  

    public customer(int id_khachhang, String hoten, String sodienthoai, String diemtichluy) {
        this.id_khachhang = id_khachhang;
        this.hoten = hoten;
        this.sodienthoai = sodienthoai;
        this.diemtichluy = diemtichluy;
    }

    public customer() {
    }
    

    public int getId_khachhang() {
        return id_khachhang;
    }

    public void setId_khachhang(int id_khachhang) {
        this.id_khachhang = id_khachhang;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getDiemtichluy() {
        return diemtichluy;
    }

    public void setDiemtichluy(String diemtichluy) {
        this.diemtichluy = diemtichluy;
    }    
}
