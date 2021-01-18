package commands;

import gui.controller.ActionManager;
import gui.view.MainView;

import java.util.ArrayList;

public class CommandManager {

    private ArrayList<AbstractCommand> commands;
    private int currentCommand = 0;


    public CommandManager(){
        commands= new ArrayList<AbstractCommand>();
    }

    public void addCommand(AbstractCommand command) {
        while(currentCommand < commands.size())
            commands.remove(currentCommand);
        commands.add(command);
        doCommand();
    }


    public void doCommand() {
        if(currentCommand < commands.size()) {
            commands.get(currentCommand++).doCommand();
            MainView.getInstance().getActionManager().getUndoAction().setEnabled(true);
        }

        if(currentCommand == commands.size()) {
            MainView.getInstance().getActionManager().getRedoAction().setEnabled(false);
        }
    }

    public void undoCommand() {
        if(currentCommand > 0) {
            ActionManager.getInstance().getRedoAction().setEnabled(true);
            commands.get(--currentCommand).undoCommand();
        }

        if(currentCommand == 0) {
            ActionManager.getInstance().getUndoAction().setEnabled(false);
        }
    }



}
