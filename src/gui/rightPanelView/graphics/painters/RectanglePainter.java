package gui.rightPanelView.graphics.painters;

import repository.slot.RectangleSlot;
import repository.slot.Slot;

import java.awt.geom.GeneralPath;

public class RectanglePainter extends SlotPainter {
    public RectanglePainter(Slot element) {
        super(element);

        RectangleSlot rectangle = (RectangleSlot) element;

        shape=new GeneralPath();
        ((GeneralPath)shape).moveTo(rectangle.getPosition().getX(),rectangle.getPosition().getY());

        ((GeneralPath)shape).lineTo(rectangle.getPosition().getX()+rectangle.getDimension().width,rectangle.getPosition().getY());

        ((GeneralPath)shape).lineTo(rectangle.getPosition().getX()+rectangle.getDimension().width,rectangle.getPosition().getY()+rectangle.getDimension().height);

        ((GeneralPath)shape).lineTo(rectangle.getPosition().getX(),rectangle.getPosition().getY()+rectangle.getDimension().height);

        ((GeneralPath)shape).closePath();

    }
}
