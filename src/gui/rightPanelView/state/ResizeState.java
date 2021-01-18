package gui.rightPanelView.state;

import app.Main;
import gui.rightPanelView.PageView;
import gui.rightPanelView.graphics.painters.SlotPainter;


import java.awt.*;
import java.awt.event.MouseEvent;

public class ResizeState extends State {
    PageView mediator;
    Point start;
    Point dragged;

    public ResizeState(PageView mediator) {
        this.mediator = mediator;
    }

    public void mousePressed(MouseEvent e) {

        Point position = e.getPoint();
        if (e.getButton()== MouseEvent.BUTTON1){



                    if(!(mediator.getSelecetedSlotPainters()==null)){
                        start = position;
                        for (SlotPainter nsp: mediator.getSelecetedSlotPainters()) {
                            nsp.getSlot().setOriginalDimension(nsp.getSlot().getDimension());
                        }
                    }

            }

    }

    public void mouseDragged(MouseEvent e){
        dragged = e.getPoint();
        for(SlotPainter nsp: mediator.getSelecetedSlotPainters()) {

             int originalx = (int) nsp.getSlot().getOriginalDimension().getWidth();
             int originaly = (int) nsp.getSlot().getOriginalDimension().getHeight();

                Main.getInstance().getSlotHandler().resize(start, dragged, nsp, mediator, originalx, originaly);

        }
    }

    public void mouseReleased(MouseEvent e) {


        for (SlotPainter nsp: mediator.getSelecetedSlotPainters()) {
            nsp.getSlot().setOriginalDimension(nsp.getSlot().getDimension());
        }


    }

}
