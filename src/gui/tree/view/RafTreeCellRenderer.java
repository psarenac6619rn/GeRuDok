package gui.tree.view;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import gui.tree.model.TreeItem;
import repository.Document;
import repository.Page;
import repository.Project;
import repository.slot.Slot;
import repository.Workspace;

public class RafTreeCellRenderer extends DefaultTreeCellRenderer {
	
	public RafTreeCellRenderer() {
		
	}
	
	 public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {

         super.getTreeCellRendererComponent(tree, value, sel,expanded, leaf, row, hasFocus);

         if (((TreeItem)value).getRafNodeModel() instanceof Workspace) {
             String imageURL = "images/workspace.png";
             Icon icon = null;
             if (imageURL != null)
                 icon = new ImageIcon(imageURL);
             setIcon(icon);

         }
         if (((TreeItem)value).getRafNodeModel() instanceof Project) {
        	 String imageURL = "images/project.png";
             Icon icon = null;
             if (imageURL != null)
                 icon = new ImageIcon(imageURL);
             setIcon(icon);
         }
         if (((TreeItem)value).getRafNodeModel() instanceof Document) {
        	 String imageURL = "images/document.png";
             Icon icon = null;
             if (imageURL != null)
                 icon = new ImageIcon(imageURL);
             setIcon(icon);
         }
         if (((TreeItem)value).getRafNodeModel() instanceof Page) {
        	 String imageURL = "images/page.png";
             Icon icon = null;
             if (imageURL != null)
                 icon = new ImageIcon(imageURL);
             setIcon(icon);
         }
         if (((TreeItem)value).getRafNodeModel() instanceof Slot) {
        	 String imageURL = "images/slot.png";
             Icon icon = null;
             if (imageURL != null)
                 icon = new ImageIcon(imageURL);
             setIcon(icon);
         }
         return this;
     }

}
