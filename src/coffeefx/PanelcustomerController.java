/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeefx;

import coffee.data.customer_data;
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
import javafx.scene.input.InputMethodEvent;
import model.customer;

/**
 * FXML Controller class
 *
 * @author MyPC
 */
public class PanelcustomerController implements Initializable {
    ObservableList<String> list_unit = FXCollections.observableArrayList("Số đơn hàng nhiều nhất", "Tổng giá trị đơn hàng nhiều nhất");

    @FXML
    private TableView<customer> tb_danhsachkhachhang;

   
        /**
     * Creates new form customers_panel
     */
    String[] headers = {"ID","Tên khách hàng","Số điện thoại","Điểm tích lũy"};
    @FXML
    private TableColumn<customer, Integer> id_column;
    @FXML
    private TableColumn<customer, String> khachhang_column;
    @FXML
    private TableColumn<customer, String> sdt_column;
    @FXML
    private TableColumn<customer, String> diemtl_column;
    @FXML
    private TextField txtTenKhachHang;
    @FXML
    private Button btn_Search;
    @FXML
    private TextField txt_sodienthoai;
    @FXML
    private ComboBox<String> cbb_khachhtt;
    @FXML
    private Button btn_check;

   /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cbb_khachhtt.setValue("Tổng đơn hàng nhiều nhất");
        cbb_khachhtt.setItems(list_unit);
                //Set up the columns in the table
        id_column.setCellValueFactory(new PropertyValueFactory<customer, Integer>("id_khachhang"));
        khachhang_column.setCellValueFactory(new PropertyValueFactory<customer, String>("hoten"));
        sdt_column.setCellValueFactory(new PropertyValueFactory<customer, String>("sodienthoai"));
        diemtl_column.setCellValueFactory(new PropertyValueFactory<customer, String>("diemtichluy"));
        
        //load dummy data
        //table.setItems(getMaterial());
        tb_danhsachkhachhang.setItems(customer_data.GetDataKhachHang());
    }    

    private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void onClickSearch(ActionEvent event) {
        customer_data cus_dt=new customer_data();
        String[] data=new String[4];
        if(!txt_sodienthoai.getText().isEmpty()){
            int check = cus_dt.checkKhachhang(txt_sodienthoai.getText());
            System.out.println("Start check");

            System.out.println(check);
            if(check==1){
                data=cus_dt.getKhachhang(txt_sodienthoai.getText());
                customer kh = new customer();
                ObservableList<customer> list_cust = FXCollections.observableArrayList();
                kh.setId_khachhang(Integer.parseInt(data[3]));
                kh.setHoten(data[0]);
                kh.setSodienthoai(txt_sodienthoai.getText());
                kh.setDiemtichluy(data[2]);
                list_cust.add(kh);
                tb_danhsachkhachhang.setItems(list_cust);

            }
            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");

                // Header Text: null
                alert.setHeaderText(null);
                alert.setContentText("Khách hàng không tồn tại");
                alert.showAndWait();
            }
        }
        if(!txtTenKhachHang.getText().isEmpty()){
            int check = cus_dt.checkTenKhachhang(txtTenKhachHang.getText());
            System.out.println("Start check");

            System.out.println(check);
            if(check==1){
                data=cus_dt.getKhachhang_ten(txtTenKhachHang.getText());
                customer kh = new customer();
                ObservableList<customer> list_cust = FXCollections.observableArrayList();
                kh.setId_khachhang(Integer.parseInt(data[3]));
                kh.setHoten(data[0]);
                kh.setSodienthoai(data[1]);
                kh.setDiemtichluy(data[2]);
                list_cust.add(kh);
                tb_danhsachkhachhang.setItems(list_cust);

            }
            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");

                // Header Text: null
                alert.setHeaderText(null);
                alert.setContentText("Khách hàng không tồn tại");
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void onClickSearch(InputMethodEvent event) {
    }

    @FXML
    private void onClickCheck(ActionEvent event) {
        
        String khachhtt = cbb_khachhtt.getSelectionModel().getSelectedItem();
        if(khachhtt.equals("Số đơn hàng nhiều nhất"))
        {
            tb_danhsachkhachhang.setItems(customer_data.getKhachhtt1());
        }
        else
        {
            tb_danhsachkhachhang.setItems(customer_data.getKhachhtt2());
        }
    }
    
}
