/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeefx;

import coffee.data.douongdata;
import coffee.data.material_data;
import coffee.data.thanhphandouong_data;
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
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import model.douong;
import model.material;
import model.nguyenlieu;
import model.thanhphandouong;

/**
 * FXML Controller class
 *
 * @author MyPC
 */
public class PanelmenuController implements Initializable {
    ObservableList<String> list_unit_loai = FXCollections.observableArrayList("Cà Phê", "Trà","Sinh tố");
    ObservableList<String> list_unit_donvi = FXCollections.observableArrayList("Cốc", "Hộp");
    ObservableList<String> list_unit_nguyenlieu = FXCollections.observableArrayList("Bột cà phê", "Đường", "Sữa", "Bột trà");
    ObservableList<String> list_unit_douong = FXCollections.observableArrayList("Cà phê đen", "Cà phê nâu", "Cà phê cốt dừa", "Bạc xỉu","Trà chanh","Trà đào cam xả","Nước cam");
//    public void fillComboBox(){
//        String query = "select FirstName from douong";
//        pst = conn.pepareStatement(query);
//        
//    }
    @FXML
    private Tab DoUong_tab;
    @FXML
    private TableView<douong> table_menu;
    @FXML
    private TableColumn<douong, Integer> id_column;
    @FXML
    private TableColumn<douong, String> DoUong_column;
    @FXML
    private TableColumn<douong, String> Loai_column;
    @FXML
    private TableColumn<douong, Integer> Gia_column;
    @FXML
    private TableColumn<douong, String> DonVi_column;
    @FXML
    private Tab ThanhPhan_tab;
    @FXML
    private TextField tendouong_txt;
    @FXML
    private Button btn_them;
    @FXML
    private TextField giatien_txt;
    @FXML
    private Button btn_sua;
    @FXML
    private Button btn_xoa;
    @FXML
    private ComboBox<String> cbb_donvi;
    @FXML
    private ComboBox<String> cbb_loaidouong;
    @FXML
    private Label lb_warn;
    private ComboBox<String> cbb_nguyenlieu;
    private TextField luong_txt;
    @FXML
    private Button btn_capnhatTP;
    @FXML
    private ComboBox<String> cbb_nguyenlieu1;
    @FXML
    private TextField luong_txt1;
    @FXML
    private Label lb_warn1;
    @FXML
    private TableView<thanhphandouong> table_thanhphan;
    @FXML
    private TableColumn<thanhphandouong, Integer> luong_column;
    @FXML
    private ComboBox<String> cbb_loaidouong1;
    @FXML
    private TableColumn<thanhphandouong, String> idnguyenlieu_column;
  //  private TableColumn<nguyenlieu, String> tennguyenlieu_column;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                cbb_loaidouong.setValue("Chọn loại đồ uống");
                cbb_loaidouong.setItems(list_unit_loai);
                cbb_nguyenlieu1.setValue("Chọn nguyên liệu");
                cbb_nguyenlieu1.setItems(list_unit_nguyenlieu);
                cbb_loaidouong1.setValue("Chọn đồ uống");
                cbb_loaidouong1.setItems(list_unit_douong);
                cbb_donvi.setValue("Cốc");
                cbb_donvi.setItems(list_unit_donvi);
        // set up column in table
                id_column.setCellValueFactory(new PropertyValueFactory<douong, Integer>("id_douong"));
                DoUong_column.setCellValueFactory(new PropertyValueFactory<douong, String>("tendouong"));
                Loai_column.setCellValueFactory(new PropertyValueFactory<douong, String>("loaidouong"));
                Gia_column.setCellValueFactory(new PropertyValueFactory<douong, Integer>("gia"));
                DonVi_column.setCellValueFactory(new PropertyValueFactory<douong, String>("donvi"));
      //          tennguyenlieu_column.setCellValueFactory(new PropertyValueFactory<nguyenlieu, String>("tennguyenlieu"));
                idnguyenlieu_column.setCellValueFactory(new PropertyValueFactory<thanhphandouong, String>("tennguyenlieu"));
                luong_column.setCellValueFactory(new PropertyValueFactory<thanhphandouong, Integer>("luong"));
                table_menu.setItems(douongdata.GetDouongData());
    }    

    @FXML
    private void add_button(ActionEvent event) {
        if(tendouong_txt.getText().equals("") || giatien_txt.getText().equals("")){
            System.out.println("Bạn chưa nhập giá trị đầy đủ vào các ô!!!");
            lb_warn.setText("Bạn chưa nhập giá trị đầy đủ vào các ô!!!");
            lb_warn.setVisible(true);
        }
        else{
            String tendouong = tendouong_txt.getText();
            String loaidouong = cbb_loaidouong.getSelectionModel().getSelectedItem();
            int gia = Integer.parseInt(giatien_txt.getText().trim());
            String donvi = cbb_donvi.getSelectionModel().getSelectedItem();
            if(douongdata.is_existed(tendouong) == 1){
//               lb_warn.setText("Nguyên liệu này đã tồn tại, bạn không thể thêm! Bạn có thể Update!");
//               lb_warn.setVisible(true);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login");

            // Header Text: null
            alert.setHeaderText(null);
            alert.setContentText("Nguyên liệu này đã tồn tại, bạn không thể thêm! Bạn có thể Update!");

            alert.showAndWait();
            }
            else{
                //System.out.println(name + "test");
               int kq = douongdata.insertDoUong(tendouong, loaidouong, gia, donvi);
               if (kq == 1)
               {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Login");

            // Header Text: null
                    alert.setHeaderText(null);
                    alert.setContentText("Thêm thành công");

                    alert.showAndWait();
               }
               else
               {
//                    lb_warn.setText("Thêm thất bại");
//                    lb_warn.setVisible(true);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Login");

            // Header Text: null
                    alert.setHeaderText(null);
                    alert.setContentText("Thêm thất bại");

                    alert.showAndWait();
               }                   
                table_menu.setItems(douongdata.GetDouongData());
            }
             
        }
    
    }

    @FXML
    private void update_btn(ActionEvent event) {
        if(table_menu.getSelectionModel().getSelectedItem() == null){
            lb_warn.setVisible(true);
            lb_warn.setText("Chua chon dong");
        }
        else{
            lb_warn.setVisible(false);
            douong douong = table_menu.getSelectionModel().getSelectedItem();
            //Load value from row to txt field
            //txt_name.setText(mat.getName());
            //cbb_unit.setPromptText(mat.getUnit()); //TODO: Check this, It's not ok!
            
            if(tendouong_txt.getText() == null || giatien_txt.getText() == null){
                lb_warn.setText("Bạn chưa nhập tên nhập hoặc giá!");
                lb_warn.setVisible(true);
            }   
            else{
                // Add amount to luong
                String tendouong = tendouong_txt.getText();
                int id = douong.getId_douong();
                String loaidouong = cbb_loaidouong.getSelectionModel().getSelectedItem();
                int gia = Integer.parseInt(giatien_txt.getText().trim());
                String donvi = cbb_donvi.getSelectionModel().getSelectedItem();               
                int kq = douongdata.updateDoUong(id,tendouong,loaidouong, gia, donvi);
               if (kq == 1)
               {
                    lb_warn.setText("Update thành công");
                    lb_warn.setVisible(true);
               }
               else
               {
                    lb_warn.setText("Update thất bại");
                    lb_warn.setVisible(true);
               }  
                table_menu.setItems(douongdata.GetDouongData());
            }

        }
    }

    @FXML
    private void delete_btn(ActionEvent event) {
            if(table_menu.getSelectionModel().getSelectedItem().equals("")){
            lb_warn.setVisible(true);
            lb_warn.setText("Chưa chọn dòng!");
        }
        else{
            lb_warn.setVisible(false);
            douong douong = table_menu.getSelectionModel().getSelectedItem();
            //Load value from row to txt field
            //txt_name.setText(mat.getName());
            //cbb_unit.setPromptText(mat.getUnit()); //TODO: Check this, It's not ok!
            
            int id = douong.getId_douong();
            int kq = douongdata.deleteDouong(id);
            if (kq == 1)
               {
                    lb_warn.setText("Xóa thành công");
                    lb_warn.setVisible(true);
               }
               else
               {
                    lb_warn.setText("Xóa thất bại");
                    lb_warn.setVisible(true);
               }  
            table_menu.setItems(douongdata.GetDouongData());

        }
    }

    @FXML
    private void handleMouseClickedRow(MouseEvent event) {
        douong douong = table_menu.getSelectionModel().getSelectedItem();
        //int id = table.getSelectionModel().getSelectedItem().getId();
        //System.out.println(id);
        
        //Load value from row to txt field
        tendouong_txt.setText(douong.getTendouong());
        cbb_loaidouong.setPromptText(douong.getLoaidouong());
        giatien_txt.setText(Integer.toString(douong.getGia()));
        cbb_donvi.setPromptText(douong.getDonvi());
        //Get value from amout txt field
      //  return douong;
    }
