package gui.tree;

import javax.swing.JTree;

import repository.Document;
import repository.Page;
import repository.Project;
import repository.slot.Slot;
import repository.Workspace;
import repository.node.RafNode;

public interface RafTree {

	JTree generateTree(Workspace workspace);
	void addProject(Project project);
	void addPage(Page page);
	void addSlot(Slot slot);
	void addDocument(Document document);
	RafNode getSelectedNode();
	void deleteNode(RafNode node);
	void shareDocument(RafNode node);
	void removeFromOldParent(RafNode child,RafNode parent);
	
}
