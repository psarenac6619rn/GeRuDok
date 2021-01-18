package commands;

import gui.rightPanelView.PageView;
import gui.rightPanelView.graphics.painters.SlotPainter;
import gui.view.MainView;
import repository.Page;
import repository.factory.CircleFactory;
import repository.factory.RectangleFactory;
import repository.factory.SlotFactory;
import repository.slot.Slot;
import repository.slot.SlotTypeEnum;

import java.awt.*;

public class AddCommand extends  AbstractCommand{
    static private int i = 0;
    private PageView page;
    private Point point;
    private SlotTypeEnum slotTypeEnum;
    private Slot slot;
    private SlotPainter slotPainter;

    public AddCommand(PageView page,Point point, SlotTypeEnum slotTypeEnum) {
        this.page = page;
        this.point = point;
        this.slotTypeEnum = slotTypeEnum;
    }

    @Override
    public void doCommand() {
        if(slot == null) {
            if(slotTypeEnum == SlotTypeEnum.R) {
                System.out.println("Dodje");
                SlotFactory slotFactory = new RectangleFactory();
                slot = slotFactory.createSlot("Rectangle" + i++,slotTypeEnum,page.getPage(),point);
                slotPainter = new SlotPainter(slot);
                page.getSlotPainters().add(slotPainter);
                page.getPage().notifyListeners(this);
                page.getPage().addChild(slot);


            }
            if(slotTypeEnum == SlotTypeEnum.C) {
                SlotFactory slotFactory=new RectangleFactory();
                slot = slotFactory.createSlot("Triangle" + i++,slotTypeEnum,page.getPage(),point);
                page.getPage().addChild(slot);
            }
            if(slotTypeEnum == SlotTypeEnum.T) {
                SlotFactory slotFactory = new CircleFactory();
                slot =slotFactory.createSlot("Circle",slotTypeEnum,page.getPage(),point);
                page.getPage().addChild(slot);
            }
        }
        else
            page.getPage().addChild(slot);

    }

    @Override
    public void undoCommand() {
        page.getPage().removeChild(slot);
    }
}
