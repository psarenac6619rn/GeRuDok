package repository.slot;

import repository.node.RafNode;

import java.awt.*;
import java.awt.geom.Point2D;

public class TriangleSlot extends Slot{
    public SlotTypeEnum type;
    public TriangleSlot(String name, RafNode parent, Dimension dimension, Point2D position) {
        super(name, parent, dimension, position);
        type= SlotTypeEnum.T;
    }

    public SlotTypeEnum getType() {
        return type;
    }
}
