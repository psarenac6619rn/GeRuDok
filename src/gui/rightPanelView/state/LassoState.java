package gui.rightPanelView.state;

import gui.rightPanelView.PageView;
import gui.rightPanelView.graphics.painters.RectanglePainter;
import gui.rightPanelView.graphics.painters.SlotPainter;
import repository.slot.Slot;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class LassoState extends State{
    PageView mediator;
    Point start;
    Point dragged;
    Slot temp;
    RectanglePainter lasso;
    Rectangle rect;

    public LassoState(PageView mediator) {
        this.mediator = mediator;
    }
    public void mousePressed(MouseEvent e) {

            for (SlotPainter sp : mediator.getSelecetedSlotPainters()) {
                sp.setPaint(Color.RED);
                mediator.getPage().removeSelectedSlot(sp.getSlot());
            }
        mediator.getSelecetedSlotPainters().clear();


            start = e.getPoint();
            rect=new Rectangle();
            rect.setSize(new Dimension(0,0));
            rect.setLocation(start);


    }

    public void mouseDragged(MouseEvent e){
        dragged=e.getPoint();
        rect.setSize(new Dimension((int)(dragged.getX()-start.getX()),(int)(dragged.getY()- start.getY())));
        mediator.getPage().setLasso(rect);

    }

    public void mouseReleased(MouseEvent e) {


            for (SlotPainter nsp : mediator.getSlotPainters()) {
                 if (rect.contains(nsp.getSlot().getPosition())){
                    nsp.setPaint(Color.GREEN);
                    mediator.getSelecetedSlotPainters().add(nsp);
                    mediator.getPage().setSelected(nsp.getSlot());

                }
            }
        mediator.getPage().setLasso(null);
    }

}
