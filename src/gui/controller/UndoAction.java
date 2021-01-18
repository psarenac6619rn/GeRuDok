package gui.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class UndoAction extends AbstractActionClass{

    public UndoAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("images/undo.png"));
        putValue(NAME, "Undo action");
        putValue(SHORT_DESCRIPTION, "Undo action");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
