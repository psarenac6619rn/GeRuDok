package gui.controller;

import gui.rightPanelView.PageView;
import gui.view.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ResizeAction extends AbstractActionClass{
    public ResizeAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F7, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("images/resize.png"));
        putValue(NAME, "Resize slot");
        putValue(SHORT_DESCRIPTION, "Resize slot");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(PageView pv: MainView.getInstance().getActiveDocument().getPages()){
            pv.startResizeState();
            System.out.println(pv.getName()+"   "+pv.getStateManager().getCurrentState());
        }
    }
}
