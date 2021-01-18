package gui.controller;

import gui.rightPanelView.PageView;
import gui.view.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class LassoAction extends AbstractActionClass{
    public LassoAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F15, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("images/lasso.png"));
        putValue(NAME, "Lasso Selection");
        putValue(SHORT_DESCRIPTION, "Lasso Selection");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(PageView pv: MainView.getInstance().getActiveDocument().getPages()){
            pv.startLassoState();
            System.out.println(pv.getName()+"   "+pv.getStateManager().getCurrentState());
        }
    }
}
