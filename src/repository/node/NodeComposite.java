package repository.node;

import observer.IListener;
import observer.IObserver;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class NodeComposite extends RafNode implements Serializable {
	
	 List<RafNode> children;
	 private transient ArrayList<IListener> listeners;

	public NodeComposite(String name, RafNode parent) {
		super(name, parent);
		this.children = new ArrayList<>();
		this.listeners = new ArrayList<IListener>();
	}
	
	public NodeComposite(String name, RafNode parent,List<RafNode> children) {
		super(name, parent);
		this.children = new ArrayList<>();
	}

	public abstract NodeComposite getChildAt(int index);


	public abstract int getChildCount();

	public abstract void addChild(RafNode child);
	
	public RafNode getChildByName(String name) {
        for (RafNode child: this.getChildren()) {
            if (name.equals(child.getName())) {
                return child;
            }
        }
        return null;
    }

	//public abstract int getIndex(RafNode aChild);

	public List<RafNode> getChildren() {
		return children;
	}

	@Override
	public void addListener(IListener listener) {
		if(listener == null) return;
		if(listeners == null) listeners = new ArrayList<IListener>();
		if(listeners.contains(listener)) return;
		listeners.add(listener);

	}

	@Override
	public void removeListener(IListener listener) {
		if(listener == null || listeners == null || !listeners.contains(listener)) return;
		listeners.remove(listener);
	}

	@Override
	public void notifyListeners(Object event) {
		if(this.listeners == null || this.listeners.isEmpty() || event == null)
			return;
		for(IListener l: listeners) {
			l.update(event);
		}
	}

	//Imam metodu za remove,uzecu dete izbrisati ga iz liste,pozvati lisenerr za remove.
	public abstract void removeChild(RafNode node);

}
