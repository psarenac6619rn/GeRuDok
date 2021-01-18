package gui.rightPanelView.state;

import app.Main;
import core.AppFramework;
import editor.EditorEnum;
import gui.rightPanelView.PageView;
import gui.rightPanelView.graphics.painters.SlotPainter;
import repository.slot.Slot;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SelectState extends State{
    private PageView mediator;

    public SelectState(PageView mediator) {
        this.mediator = mediator;
    }
    public void mousePressed(MouseEvent e) {
        Point position = e.getPoint();
        if (e.getButton()== MouseEvent.BUTTON1){
            if (mediator.getElementAtPosition(position)==-1) {
                for (SlotPainter nsp : mediator.getSelecetedSlotPainters()) {
                    nsp.setPaint(Color.RED);
                    mediator.getPage().removeSelectedSlot(nsp.getSlot());
                }
                mediator.getSelecetedSlotPainters().clear();
            }
                for (SlotPainter sp : mediator.getSlotPainters()) {
                    if ((sp.isElementAt(position)) && (mediator.getSelecetedSlotPainters().contains(sp))) {
                        sp.setPaint(Color.RED);
                        mediator.getSelecetedSlotPainters().remove(sp);
                        mediator.getPage().removeSelectedSlot(sp.getSlot());
                    } else if (sp.isElementAt(position)) {
                        sp.setPaint(Color.GREEN);
                        mediator.getSelecetedSlotPainters().add(sp);
                        mediator.getPage().setSelected(sp.getSlot());
                        break;
                    }
                }


        }
    }
}
