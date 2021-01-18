package gui.rightPanelView.state;

import gui.rightPanelView.DocumentView;
import gui.rightPanelView.PageView;
import gui.rightPanelView.ProjectView;
import gui.rightPanelView.graphics.painters.CirclePainter;
import gui.rightPanelView.graphics.painters.ElementPainter;
import gui.rightPanelView.graphics.painters.SlotPainter;
import gui.view.MainView;
import repository.factory.CircleFactory;
import repository.factory.SlotFactory;
import repository.slot.Slot;
import repository.slot.SlotTypeEnum;

import java.awt.*;
import java.awt.event.MouseEvent;

public class CircleState extends State{

    private PageView mediator;

    public CircleState(PageView mediator) {
        this.mediator = mediator;
    }

    public void mousePressed(MouseEvent e) {
        Point position = e.getPoint();
        if (e.getButton()== MouseEvent.BUTTON1){
            if (mediator.getElementAtPosition(position)==-1){
            SlotFactory slotFactory=new CircleFactory();
            Slot slot=slotFactory.createSlot("Circle"+mediator.getPage().getChildCount(), SlotTypeEnum.C, mediator.getPage(), position);
            mediator.getPage().addChild(slot);
            SlotPainter painter=new CirclePainter(slot);
            mediator.getSlotPainters().add(painter);

           /* ProjectView projectView=(ProjectView) MainView.getInstance().getSplitPane().getRightComponent();
            for (DocumentView d:projectView.getDocumentViews()){
                if(d.getPages().contains(mediator)){
                    projectView.setFocused(mediator);
                }
            }*/
            }
        }
    }
}
