/*
 * 
 * 
 */
package adg.red.controllers;

import adg.red.models.Faq;
import adg.red.session.Context;
import adg.red.locale.LocaleManager;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.scene.control.Accordion;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;

/**
 * FXML Controller class for FaqView.fxml
 * <p/>
 * @author Witt
 */
public class FaqController implements Initializable
{

    @FXML
    private Accordion accordion;
    private ListView<Text> faqLv;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        Context.getInstance().setTitle(LocaleManager.get(16));
        BreadCrumbController.renderBreadCrumb(Context.getInstance().getCurrentUser().getUserTypeId().getName().toLowerCase() + "/HomeView|FaqView");
        populateListView();
    }

    /**
     *  Gets the faq list and populate the faq table with the list.
     */
    public void populateListView()
    {

        List<Faq> faqList = Faq.getAllFaq();
        for (Faq faq : faqList)
        {
            TextArea text = new TextArea(faq.getAnswer());
            text.setEditable(false);
            text.setWrapText(true);
            accordion.getPanes().add(new TitledPane(faq.getQuestion(), text));
        }
    }
}
