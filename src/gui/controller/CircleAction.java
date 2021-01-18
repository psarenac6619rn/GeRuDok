package gui.controller;

import gui.rightPanelView.PageView;
import gui.view.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class CircleAction extends AbstractActionClass{
    public CircleAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("images/circle.png"));
        putValue(NAME, "Draw Circle");
        putValue(SHORT_DESCRIPTION, "Draw Circle");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(PageView pv: MainView.getInstance().getActiveDocument().getPages()){
            pv.startCircleState();
            System.out.println(pv.getName()+"   "+pv.getStateManager().getCurrentState());
        }
    }
}
