package gui.controller;

import gui.rightPanelView.PageView;
import gui.view.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class    DeleteAction extends AbstractActionClass{
    public DeleteAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F11, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("images/deleteSlot.png"));
        putValue(NAME, "Delete slot");
        putValue(SHORT_DESCRIPTION, "Delete slot");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(PageView pv: MainView.getInstance().getActiveDocument().getPages()){
            pv.startDeleteState();
            System.out.println(pv.getName()+"   "+pv.getStateManager().getCurrentState());
        }
    }
}
