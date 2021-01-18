package gui.tree.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;

import gui.tree.model.TreeItem;
import repository.*;
import repository.slot.Slot;

public class RafTreeCellEditor extends DefaultTreeCellEditor implements ActionListener {


	private Object clickedOn = null;
	private JTextField edit = null;

	public RafTreeCellEditor(JTree arg0, DefaultTreeCellRenderer arg1) {
		super(arg0, arg1);
	}

	public Component getTreeCellEditorComponent(JTree arg0, Object arg1, boolean arg2, boolean arg3, boolean arg4, int arg5) {
		//super.getTreeCellEditorComponent(arg0,arg1,arg2,arg3,arg4,arg5);
		clickedOn = arg1;
		edit = new JTextField(arg1.toString());
		edit.addActionListener(this);
		return edit;
	}


	public boolean isCellEditable(EventObject arg0) {
		if (arg0 instanceof MouseEvent)
			if (((MouseEvent) arg0).getClickCount() == 3) {
				return true;
			}
		return false;
	}


	public void actionPerformed(ActionEvent e) {

		if (!(clickedOn instanceof TreeItem))
			return;

		TreeItem clicked = (TreeItem) clickedOn;

		if (clicked.getRafNodeModel() instanceof Workspace) {
			clicked.setName(e.getActionCommand());
			((Workspace) clicked.getRafNodeModel()).setName(e.getActionCommand());
		} else if (clicked.getRafNodeModel() instanceof Project) {
			clicked.setName(e.getActionCommand());
			((Project) clicked.getRafNodeModel()).setName(e.getActionCommand());
			//(() clickedOn).setName(e.getActionCommand());
		} else if (clicked.getRafNodeModel() instanceof Document) {
			clicked.setName(e.getActionCommand());
			((Document) clicked.getRafNodeModel()).setName(e.getActionCommand());
		} else if (clicked.getRafNodeModel() instanceof Page) {
			clicked.setName(e.getActionCommand());
			((Page) clicked.getRafNodeModel()).setName(e.getActionCommand());
		} else if (clicked.getRafNodeModel() instanceof Slot) {
			clicked.setName(e.getActionCommand());
			((Slot) clicked.getRafNodeModel()).setName(e.getActionCommand());
		}

	}

}