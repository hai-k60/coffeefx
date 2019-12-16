/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeefx;

import static coffee.data.connectdata.openConnection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import com.mysql.jdbc.Connection;
import static coffee.data.connectdata.openConnection;
import coffee.data.employee_data;
import model.Employee;

/**
 * FXML Controller class
 *
 * @author MyPC
 */
public class PanelemployeeController implements Initializable {
     @FXML
    private TableView<Employee> table;
    @FXML
    private TableColumn<Employee, Integer> idColumn;
    @FXML
    private TableColumn<Employee, String> nameColumn;
    @FXML
    private TableColumn<Employee, String> addressColumn;
    @FXML
    private TableColumn<Employee, String> jobColumn;
    @FXML
    private TableColumn<Employee, String> usernameColumn;
    @FXML
    private TableColumn<Employee, String> phoneColumn;
    @FXML
    private TextField hotenText;
    @FXML
    private TextField diachiText;
    @FXML
    private TextField chucvuText;
    @FXML
    private TextField usernameText;
    @FXML
    private TextField passwordText;
    @FXML
    private TextField sodienthoaiText;
    private ObservableList<Employee> employeeList;
    
    public void loadtable(){
        employee_data data = new employee_data();
    //Set up the columns in the table
        idColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id_nhanvien"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("hoten"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("diachi"));
        jobColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("chucvu"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("username"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("sodienthoai"));
        
        //load dummy data
        //table.setItems(getMaterial());
        table.setItems(employee_data.GetEmployeeData());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadtable();
        
        
    }
    // Xu ly su kien create
    @FXML
    private void create(ActionEvent event) {
        employee_data newEmployee = new employee_data();
        newEmployee.addEmployee(hotenText.getText(),diachiText.getText(), chucvuText.getText(), usernameText.getText(), passwordText.getText(), sodienthoaiText.getText());
        loadtable();
    
    }
    //Xu ly su kien delete
    @FXML
     private void delete(ActionEvent event){
     Employee mat = table.getSelectionModel().getSelectedItem();
            //Load value from row to txt field
            //txt_name.setText(mat.getName());
            //cbb_unit.setPromptText(mat.getUnit()); //TODO: Check this, It's not ok!
            
            int id = mat.getId_nhanvien();
            employee_data.delEmployee(id);
            table.setItems(employee_data.GetEmployeeData());
            loadtable();
     }
     // Xu ly su kien  update
     private void update(ActionEvent event){
     Employee mat = table.getSelectionModel().getSelectedItem();
     }

}
    
    /*Xu ly su kien Create*/
    
    
    /*Xu ly su kien Delete*/
        

