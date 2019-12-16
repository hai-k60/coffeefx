/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeefx;

import coffee.data.material_data;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.material;

/**
 * FXML Controller class
 *
 * @author MyPC
 */
public class PanelstorageController implements Initializable {

    ObservableList<String> list_unit = FXCollections.observableArrayList("gam", "chai", "hop");
    
    private boolean flag = false;
    @FXML
    private Button btt_reload;
    @FXML
    private AnchorPane txt_cost;
    @FXML
    private TextField txt_name;
    @FXML
    private Button btt_modify;
    @FXML
    private Button btt_delete;
    @FXML
    private ComboBox<String> cbb_unit;
    @FXML
    private TextField txt_amount;
    @FXML
    private TableColumn<material, Integer> id_column;
    @FXML
    private TableColumn<material, String> name_column;
    @FXML
    private TableColumn<material, String> amount_column;
    @FXML
    private TableColumn<material, String> unit_column;
    @FXML
    private TableView<material> table;
    @FXML
    private Label lb_warn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cbb_unit.setValue("gam");
        cbb_unit.setItems(list_unit);
        
                //Set up the columns in the table
        id_column.setCellValueFactory(new PropertyValueFactory<material, Integer>("id"));
        name_column.setCellValueFactory(new PropertyValueFactory<material, String>("name"));
        amount_column.setCellValueFactory(new PropertyValueFactory<material, String>("amount"));
        unit_column.setCellValueFactory(new PropertyValueFactory<material, String>("unit"));
        
        //load dummy data
        //table.setItems(getMaterial());
        table.setItems(material_data.GetMaterialData());
    }    

    @FXML
    private void handleButtonReload(ActionEvent event) {
        table.setItems(material_data.GetMaterialData());
    }

    @FXML
    private void handleButtonModify(ActionEvent event) {
        if(!flag){
            lb_warn.setVisible(true);
            lb_warn.setText("Không có dòng nào được chọn cả!!!");
        }
        else{
            lb_warn.setVisible(false);
            material mat = table.getSelectionModel().getSelectedItem();
            //Load value from row to txt field
            //txt_name.setText(mat.getName());
            //cbb_unit.setPromptText(mat.getUnit()); //TODO: Check this, It's not ok!
            
            if(txt_amount.getText() == null){
                lb_warn.setText("Bạn chưa nhập lượng nhập!!!");
                lb_warn.setVisible(true);
            }   
            else{
                // Add amount to luong
                String amount = txt_amount.getText();
                int id = mat.getId();
                //String old_amount = mat.getAmount();
                
                material_data.mod_available(amount, id);
                table.setItems(material_data.GetMaterialData());
            }
            flag = false;
        }
    }

    @FXML
    private void handleButtonDelete(ActionEvent event) {
        if(!flag){
            lb_warn.setVisible(true);
            lb_warn.setText("Không có dòng nào được chọn cả!!!");
        }
        else{
            lb_warn.setVisible(false);
            material mat = table.getSelectionModel().getSelectedItem();
            //Load value from row to txt field
            //txt_name.setText(mat.getName());
            //cbb_unit.setPromptText(mat.getUnit()); //TODO: Check this, It's not ok!
            
            int id = mat.getId();
            material_data.delMaterial(id);
            table.setItems(material_data.GetMaterialData());
            
            flag = false;
        }
    }

    @FXML
    private void handleRowClicked(MouseEvent event) {
        material mat = table.getSelectionModel().getSelectedItem();
        //int id = table.getSelectionModel().getSelectedItem().getId();
        //System.out.println(id);
        flag = true;
        //Load value from row to txt field
        txt_name.setText(mat.getName());
        txt_amount.setText(mat.getAmount());
        cbb_unit.setPromptText(mat.getUnit());
        
        //Get value from amout txt field
        //return mat;
    }
    
}
