package gui.view;


import javax.swing.*;

import core.ErrorHandler;
import core.Repository;
import error.ErrorClass;
import gui.controller.ActionManager;
import error.ErrorEnum;
import gui.rightPanelView.DocumentView;
import gui.rightPanelView.PageView;
import gui.rightPanelView.ProjectView;
import gui.tree.RafTree;
import gui.tree.model.TreeItem;
import gui.tree.view.RafTreeImplementation;
import gui.tree.view.TreeView;
import gui.view.MenuLine;
import gui.view.Toolbar;
import repository.Project;
import repository.RepositoryImplementation;
import repository.Workspace;

import java.awt.*;

public class MainView extends JFrame {

    private static MainView instance = null;

    private Toolbar toolBar;
    private MenuLine menu;
    private JSplitPane splitPane;
    private ActionManager actionManager;
    private JPanel panel2;
    private JScrollPane scroll;
    private Repository documentRepository;
    private JTree workspaceTree;
    private RafTree tree;
    private Pallete pallete;


    private MainView() {

    }

    private void init() {

        actionManager = ActionManager.getInstance();

    }

    public void initTree() {
        tree = new RafTreeImplementation();
        workspaceTree = tree.generateTree(documentRepository.getWorkspace());
        addElements();


    }

    private void addElements() {
        setTitle("RuDok");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);

        menu = new MenuLine();
        toolBar = new Toolbar();
        pallete = new Pallete();

        setJMenuBar(menu);

        JScrollPane scroll = new JScrollPane(workspaceTree);
        scroll.setSize(420, 420);
        scroll.setMinimumSize(new Dimension(200, 200));

        panel2 = new JPanel(new BorderLayout());
        panel2.setFocusable(true);
        panel2.setRequestFocusEnabled(true);

        splitPane = new JSplitPane(SwingConstants.VERTICAL, scroll, panel2);

        splitPane.setDividerLocation(300);
        getContentPane().add(splitPane, BorderLayout.CENTER);
        add(toolBar, BorderLayout.NORTH);
        add(pallete, BorderLayout.EAST);


    }

    public static MainView getInstance() {
        if (instance == null) {
            instance = new MainView();
            instance.init();
        }
        return instance;
    }


    public JToolBar getToolBar() {
        return toolBar;
    }

    public void setToolBar(Toolbar toolBar) {
        this.toolBar = toolBar;
    }


    public JSplitPane getSplitPane() {
        return splitPane;
    }

    public void setSplitPane(JSplitPane splitPane) {
        this.splitPane = splitPane;
    }

    public MenuLine getMenu() {
        return menu;
    }

    public void setMenu(MenuLine menu) {
        this.menu = menu;
    }

    public ActionManager getActionManager() {
        return actionManager;
    }

    public Repository getDocumentRepository() {
        return documentRepository;
    }

    public void setDocumentRepository(Repository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public JTree getWorkspaceTree() {
        return workspaceTree;
    }

    public void setWorkspaceTree(JTree workspaceTree) {
        this.workspaceTree = workspaceTree;
    }

    public void setWorkspaceTree(TreeView workspaceTree) {
        this.workspaceTree = workspaceTree;
    }

    public RafTree getTree() {
        return tree;
    }

    public void setTree(RafTree tree) {
        this.tree = tree;
    }

    public void projectViewMaker(Project project) {

        ProjectView p = new ProjectView(project);
        ProjectView.projectViews.add(p);
        //ProjectView.projectViews.add(p);
        System.out.println("Kreira ");
        // this.splitPane.getRightComponent(p);
        this.panel2.add(BorderLayout.CENTER, p);

    }

    public DocumentView getActiveDocument() {
        for (ProjectView pv : ProjectView.projectViews) {
            if (pv.isFocused()) {
                int index = pv.getDocuments().getSelectedIndex();
                DocumentView dv = pv.getDocumentViewAt(pv, index);
                return dv;
            }
        }
        return null;
    }


   /* public void openProjectView(ProjectView p) {
        // System.out.println("Dodaje projectView  u desni panel");
        if (p == null) {
            System.out.println("Project je null");
            this.panel2.removeAll();
        } else {
            this.panel2.removeAll();
            //this.panel2.add(BorderLayout.CENTER,p);
            this.panel2.add(BorderLayout.CENTER, p);
            this.panel2.grabFocus();
        }
    }*/

    public void fireError(ErrorClass e) {

	    JOptionPane.showMessageDialog(null,e.getMessage(),
                e.getTitle(),JOptionPane.ERROR_MESSAGE);

    
    }

    public JPanel getPanel2() {
        return panel2;
    }
}
