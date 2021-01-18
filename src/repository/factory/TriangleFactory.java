package repository.factory;

import repository.Page;
import repository.slot.Slot;
import repository.slot.SlotTypeEnum;
import repository.slot.TriangleSlot;

import java.awt.*;

public class TriangleFactory extends SlotFactory {
    @Override
    public Slot makeSlot(String name, Page parent, SlotTypeEnum type) {
        Slot slot=null;
        if(type==SlotTypeEnum.T){
            slot=new TriangleSlot(name,parent,new Dimension(50,50),null);
        }
        return slot;
    }
}
