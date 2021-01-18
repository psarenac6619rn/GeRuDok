package gui.rightPanelView;

import commands.CommandManager;
import gui.controller.ActionEnum;
import gui.rightPanelView.graphics.painters.SlotPainter;
import gui.rightPanelView.state.StateManager;
import gui.tree.model.TreeItem;
import gui.view.MainView;
import observer.IListener;
import repository.Document;
import repository.Page;
import repository.Project;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class PageView extends  JPanel implements IListener {

    private JLabel name;
    private Page page;
    private ViewController viewController;
    private ArrayList<SlotPainter> slotPainters;
    private StateManager stateManager;
    private ArrayList<SlotPainter> selecetedSlotPainters;
    private CommandManager commandManager;


    public PageView(Page page) {


        System.out.println("Pravi PageView");
        this.page = page;
        page.addListener(this);
        slotPainters=new ArrayList<SlotPainter>();
        this.setBorder(BorderFactory.createMatteBorder(
               1, 1, 1, 1, Color.red));
        //setBorder(BorderFactory.createEmptyBorder(5,  5,  5,  5));

        name = new JLabel(page.getName());
        this.setPreferredSize(new Dimension(950, 560));
        this.setBackground(Color.WHITE);
        this.add(name);
        viewController=new ViewController();
        this.addMouseListener(viewController);
        this.addMouseMotionListener(viewController);
        stateManager=new StateManager(this);
        selecetedSlotPainters=new ArrayList<SlotPainter>();
        commandManager = new CommandManager();



    }



    @Override
    public void update(Object event) {
        if(event== ActionEnum.ACTION_ADD) {
            repaint();
            revalidate();
        }
        else if(event==ActionEnum.ACTION_RENAME){
            System.out.println("Update Page");
            name.setText(page.getName());
            revalidate();
        }else if (event == ActionEnum.ACTION_REMOVE){
            removeSlot();
        }else if(event==ActionEnum.ACTION_SELECTED){
            repaint();
        }else if(event==ActionEnum.ACTION_SLOTCHANGED){
            repaint();
        }else{
            repaint();
        }

    }

    private class ViewController extends MouseAdapter implements MouseMotionListener {

        public void mousePressed(MouseEvent e) {
            stateManager.getCurrentState().mousePressed(e);
        }

        public void mouseDragged(MouseEvent e){
            stateManager.getCurrentState().mouseDragged(e);
        }

        public void mouseReleased(MouseEvent e) {
            stateManager.getCurrentState().mouseReleased(e);
        }

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for(SlotPainter sp:this.getSlotPainters()){
            sp.paint(g2,sp.getSlot());

        }
        Graphics2D g3=g2;

        float[] lassoPattern = {10f, 10f, 1f, 10f};
        Stroke s=new BasicStroke(4f, BasicStroke.CAP_SQUARE,
                BasicStroke.JOIN_MITER, 1.0f, lassoPattern, 0.0f);
        g3.setStroke(s);
        g3.setColor(Color.BLACK);
        if(this.getPage().getLasso()!=null) {
            g3.draw(this.getPage().getLasso());
        }


    }


    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public ArrayList<SlotPainter> getSlotPainters() {
        return slotPainters;
    }

    public ArrayList<SlotPainter> getSelecetedSlotPainters() {
        return selecetedSlotPainters;
    }

    public void setSelecetedSlotPainters(ArrayList<SlotPainter> selecetedSlotPainters) {
        this.selecetedSlotPainters = selecetedSlotPainters;
    }

    public int getElementAtPosition(Point point) {
        for(int i=this.slotPainters.size()-1;i>=0;i--){
            SlotPainter slp = getElementAt(i);
            if(slp.isElementAt(point)){
                return i;
            }
        }
        return -1;
    }

    public SlotPainter getElementAt(int i){
        return slotPainters.get(i);
    }


    //-----------------------Stateovi-----------------------
    public void startCircleState() {
        stateManager.setCircleState();
    }
    public void startSelectState() {
        stateManager.setSelectState();
    }
    public void startTriangleState(){
        stateManager.setTriangleState();
    }
    public void startRectangleState(){
        stateManager.setRectangleState();
    }
    public void startResizeState(){stateManager.setResizeState();}
    public void startDeleteState(){stateManager.setDeleteState();}
    public void startMoveState(){stateManager.setMoveState();}
    public void startRotateState(){stateManager.setRotateState();}
    public void startLassoState(){stateManager.setLassoState();}
    public void startContentState(){stateManager.setContentState();}
    //-------------------------------------------------------
    public StateManager getStateManager() {
        return stateManager;
    }

    private void removeSlot(){
       repaint();

    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    @Override
    public String toString() {
        return page.toString() ;
    }
}