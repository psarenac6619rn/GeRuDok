package gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.KeyStroke;

import app.Main;
import error.ErrorEnum;
import gui.view.MainView;
import repository.Workspace;
import repository.node.RafNode;

public class DeleteNodeAction extends AbstractActionClass {
	public DeleteNodeAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
				KeyEvent.VK_F2, ActionEvent.ALT_MASK));
		putValue(SMALL_ICON, loadIcon("images/delete.png"));
		putValue(NAME, "Delete Node");
		putValue(SHORT_DESCRIPTION, "Delete Node");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		RafNode node = MainView.getInstance().getTree().getSelectedNode();

		if (node != null) {
			if (!(node instanceof Workspace)) {
				MainView.getInstance().getTree().deleteNode(node);
			} else {
				Main.getInstance().getErrorHandler().generateError(ErrorEnum.ERROR_DELETEWS);		}
			}else{
				Main.getInstance().getErrorHandler().generateError(ErrorEnum.ERROR_NOSELECTEDNODE);
			}
		}
	}


