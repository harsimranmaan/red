
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers;

import adg.red.models.Glossary;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 * <p/>
 * @author jingboyu
 */
public class GlossaryController implements Initializable
{

    @FXML
    private Accordion glossaryAccordion; // Value injected by FXMLLoader
    @FXML
    private HBox alphabetHbox; // Value injected by FXMLLoader

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
        populateGlossary("All");

        Iterator<Node> nodes = alphabetHbox.getChildren().iterator();
        while (nodes.hasNext())
        {
            ((Hyperlink) nodes.next()).setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event)
                {
                    String beginsWith = ((Hyperlink) event.getSource()).getText();
                    populateGlossary(beginsWith);
                }
            });
        }
    }

    private void populateGlossary(String beginsWith)
    {
        List<Glossary> glossaryList;
        if (beginsWith.equals("All"))
        {
            glossaryList = Glossary.getAllGlossary();
        }
        else
        {
            glossaryList = Glossary.getByTermBeginsWith(beginsWith);
        }
        populate(glossaryList);
    }

    public void populate(List<Glossary> glossaryList)
    {
        glossaryAccordion.getPanes().clear();
        for (Glossary glossary : glossaryList)
        {
            glossaryAccordion.getPanes().add(new TitledPane(glossary.getTerm(), new Text(glossary.getDefinition())));
        }
    }
}
