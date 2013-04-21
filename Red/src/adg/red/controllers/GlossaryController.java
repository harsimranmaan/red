
/*
 *
 *
 */
package adg.red.controllers;

import adg.red.models.Glossary;
import adg.red.session.Context;
import adg.red.locale.LocaleManager;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class for Glossary.fxml
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
        populateGlossary("All");
        Context.getInstance().setTitle(LocaleManager.get(14));
        BreadCrumbController.renderBreadCrumb(Context.getInstance().getCurrentUser().getUserTypeId().getName().toLowerCase() + "/HomeView|Glossary");
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

    /**
     * Get list of glossary that begins with the input character
     * @param beginsWith the input character that a glossary term begins with  
     */
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

    /**
     * Populate the glossary table
     * @param glossaryList the list that begins with a specified character or list all
     */
    public void populate(List<Glossary> glossaryList)
    {
        glossaryAccordion.getPanes().clear();

        for (Glossary glossary : glossaryList)
        {
            TextArea text = new TextArea(glossary.getDefinition());
            text.setEditable(false);
            text.setWrapText(true);
            glossaryAccordion.getPanes().add(new TitledPane(glossary.getTerm(), text));
        }
    }
}
