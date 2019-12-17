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

/**
 *
 * @author An Le Ha
 */
public class douongdata {
        public static ObservableList<douong> GetDouongData()
    {
        ObservableList<douong> list_douong = FXCollections.observableArrayList();
        Connection connection = openConnection();//Mo ket noi
        String sql="SELECT * FROM douong"; //Chuoi truy van CSDL
        try{
            PreparedStatement ps = connection.prepareStatement(sql);//Chuan bi truy van
            ResultSet rs = ps.executeQuery();//Thuc thi truy van
            while(rs.next())//Doc du lieu
            {
                douong douong = new douong();
                douong.setId_douong(rs.getInt("id_douong"));
                douong.setTendouong(rs.getString("tendouong"));
                douong.setLoaidouong(rs.getString("loaidouong"));
                douong.setGia(rs.getInt("gia"));
                douong.setDonvi(rs.getString("donvi"));
                list_douong.add(douong);
            }
        //return list_mat;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list_douong;
    }
    public static int insertDoUong(String douong, String loaidouong, int gia, String donvi)// throws SQLException
    {
            int kq = -1;
            String querry = "INSERT INTO douong (tendouong, loaidouong, gia, donvi) VALUES (?,?,?,?)";
            Connection connection = openConnection();
        try {
           PreparedStatement ps = (PreparedStatement) connection.prepareStatement(querry);
           ps.setString(1, douong);
           ps.setString(2, loaidouong);
           ps.setInt(3, gia);
           ps.setString(4, donvi);
           kq = ps.executeUpdate();
           return kq;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return kq;
      
    }
        public static int is_existed(String name){
        int count = 0;
        Connection connection = openConnection();//mo ket noi
        //chuoi ket noi
        String sql = "SELECT COUNT(*) FROM coffeeshop.douong WHERE tendouong=\""+name+"\"";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);//chuan bi truy van
            ResultSet rs = ps.executeQuery();//Thuc thi truy van
            rs.next();
            count=rs.getInt("COUNT(*)");
            //login_model acc = new login_model();
            //return(count);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return count;
    }
    public static int deleteDouong(int id_douong)
    {
        int kq = -1;
        Connection connection = openConnection();
        try{
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement("DELETE FROM douong WHERE id_douong=?");
            ps.setInt(1, id_douong);
            kq = ps.executeUpdate();
            return kq;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return kq;
    }
    public static int updateDoUong(int id_douong, String douong, String loaidouong, int gia, String donvi)// throws SQLException
    {
            int kq = -1;
            String querry = "UPDATE douong SET tendouong=?, loaidouong=?, gia=?, donvi=? WHERE id_douong=?";
            Connection connection = openConnection();
        try {
           PreparedStatement ps = (PreparedStatement) connection.prepareStatement(querry);
           ps.setString(1, douong);
           ps.setString(2, loaidouong);
           ps.setInt(3, gia);
           ps.setString(4, donvi);
           ps.setInt(5, id_douong);
           kq = ps.executeUpdate();
           return kq;
        }
        catch (Exception e){
            e.printStackTrace();
        
        }
        return kq;
      
    }
     public static int getid_douong(String tendouong)
    {
        int kq =0 ;
        String querry = "SELECT * FROM douong WHERE tendouong =?";
        Connection connection = openConnection(); 
        try {
           douong p = new douong();            
           PreparedStatement ps = (PreparedStatement) connection.prepareStatement(querry);
           ps.setString(1, tendouong);
           ResultSet rs = ps.executeQuery();
           while(rs.next())
           {
                p.setId_douong(rs.getInt("id_douong"));
                kq = p.getId_douong() ;
                return kq;
           }
        }
        catch (Exception e){
            e.printStackTrace();
       
        }
        return kq;
    }
}