//
//    private void capnhatTP_btn(ActionEvent event) {
//        if(table_menu.getSelectionModel().getSelectedItem() == null){
//            lb_warn.setVisible(true);
//            lb_warn.setText("Chua chon dong");
//        }  
//        else{
//            lb_warn.setVisible(false);
//            douong douong = table_menu.getSelectionModel().getSelectedItem();
//            //Load value from row to txt field
//            //txt_name.setText(mat.getName());
//            //cbb_unit.setPromptText(mat.getUnit()); //TODO: Check this, It's not ok!
//            int id_douong = douong.getId_douong();
//            int id_nguyenlieu = thanhphandouong_data.getid_nguyenlieu(cbb_nguyenlieu.getSelectionModel().getSelectedItem());
//            int luong = Integer.parseInt(luong_txt.getText().trim());
//            
//            int kq = thanhphandouong_data.insertThanhphan(id_douong, id_nguyenlieu, luong);
//            if (kq == 1)
//               {
//                    lb_warn.setText("Cập nhật thành công");
//                    lb_warn.setVisible(true);
//               }
//               else
//               {
//                    lb_warn.setText("Cập nhật thất bại");
//                    lb_warn.setVisible(true);
//               } 
//            }
//
//        }

    @FXML
    private void capnhatTP_btn_test(ActionEvent event) {
                 lb_warn1.setVisible(false);
//            douong douong = table_menu.getSelectionModel().getSelectedItem();
            //Load value from row to txt field
            //txt_name.setText(mat.getName());
            //cbb_unit.setPromptText(mat.getUnit()); //TODO: Check this, It's not ok!
            int id_douong = douongdata.getid_douong(cbb_loaidouong1.getSelectionModel().getSelectedItem());
            int id_nguyenlieu = thanhphandouong_data.getid_nguyenlieu(cbb_nguyenlieu1.getSelectionModel().getSelectedItem());
            int luong = Integer.parseInt(luong_txt1.getText().trim());
           int kq = thanhphandouong_data.insertThanhphan(id_douong, id_nguyenlieu, luong);
            String a = Integer.toString(id_douong);
            if (kq == 1)
               {
                    lb_warn1.setText("Cập nhật thành công ");
                    lb_warn1.setVisible(true);
               }
               else
               {
                    lb_warn1.setText("Cập nhật thất bại");
                    lb_warn1.setVisible(true);
               } 
            table_thanhphan.setItems(thanhphandouong_data.GetThanhPhanDoUong(id_douong));
//            table_nguyenlieu.setItems(material_data.GetTenNguyenLieu(id_nguyenlieu));
            }

    @FXML
    private void showlist(ActionEvent event) {
            int id_douong = douongdata.getid_douong(cbb_loaidouong1.getSelectionModel().getSelectedItem());
            table_thanhphan.setItems(thanhphandouong_data.GetThanhPhanDoUong(id_douong));
    }


    }

   
    



