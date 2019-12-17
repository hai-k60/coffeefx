/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffee.data;

import static coffee.data.connectdata.openConnection;
import com.mysql.jdbc.Connection;
import model.customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author Windows 8.1 pro
 */
public class customer_data {
    public static ObservableList<customer> GetDataKhachHang (){
        ObservableList<customer> list_cus = FXCollections.observableArrayList();
        Connection connection= openConnection();
        String sql= "SELECT * FROM khachhang";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);//Chuan bi truy van
            ResultSet rs = ps.executeQuery();//Thuc thi truy van
            while(rs.next())//Doc du lieu
            {
                
                customer kh = new customer();
                kh.setId_khachhang(rs.getInt("id_khachhang"));
                kh.setHoten(rs.getString("hoten"));
                kh.setSodienthoai(rs.getString("sodienthoai"));
                kh.setDiemtichluy(rs.getString("diemtichluy"));
                
                list_cus.add(kh);
                //Dua vector vao model
                //myModel.addRow(vector);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list_cus;
    }
    public String[] getKhachhang(String sodienthoai){
        String[] data= new String[]{"","","0",""};
        java.sql.Connection connection= openConnection();//mo ket noi
        String sql="select hoten,sodienthoai,diemtichluy,id_khachhang from coffeeshop.khachhang where sodienthoai=\""+sodienthoai+"\"";
        try{
            PreparedStatement ps = connection.prepareCall(sql);//chuan bi ket noi
            ResultSet rs = ps.executeQuery();//Thuc thi truy van
            rs.next();
            data[0]=rs.getString("hoten");
            data[1]=rs.getString("sodienthoai");
            data[2]=rs.getString("diemtichluy");
            data[3]=rs.getString("id_khachhang");
        } catch(Exception e){
            e.printStackTrace();
        }
        return data; 
    }
    public String[] getKhachhang_ten(String tenkhahhang){
        String[] data= new String[]{"","","0",""};
        java.sql.Connection connection= openConnection();//mo ket noi
        String sql="select hoten,sodienthoai,diemtichluy,id_khachhang from coffeeshop.khachhang where hoten like '%"+tenkhahhang+"%'";
        try{
            PreparedStatement ps = connection.prepareCall(sql);//chuan bi ket noi
            ResultSet rs = ps.executeQuery();//Thuc thi truy van
            rs.next();
            data[0]=rs.getString("hoten");
            data[1]=rs.getString("sodienthoai");
            data[2]=rs.getString("diemtichluy");
            data[3]=rs.getString("id_khachhang");
        } catch(Exception e){
            e.printStackTrace();
        }
        return data; 
    }
    
    public int checkKhachhang(String sodienthoai){
        int count=0;
        java.sql.Connection connection= openConnection();//mo ket noi
        String sql="SELECT COUNT(*) FROM coffeeshop.khachhang WHERE sodienthoai=\""+sodienthoai+"\"";
        try{
            PreparedStatement ps = connection.prepareCall(sql);//chuan bi ket noi
            ResultSet rs = ps.executeQuery();//Thuc thi truy van
            rs.next();
            count=rs.getInt("COUNT(*)");//check so dien thoai khach hang
        } catch(Exception e){
            e.printStackTrace();
        }
        return count;
    }
        public int checkTenKhachhang(String tenkhahhang){
        int count=0;
        java.sql.Connection connection= openConnection();//mo ket noi
        String sql="SELECT COUNT(*) FROM coffeeshop.khachhang where hoten like '%"+tenkhahhang+"%'";
        try{
            PreparedStatement ps = connection.prepareCall(sql);//chuan bi ket noi
            ResultSet rs = ps.executeQuery();//Thuc thi truy van
            rs.next();
            count=rs.getInt("COUNT(*)");//check so dien thoai khach hang
        } catch(Exception e){
            e.printStackTrace();
        }
        return count;
    }
    public static ObservableList<customer> getKhachhtt1 (){
        ObservableList<customer> list_cus = FXCollections.observableArrayList();
        Connection connection= openConnection();
        String sql= "SELECT * FROM coffeeshop.khachhang WHERE diemtichluy = (SELECT MAX(diemtichluy) FROM coffeeshop.khachhang)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);//Chuan bi truy van
            ResultSet rs = ps.executeQuery();//Thuc thi truy van
            while(rs.next())//Doc du lieu
            {
                
                customer kh = new customer();
                kh.setId_khachhang(rs.getInt("id_khachhang"));
                kh.setHoten(rs.getString("hoten"));
                kh.setSodienthoai(rs.getString("sodienthoai"));
                kh.setDiemtichluy(rs.getString("diemtichluy"));
                
                list_cus.add(kh);
                //Dua vector vao model
                //myModel.addRow(vector);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list_cus;
    }
    public static ObservableList<customer> getKhachhtt2 (){
        ObservableList<customer> list_cus = FXCollections.observableArrayList();
        Connection connection= openConnection();
        String s1= "SELECT id_khachhang FROM coffeeshop.donhang WHERE tongtien = (SELECT MAX(tongtien) FROM coffeeshop.donhang)";
        String sql= "SELECT *FROM coffeeshop.khachhang WHERE id_khachhang = 's1'";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);//Chuan bi truy van
            ResultSet rs = ps.executeQuery();//Thuc thi truy van
            while(rs.next())//Doc du lieu
            {
                
                customer kh = new customer();
                kh.setId_khachhang(rs.getInt("id_khachhang"));
                kh.setHoten(rs.getString("hoten"));
                kh.setSodienthoai(rs.getString("sodienthoai"));
                kh.setDiemtichluy(rs.getString("diemtichluy"));
                
                list_cus.add(kh);
                //Dua vector vao model
                //myModel.addRow(vector);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list_cus;
    }
}
