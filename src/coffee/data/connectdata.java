/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffee.data;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author MyPC
 */
public class connectdata {
    public static Connection connection;
    //Ham ket noi CSDL
    public static synchronized Connection openConnection()
    {
        if(connection!=null)
        {
            return connection;
        }
        else
        {
            String url = "jdbc:mysql://localhost:3306/coffeeshop";
            String user="root";
            String pass="danhnghia26";
            try{
                Class.forName("com.mysql.jdbc.Driver");
                connection = (Connection) DriverManager.getConnection(url, user, pass);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    
    //Ham dong ket noi CSDL
    public static synchronized void closeConnection()
    {
        try{
            connection.close();
        } catch(Exception e) {
            
        }
        finally{
            connection = null;
        }
    }
}
