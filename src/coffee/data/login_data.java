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

/**
 *
 * @author MyPC
 */
public class login_data {
    //Ham xac thuc username password
    public int getLogin(String user, String pass){
        int count = 0;
        Connection connection = openConnection();//mo ket noi
        //chuoi ket noi
        String sql = "SELECT COUNT(*) FROM coffeeshop.nhanvien WHERE username=\""+user+"\" and password=\""+pass+"\"";
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
}
