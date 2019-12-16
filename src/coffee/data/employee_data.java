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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Employee;

/**
 *
 * @author admin
 */
public class employee_data {
    //Ham lay du lieu nhan vien tu SQL
    public static ObservableList<Employee> GetEmployeeData()
    {
        ObservableList<Employee> list_mat = FXCollections.observableArrayList();
        Connection connection = openConnection();//Mo ket noi
        String sql="SELECT * FROM nhanvien"; //Chuoi truy van CSDL
        try{
            PreparedStatement ps = connection.prepareStatement(sql);//Chuan bi truy van
            ResultSet rs = ps.executeQuery();//Thuc thi truy van
            while(rs.next())//Doc du lieu
            {
                Employee mat = new Employee();
                mat.setId_nhanvien(rs.getInt("id_nhanvien"));
                mat.setHoten(rs.getString("hoten"));
                mat.setDiachi(rs.getString("diachi"));
                mat.setChucvu(rs.getString("chucvu"));
                mat.setUsername(rs.getString("username"));
                mat.setPassword(rs.getString("password"));
                mat.setSodienthoai(rs.getString("sodienthoai"));
                list_mat.add(mat);
            }
        //return list_mat;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list_mat;
    }
    
    //Ham Add Csdl
    public void addEmployee(String hoten, String diachi, String chucvu, String username, String password, String sodienthoai){
        java.sql.Connection connection= openConnection();//mo ket noi
        String sql="INSERT INTO `coffeeshop`.`nhanvien` (hoten, diachi, chucvu, username, password, sodienthoai) VALUES ('"+hoten+"', '"+diachi+"','"+chucvu+"','"+username+"','"+password+"','"+sodienthoai+"')";
        try{
            PreparedStatement ps = connection.prepareCall(sql);//chuan bi ket noi
            ps.execute();//Thuc thi truy van
        } catch(Exception e){
            e.printStackTrace();
        }
     
    }
    //Ham Delete Csdl 
    public static void delEmployee(int id){
        String querry = "DELETE FROM nhanvien WHERE id_nhanvien= (?)";
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
    // Ham Update du lieu
    
}
