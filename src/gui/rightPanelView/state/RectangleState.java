package gui.rightPanelView.state;

import app.Main;
import commands.AddCommand;
import gui.rightPanelView.DocumentView;
import gui.rightPanelView.PageView;
import gui.rightPanelView.ProjectView;
import gui.rightPanelView.graphics.painters.ElementPainter;
import gui.rightPanelView.graphics.painters.RectanglePainter;
import gui.rightPanelView.graphics.painters.SlotPainter;
import gui.view.MainView;
import repository.factory.RectangleFactory;
import repository.factory.SlotFactory;
import repository.slot.Slot;
import repository.slot.SlotTypeEnum;

import java.awt.*;
import java.awt.event.MouseEvent;

public class RectangleState extends State{
    private PageView mediator;

    public RectangleState(PageView mediator) {
        this.mediator = mediator;
    }

    public void mousePressed(MouseEvent e) {
        Point position = e.getPoint();
        if (e.getButton()== MouseEvent.BUTTON1){
            if (mediator.getElementAtPosition(position)==-1){
//                SlotFactory slotFactory=new RectangleFactory();
//            Slot slot=slotFactory.createSlot("Rectangle"+mediator.getSlotPainters().size(), SlotTypeEnum.R, mediator.getPage(), position);
//          SlotPainter painter=new RectanglePainter(slot);\
                mediator.getCommandManager().addCommand(new AddCommand(mediator ,position,SlotTypeEnum.R));
                //mediator.getSlotPainters().add(painter);


          /*  for (DocumentView d:projectView.getDocumentViews()){
                if(d.getPages().contains(mediator)){
                    projectView.setFocused(mediator);
                }            }*/

            }
        }
    }
}
