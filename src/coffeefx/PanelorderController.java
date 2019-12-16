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
import javafx.scene.control.cell.PropertyValueFactory;
import model.chitietdonhang;

/**
 * FXML Controller class
 *
 * @author MyPC
 */
public class PanelorderController implements Initializable {
    
    @FXML
    private ComboBox<String> cb_douong; 
    
    ObservableList<String> list_unit = FXCollections.observableArrayList("Cà phê đen", "Cà phê nâu", "Cà phê cốt dừa");
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
    private TableView<chitietdonhang> tb_danhsachorder;
    @FXML
    private TableColumn<chitietdonhang, Integer> cl_madouong;
    @FXML
    private TableColumn<chitietdonhang, String> cl_tendouong;
    @FXML
    private TableColumn<chitietdonhang, Integer> cl_soluong;
    @FXML
    private TableColumn<chitietdonhang, Integer> cl_dongia;
    
    private ObservableList<chitietdonhang> chitietdonhangList;
    
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
    private TextField txt_tongtien;
    
    
    @FXML
    private void onClickAdd(ActionEvent event){
        if(txt_madonhang.getText().equals("")){
            order_data ord_data=new order_data();
            ord_data.addDonhang("", "", "", "", "");
            String text=ord_data.getIdDonhang();
            System.out.println(text);
            txt_madonhang.setText(text);
        }
        
        System.out.println(cb_douong.getSelectionModel().getSelectedItem().toString());
        order_data ord_data = new order_data();
        String[] datadouong= new String[3];
        datadouong = ord_data.getDouong(cb_douong.getSelectionModel().getSelectedItem().toString());
        //add do uong vao chi tiet don hang
        ord_data.addDouong(txt_madonhang.getText(), datadouong[0], txt_soluong.getText(), datadouong[2]);
        //Load chi tiet don hang len bang
        
        int tongtien=ord_data.getTongtien(txt_madonhang.getText());
        txt_tongtien.setText(Integer.toString(tongtien));
        loadTable(txt_madonhang.getText());
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
    
    public void loadTable(String id_dh){
        cl_madouong.setCellValueFactory(new PropertyValueFactory<chitietdonhang, Integer>("id_douong"));
        cl_dongia.setCellValueFactory(new PropertyValueFactory<chitietdonhang, Integer>("dongia"));
        cl_tendouong.setCellValueFactory(new PropertyValueFactory<chitietdonhang, String>("tendouong"));
        cl_soluong.setCellValueFactory(new PropertyValueFactory<chitietdonhang, Integer>("soluong"));
    //        tb_danhsachorder.setItems(chitietdonhangList);
        
        //Load
        order_data ord_data=new order_data();
        tb_danhsachorder.setItems(ord_data.getChitietdonhang(id_dh));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // ComboBox
        cb_douong.setValue("Chọn đồ uống");
        cb_douong.setItems(list_unit);
        
        //TableView
        chitietdonhangList=FXCollections.observableArrayList(
                new chitietdonhang(1, "Cà phê", 1, 1)
        );
        
        
    }    


}
