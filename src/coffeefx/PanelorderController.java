/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeefx;

import coffee.data.order_data;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author MyPC
 */
public class PanelorderController implements Initializable {
    
    @FXML
    private ComboBox<String> cb_douong; 
    
    ObservableList<String> list_unit = FXCollections.observableArrayList("Cà phê", "Sinh tố", "Trà sữa", "Siro");
    @FXML
    private Button btn_check;
    @FXML
    private TextField txt_sodienthoai;
    @FXML
    private TextField txt_tenkhachhang;
    @FXML
    private TextField txt_makhachhang;
    @FXML
    private TextField txt_diemtichluy;
    @FXML
    private Button btn_create;
    @FXML
    private TableView<?> tb_danhsachorder;
    @FXML
    private TableColumn<?, ?> cl_tendouong;
    @FXML
    private TableColumn<?, ?> cl_soluong;
    @FXML
    private TableColumn<?, ?> cl_dongia;
    @FXML
    private TextField txt_madonhang;
    @FXML
    private TextField txt_soluong;
    @FXML
    private Button btn_add;
    @FXML
    private TextField txt_uudai;
    @FXML
    private TextField txt_soban;
    
    @FXML
    private void onClickAdd(ActionEvent event){
        System.out.println("Hello hello");
    }
        @FXML
    private void onClickCheck(ActionEvent event) {
        order_data ord_data=new order_data();
        String[] data=new String[4];
        int check = ord_data.checkKhachhang(txt_sodienthoai.getText());
        System.out.println(check);
        if(check==1){
            data=ord_data.getKhachhang(txt_sodienthoai.getText());
            txt_tenkhachhang.setText(data[0]);
            txt_diemtichluy.setText(data[2]);
            txt_makhachhang.setText(data[3]);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");

            // Header Text: null
            alert.setHeaderText(null);
            alert.setContentText("Khách hàng mới");
            alert.showAndWait();
        }
    }

    @FXML
    private void onClickCreate(ActionEvent event) {
        order_data ord_data=new order_data();
        ord_data.addKhachhang(txt_sodienthoai.getText(), txt_tenkhachhang.getText());
        txt_makhachhang.setText(ord_data.getIdKhachhang()); 
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cb_douong.setValue("Chọn đồ uống");
        cb_douong.setItems(list_unit);
    }    


}
