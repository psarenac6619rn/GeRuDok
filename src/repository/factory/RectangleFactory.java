package repository.factory;

import repository.Page;
import repository.slot.RectangleSlot;
import repository.slot.Slot;
import repository.slot.SlotTypeEnum;

import java.awt.*;

public class RectangleFactory extends SlotFactory{

    @Override
    public Slot makeSlot(String name, Page parent, SlotTypeEnum type) {
        Slot slot=null;
        if(type==SlotTypeEnum.R){
            slot=new RectangleSlot(name,parent,new Dimension(80,40),null);
        }
        return  slot;
    }
}
