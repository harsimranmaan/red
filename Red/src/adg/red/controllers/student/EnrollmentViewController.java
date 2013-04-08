///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package adg.red.controllers.student;
//
//import adg.red.controllers.BreadCrumbController;
//import adg.red.models.Course;
//import adg.red.models.Registration;
//import adg.red.utils.Context;
//import adg.red.utils.LocaleManager;
//import java.net.URL;
//import java.util.List;
//import java.util.ResourceBundle;
//import javafx.beans.property.SimpleStringProperty;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//
///**
// * FXML Controller class
// *
// * @author jingboyu
// */
//public class EnrollmentViewController implements Initializable {
//
//    public class Item {
//        public String programName;
//        
//        public String getProgramName() {
//            return programName;
//        }
//    }
//    
//    @FXML
//    private TableColumn<Item, String> colProgram;
//    @FXML
//    private TableView<Item> tabDisplay;    
//    
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        Context.getInstance().setTitle(LocaleManager.get(60)); // to do ??? don't know ???
//        BreadCrumbController.renderBreadCrumb("student/HomeView|student/EnrollmentView"); // don't know
//        initializeComponentsByLocale();
//        List<Item> itemList = new List<Item>();
//        
//        populateEnrollmentTable();
//    }
//
//    private void initializeComponentsByLocale()
//    {
//        colProgram.setText(LocaleManager.get(50));
//        tabDisplay.getItems();
//    } 
//    
//    private void populateEnrollmentTable(List<Item> itemList)
//    {
//        colProgram.setCellValueFactory(new PropertyValueFactory<Item, String>("programName"));
//        tabDisplay.getItems().setAll(itemList);
//    }
//}
//
