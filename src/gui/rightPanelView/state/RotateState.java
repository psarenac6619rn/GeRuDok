package gui.rightPanelView.state;

import app.Main;
import gui.rightPanelView.PageView;
import gui.rightPanelView.graphics.painters.SlotPainter;

import java.awt.*;
import java.awt.event.MouseEvent;

public class RotateState extends State{
    PageView mediator;
    int slotx;int sloty;
    Point start;
    Point dragged;
    SlotPainter sp;

    public RotateState(PageView mediator) {
        this.mediator = mediator;
    }
    public void mousePressed(MouseEvent e) {/*

        Point position = e.getPoint();
        if (e.getButton()== MouseEvent.BUTTON1){



            start = position;
            sp=mediator.getSelectedSlot();
            if (!(sp==null)) {

                slotx = (int) sp.getSlot().getPosition().getX();
                sloty = (int) sp.getSlot().getPosition().getY();
            }

        }*/

    }

    public void mouseDragged(MouseEvent e){/*
        sp=mediator.getSelectedSlot();
        dragged=e.getPoint();

        if(sp==null){

        }
        else {
            Main.getInstance().getSlotHandler().rotate(start,dragged,sp,slotx,sloty);
        }*/

    }

    public void mouseReleased(MouseEvent e) {





    }
}
