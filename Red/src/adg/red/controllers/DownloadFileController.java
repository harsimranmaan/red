/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;

/**
 *
 * @author Witt
 */
public class DownloadFileController
{

    public static void saveFile(String content, String extension)
    {
        FileChooser fileChooser = new FileChooser();
        //Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(extension + " file  (*." + extension + ")", "*." + extension);
        fileChooser.getExtensionFilters().add(extFilter);



        //Show open file dialog
        File file = fileChooser.showSaveDialog(null);
        String filePath = file.getAbsolutePath() + "." + extension;

        save(content, filePath);
    }

    private static void save(String content, String file)
    {
        try
        {
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();
        }
        catch (IOException ex)
        {
            Logger.getLogger(DownloadFileController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
