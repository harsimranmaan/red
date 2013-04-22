/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controls;

import javafx.scene.control.Label;

/**
 *
 * @author harsimran.maan
 */
public class MessageStyleManager
{

    public static void setError(Label label)
    {
        label.getStyleClass().remove("success-label");
        label.getStyleClass().add("error-label");
    }

    public static void setSuccess(Label label)
    {
        label.getStyleClass().remove("error-label");
        label.getStyleClass().add("success-label");
    }
}
