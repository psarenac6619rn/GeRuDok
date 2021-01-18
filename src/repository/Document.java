package repository;


import gui.controller.ActionEnum;
import observer.IListener;
import repository.node.NodeComposite;
import repository.node.RafNode;

import java.io.Serializable;
import java.util.ArrayList;

public class Document extends NodeComposite implements Serializable {
    private ArrayList<Page> pages;
    private transient ArrayList<IListener> listeners;


	public Document(String name, RafNode parent) {
		super(name, parent);


	}

    @Override
    public void addChild(RafNode child) {
        if (child != null &&  child instanceof Page){
            Page page = (Page) child;
            if (!this.getChildren().contains(page)){
                this.getChildren().add(page);
                this.notifyListeners(ActionEnum.ACTION_ADD);
            }
        }
    }

    @Override
    public void removeChild(RafNode node) {
        if (node != null &&  node instanceof Page){
            Page page = (Page) node;
            this.getChildren().remove(page);
            this.notifyListeners(ActionEnum.ACTION_REMOVE);        }
	}

    //@Override
    //public int getIndex(RafNode aChild) {
    //    return 0;
    //}

    @Override
    public NodeComposite getChildAt(int index) {
        return (NodeComposite) this.getChildren().get(index);
    }

    @Override
    public int getChildCount() {
        return this.getChildren().size();
    }

}
