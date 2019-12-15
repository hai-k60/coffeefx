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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.material;

/**
 * FXML Controller class
 *
 * @author MyPC
 */
public class PanelmaterialController implements Initializable {

    ObservableList<String> list_unit = FXCollections.observableArrayList("gam", "chai", "hop");
    
    @FXML
    private Button btt_create;
    @FXML
    private ComboBox<String> cbb_unit;
    @FXML
    private TextField txt_name;
    @FXML
    private TextField amount;
    @FXML
    private TableView<material> table;
    @FXML
    private TextField cost;
    @FXML
    private Button btt_update;
    @FXML
    private TableColumn<material, Integer> id_column;
    @FXML
    private TableColumn<material, String> name_column;
    @FXML
    private TableColumn<material, String> amount_column;
    @FXML
    private TableColumn<material, String> unit_column;

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
    
    public ObservableList<material> getMaterial(){
        ObservableList<material> mat = FXCollections.observableArrayList();
        mat.add(new material(1,"nuoc", "5", "hop"));
        mat.add(new material(2,"sua", "7", "hop"));
        
        return mat;
    }

    @FXML
    private void handleButtonCreate(ActionEvent event) {
        
        
    }

    @FXML
    private void handleButtonUpdate(ActionEvent event) {
    }
    
    
    
}
