/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers;

import adg.red.models.Department;
import adg.red.models.Faq;
import adg.red.models.Glossary;
import adg.red.utils.Context;
import adg.red.utils.ViewLoader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author jingboyu
 */
public class GlossaryController implements Initializable {

    @FXML //  fx:id="glossaryLv"
    private ListView<Text> glossaryLv; // Value injected by FXMLLoader
    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
        populateListView("All");

    }

    
    public void populateListView(String beginsWith) {
        List<Glossary> glossaryList;
        //glossaryList = Glossary.getAllGlossary();
        List<Text> stringList = new ArrayList<>();
          
        if (beginsWith.equals("All"))
        {
            glossaryList = Glossary.getAllGlossary();
        }
        else
        {
            glossaryList = Glossary.getByTermBeginsWith(beginsWith);
        }
        //populate(glossaryList);
        
        for(Glossary glossary: glossaryList) {
            Text textItem = new Text();
            textItem.wrappingWidthProperty().bind(glossaryLv.widthProperty());
            textItem.setText(glossary.getGlossaryPK().getTerm());            
            stringList.add(textItem);
            
            Text textDefinition = new Text();            
            textDefinition.wrappingWidthProperty().bind(glossaryLv.widthProperty());
            textDefinition.setText(glossary.getDefinition());            
            stringList.add(textDefinition);
        }           
        
        glossaryLv.getItems().setAll(stringList);
        
    }
}