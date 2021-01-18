package gui.rightPanelView.state;

import gui.rightPanelView.DocumentView;
import gui.rightPanelView.PageView;
import gui.rightPanelView.ProjectView;
import gui.rightPanelView.graphics.painters.ElementPainter;
import gui.rightPanelView.graphics.painters.SlotPainter;
import gui.rightPanelView.graphics.painters.TrianglePainter;
import gui.view.MainView;
import repository.factory.SlotFactory;
import repository.factory.TriangleFactory;
import repository.slot.Slot;
import repository.slot.SlotTypeEnum;

import java.awt.*;
import java.awt.event.MouseEvent;

public class TriangleState extends State {
    private PageView mediator;
    public TriangleState(PageView mediator) {
        this.mediator = mediator;
    }
    public void mousePressed(MouseEvent e) {
        Point position = e.getPoint();
        if (e.getButton()== MouseEvent.BUTTON1){
            if (mediator.getElementAtPosition(position)==-1){
                SlotFactory slotFactory=new TriangleFactory();
                Slot slot=slotFactory.createSlot("Triangle"+mediator.getPage().getChildCount(), SlotTypeEnum.T, mediator.getPage(), position);
                SlotPainter element=new TrianglePainter(slot);
                mediator.getPage().addChild(slot);
                mediator.getSlotPainters().add(element);


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
