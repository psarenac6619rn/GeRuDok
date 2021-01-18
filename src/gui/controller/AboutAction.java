package gui.controller;

import gui.view.AboutView;

import javax.naming.Name;
import java.awt.event.ActionEvent;

public class AboutAction extends AbstractActionClass{

    public AboutAction(){
        putValue(NAME,"About");

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        AboutView about = new AboutView();
        about.setVisible(true);


    }
}
