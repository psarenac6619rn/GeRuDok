package repository.factory;

import repository.Page;
import repository.slot.CircleSlot;
import repository.slot.Slot;
import repository.slot.SlotTypeEnum;

import java.awt.*;

public class CircleFactory extends SlotFactory{


    @Override
    public Slot makeSlot(String name, Page parent, SlotTypeEnum type) {
        Slot slot=null;
        if(type==SlotTypeEnum.C){
            slot=new CircleSlot(name,parent,new Dimension(50,50),null);
        }
        return slot;
    }
}
