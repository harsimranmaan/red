/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers;

import adg.red.models.Glossary;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 * <p/>
 * @author jingboyu
 */
public class GlossaryController implements Initializable
{

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

    public void populateListView(String beginsWith)
    {
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

        for (Glossary glossary : glossaryList)
        {
            Text textItem = new Text();
            textItem.wrappingWidthProperty().bind(glossaryLv.widthProperty());
            textItem.setText(glossary.getTerm());
            stringList.add(textItem);

            Text textDefinition = new Text();
            textDefinition.wrappingWidthProperty().bind(glossaryLv.widthProperty());
            textDefinition.setText(glossary.getDefinition());
            stringList.add(textDefinition);
        }

        glossaryLv.getItems().setAll(stringList);

    }
}
