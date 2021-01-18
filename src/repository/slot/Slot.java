package repository.slot;

import gui.controller.ActionEnum;
import gui.rightPanelView.slotContent.SlotContent;
import observer.IListener;
import repository.node.RafNode;

import java.awt.*;
import java.awt.geom.Point2D;

public class Slot extends RafNode {

	private Dimension dimension;
	private Point2D position;
	private double angle;
	private Point2D originalPosition=null;
	private Dimension originalDimension=null;
	private SlotContent slotContent=null;

	public Slot(String name, RafNode parent, Dimension dimension, Point2D position) {
		super(name, parent);
		this.dimension = dimension;
		this.position = position;
		this.angle=0;
	}

	@Override
	public void addListener(IListener listener) {

	}

	@Override
	public void removeListener(IListener listener) {

	}

	@Override
	public void notifyListeners(Object event) {

	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
		this.notifyListeners(ActionEnum.ACTION_SLOTCHANGED);

	}

	public Point2D getPosition() {
		return position;
	}

	public void setPosition(Point2D position) {
		this.position = position;
		this.notifyListeners(ActionEnum.ACTION_SLOTCHANGED);

	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
		this.notifyListeners(ActionEnum.ACTION_SLOTCHANGED);
	}

	public Point2D getOriginalPosition() {
		return originalPosition;
	}

	public void setOriginalPosition(Point2D originalPosition) {
		this.originalPosition = originalPosition;
	}

	public Dimension getOriginalDimension() {
		return originalDimension;
	}

	public void setOriginalDimension(Dimension originalDimension) {
		this.originalDimension = originalDimension;
	}

	public SlotContent getSlotContent() {
		return slotContent;
	}

	public void setSlotContent(SlotContent slotContent) {
		this.slotContent = slotContent;
	}
}
