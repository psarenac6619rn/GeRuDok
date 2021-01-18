package gui.controller;

import javax.swing.*;
import java.net.URL;

public abstract class AbstractActionClass extends AbstractAction {

    public Icon loadIcon(String filename){
        Icon icon = null;

        if(filename != null) icon = new ImageIcon(filename);
        else {
            System.err.println("Resource not found: " + filename);
        }
        return icon;
    }



}
