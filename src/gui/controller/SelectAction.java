package gui.controller;

import gui.rightPanelView.PageView;
import gui.view.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class SelectAction extends AbstractActionClass{
    public SelectAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F10, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("images/select.png"));
        putValue(NAME, "SelectSlot");
        putValue(SHORT_DESCRIPTION, "Select Slot");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(PageView pv: MainView.getInstance().getActiveDocument().getPages()){
            pv.startSelectState();
            System.out.println(pv.getName()+"   "+pv.getStateManager().getCurrentState());
        }
    }
}
