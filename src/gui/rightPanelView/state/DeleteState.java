package gui.rightPanelView.state;

import gui.rightPanelView.PageView;
import gui.rightPanelView.graphics.painters.SlotPainter;

import java.awt.*;
import java.awt.event.MouseEvent;

public class DeleteState extends State{
    private PageView mediator;
    public DeleteState(PageView mediator){this.mediator=mediator;}
    public void mousePressed(MouseEvent e) {
        Point position = e.getPoint();
        if (e.getButton()== MouseEvent.BUTTON1){
            SlotPainter tbd=null;
            for(SlotPainter sp: mediator.getSlotPainters()){
                if(sp.isElementAt(position)){
                    tbd=sp;

                }
            }
            if(mediator.getSelecetedSlotPainters().contains(tbd)){
                mediator.getSelecetedSlotPainters().remove(tbd);
                mediator.getPage().getSelectedSlots().remove(tbd.getSlot());
            }
            if(!(tbd==null)){
                mediator.getSlotPainters().remove(tbd);
                mediator.getPage().removeChild(tbd.getSlot());
            }
        }
    }
}
