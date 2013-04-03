/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers;

import adg.red.models.Faq;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Witt
 */
public class FaqController implements Initializable {

    @FXML //  fx:id="accordion"
    private Accordion accordion; // Value injected by FXMLLoader
    
    private ListView<Text> faqLv; // Value injected by FXMLLoader
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        populateListView();
    }    
    
    public void populateListView() {
        
        List<Faq> faqList= Faq.getAllFaq();
        for(Faq faq: faqList) 
        {
           accordion.getPanes().add(new TitledPane(faq.getQuestion(),new TextArea(faq.getAnswer())));
        }
    }
}
