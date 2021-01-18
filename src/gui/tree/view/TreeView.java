package gui.tree.view;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

import gui.tree.controller.RafTreeCellEditor;
import gui.tree.controller.RafTreeSelectionListener;

public class TreeView extends JTree {
	
	public TreeView(DefaultTreeModel model) {
		setModel(model);
		RafTreeCellRenderer rtcr=new RafTreeCellRenderer(); ;
		addTreeSelectionListener(new RafTreeSelectionListener());
		setCellEditor(new RafTreeCellEditor(this,rtcr));
		setCellRenderer(rtcr);
		setEditable(true);
	}

}
