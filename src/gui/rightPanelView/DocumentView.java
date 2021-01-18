package gui.rightPanelView;

import app.Main;
import error.ErrorEnum;
import gui.controller.ActionEnum;
import gui.tree.model.TreeItem;
import gui.view.MainView;
import observer.IListener;
import repository.Document;
import repository.Page;
import repository.Project;
import repository.node.RafNode;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DocumentView extends JPanel implements IListener {

    private Document document;
    private JLabel name;
    private ArrayList<PageView> pages;
    private int pageCount = 0;
    private GridLayout grid;
    private JSplitPane split;
    private JScrollPane scroll;
    private JPanel panel;
    private JPanel panel2;

    public DocumentView(Document document) {
        super();
        grid = new GridLayout(0, 3);
        this.setLayout(grid);
        this.document = document;
        pages = new ArrayList<PageView>();
        document.addListener(this);
        //split = new JSplitPane();

        //scroll = new JScrollPane();
        // scroll.setSize(420, 420);
        // scroll.setMinimumSize(new Dimension(200, 200));
        //panel = new JPanel();
        //GridLayout grid = new GridLayout(0, 1);
        // grid.setVgap(20);
        // panel = new JPanel(grid);
        //scroll.setViewportView(panel2);

        //split.setLeftComponent(scroll);
        //split.setRightComponent(panel);

        //scroll.setMinimumSize(new Dimension(145, 145));
        //  panel.setMinimumSize(new Dimension(800, 500));
        //this.add(scroll);
        //this.add(BorderLayout.CENTER,scroll);
        name = new JLabel(document.toString());

        //this.add(panel);
        //add(split);


    }


    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }


    public String getName() {
        return name.getText();
    }

    public void setName(JLabel name) {
        this.name = name;
    }

    public ArrayList<PageView> getPages() {
        return pages;
    }

    public void setPages(ArrayList<PageView> pages) {
        this.pages = pages;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public JSplitPane getSplit() {
        return split;
    }

    public void setSplit(JSplitPane split) {
        this.split = split;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    @Override
    public void update(Object event) {
        //Project pr = (RafNode) this.document.getParent();
        if (event == ActionEnum.ACTION_ADD) {
        	addPage();
        	revalidate();
        }
        else if (event == ActionEnum.ACTION_RENAME) {
            renameDocument();
        }
        else if (event == ActionEnum.ACTION_REMOVE){
            removePage();
        }else if (event == ActionEnum.ACTION_SHARE){
            share();
        }


    }


    private void addPage() {
        System.out.println("uso u add page metodu");
        if (!(document.getChildCount() == 0) && !(document.getChildCount() == pageCount)) {
            System.out.println("usao u if");
            PageView p = new PageView((Page) document.getChildAt(document.getChildCount() - 1));
            //this.scroll.add(new JPanel());
            //split.setRightComponent(p);
            pages.add(p);
            this.add(p);
        }

    }

    private void renameDocument() {
        System.out.println("Udje u rename Document");
        System.out.println(name.getText());
        name.setText(document.getName());
      //  Project p = this.document.getParent();
       // for (ProjectView projectView : ProjectView.projectViews) {
       //     if (projectView.getProject().equals(p)) {
       //         projectView.getDocuments().setTitleAt(p.getIndex(document), document.getName());
       //         ((DocumentView) projectView.getDocumentViews().get(p.getIndex((TreeNode) document))).setName(new JLabel(document.getName()));
      //      }

        }
    /*private void removeDocument(){
        TreeItem d = ((TreeItem) MainView.getInstance().getWorkspaceTree().getSelectionPath().getLastPathComponent());
        Project p = (Project) d.getRafNodeModel().getParent();

        p.notifyListeners(ActionEnum.ACTION_DOCUMENTDELETE);

//        this.setVisible(false);
//        MainView.getInstance().getSplitPane().revalidate();
//        MainView.getInstance().getSplitPane().repaint();
    }*/

    private void removePage(){
        TreeItem d = ((TreeItem) MainView.getInstance().getWorkspaceTree().getSelectionPath().getLastPathComponent());
        Page page = (Page) d.getRafNodeModel();

        PageView tbd=null;
//        String page = docdoc[1];
//        PageView newPv = null;
//        int i = 0;
//        for(PageView pv : pages){
//            if(i == Integer.parseInt(page)) {
//                 newPv = pv;
//            }
//            i++;
//        }
//        i = 0;
//        System.out.println(newPv.toString() + " za brisanje");
//        System.out.println("removePage docview");

        for(PageView pv : this.pages){
            if(pv.getPage()==page){
                tbd=pv;
            }
        }
        this.pages.remove(tbd);
        this.removeAll();
        for(PageView pv : this.pages){
            this.add(pv);
        }
        System.out.println("Broj stranica"+this.getPages().size());
        revalidate();
        repaint();


    }

    private void share(){
        System.out.println("desi se share");
        for(PageView pv : pages){
            this.add(pv);
            MainView.getInstance().getSplitPane().revalidate();
            MainView.getInstance().getSplitPane().repaint();
        }
    }


}
