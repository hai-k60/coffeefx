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
import java.util.Vector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.table.DefaultTableModel;
import model.material;
import coffee.data.storage_data;

/**
 *
 * @author danhnghia
 */
public class material_data {
    
    //Function for taking data from database
    public static ObservableList<material> GetMaterialData()
    {
        ObservableList<material> list_mat = FXCollections.observableArrayList();
        Connection connection = openConnection();//Mo ket noi
        String sql="SELECT * FROM nguyenlieu"; //Chuoi truy van CSDL
        try{
            PreparedStatement ps = connection.prepareStatement(sql);//Chuan bi truy van
            ResultSet rs = ps.executeQuery();//Thuc thi truy van
            while(rs.next())//Doc du lieu
            {
                
                material mat = new material();
                mat.setId(rs.getInt("id_nguyenlieu"));
                mat.setName(rs.getString("tennguyenlieu"));
                mat.setAmount(rs.getString("luong"));
                mat.setUnit(rs.getString("donvi"));
                list_mat.add(mat);
            }
        //return list_mat;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list_mat;
    }
    
    //Function for button Update
    public static void add_to_available(String amount, String old_amount, int id){
        int total = Integer.parseInt(amount) + Integer.parseInt(old_amount);
        modMaterial(id, Integer.toString(total));
        //material_data.GetMaterialData();//lll
    }
    public static void mod_available(String amount, int id){
        //int total = Integer.parseInt(amount) + Integer.parseInt(old_amount);
        modMaterial(id, amount);
        //material_data.GetMaterialData();//lll
    }
    
    
    public static void modMaterial(int id, String amount){
        
        String querry = "UPDATE nguyenlieu SET luong = ? WHERE id_nguyenlieu = ?";
        
        Connection connection = openConnection();//Mo ket noi
        try{
            PreparedStatement ps = connection.prepareStatement(querry);//Chuan bi truy van
            //int row = table_nguyenlieu.getSelectedRow();
            ps.setInt(1, Integer.parseInt(amount));
            ps.setInt(2, id);
            ps.executeUpdate();//Thuc thi truy van
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void addMaterial(String txt_nguyenlieu, String txt_luong, String txt_donvi){
         String querry = "INSERT INTO nguyenlieu (tennguyenlieu, luong, donvi) VALUES (?,?,?)";
        
        Connection connection = openConnection();//Mo ket noi

        try{
            PreparedStatement ps = connection.prepareStatement(querry);//Chuan bi truy van
            ps.setString(1, txt_nguyenlieu);
            ps.setString(2, txt_luong);
            ps.setString(3, txt_donvi);
            ps.execute();//Thuc thi truy van
            
        } catch (Exception e) {
            e.printStackTrace();
        }
     }
    
    public static int is_existed(String name){
        int count = 0;
        Connection connection = openConnection();//mo ket noi
        //chuoi ket noi
        String sql = "SELECT COUNT(*) FROM coffeeshop.nguyenlieu WHERE tennguyenlieu=\""+name+"\"";
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
    
    public static void delMaterial(int id){
                String querry = "DELETE FROM nguyenlieu WHERE id_nguyenlieu= (?)";
        
        Connection connection = openConnection();//Mo ket noi

        try{
            PreparedStatement ps = connection.prepareStatement(querry);//Chuan bi truy van
            //int row = table_nguyenlieu.getSelectedRow();
            ps.setInt(1, id);
            ps.execute();//Thuc thi truy van
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
