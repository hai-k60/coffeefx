/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeefx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MyPC
 */
public class HomeController implements Initializable {
    
//    @FXML
//    private Label btn_logout;
//    
    @FXML
    private void onClickLogout(ActionEvent event){
        System.out.println("Log out");
        try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXMLDocument.fxml"));
                /* 
                 * if "fx:controller" is not set in fxml
                 * fxmlLoader.setController(NewWindowController);
                 */
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setTitle("Login");
                stage.setScene(scene);
                stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
            } catch (IOException e) {
                Logger logger = Logger.getLogger(getClass().getName());
                logger.log(Level.SEVERE, "Failed to create new Window.", e);
            }
    }
//    
//    @FXML
//    private void onClickHome(ActionEvent event) {
//    }
//    
    @FXML
    private void onClickOrder(ActionEvent event) {
    }
//    
//    @FXML
//    private void onClickMenu(ActionEvent event) {
//    }
//    
//    @FXML
//    private void onClickEmployees(ActionEvent event) {
//    }
//    
//    @FXML
//    private void onClickCustomer(ActionEvent event) {
//    }
//    
//    @FXML
//    private void onClickMaterials(ActionEvent event){
//    }
//    
//    @FXML
//    private void onClickStorage(ActionEvent event){
//    }
//    
//    @FXML
//    private void onClickReport(ActionEvent event){
//    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
