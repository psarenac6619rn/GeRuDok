package error;


import core.ErrorHandler;
import observer.IListener;

import java.util.ArrayList;

public class ErrorHandlerImplementation implements ErrorHandler {

	private ArrayList<IListener> listeners;

	@Override
	public void generateError(ErrorEnum type) {
		if(type == ErrorEnum.ERROR_DELETEWS)
			notifyListeners(new ErrorClass(1,"Error!","Workspace can not be deleted!"));
		if(type == ErrorEnum.ERROR_SLOTCHILDREN)
			notifyListeners(new ErrorClass(2,"Error!","Slot can not have children!"));
		if(type == ErrorEnum.ERROR_NOSELECTEDNODE)
			notifyListeners(new ErrorClass(3,"Error!","You have to select node first!"));
		if(type == ErrorEnum.ERROR_ISNOTDOCUMENT)
			notifyListeners(new ErrorClass(4,"Error!","You must select document first!"));
		if(type == ErrorEnum.ERROR_ALREADYPARENT)
			notifyListeners(new ErrorClass(5,"Error!","Selected project is already a parent of selected document!"));
		if(type == ErrorEnum.ERROR_ISNOTPROJECT)
			notifyListeners(new ErrorClass(6,"Error!","You must select new parent project!"));
		if(type == ErrorEnum.ERROR_REMOVE)
			notifyListeners(new ErrorClass(7,"Error!","You must be in right document!"));
		if(type==ErrorEnum.ERROR_NOSELECTEDNODE)
			notifyListeners(new ErrorClass(8,"Error!","You must select shape first!"));
		if(type==ErrorEnum.ERROR_NOACTIVEPAGE)
			notifyListeners(new ErrorClass(9,"Error!","You have to create page first!"));
		if(type==ErrorEnum.ERROR_NOTHINGTOSAVE)
			notifyListeners(new ErrorClass(10,"Error!","There is nothing to save!"));
		if(type==ErrorEnum.ERROR_NOSLOTCHOSEN)
			notifyListeners(new ErrorClass(11,"Error!","You have to select slot!"));
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
}

