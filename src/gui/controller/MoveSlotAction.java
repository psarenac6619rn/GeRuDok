package gui.controller;

import gui.rightPanelView.PageView;
import gui.view.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MoveSlotAction extends AbstractActionClass{
    public MoveSlotAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F8, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("images/move.png"));
        putValue(NAME, "Move Slot");
        putValue(SHORT_DESCRIPTION, "Move Slot");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(PageView pv: MainView.getInstance().getActiveDocument().getPages()){
            pv.startMoveState();
            System.out.println(pv.getName()+"   "+pv.getStateManager().getCurrentState());
        }
    }
}
