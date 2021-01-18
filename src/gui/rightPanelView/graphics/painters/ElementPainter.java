package gui.rightPanelView.graphics.painters;

import repository.slot.Slot;

import java.awt.*;

public abstract class ElementPainter {

    public ElementPainter(Slot element){ }

    public abstract void paint(Graphics2D g, Slot element);

    public  abstract boolean isElementAt(Point position);


}
