/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffee.data;

import static coffee.data.connectdata.openConnection;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.douong;
import model.material;
import model.nguyenlieu;
import model.thanhphandouong;

/**
 *
 * @author An Le Ha
 */
public class thanhphandouong_data {
    public static ObservableList<thanhphandouong> GetThanhPhanDoUong(int id_douong)
    {
        ObservableList<thanhphandouong> list_douong = FXCollections.observableArrayList();
        Connection connection = openConnection();//Mo ket noi
        String sql="SELECT * FROM thanhphandouong where id_douong=?"; //Chuoi truy van CSDL
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);//Chuan bi truy van
            ps.setInt(1, id_douong);
            ResultSet rs = ps.executeQuery();//Thuc thi truy van
            while(rs.next())//Doc du lieu
            {
                thanhphandouong douong = new thanhphandouong();
                douong.setId_douong(rs.getInt("id_douong"));
                douong.setId_nguyenlieu(rs.getInt("id_nguyenlieu"));
                douong.setLuong(rs.getInt("luong"));
//                String sql_1="SELECT * FROM nguyenlieu where id_nguyenlieu=?";
//                PreparedStatement ps_1 = connection.prepareStatement(sql_1);//Chuan bi truy van
//                ps_1.setInt(1, rs.getInt("id_nguyenlieu"));
//                ResultSet rs_1 = ps_1.executeQuery();
                douong.setTennguyenlieu(material_data.getTennguyenlieu(rs.getInt("id_nguyenlieu")));
                list_douong.add(douong);
            }
        //return list_mat;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list_douong;
    }
    
     public static int insertThanhphan(int id_douong, int id_nguyenlieu, int luong )
    {
        int kq = -1;
        String querry = "INSERT INTO thanhphandouong (id_douong, id_nguyenlieu, luong) VALUES (?,?,?)";
        Connection connection = openConnection(); 
        try {
           PreparedStatement ps = (PreparedStatement) connection.prepareStatement(querry);
           ps.setInt(1, id_douong);
           ps.setInt(2, id_nguyenlieu);
           ps.setInt(3, luong);
           kq = ps.executeUpdate();
           return kq;
        }
        catch (Exception e){
            e.printStackTrace();
        
        }
        return kq;
    }
    public static int getid_nguyenlieu(String tennguyenlieu)
    {
        int kq =0 ;
        String querry = "SELECT * FROM nguyenlieu WHERE tennguyenlieu =?";
        Connection connection = openConnection(); 
        try {
           nguyenlieu p = new nguyenlieu();            
           PreparedStatement ps = (PreparedStatement) connection.prepareStatement(querry);
           ps.setString(1, tennguyenlieu);
           ResultSet rs = ps.executeQuery();
           while(rs.next())
           {
                p.setId_nguyenlieu(rs.getInt("id_nguyenlieu"));
                kq = p.getId_nguyenlieu() ;
                return kq;
           }
        }
        catch (Exception e){
            e.printStackTrace();
       
        }
        return kq;
    }
    public static int updatethanhphandouong(int id_douong, int id_nguyenlieu, int donvi)// throws SQLException
    {
            int kq = -1;
            String querry = "UPDATE thanhphandouong SET donvi=? WHERE id_douong=? and id_nguyenlieu=?";
            Connection connection = openConnection();
        try {
           PreparedStatement ps = (PreparedStatement) connection.prepareStatement(querry);
           ps.setInt(1, donvi);
           ps.setInt(2, id_douong);
           ps.setInt(3, id_nguyenlieu);
           kq = ps.executeUpdate();
           return kq;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return kq;
    }
}
