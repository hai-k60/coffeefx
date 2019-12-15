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
import java.util.Vector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.table.DefaultTableModel;
import model.material;

/**
 *
 * @author danhnghia
 */
public class material_data {
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
}
