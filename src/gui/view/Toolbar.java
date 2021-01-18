package gui.view;


import javax.swing.JButton;
import javax.swing.JToolBar;

import gui.view.MainView;

public class Toolbar extends JToolBar{

	public Toolbar() {
		setFloatable(false);
	
		add(MainView.getInstance().getActionManager().getAddNodeAction());
		add(MainView.getInstance().getActionManager().getDeleteNodeAction());
		
		this.addSeparator();

		add(MainView.getInstance().getActionManager().getShareDocumentAction());

		this.addSeparator();

		add(MainView.getInstance().getActionManager().getSaveAction());
		add(MainView.getInstance().getActionManager().getOpenAction());

		this.addSeparator();

		add(MainView.getInstance().getActionManager().getUndoAction());
		add(MainView.getInstance().getActionManager().getRedoAction());
	}
}
