package gui.view;

import gui.controller.ActionManager;

import javax.swing.*;

public class Pallete extends JToolBar{
    public Pallete(){
        add(ActionManager.getInstance().getCircleAction());
        add(ActionManager.getInstance().getRectangleAction());
        add(ActionManager.getInstance().getTriangleAction());
        add(ActionManager.getInstance().getSelectAction());
        add(ActionManager.getInstance().getDeleteAction());
        add(ActionManager.getInstance().getResizeAction());
        add(ActionManager.getInstance().getMoveSlotAction());
        add(ActionManager.getInstance().getRotateAction());
        add(ActionManager.getInstance().getLassoAction());
        add(ActionManager.getInstance().getContentAction());
        setFloatable(false);
        setOrientation(JToolBar.VERTICAL);
    }
}
