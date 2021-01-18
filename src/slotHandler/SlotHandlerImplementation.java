package slotHandler;

import app.Main;
import core.SlotHandler;
import gui.rightPanelView.PageView;
import gui.rightPanelView.graphics.painters.CirclePainter;
import gui.rightPanelView.graphics.painters.RectanglePainter;
import gui.rightPanelView.graphics.painters.SlotPainter;
import gui.rightPanelView.graphics.painters.TrianglePainter;
import repository.Page;
import repository.slot.Slot;

import javax.sound.midi.SysexMessage;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

public class SlotHandlerImplementation implements SlotHandler {

    @Override
    public void resize(Point2D start, Point2D dragged, SlotPainter slotPainter, PageView mediator,int x,int y) {
        int widthInt= (int) (x+ (dragged.getX()- start.getX()));
        int heightInt= (int) (y+ (dragged.getY()- start.getY()));
        slotPainter.getSlot().setDimension(new Dimension(widthInt,heightInt));
        Slot s=slotPainter.getSlot();
        Page p=(Page) s.getParent();
        p.removeSelectedSlot(s);
        p.removeChild(s);
        mediator.getSlotPainters().remove(slotPainter);
        mediator.getSelecetedSlotPainters().remove(slotPainter);

        mediator.getPage().addChild(s);
        SlotPainter painter=null;
        if(slotPainter instanceof RectanglePainter) {
            painter = new RectanglePainter(s);
        }else if(slotPainter instanceof CirclePainter){
            painter = new CirclePainter(s);
        }else{
            painter=new TrianglePainter(s);
        }

        painter.setPaint(Color.green);
        mediator.getSlotPainters().add(painter);
        mediator.getPage().setSelected(painter.getSlot());
        mediator.getSelecetedSlotPainters().add(painter);


    }

    @Override
    public void rotate(Point2D start, Point2D dragged, SlotPainter slotPainter,int x,int y) {
        double startx=start.getX()-x;
        double starty=start.getY()-y;
        double draggedx=dragged.getX()-x;
        double draggedy=dragged.getY()-y;
        double point1=startx*draggedy-starty*draggedx;
        double point2=startx*draggedx-starty*draggedy;

        double newAngle=Math.toDegrees(Math.atan2(point1,point2));
        AffineTransform transform = new AffineTransform();
        transform.rotate(Math.toRadians(newAngle),x,y);
        slotPainter.setShape(transform.createTransformedShape(slotPainter.getShape()));

        slotPainter.getSlot().setAngle(newAngle);

    }

    @Override
    public void move(Point2D start,Point2D dragged,SlotPainter slotPainter,PageView mediator,int oldx,int oldy) {
            int x= (int) (oldx+(dragged.getX()-start.getX()));
            int y= (int) (oldy+(dragged.getY()-start.getY()));
            System.out.println("Original   "+slotPainter.getSlot().getPosition()+"x   "+x+"y   "+y);
            slotPainter.getSlot().setPosition(new Point(x,y));
            System.out.println("New   "+slotPainter.getSlot().getPosition());

        Slot s=slotPainter.getSlot();
        Page p=(Page) s.getParent();
        p.removeSelectedSlot(s);
        p.removeChild(s);

        mediator.getSlotPainters().remove(slotPainter);
        mediator.getSelecetedSlotPainters().remove(slotPainter);


        mediator.getPage().addChild(s);
        SlotPainter painter=null;
        if(slotPainter instanceof RectanglePainter) {
            painter = new RectanglePainter(s);
        }else if(slotPainter instanceof CirclePainter){
            painter = new CirclePainter(s);
        }else{
            painter=new TrianglePainter(s);
        }

        painter.setPaint(Color.green);
        mediator.getSlotPainters().add(painter);
        mediator.getPage().setSelected(painter.getSlot());
        mediator.getSelecetedSlotPainters().add(painter);
    }
}
