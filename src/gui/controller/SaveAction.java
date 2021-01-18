package gui.controller;

import gui.controller.AbstractActionClass;
import gui.controller.FileFilter;
import gui.view.MainView;
import org.w3c.dom.Node;
import repository.Project;
import repository.node.RafNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveAction extends AbstractActionClass {

    public SaveAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("images/save.png"));
        putValue(NAME, "Save project");
        putValue(SHORT_DESCRIPTION, "Save project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new FileFilter());

        RafNode project = MainView.getInstance().getTree().getSelectedNode();
        File projectFile;

        if ((project instanceof Project)) {

            projectFile = ((Project) project).getFile();


            if (((Project) project).getFile() == null) {
                if (jfc.showSaveDialog(MainView.getInstance()) == JFileChooser.APPROVE_OPTION) {
                    projectFile = jfc.getSelectedFile();

                } else {
                    return;
                }
            }

            ObjectOutputStream os;
            try {
                os = new ObjectOutputStream(new FileOutputStream(projectFile));
                os.writeObject(project);
                ((Project) project).setFile(projectFile);
                ((Project) project).setChanged(false);

            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }

    }
}