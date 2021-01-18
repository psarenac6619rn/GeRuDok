package gui.controller;

import gui.rightPanelView.PageView;
import gui.view.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RotateAction extends AbstractActionClass{
    public RotateAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F8, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("images/rotate.png"));
        putValue(NAME, "Rotate slot");
        putValue(SHORT_DESCRIPTION, "Rotate slot");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(PageView pv: MainView.getInstance().getActiveDocument().getPages()){
            pv.startRotateState();
        }
    }
}
