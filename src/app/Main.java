package app;


import core.*;
import editor.EditorImplementation;
import error.ErrorHandlerImplementation;
import gui.RafGui;
import gui.view.MainView;
import repository.RepositoryImplementation;
import slotHandler.SlotHandlerImplementation;

public class Main extends AppFramework {
	
	private static Main instance;
	private Main() {
		
	}
	
	public static Main getInstance(){
        if(instance==null){
            instance = new Main();
        }
        return instance;
    }
	
	@Override
	public void run() {
		this.gui.start();
		
	}


	public static void main(String[] args) {

    	Repository r = new RepositoryImplementation();
    	ErrorHandler eh=new ErrorHandlerImplementation();
		SlotHandler sh=new SlotHandlerImplementation();
		Editor editor=new EditorImplementation();
    	Gui gui=new RafGui(r);
    	AppFramework main=Main.getInstance();
    	MainView.getInstance().setDocumentRepository(r);
    	main.initialise(gui, r, eh,sh,editor); //

    	main.run();
        

    }

	
}


