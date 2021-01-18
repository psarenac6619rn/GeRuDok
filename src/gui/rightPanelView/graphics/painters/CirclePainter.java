package gui.rightPanelView.graphics.painters;


import repository.slot.CircleSlot;
import repository.slot.Slot;

import java.awt.geom.GeneralPath;

public class CirclePainter extends SlotPainter {

    public CirclePainter(Slot element) {
        super(element);
        CircleSlot cr=(CircleSlot)element;

        shape=new GeneralPath();

        ((GeneralPath)shape).moveTo(cr.getPosition().getX()+cr.getDimension().getWidth()/2,cr.getPosition().getY());
        ((GeneralPath)shape).quadTo(cr.getPosition().getX()+cr.getDimension().getWidth(),cr.getPosition().getY(), cr.getPosition().getX()+cr.getDimension().getWidth(),cr.getPosition().getY()+cr.getDimension().getHeight()/2);
        ((GeneralPath)shape).quadTo(cr.getPosition().getX()+cr.getDimension().getWidth(),cr.getPosition().getY()+cr.getDimension().getHeight(),cr.getPosition().getX()+cr.getDimension().getWidth()/2, cr.getPosition().getY()+cr.getDimension().getHeight());
        ((GeneralPath)shape).quadTo(cr.getPosition().getX(),cr.getPosition().getY()+cr.getDimension().getHeight(),cr.getPosition().getX(), cr.getPosition().getY()+cr.getDimension().getHeight()/2);
        ((GeneralPath)shape).quadTo(cr.getPosition().getX(),cr.getPosition().getY(),cr.getPosition().getX()+cr.getDimension().getWidth()/2,cr.getPosition().getY());
    }
}
