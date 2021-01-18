package gui.rightPanelView.state;

import app.Main;
import gui.rightPanelView.PageView;
import gui.rightPanelView.graphics.painters.SlotPainter;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

public class MoveState extends State{
    Point start;
    Point dragged;
    PageView mediator;


    public MoveState(PageView mediator) {
        this.mediator = mediator;
    }


    public void mousePressed(MouseEvent e) {

        Point position = e.getPoint();
        if (e.getButton()== MouseEvent.BUTTON1){


            if(!(mediator.getSelecetedSlotPainters()==null)) {
                start = position;
                for (SlotPainter nsp: mediator.getSelecetedSlotPainters()) {
                    nsp.getSlot().setOriginalPosition(nsp.getSlot().getPosition());
                }
            }


        }

    }

    public void mouseDragged(MouseEvent e){
         dragged=e.getPoint();

            for (SlotPainter nsp: mediator.getSelecetedSlotPainters()) {
                int originalX= (int) nsp.getSlot().getOriginalPosition().getX();
                int originaly= (int) nsp.getSlot().getOriginalPosition().getY();

                Main.getInstance().getSlotHandler().move(start, dragged, nsp, mediator, originalX, originaly);
            }

    }

    public void mouseReleased(MouseEvent e) {


        for (SlotPainter nsp: mediator.getSelecetedSlotPainters()) {
            nsp.getSlot().setOriginalPosition(nsp.getSlot().getPosition());
        }


    }
}
