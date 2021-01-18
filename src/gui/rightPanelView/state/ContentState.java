package gui.rightPanelView.state;

import app.Main;
import editor.EditorEnum;
import error.ErrorEnum;
import gui.rightPanelView.PageView;
import gui.rightPanelView.graphics.painters.SlotPainter;
import repository.slot.Slot;

import java.awt.*;
import java.awt.event.MouseEvent;

public class ContentState extends State{
    private PageView mediator;
    private Slot s;

    public ContentState(PageView mediator) {
        this.mediator = mediator;
    }

    public void mousePressed(MouseEvent e) {
        Point position=e.getPoint();
        for (SlotPainter sp : mediator.getSlotPainters()) {
            if (sp.isElementAt(position)) {
                s=sp.getSlot();
            }
        }if(s==null){
            Main.getInstance().getErrorHandler().generateError(ErrorEnum.ERROR_NOSLOTCHOSEN);
        } else if(s.getSlotContent()==null) {
            Main.getInstance().getEditor().choseContentType(s);

        }else if(s.getSlotContent().getType()== EditorEnum.TEXT){
            Main.getInstance().getEditor().openTextContent(s);
        }else if(s.getSlotContent().getType()==EditorEnum.IMAGE){
            Main.getInstance().getEditor().openImageContent(s);
        }
    }
}
