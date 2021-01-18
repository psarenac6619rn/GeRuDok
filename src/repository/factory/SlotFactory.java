package repository.factory;

import repository.Page;
import repository.slot.Slot;
import repository.slot.SlotTypeEnum;

import java.awt.*;

public abstract class SlotFactory {
    public Slot createSlot(String name, SlotTypeEnum type, Page parent, Point position){
        Slot slot;
        slot= makeSlot(name, parent, type);
        slot.setPosition(position);
        return slot;
    }

    public abstract Slot makeSlot(String name,Page parent,SlotTypeEnum type);

}
