/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers;

import adg.red.BootStrap;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * The class that can load a new view
 * @author Witt
 */
public class View {
    private Pane viewArea;
    
    // constructor
    public View(Pane viewArea) {
        this.viewArea = viewArea;        
    }
    
    /**
     * Load new view.
     * @param fxmlView the fxml file name to be loaded.
     */
    public void loadView(String fxmlView) {
        // load home view
                try {
                    BootStrap boot = new BootStrap();
                    URL location = getClass().getResource(boot.getUserInterfaceUrl(fxmlView));
                    FXMLLoader fxmlLoader = new FXMLLoader(location);                   
                    Node view = (Node)fxmlLoader.load();
                    viewArea.getChildren().setAll(view);              
                    // set anchors
                    AnchorPane.setLeftAnchor(view, 0.0);
                    AnchorPane.setRightAnchor(view, 0.0);
                    AnchorPane.setTopAnchor(view, 0.0);
                    AnchorPane.setBottomAnchor(view, 0.0);
                }
                catch (Exception ex){
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                }   
    } 
    
}
