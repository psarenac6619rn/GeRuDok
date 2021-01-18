package gui.controller;

import app.Main;
import error.ErrorEnum;
import gui.rightPanelView.PageView;
import gui.view.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ContentAction extends AbstractActionClass{
    public ContentAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("images/content.png"));
        putValue(NAME, "Add Content");
        putValue(SHORT_DESCRIPTION, "Add Content");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(MainView.getInstance().getActiveDocument()!=null) {
            if(MainView.getInstance().getActiveDocument().getPages().size()!=0) {
                for (PageView pv : MainView.getInstance().getActiveDocument().getPages()) {
                    pv.startContentState();
                }

            }else{
                Main.getInstance().getErrorHandler().generateError(ErrorEnum.ERROR_NOACTIVEPAGE);
            }
        }else{
            Main.getInstance().getErrorHandler().generateError(ErrorEnum.ERROR_NOACTIVEPAGE);
        }
    }
}
