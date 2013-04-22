package adg.red.controls;

import adg.red.locale.LocaleManager;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author harsimran.maan
 */
public class CustomTextBox extends HBox
{

    private TextBoxType textBoxType;
    final TextField field;
    final Label lblHeader;
    final Label lblError;
    final VBox vBox;

    public CustomTextBox(TextBoxType type, String labelText, String errorMessage)
    {
        super(3);
        super.setAlignment(Pos.TOP_CENTER);
        textBoxType = type;
        vBox = new VBox(3);
        lblHeader = new Label(labelText);
        lblHeader.setPrefWidth(120);
        lblHeader.setAlignment(Pos.CENTER_RIGHT);
        lblHeader.setText(labelText); 
       
        
        lblError = new Label(errorMessage);
        lblError.setTextFill(Color.RED);
        lblError.setVisible(false);
        lblError.setText(errorMessage);

        field = new TextField()
        {
            @Override
            public void replaceText(int start, int end, String text)
            {
                super.replaceText(start, end, text);
                if (this.getText().matches(textBoxType.getPattern()))
                {
                    lblError.setVisible(false);
                }
                else
                {
                    lblError.setVisible(true);
                }


            }

            @Override
            public void replaceSelection(String text)
            {
                super.replaceSelection(text);
                if (this.getText().matches(textBoxType.getPattern()))
                {

                    lblError.setVisible(false);
                }
                else
                {
                    lblError.setVisible(true);
                }


            }
        };
        field.setPrefWidth(200);
        vBox.getChildren().setAll(field, lblError);
        this.getChildren().setAll(lblHeader, vBox);

    }

    public String getText()
    {
        return field.getText();
    }

    public void setText(String text)
    {
        field.setText(text);
    }
}
