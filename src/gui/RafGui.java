package gui;

import core.ErrorHandler;
import core.Gui;
import core.Repository;
import error.ErrorClass;
import gui.view.MainView;
import repository.Workspace;

public class RafGui implements Gui{

	private MainView mv;
	private Repository repository;
	private Workspace workspace;
	
	
	public RafGui(Repository repository) {
		this.repository = repository;
	}



	@Override
	public void start() {
		mv=MainView.getInstance();
		mv.setDocumentRepository(repository);
		mv.initTree();
		mv.setVisible(true);
	}

	@Override
	public void update(Object notification) {
		if(notification instanceof ErrorClass){
			MainView.getInstance().fireError((ErrorClass) notification);
		}
	}
}
