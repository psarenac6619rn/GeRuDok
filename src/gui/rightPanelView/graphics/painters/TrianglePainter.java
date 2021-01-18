package gui.rightPanelView.graphics.painters;


import repository.slot.Slot;
import repository.slot.TriangleSlot;

import java.awt.geom.GeneralPath;

public class TrianglePainter extends SlotPainter {
    public TrianglePainter(Slot element) {
        super(element);
        TriangleSlot t=(TriangleSlot)element;

        shape=new GeneralPath();

        ((GeneralPath)shape).moveTo(t.getPosition().getX(),t.getPosition().getY());
        ((GeneralPath)shape).lineTo(t.getPosition().getX()+t.getDimension().width,t.getPosition().getY()+t.getDimension().height);
        ((GeneralPath)shape).lineTo(t.getPosition().getX(),t.getPosition().getY()+t.getDimension().height);


        ((GeneralPath)shape).closePath();
    }
}
