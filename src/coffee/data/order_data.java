/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffee.data;

import static coffee.data.connectdata.openConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MyPC
 */
public class order_data {
    //Ham check sdt khach hang
    public int checkKhachhang(String sodienthoai){
        int count=0;
        Connection connection= openConnection();//mo ket noi
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
    
    //Ham add khach hang moi
    public void addKhachhang(String sodienthoai, String hoten){
        Connection connection= openConnection();//mo ket noi
        String sql="INSERT INTO `coffeeshop`.`khachhang` (hoten, sodienthoai, diemtichluy) VALUES ('"+hoten+"', '"+sodienthoai+"', '0')";
        try{
            PreparedStatement ps = connection.prepareCall(sql);//chuan bi ket noi
            ps.execute();//Thuc thi truy van
        } catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    //Ham get Id khach hang mois
    public String getIdKhachhang(){
        String id = null;
        Connection connection= openConnection();//mo ket noi
        String sql="SELECT max(id_khachhang) FROM coffeeshop.khachhang";
        try{
            PreparedStatement ps = connection.prepareCall(sql);//chuan bi ket noi
            ResultSet rs = ps.executeQuery();//Thuc thi truy van
            rs.next();
            id=rs.getString("max(id_khachhang)");//check so dien thoai khach hang
        } catch(Exception e){
            e.printStackTrace();
        }
        return id;
    }
    
    //Ham get thong tin khach hang
    public String[] getKhachhang(String sodienthoai){
        String[] data= new String[]{"","","0",""};
        Connection connection= openConnection();//mo ket noi
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
    
    //Ham tao don hang
    public void addDonhang(String id_khachhang, String id_nhanvien, String thoigian, String uudai, String soban ){
        Date date = new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        Connection connection= openConnection();//mo ket noi
        String sql="INSERT INTO coffeeshop.donhang (id_khachhang, id_nhanvien, thoigian, uudai, soban) VALUES ('2', '1', '"+ts.toString()+"', '0', '2')";
        try{
            PreparedStatement ps = connection.prepareCall(sql);//chuan bi ket noi
            ps.execute();//Thuc thi truy van
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public String getIdDonhang(){
        String id = null;
        Connection connection= openConnection();//mo ket noi
        String sql="SELECT max(id_donhang) FROM coffeeshop.donhang";
        try{
            PreparedStatement ps = connection.prepareCall(sql);//chuan bi ket noi
            ResultSet rs = ps.executeQuery();//Thuc thi truy van
            rs.next();
            id=rs.getString("max(id_donhang)");//check so dien thoai khach hang
        } catch(Exception e){
            e.printStackTrace();
        }
        return id;
    }
    
    //Ham get do uong
    public String[] getDouong(String tendouong){
        String[] data = new String[3];
        Connection connection= openConnection();//mo ket noi
        String sql="SELECT id_douong,tendouong,gia FROM coffeeshop.douong where tendouong=\""+tendouong+"\"";
        try{
            PreparedStatement ps = connection.prepareCall(sql);//chuan bi ket noi
            ResultSet rs = ps.executeQuery();//Thuc thi truy van
            rs.next();
            data[0]=rs.getString("id_douong");
            data[1]=rs.getString("tendouong");
            data[2]=rs.getString("gia");
        } catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }
    
    //Ham add do uong
    public void addDouong(String id_donhang, String id_douong, String soluong, String dongia){
        
        Connection connection= openConnection();//mo ket noi
        String sql="insert into coffeeshop.chitietdonhang (id_donhang, id_douong, soluong, dongia) value ('"+id_donhang+"','"+id_douong+"','"+soluong+"','"+dongia+"')";
        try{
            PreparedStatement ps = connection.prepareCall(sql);//chuan bi ket noi
            ps.execute();//Thuc thi truy van
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //Ham get chi tiet don hang
//    public void GetChitietdoihang(DefaultTableModel myModel, String id_donhang)
//    {
//        Connection connection = openConnection();//Mo ket noi
//        String sql="select id_douong,soluong,dongia from coffeeshop.chitietdonhang where coffeeshop.chitietdonhang.id_donhang="+id_donhang+""; //Chuoi truy van CSDL
//        try{
//            PreparedStatement ps = connection.prepareStatement(sql);//Chuan bi truy van
//            ResultSet rs = ps.executeQuery();//Thuc thi truy van
//            while(rs.next())//Doc du lieu
//            {
//                chitietdonhang ctdh = new chitietdonhang();
//                ctdh.setId_douong(rs.getInt("id_douong"));
//                ctdh.setDongia(rs.getInt("dongia"));
//                //Dua du lieu nhanvien vao vector
//                Vector vector = new Vector();
//                vector.add(ctdh.getId_douong());
//                vector.add(ctdh.getSoluong());
//                vector.add(ctdh.getDongia());
//                
//                //Dua vector vao model
//                myModel.addRow(vector);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    //HAm tinh tong tien
    public int getTongtien(String id_donhang){
        int sum = 0;
        Connection connection= openConnection();//mo ket noi
        String sql="select sum(dongia*soluong) from coffeeshop.chitietdonhang where id_donhang="+id_donhang+"";
        try{
            PreparedStatement ps = connection.prepareCall(sql);//chuan bi ket noi
            ResultSet rs = ps.executeQuery();//Thuc thi truy van
            rs.next();
            sum=rs.getInt("sum(dongia*soluong)");//check so dien thoai khach hang
        } catch(Exception e){
            e.printStackTrace();
        }
        return sum;
    }
    
}
