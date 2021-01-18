package repository;

import gui.controller.ActionEnum;
import repository.node.NodeComposite;
import repository.node.RafNode;

import java.io.Serializable;

public class Workspace extends NodeComposite implements Serializable {

	public Workspace(String name) {
		super(name,null);
	}

    @Override
    public NodeComposite getChildAt(int index) {
        return (NodeComposite) this.getChildren().get(index);
    }

    @Override
    public int getChildCount() {
        return this.getChildren().size();
    }

    @Override
    public void addChild(RafNode child) {
        if (child != null &&  child instanceof Project){
            Project p = (Project) child;
            if (!this.getChildren().contains(p)){
                this.getChildren().add(p);
                this.notifyListeners(ActionEnum.ACTION_ADD);
            }
        }
    }

    @Override
    public void removeChild(RafNode node) {
        if (node != null &&  node instanceof Project){
            Project proj = (Project) node;
            this.getChildren().remove(node);
            this.notifyListeners(ActionEnum.ACTION_REMOVEPROJECT);
        }
    }

    //@Override
    //public int getIndex(RafNode aChild) {
     //   return 0;
    //}
}
