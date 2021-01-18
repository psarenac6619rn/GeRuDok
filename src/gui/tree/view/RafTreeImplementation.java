package gui.tree.view;

import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultTreeModel;

import gui.controller.ActionEnum;
import gui.tree.RafTree;
import gui.tree.model.TreeItem;
import gui.view.MainView;
import repository.Document;
import repository.Page;
import repository.Project;
import repository.slot.Slot;
import repository.Workspace;
import repository.node.RafNode;

public class RafTreeImplementation implements RafTree {
	
	private TreeView treeView;
    private DefaultTreeModel treeModel;

	@Override
	public JTree generateTree(Workspace workspace) {
		TreeItem root=new TreeItem(workspace);
		treeModel=new DefaultTreeModel(root);
		treeView=new TreeView(treeModel);
		return treeView;
        
	}

	@Override
	public void addProject(Project project) {
		RafNode nodeModel = ((TreeItem)treeModel.getRoot()).getRafNodeModel();
        ((TreeItem)treeModel.getRoot()).add(new TreeItem(project));
        ((Workspace) nodeModel).addChild(project);
        SwingUtilities.updateComponentTreeUI(treeView);

	}

	@Override
	public void addDocument(Document document) {
		Object o=MainView.getInstance().getWorkspaceTree().getSelectionPath().getLastPathComponent();
		int index=treeModel.getIndexOfChild(treeModel.getRoot(), o);
		RafNode nodeModel = ((TreeItem)treeModel.getChild(treeModel.getRoot(), index)).getRafNodeModel();
		((TreeItem)treeModel.getChild(treeModel.getRoot(), index)).add(new TreeItem(document));
		((Project) nodeModel).addChild(document);
        SwingUtilities.updateComponentTreeUI(treeView);
	}
		

	@Override
	public void addPage(Page page) {
		Object o=MainView.getInstance().getWorkspaceTree().getSelectionPath().getLastPathComponent();
		int index=treeModel.getIndexOfChild(((TreeItem)o).getParent(), o);		
		RafNode nodeModel = ((TreeItem)treeModel.getChild(((TreeItem)o).getParent(), index)).getRafNodeModel();
		((TreeItem)treeModel.getChild(((TreeItem)o).getParent(), index)).add(new TreeItem(page));
        ((Document) nodeModel).addChild(page);
        SwingUtilities.updateComponentTreeUI(treeView);

	}

	@Override
	public void addSlot(Slot slot) {
		Object o=MainView.getInstance().getWorkspaceTree().getSelectionPath().getLastPathComponent();
		int index=treeModel.getIndexOfChild(((TreeItem)o).getParent(), o);		
		RafNode nodeModel = ((TreeItem)treeModel.getChild(((TreeItem)o).getParent(), index)).getRafNodeModel();
		((TreeItem)treeModel.getChild(((TreeItem)o).getParent(), index)).add(new TreeItem(slot));
        ((Page) nodeModel).addChild(slot);
        System.out.println(nodeModel.getName()+" "+slot.getName()+" "+slot.getParent().getName());
        SwingUtilities.updateComponentTreeUI(treeView);
		
	}

	@Override
	public RafNode getSelectedNode() {
		RafNode n=null;
		Object o = MainView.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		TreeItem ti=(TreeItem)o;
		if(ti==null) {
			return n;
		}
		n=ti.getRafNodeModel();
		
		return n;
	}


	@Override
	public void deleteNode(RafNode n) {
		
		RafNode prt=n.getParent();

		if(n instanceof Project) {	
			((Workspace)prt).removeChild(n);
		}if(n instanceof Document) {			
			((Project)prt).removeChild(n);
		}if(n instanceof Page) {
			((Document) prt).removeChild(n);
		}if (n instanceof Slot)  {
			((Page)prt).removeChild(n);
		}
   
		treeView.clearSelection();
		
        SwingUtilities.updateComponentTreeUI(treeView);

	}

	@Override
	public void shareDocument(RafNode node) {
		Object o = MainView.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		int index=treeModel.getIndexOfChild(treeModel.getRoot(), o);
		RafNode nodeModel = ((TreeItem)treeModel.getChild(treeModel.getRoot(), index)).getRafNodeModel();
		((TreeItem)treeModel.getChild(treeModel.getRoot(), index)).add(new TreeItem(node));
		((Project) nodeModel).addChild(node);
		SwingUtilities.updateComponentTreeUI(treeView);
		node.notifyListeners(ActionEnum.ACTION_SHARE);
	}


	@Override
	public void removeFromOldParent(RafNode child, RafNode parent) {
		((Project)parent).getChildren().remove(child);
		treeView.clearSelection();



		SwingUtilities.updateComponentTreeUI(treeView);
	}


}
