package core;

public abstract class AppFramework {

	protected Gui gui;
	protected Repository repository;
	protected ErrorHandler errorHandler;
	protected SlotHandler slotHandler;
	protected Editor editor;
	
	public abstract void run();
	
	public void initialise(Gui g,Repository r,ErrorHandler eh,SlotHandler sh,Editor e) {
		this.gui=g;
		this.repository=r;
		this.errorHandler=eh;
		this.slotHandler=sh;
		this.editor=e;
		this.errorHandler.addListener(gui);

	}

	public ErrorHandler getErrorHandler() {
		return errorHandler;
	}

	public SlotHandler getSlotHandler() {
		return slotHandler;
	}

	public Editor getEditor() {
		return editor;
	}
}
