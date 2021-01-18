package gui.tree.model;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import repository.Workspace;
import repository.node.NodeComposite;
import repository.node.RafNode;

public class TreeItem extends DefaultMutableTreeNode {
	
	private String name;
	private RafNode rafNodeModel;
	
	public TreeItem(String name, RafNode node) {
		this.rafNodeModel = node;
		this.name = name;
	}
	
	public TreeItem( RafNode node) {
		this.rafNodeModel = node;
		this.name = rafNodeModel.getName();

	}
	
	@Override
	public int getChildCount() {
		if(rafNodeModel instanceof NodeComposite) {
			return ((NodeComposite) rafNodeModel).getChildren().size();
		}
		return 0;
	}
	
	@Override
	public boolean getAllowsChildren() {
		if(rafNodeModel instanceof NodeComposite) {
			return true;
		}else {
			return false;
		}
	}

	 @Override
	    public boolean isLeaf() {
	        if(rafNodeModel instanceof NodeComposite)
	            return false;
	        return true;
	    }
	
	@Override
	public Enumeration children() {
		if(rafNodeModel instanceof NodeComposite) {
		return (Enumeration)((NodeComposite) rafNodeModel).getChildren();
		}else {
			return null;
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if(o != null && o instanceof TreeItem) {
			TreeItem o2=(TreeItem) o;
			return this.rafNodeModel.equals(o2.rafNodeModel);
		}else {
			return false;
		}		
	}
	
	private TreeNode findChildByIndex(int index) {
		if(rafNodeModel instanceof NodeComposite) {
			TreeItem i = new TreeItem (((NodeComposite) rafNodeModel).getChildren().get(index));

			if(super.children==null){
				super.children=new Vector<>();
			}
			super.children.add(i);

			Iterator childrenIterator = children.iterator();
	        TreeNode current;

	        while(childrenIterator.hasNext()) {
	        	current = (TreeNode) childrenIterator.next();
	        	if(current.equals(i)) {
	        		return current;
	        	}
	        }
		}
		return null;
	}
	
	@Override 
	public TreeNode getChildAt(int index) {
		return findChildByIndex(index);
	}
	
	private int findIndexByChild(TreeItem n) {
		if(this.rafNodeModel instanceof NodeComposite) {
			return ((NodeComposite) this.rafNodeModel).getChildren().indexOf(n.getRafNodeModel());
		}else {
			return -1;
		}
	}
	
	@Override
    public int getIndex(TreeNode node) {
        return findIndexByChild((TreeItem)node);
    }
	
	

	@Override
	public String toString() {
		return name ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RafNode getRafNodeModel() {
		return rafNodeModel;
	}

	public void setNodeRafNodeModel(RafNode node) {
		this.rafNodeModel = node;
	}


	}
	

