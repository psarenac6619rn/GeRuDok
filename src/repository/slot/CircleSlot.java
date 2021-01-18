package repository.slot;

import repository.node.RafNode;

import java.awt.*;
import java.awt.geom.Point2D;

public class CircleSlot extends Slot{
    public SlotTypeEnum type;
    public CircleSlot(String name, RafNode parent, Dimension dimension, Point2D position) {
        super(name, parent, dimension, position);
        type= SlotTypeEnum.C;
    }

    public SlotTypeEnum getType() {
        return type;
    }
}
