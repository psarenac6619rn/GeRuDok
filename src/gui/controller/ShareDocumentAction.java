package gui.controller;

import app.Main;
import core.AppFramework;
import error.ErrorEnum;
import gui.tree.model.TreeItem;
import gui.view.MainView;
import repository.Document;
import repository.Project;
import repository.node.RafNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ShareDocumentAction extends AbstractActionClass {

    public ShareDocumentAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F6, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("images/share.png"));
        putValue(NAME, "Share Document");
        putValue(SHORT_DESCRIPTION, "Share Document");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RafNode node = MainView.getInstance().getTree().getSelectedNode();

        if (node instanceof Document){
            RafNode p = node.getParent();

            String[] options = {"OK"};
            String text="Now choose the new parent project and then click share!";
            JDialog popup=new JDialog();
            popup.setSize(400,150);
            popup.setResizable(false);
            popup.setTitle("Chose new parent!");
            JLabel jLabel=new JLabel(text);
            JButton share=new JButton("Share");
            JPanel buttonPanel=new JPanel();
            JPanel textPanel=new JPanel();

            textPanel.add(jLabel);
            buttonPanel.add(share);
            textPanel.setBorder(BorderFactory.createEmptyBorder(20,20,10,20));
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(10,20,20,20));
            popup.add(textPanel,BorderLayout.CENTER);
            popup.add(buttonPanel,BorderLayout.SOUTH);

            popup.setVisible(true);

            share.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    RafNode newParent=MainView.getInstance().getTree().getSelectedNode();
                    if(!(newParent instanceof Project)){
                        Main.getInstance().getErrorHandler().generateError(ErrorEnum.ERROR_ISNOTPROJECT);


                    }else{
                        if(newParent == p){
                            Main.getInstance().getErrorHandler().generateError(ErrorEnum.ERROR_ALREADYPARENT);



                        }else{
                            MainView.getInstance().getTree().shareDocument(node);
                           // MainView.getInstance().getTree().removeFromOldParent(node,p);
                            popup.setVisible(false);


                        }
                    }
                }
            });


        }else{
            Main.getInstance().getErrorHandler().generateError(ErrorEnum.ERROR_ISNOTDOCUMENT);


        }
    }
}
