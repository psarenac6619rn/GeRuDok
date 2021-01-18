package gui.tree.controller;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

import app.Main;
import gui.controller.ActionEnum;
import gui.rightPanelView.ProjectView;
import gui.tree.model.TreeItem;
import gui.view.MainView;
import repository.Document;
import repository.Page;
import repository.Project;
import repository.Workspace;
import repository.node.RafNode;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collections;

public class RafTreeSelectionListener implements TreeSelectionListener {

	@Override
	public void valueChanged(TreeSelectionEvent arg0) {
		TreePath path = arg0.getPath();
        TreeItem treeItemSelected = (TreeItem)path.getLastPathComponent();
        System.out.println("[Selektovan cvor: "+ treeItemSelected.getName()+"]   |  [Putanja: "+arg0.getPath()+" ]");

		MainView.getInstance().getWorkspaceTree().addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					TreeItem tr = (TreeItem) path.getLastPathComponent();
					RafNode node = tr.getRafNodeModel();
					if(node instanceof Workspace) {
						//node.notifyListeners(ActionEnum.ACTION_FOCUS);
					}
					else if(node instanceof Project) {
						node.notifyListeners(ActionEnum.ACTION_FOCUS);
					}
					else if(node instanceof Document) {
						System.out.println("ovo je document");
						Document d = (Document)node;
						Project p = (Project) d.getParent();
						/*for(ProjectView view: ProjectView.projectViews) {
							if(view.getProject().equals(p)) {
								//MainView.getInstance().openProjectView(view);
								view.addClickedTab(d);
								view.getDocuments().setSelectedIndex(p.getIndex(d));
							}
						}*/
					}
					else if(node instanceof Page) {
						Page page = (Page)node;
						Document d = (Document) page.getParent();
						Project p = (Project) d.getParent();
						/*for(ProjectView view: ProjectView.projectViews) {
							if(view.getProject().equals(p)) {
								//MainView.getInstance().openProjectView(view);
								view.getDocuments().setSelectedIndex(p.getIndex(d));

							}
						}*/
					}
				}
			}


			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});

		//MainView.getInstance().getWorkspaceTree().addMouseListener(new PopupListener());

		TreeItem d = (TreeItem) path.getPathComponent(path.getPathCount() - 1);
		RafNode node = d.getRafNodeModel();
		System.out.println(node.toString());

	}

	

}
