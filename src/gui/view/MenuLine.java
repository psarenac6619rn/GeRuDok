package gui.view;

import javax.swing.JMenuBar;

import gui.controller.ActionManager;
import gui.view.MainView;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;



public class MenuLine extends JMenuBar {

	public MenuLine() {
		JMenu file=new JMenu("File");
		
		
		JMenu help=new JMenu("Help");
		
		
		JMenu edit=new JMenu("Edit");
		edit.add(MainView.getInstance().getActionManager().getAddNodeAction());
		edit.add(MainView.getInstance().getActionManager().getDeleteNodeAction());
		edit.add(MainView.getInstance().getActionManager().getShareDocumentAction());

		help.add(ActionManager.getInstance().getAboutAction());

		this.add(file);
		this.add(edit);
		this.add(help);
		//this.add(ActionManager.getInstance().getAboutAction());
	}

}

